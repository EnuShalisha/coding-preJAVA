package com.ex0208;

public class Ex01 {

	public static void main(String[] args) {

/*		int a, b, c;
		b=10; c=0;
		
		a=b/c;
		System.out.println("결과: "+a);
		System.out.println("프로그램 종료");
*/	
		int a, b, c;
		b=10; c=0;
		
		try {
			a=b/c;
			System.out.println("결과: "+a);
		} catch (Exception e) {
			System.out.println("0으로 못나눔");
		}
		System.out.println("프로그램 종료");
	
	}

}
