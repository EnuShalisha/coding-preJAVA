package com.quiz0121;
public class Ex003_while {
	public static void main(String[] args) {
/*
		1~10 까지 수중 홀수를 출력
*/ 
		int n=1;
		while(n<=10) {
			System.out.print(n+"  ");
			n+=2;
		}
		System.out.println();
		// System.out.println(n); // 11
	}
}
