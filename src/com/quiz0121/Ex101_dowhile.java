package com.quiz0121;
public class Ex101_dowhile {
	public static void main(String[] args) {
/*
		1~10 까지 수를 출력하는 프로그램
*/
		int n;
		
		n=0;
		do {
			n++;
			System.out.print(n+"  ");
		}while(n<10);
		System.out.println();
		// System.out.println(n); // 10
	}
}
