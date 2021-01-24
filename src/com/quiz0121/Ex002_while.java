package com.quiz0121;
public class Ex002_while {
	public static void main(String[] args) {
/*
		1~10 까지 수중 짝수를 출력
*/ 
		int n=0;
		while(n<10) {
			n+=2;
			System.out.print(n+"  ");
		}
		System.out.println();
		// System.out.println(n); // 10
	}
}
