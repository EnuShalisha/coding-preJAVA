package com.ex0119;

import java.util.Scanner;

public class Ex6 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a,b,c,d;
		
		System.out.print("가로");
		a=sc.nextInt();
		System.out.print("세로");
		b=sc.nextInt();
		
		c=a*b;
		d=(a+b)*2;
		System.out.printf("넓이: %d\n",c);
		System.out.printf("둘레: %d\n",d);
		
		sc.close();

	}

}
