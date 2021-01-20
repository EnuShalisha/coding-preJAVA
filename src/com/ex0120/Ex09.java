package com.ex0120;

public class Ex09 {

	public static void main(String[] args) {
		int a=-13;
		System.out.printf("%d, %d\n", a<<3, a>>3);
		int b=13; // 우측시 왼쪽자리는 부호로 채움
		System.out.printf("%d, %d", b<<3, b>>3);
		a=-32>>>2;
		System.out.println(a); // 0으로 채우기 때문에 음수->양수

	}

}
