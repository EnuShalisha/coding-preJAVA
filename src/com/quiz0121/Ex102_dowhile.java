package com.quiz0121;
public class Ex102_dowhile {
	public static void main(String[] args) {
/*
		1~100 까지 수의 합을 계산하여 출력
*/
		int n, s;
		
		s=n=0;
		do {
			n++;
			s+=n;
		}while(n<100);
		System.out.println("결과 : "+s); // 5050
	}
}
