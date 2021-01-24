package com.quiz0121;
public class Ex001_while {
	public static void main(String[] args) {
/*
		1~10 까지 정수를 출력
*/ 
		int n;
		n=0; // 초기화가 필요
		while(n<10) {
			n++;
			System.out.print(n+"  ");
		}
		System.out.println();
		// System.out.println(n); // 10
		
/*		
		int n=0; // 변수 선언돠 동시에 초기화
		while(n++<10) {
			System.out.print(n+"  ");
		}
		System.out.println();
		System.out.println(n); // 11
*/
		
/*		
		int n=0;
		while(++n<=10) {
			System.out.print(n+"  ");
		}
		System.out.println();
		// System.out.println(n); // 11
*/		
	}
}
