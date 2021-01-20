package com.ex0120;

import java.util.Scanner;

public class Ex01if {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수: ");
		int a=sc.nextInt();
		if (a<0) {
			a=-a;
		}
		System.out.println(-a);
		
		if(a%2==1) {
			System.out.println("홀수입니다");
		
		}

	}
}
