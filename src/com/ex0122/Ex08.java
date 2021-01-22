package com.ex0122;

import java.util.Scanner;

public class Ex08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b;
		b=0;
		for(int i=1; i<=10; i++) 
		{System.out.println("총 10개 입력: ");
		a=sc.nextInt();
		if (a%2==0)
			b++;
		}
		System.out.println("결과: "+b);
		sc.close();
	}

}
