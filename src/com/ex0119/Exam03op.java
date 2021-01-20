package com.ex0119;

import java.util.Scanner;


public class Exam03op {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("금액 입력:");
		int a=sc.nextInt();
		System.out.printf("오만원권 %d장\n일만원권 %d장\n오천원권 %d장\n"
				+ "일천원권 %d장\n오백원권 %d장\n일백원권 %d장\n"
				+ "오십원권 %d장\n십원권 %d장\n오원권 %d장\n"
				+ "일원권 %d장", a/50000, a%50000/10000, a%10000/5000,
				a%5000/1000, a%1000/500, a%500/100, a%100/50,
				a%50/10, a%10/5, a%5);
		
		sc.close();

	}

}
