package com.ex0222;

import java.awt.BorderLayout;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatForm extends JFrame implements Runnable{
	
	private static final long serialVersionUID = 1L;
	
	private JTextField tf=new JTextField();
	private JTextArea ta=new JTextArea();
	
	public ChatForm() {
		//x버튼으로 프로그램 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane sp=new JScrollPane(ta);
		add(sp, BorderLayout.CENTER);
		
		add(tf, BorderLayout.SOUTH);
		
		setTitle("채팅");
		setSize(500, 500);
		setVisible(true);
		
		Thread t=new Thread(this);
		t.start();
	}

	public static void main(String[] args) {
		new ChatForm();
	}

	@Override
	public void run() {
		try {
			while(true) {
				Calendar cal=Calendar.getInstance();
				String s=String.format("%tF %tT", cal, cal);
				setTitle("채팅-"+s);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
