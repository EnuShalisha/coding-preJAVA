package com.quiz0121;
public class Ex004_Hap {
	public static void main(String[] args) {
/*
		1~100 까지 정수의 합을 계산하여 출력하는 프로그램
*/
		int s, n;
		s=0;
		n=0;
		while(n<100) {
			n++;
			s+=n;
		}
		System.out.println("결과 : "+s); // 5050
		
/*		
		int s, n;
		s=n=0;
		while(n++<100) {
			s+=n;
		}
		System.out.println("결과 : "+s);
*/		

/*		
		int s, n;
		s=n=0;
		while(++n<=100) {
			s+=n;
		}
		System.out.println("결과 : "+s);
*/		
	}
}
