package com.ex0126;

public class Ex07arr {

	public static void main(String[] args) {
		int a[] = {10, 20, 30};
		int b[] = a;
		System.out.println(a==b);
		
		int x[]= {100, 200, 300};
		int y[]= new int[x.length];
		
		System.arraycopy(x, 0, y, 0, x.length);
		//원본배열, 원본 시작 위치, 복사배열, 복사 시작 위치, 복사할 배열 길이
		System.out.println(x+","+y);
		System.out.println(x==y); // 주소까지 같나? 다름
		
		a[1]=5;
		System.out.println(a+","+b);

	}

}
