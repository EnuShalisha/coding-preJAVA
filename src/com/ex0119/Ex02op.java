package com.ex0119;

public class Ex02op {

	public static void main(String[] args) {
		int a;
		char b;
		double c;
		
		b='A';
		a=b;
		System.out.println(a+","+b);
		c='A'+10;
		System.out.println(c);
		c='A'+'B';
		System.out.println(c);
		
		a=65;
		b=(char)a;
		System.out.println(b);
		
		b='A';
		b=(char)(b+10);
		System.out.println(b);
		
		a=0b101+013;
		System.out.println(a);
		
		double e;
		e=1./2;
		System.out.println(e);
	}

}
