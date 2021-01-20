package com.ex0120;

public class Ex08 {

	public static void main(String[] args) {
		int a=10, b=5;
		a=a^b;
		b=b^a;
		System.out.println(a+","+b);
		a=a^b;
		System.out.println(a+","+b);
		
		int x=37;
		x=x^75;
		System.out.println(x); // 암호화
		x=x^75;
		System.out.println(x); // 복호화
		
	
	}

}
