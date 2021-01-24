package com.quiz0121;
public class Ex014_Hap {
	public static void main(String[] args) {
/*
		1/2+2/3+3/4+...+9/10의 결과를 출력하는 프로그램
*/
		int n;
		double s;
		
		n=0;
		s=0;
		while(n<9) {
			n++;
			s+=(double)n/(n+1);
			// s=s+(double)n/(n+1);
		}
		System.out.println("결과 : "+s); // 7.071031746031746
	}
}
