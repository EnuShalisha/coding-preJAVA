package com.ex0122;

import java.util.Scanner;

public class Ex11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b, c, result=0;
		b=0x7fffffff;
		System.out.println("총 10개 입력: ");
		for(int i=0; i<10; i++) {
			a=sc.nextInt();
			if(a==7)
				i--; 
			else
				{c = a>7?a-7:7-a; // 어디를 어디까지 묶느냐의 중요성 -> 7일 땐 입력 자체가 무시
				if(b>c) 
				result=a;
				b=c;}}
		
		System.out.println("결과: "+result);
		
		sc.close();
	}

	}
