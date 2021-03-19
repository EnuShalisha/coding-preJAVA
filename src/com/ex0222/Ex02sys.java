package com.ex0222;

import java.util.Scanner;

public class Ex02sys {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int n;
		
		try {
			System.out.print("정수?");
			n=sc.nextInt();
			if(n==0n) {
				return;
			}
			System.out.println("값:"+n);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("finally block");
			sc.close();
		}

	}

}
