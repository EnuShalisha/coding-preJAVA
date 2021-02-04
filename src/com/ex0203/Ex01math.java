package com.ex0203;

public class Ex01math {

	public static void main(String[] args) {
		double a;
		
		// sin30도
		a=Math.sin(30*Math.PI/180); // 도가 아니라 라디안 - 각도*3.14/180
		System.out.println(a);
		
		//루트2
		a=Math.sqrt(2);
		System.out.println(a);
		
		//절삭
		a=Math.floor(12.77);
		System.out.println(a);

		//올림
		a=Math.ceil(12.77);
		System.out.println(a);
		
		//2의 10승
		a=Math.pow(2, 10);
		System.out.println(a);
		
		a=Math.random();
		System.out.println(a);
		
	}

}
