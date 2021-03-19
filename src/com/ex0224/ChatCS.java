package com.ex0224;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/*
 DatagramSocket : UDP를 이용하여 데이터 그램 패킷 전송
 MulticastSocket: 한번에 다수의 클라이언트에게 전송
 DatagramPacket: UDP에서 전송될 수 있는 데이터
 MulticastSocket : 그룹-D class(224.0.0.1 - 239.255.255.255)
 */


//다:다
public class ChatCS extends JFrame implements Runnable, ActionListener{
	private static final long serialVersionUID = 1L;
	
	private JTextField tf = new JTextField();
	private JTextArea ta =new JTextArea();
	
	private MulticastSocket ms = null;
	private InetAddress xGroup=null; // ip 받아서 자바에서 활용
	
	private String userName="자바";
	private String host="230.0.0.1"; // D클래스
	private int port=5555;
	
	public ChatCS() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ta.setEditable(false);
		JScrollPane sp = new JScrollPane(ta);
		add(sp, BorderLayout.CENTER);
		
		tf.addActionListener(this);
		add(tf, BorderLayout.SOUTH);
		
		setTitle("채팅");
		setSize(500, 500);
		setResizable(false);
		setVisible(true);
		
	}
	
	public void setup() {
		try {
			xGroup=InetAddress.getByName(host);
			ms=new MulticastSocket(port);
			
			ms.joinGroup(xGroup);
			
			Thread t = new Thread(this);
			t.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void disConn() {
		try {
			ms.leaveGroup(xGroup);
			ms.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ms=null;
	}
	
	public static void main(String[] args) {
		new ChatCS().setup();

	}
	@Override
	public void run() {
		if(ms==null) return;
		
		try {
			while(true) {
				byte[] buffer = new byte[256];
				//전송 받을 패킷
				DatagramPacket p = new DatagramPacket(buffer, buffer.length);
				//전송 받음
				ms.receive(p);
				String s=new String(p.getData()).trim();
				ta.append(s+"\n");
				ta.setCaretPosition(ta.getDocument().getLength());
			}
		} catch (Exception e) {
			disConn();
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==tf) {
			String s=tf.getText().trim();
			if(s.length()==0) {
				return;
			}
			
			if(ms==null) return;
			
			byte[] buffer = (userName+"] "+s).getBytes();
			
			try {
				//전송

				DatagramPacket p = new DatagramPacket(buffer, buffer.length, xGroup, port);
				
				ms.send(p);
				
				tf.setText("");
				tf.requestFocus();
			} catch (Exception e2) {
	
			}
		}
		
	}

}
