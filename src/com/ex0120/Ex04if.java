package com.ex0120;

import java.util.Scanner;

public class Ex04if {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("��?");
		int a=sc.nextInt();
		String s;
		s="2�� 3�� ����� �ƴ�";
		if(a%2==0)
		{if(a%3==0) {
			s="2�̸鼭 3�� �����";
		}
		else {
			s="2�� �����";
		}
		}
		else if(a%3==0) {
			s="3�� �����";
		}
		System.out.println(s);
		
		sc.close();

	}

}
