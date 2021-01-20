package com.ex0120;

import java.util.Scanner;

public class Exam02Answ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("¼¼ ¼ö:");
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		int t;
		if(a>b) {
			t=a; a=b; b=t;
		}
		if(a>c) {
			t=a; a=c; c=t;
		}
		if(b>c) {
			t=b; b=c; c=t;
		}
		System.out.println(a+","+b+","+c);
		sc.close();
	}

}
