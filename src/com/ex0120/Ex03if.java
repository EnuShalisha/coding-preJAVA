package com.ex0120;

import java.util.Scanner;

public class Ex03if {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("두수 입력: ");
		int a=sc.nextInt();
		int b=sc.nextInt();
		/*if(a<=b) {
			System.out.printf("두수의 차이는 %d",b-a);
		}
		else if(a>b) {
			System.out.printf("두수의 차이는 %d", a-b);
		}*/
		int c;
		c=a-b;
		if(c<0)
				c=-c;
		System.out.println("차이:"+c);
		sc.close();

	}

}
