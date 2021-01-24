package com.quiz0121;
public class Ex005_EvenHap {
	public static void main(String[] args) {
/*
		1~100 까지 수 중 짝수의 합을 계산하여 출력하는 프로그램
*/
		int s, n;
		s=0;
		n=0;
		while(n<100) {
			n+=2;
			s+=n;
		}
		System.out.println("결과 : "+s); // 2550
	}
}
