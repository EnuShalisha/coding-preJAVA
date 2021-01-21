package com.ex0121;

import java.util.Scanner;

public class Ex01wh {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 입력: ");
		int a=sc.nextInt();
		int n=1; int s=0;
		if(a<0) 
			System.out.println("오류입니다.");
		else {while(n<=a)
				{s+=n;
				n+=2;
		}
		System.out.printf("1부터 %d까지의 홀수합은 %d입니다.", a, s);}

	}

}
