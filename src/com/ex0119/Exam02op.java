package com.ex0119;

import java.util.Scanner;

public class Exam02op {

	public static void main(String[] args) {
		int a;
		Scanner sc=new Scanner(System.in);
		System.out.println("정수 입력 ");
		a=sc.nextInt();
		int b;
		int c;
		double d;
		int e;
		b=a/10;
		c=b*10;
		d=(double)a/10;
		e=(a+5)/10*10;
		System.out.println(d);
		System.out.printf("일의자리 반올림은 %d, 절사는 %d",e,c);
		

	}

}
