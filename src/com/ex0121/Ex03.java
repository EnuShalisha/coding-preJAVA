package com.ex0121;

import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n;
		
		System.out.println("수? ");
		n = sc.nextInt();
		
		switch(n) { 
		case 3:System.out.println("###"); break;
		case 2:System.out.println("**"); break;
		case 1:System.out.println("$"); break;
		default:System.out.println("입력오류"); break;
		}
		System.out.println("\n종료");
		sc.close();
	}

}
