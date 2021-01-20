package com.ex0119;

public class Ex04op {

	public static void main(String[] args) {
		double x;
		int a=10, b=4;
		
		x=a/b;
		System.out.println("a/b="+x);
		
		x=(double)(a/b);
		System.out.println("a/b="+x);
		
		x=(double)a/b; // double/int = double
		System.out.println("a/b="+x);
		
		double c=10.;
		x=c/b;
		System.out.println("a/b="+x);


	}

}
