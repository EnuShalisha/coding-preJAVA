package com.ex0126;

public class Ex09arr {

	public static void main(String[] args) {
		int a[][]= {{10, 20, 30}, {40, 50, 60}};
		int b[][]= new int[a.length][a[0].length];
		
		System.arraycopy(a, 0, b, 0, a.length);
		//a[0] a[1]이 그대로 복사 = 주소가 복사됨
		System.out.println(a[1][1]+" "+b[1][1]);
		
		a[1][1]=5;
		System.out.println(a[1][1]+" "+b[1][1]); 

	}

}
