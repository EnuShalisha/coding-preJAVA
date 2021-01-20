package com.ex0120;

public class Ex1 {

	public static void main(String[] args) {
		int a, b;
		a=1;
		b=a;
		System.out.println(b);
		a++;
		b=++a;
		System.out.println(b);//전위연산 a=a+1 -> b=a
		a--;
		b=a--;
		System.out.println(b);//후위연산 b=a -> a=a-1
		b=a;
		System.out.println(b);
		
		a=10;
		b=a++ + a++ + 1;
		System.out.println(b);
		a=10;
		b=a++ + ++a + ++a + a++ + a++; // 10+12+13+13+14
		System.out.println(a+","+b);
		a=0;
		b=a---a;
		System.out.println(b);
		
	}

}
