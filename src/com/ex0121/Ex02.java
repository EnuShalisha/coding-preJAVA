package com.ex0121;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n;
		
		System.out.println("수? ");
		n = sc.nextInt();
		
		switch(n) { // long float double 사용 불가
		case 3:System.out.println("#");
		case 2:System.out.println("#");
		case 1:System.out.println("#");
		}
		System.out.println("\n종료");
		sc.close();
	}

}
