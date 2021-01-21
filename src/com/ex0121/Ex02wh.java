package com.ex0121;

import java.util.Scanner;

public class Ex02wh {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a;
		System.out.println("숫자 입력:");
		a=sc.nextInt();
		int n=1;
		int s=0;
		if(a<0)
			{System.out.println("입력 오류입니다.");}
		else{
			while(n<=a) {
			s+=n;
			n+=2;
			System.out.println(n);
			}
			System.out.printf("1부터 %d까지의 합은 %d입니다.", a, s);
		}
		
		sc.close();

	}

}
