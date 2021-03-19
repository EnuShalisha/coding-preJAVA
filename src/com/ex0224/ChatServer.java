package com.ex0224;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatServer extends JFrame implements Runnable, ActionListener{
	private static final long serialVersionUID = 1L;
	
	private JTextField tf = new JTextField();
	private JTextArea ta =new JTextArea();
	
	private ServerSocket ss = null;
	private int port = 8000;
	private Socket sc = null;
	
	public ChatServer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ta.setEditable(false);
		JScrollPane sp = new JScrollPane(ta);
		add(sp, BorderLayout.CENTER);
		
		tf.addActionListener(this);
		add(tf, BorderLayout.SOUTH);
		
		setTitle("채팅 서버");
		setSize(500, 500);
		setResizable(false);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new ChatServer().serverStart();

	}
	
	public void serverStart() {
		try {
			ss = new ServerSocket(port);
			ta.setText("서버 시작");
			
			sc=ss.accept(); // 클라이언트 접속 전 대기
			
			Thread t = new Thread(this); // 클라이언트 접속시 스레드 시작
			t.start();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Override
	public void run() {
		String str;
		String clientIP=null;
		
		if(sc==null) return;
		try {
			//접속한 클라이언트 아이피 주소를 구함
			clientIP = sc.getInetAddress().getHostAddress(); // 클라이언트 ip 주소
			ta.append("\n["+clientIP+"]에서 접속 !! \n");
			
			//클라이언트가 정보를 읽어들임
			BufferedReader br = new BufferedReader(new InputStreamReader(sc.getInputStream())); // getinputstream: sc 안에 바이트 스트림
			
			//클라이언트가 보낸 정보 읽기
			while((str=br.readLine())!=null) {
				ta.append(str+"\n");
				ta.setCaretPosition(ta.getDocument().getLength());
			}
		} catch (IOException e) {
			// 클라이언트 접속 해지시 IOException
			ta.append("\n["+clientIP+"]에서 접속 종료 !! \n");
			sc=null;
		}catch (Exception e) {
			// TODO: handle exception
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
				//클라이언트에게 메시지 전송
				PrintWriter pw = new PrintWriter(sc.getOutputStream(), true);
				pw.println("서버] "+s);
				
				ta.append("보냄] "+s+"\n");
				ta.setCaretPosition(ta.getDocument().getLength());
				
				tf.setText("");
				tf.requestFocus();
			} catch (Exception e2) {
				ta.append("클라이언트 접속 해제\n");
				sc=null;
			}
		}
		
	}

}
