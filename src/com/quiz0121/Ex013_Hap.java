package com.quiz0121;
public class Ex013_Hap {
	public static void main(String[] args) {
		// 1+(1+2)+(1+2+3)+...+(1+2+3+...+10) 연산 결과
		int n, s, ss;
		
		n=0;
		s=ss=0;
		while(n<10) {
			n++;
			s+=n;
			ss+=s;
		}
		System.out.println("결과 : "+ss); // 220
	}
}
