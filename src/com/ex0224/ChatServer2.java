package com.ex0224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ChatServer2 {

	private Vector<Socket> client = new Vector<Socket>();
	private ServerSocket ss=null;
	private int port=8000;
	
	//맴버 스레드 클래스
	class WorkerThread extends Thread {
		private Socket sc = null;
		
		public WorkerThread(Socket sc) {
			this.sc=sc;
		}
	
		@Override
		public void run() {
			String ip=null;
			String s;
			
			try {
				//접속 클라이언트의 입력 스트림(수신용)
				BufferedReader br = new BufferedReader(new InputStreamReader(sc.getInputStream()));
				
				ip=sc.getInetAddress().getHostAddress();
				
				client.add(sc);
				
				s="["+ip+"] 접속";
				sendMessage(s);
				System.out.println(s); /// 서버 기록
				
				while((s=br.readLine())!=null) {
					sendMessage(s);
				}
			} catch (IOException e) {
				s="["+ip+"] 퇴장";
				sendMessage(s);
				
				client.remove(sc);
				sc=null;
			}
		}
		
	private void sendMessage(String msg) {
		for(Socket s:client) {
			try {
				if(s==sc) continue;
				
				PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
				pw.println(msg);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	}
	
	public void serverStart() {
		try {
			ss=new ServerSocket(port);
			System.out.println("서버 시작");
			
			while(true) {
				Socket sc = ss.accept();
				
				WorkerThread t = new WorkerThread(sc);
				t.start();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args) {
		ChatServer2 cs = new ChatServer2();
		cs.serverStart();

	}

}
