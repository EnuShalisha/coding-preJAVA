package com.ex0223;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//스윙: 윈도우 프로그램 만들기
public class Ex02 extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private JButton btn1 = new JButton("확인1");
	private JButton btn2 = new JButton("확인2");
	private JButton btn3 = new JButton("확인3");
	
	private JTextField tf = new JTextField();
	private JTextArea ta = new JTextArea();
	public Ex02() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(tf, BorderLayout.NORTH);
		JScrollPane sp = new JScrollPane(ta);
		add(sp, BorderLayout.CENTER);
		
		//JTextField에 이벤트 등록
		tf.addActionListener(this);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
	
		//버튼 내 이벤트 등록
		
		JPanel p = new JPanel();
		p.add(btn1); p.add(btn2); add(btn3);
;		add(p, BorderLayout.SOUTH);
		
		setTitle("예제");
		setSize(500, 500);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		JFrame ex = new Ex02();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// actionevent 처리: jbutton, jmenuitem, jtextfield에서의 엔터 등
		
		//이벤트가 bt1에서 발생함을 발견하 면
		if(e.getSource()==btn1) 
			JOptionPane.showMessageDialog(this, "방가 방가");
		else if(e.getSource()==btn2)
			JOptionPane.showMessageDialog(this, "잘가");
		else if(e.getSource()==btn3) {
			JOptionPane.showMessageDialog(this, "종료");
			System.exit(0);}
		else if(e.getSource()==tf) {
			String s=tf.getText().trim();
			if(s.length()==0)
				return;
			
			ta.append(s+"\n");
			tf.setText("");
		}
				
	}

}
