package com.ex0118;

import java.util.Scanner;

public class Ex5 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int a,b;
		System.out.print("첫번째 수: ");
		a=s.nextInt();
		System.out.print("두번째 수: ");
		b=s.nextInt();
		
		System.out.printf("%d+%d=%d\t", a, b, a+b);
		System.out.println(a+"+"+b+"="+(a+b));
		System.out.printf("%d-%d=%d\n", a, b, a-b);
		System.out.println(a+"-"+b+"="+(a-b));
		System.out.printf("%d*%d=%d\t", a, b, a*b);
		System.out.println(a+"*"+b+"="+(a*b));
		System.out.printf("%d/%d=%d...%d\n", a, b, a/b, a%b);
		System.out.println(a+"/"+b+"="+(a/b)+"..."+(a%b));
		s.close();
	}

}
