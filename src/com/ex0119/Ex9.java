package com.ex0119;

import java.util.Scanner;

public class Ex9 {

	public static void main(String[] args) {
		char c;
		int a;
		Scanner sc=new Scanner(System.in);
		
		System.out.print("한문자 ");
		c=sc.next().charAt(0);
		
		//System.out.printf("%c->%d\n", c, c);
		System.out.printf("%c->%d\n", c, (int)c);
		
		a=c;
		System.out.printf("%c->%d\n // %c\n", c, a, a);
		c='대';
		System.out.printf("%c %d\n", c, (int)c);
		
		System.out.println("진리값 ");
		a=sc.next().charAt(0);
		if(a==65) {
			System.out.println("맞습니다");
		}
		else {
			System.out.println("틀립니다");
		} // 이렇게도 응용가능
	}

}
