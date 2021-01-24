package com.quiz0121;
public class Quiz105_Hap {
	public static void main(String[] args) {
/*		
		1+2+...+n 까지의 합이 100을 넘는 최소의 n과 합출력
*/
		int n=0, s=0;
		
		while(s <= 100) {
			n++;
			s+=n;
		}
		
		System.out.println("최소의 n : " + n);
		System.out.println("합 : " + s);
	}
}
