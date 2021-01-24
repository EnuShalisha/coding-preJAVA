package com.quiz0121;
public class Ex006_OddHap {
	public static void main(String[] args) {
/*
		1~100 까지 수 중 홀수의 합을 계산하여 출력하는 프로그램
*/
		int s, n;
		s=0;
		n=1;
		while(n<=100) {
			s+=n;
			n+=2;
		}
		System.out.println("결과 : "+s); // 2500
	}
}
