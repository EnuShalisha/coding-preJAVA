package com.ex0224;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements Runnable, ActionListener{
	private static final long serialVersionUID = 1L;
	
	private JTextField tf = new JTextField();
	private JTextArea ta =new JTextArea();
	
	private Socket sc = null;
	private String host = "127.0.0.1";
	private int port=8000;
	private String nickName="스프링";
	
	public ChatClient() {
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
	
	//서버 접속
	public void connect() {
		try {
			sc=new Socket(host, port);
			ta.setText("서버 접속");
			
			Thread t = new Thread(this);
			t.start();
		} catch (Exception e) {
			System.out.println("서버 접속 실패");
			sc=null;
		}
	}
	
	public static void main(String[] args) {
		new ChatClient().connect();

	}
	@Override
	public void run() {
		String s;
		
		if(sc==null) return;
		
		try { // 서버에서 보낸 정보 받기
			BufferedReader br = new BufferedReader(new InputStreamReader(sc.getInputStream()));
			while((s=br.readLine())!=null) {
				ta.append(s+"\n");
				ta.setCaretPosition(ta.getDocument().getLength());
			}
		} catch (Exception e) {
			ta.append("서버가 종료됨 \n");
			sc=null;
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==tf) {
			String s=tf.getText().trim();
			if(s.length()==0) 
				return;
			if(sc==null) return;
			
			
			try {
				//전송
				PrintWriter pw = new PrintWriter(sc.getOutputStream(), true);
				pw.println(nickName+"] "+s);
				
				ta.append("보냄] "+s+"\n");
				ta.setCaretPosition(ta.getDocument().getLength());
				
				tf.setText("");
				tf.requestFocus();
			} catch (Exception e2) {
				System.out.println("서버 종료");
				sc=null;
			}
		}
		
	}

}
