package com.ex0119;

import java.util.Scanner;

public class Exam1op {

	public static void main(String[] args) {
		int a;
		Scanner sc=new Scanner(System.in);
		System.out.println("몇초를? ");
		a=sc.nextInt();
		int b,c,d;
		b=a/3600;
		c=a%3600/60;
		d=a%60;
		System.out.printf("총 %d시간 %d분 %d초입니다.",b,c,d);
		sc.close();

	}

}
