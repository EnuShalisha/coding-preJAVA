package com.quiz0121;
public class Ex007_Hap {
	public static void main(String[] args) {
/*
		1~10 까지 합을 계산하여 출력하는 프로그램
*/
		int a=0, s=0;
		while(a++ <= 9) {
		    s+=a;
		}
		System.out.println("a:" + a + ", s:" + s);
	}
}
