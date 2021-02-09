package com.ex0208;

import java.util.Scanner;

public class Ex05 {
a
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		int a;
		
		try {
			System.out.println("정수? ");
			a=sc.nextInt();
			System.out.println();
		} finally { // try-finally도 가능
			sc.close();
		}

	}

}
