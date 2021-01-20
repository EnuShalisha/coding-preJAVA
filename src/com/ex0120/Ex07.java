package com.ex0120;

public class Ex07 {

	public static void main(String[] args) {
		int a, b;
		a=12; b=6;
		System.out.printf("~a %d a&b %d a|b %d a^b %d \n", 
				~a, a&b, a|b, a^b);
		
		String s;
		// s= a%2==0?"짝":"홀"; 보다 연산이 더 빠른것
		s = (a&1)==0?"짝":"홀"; // 막자리가 1이기만 하면 홀수니까
		//괄호 쳐줘야함, & 논리곱이 순위 가장 늦기 때문
		System.out.println(s);
		
	}

}
