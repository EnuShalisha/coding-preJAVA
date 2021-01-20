package com.ex0119;

import java.util.Scanner;

public class Exam1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a;
		System.out.print("반지름");
		a=sc.nextInt();
		double b,c;
		b=a*a*Math.PI; // math.PI도 double형
		c=2*a*Math.PI;
		System.out.printf("넓이: %.2f\n", b); // float 형태는 출력부에서 결정
		System.out.printf("둘레: %.2f\n", c);

	}

}
