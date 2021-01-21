package com.ex0121;

import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("두 수? ");
		int a=sc.nextInt();
		int b=sc.nextInt();
		
		System.out.println("연산자? ");
		String op = sc.next();
		
		String result;
		
		switch(op)
		{case "+": result=a+"+"+b+"="+(a+b); break;
		case "-": result=a+"-"+b+"="+(a-b); break;
		case "*": result=a+"*"+b+"="+(a*b); break;
		case "/": result=a+"/"+b+"="+(a/b); break;
		default: result="연산자 오류입니다.";
		}
		System.out.println(result);
		sc.close();

	}

}
