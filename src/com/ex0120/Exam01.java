package com.ex0120;

import java.util.Scanner;

public class Exam01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char a, b;
		//65~90 대문자, 97~122 소문자
		System.out.println("문자? ");
		a=sc.next().charAt(0);
		//b=a<65||a>122?a:(a>=65&&a<=90?a+32:a-32);
		b=a>=97&&a<=122?(char)(a-32):(a>=65&a<=90?(char)(a+32):a);
		System.out.println(b);
		
	}

}
