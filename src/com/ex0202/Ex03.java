package com.ex0202;

import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		String s;
		
		System.out.print("정수 ? ");
		n=sc.nextInt();
		/*
		// 정수를 문자열로
		s=Integer.toString(n);
		System.out.println(s);
		
		//뒤집어 출력
		for(int i=s.length()-1; i>=0; i--) {
			System.out.println(s.charAt(i));
		}
		System.out.println();*/
		
		//입력받은 정수의 길이
		/*
		int temp=n>0?n:-n;
		System.out.println(n+"길이 "+Integer.toString(temp).length());
		*/
		s=Integer.toString(n);
		s=s.replaceAll("3|6|9", "*");
		System.out.println(s);
		
		sc.close();

	}

}
