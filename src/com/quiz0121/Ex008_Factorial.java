package com.quiz0121;
public class Ex008_Factorial {
	public static void main(String[] args) {
/*
		10!(팩토리얼, factorial : 1*2*3...*10) 결과를 출력하는 프로그램
*/
		int s, n;
		s=1;
		n=0;
		while(n<10) {
			n++;
			s*=n;
		}
		System.out.println("결과 : "+s); // 3628800
	}
}
