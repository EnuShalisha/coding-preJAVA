package com.ex0121;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n;
		
		System.out.println("수? ");
		n=sc.nextInt();
		
		switch(n%3) {
		case 0:System.out.println("3의 배수"); break;
		case 1:
		case 2:System.out.println("3의 배수가 아님"); break;
		}
		sc.close();
	}

}
