package com.ex0119;

import java.util.Scanner;

public class Ex6 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a,b,c,d;
		
		System.out.print("����");
		a=sc.nextInt();
		System.out.print("����");
		b=sc.nextInt();
		
		c=a*b;
		d=(a+b)*2;
		System.out.printf("����: %d\n",c);
		System.out.printf("�ѷ�: %d\n",d);
		
		sc.close();

	}

}
