package com.ex0122;

import java.util.Scanner;

public class Ex09 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b;
		b=0x00000000; // 음수만을 입력했을 경우엔 가장 작은값이 0이 되는 오류
		for(int i=1; i<=10; i++) 
		{System.out.println("총 10개 입력: ");
		a=sc.nextInt();
		if (i==1)
			b=a;
		if (a>b)
			b=a;
		}
		System.out.println("결과: "+b);
		sc.close();

	}

}
