package com.ex0119;

import java.util.Scanner;

public class Ex9 {

	public static void main(String[] args) {
		char c;
		int a;
		Scanner sc=new Scanner(System.in);
		
		System.out.print("�ѹ��� ");
		c=sc.next().charAt(0);
		
		//System.out.printf("%c->%d\n", c, c);
		System.out.printf("%c->%d\n", c, (int)c);
		
		a=c;
		System.out.printf("%c->%d\n // %c\n", c, a, a);
		c='��';
		System.out.printf("%c %d\n", c, (int)c);
		
		System.out.println("������ ");
		a=sc.next().charAt(0);
		if(a==65) {
			System.out.println("�½��ϴ�");
		}
		else {
			System.out.println("Ʋ���ϴ�");
		} // �̷��Ե� ���밡��
	}

}
