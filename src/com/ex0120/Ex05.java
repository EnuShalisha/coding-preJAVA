package com.ex0120;

public class Ex05 {

	public static void main(String[] args) {
		int a, b;
		boolean c;
		
		a=20; b=20;
		c = (++a > 20) && (++b > 20);
		System.out.println(c);
		
		a=20; b=20;
		c = (++a > 20) && (b++ > 20);
		System.out.println(c);
		c = (++a > 20) && (b++ > 20);
		System.out.println(c);
		a=20; b=20;
		c = (a++ > 20) && (++b > 20);
		System.out.println(a+","+b+","+c); // a가 false -> b는 연산도 안함
		
		System.out.println("--------------------------");
		
		a=20; b=20;
		c = (a++ > 20) || (b++ > 20);
		System.out.println(a+","+b+","+c);
		a=20; b=20;
		c = (a++ > 20) || (++b > 20);
		System.out.println(a+","+b+","+c);
		a=20; b=20;
		c = (++a > 20) || (++b > 20);
		System.out.println(a+","+b+","+c); // ++a 이후로 볼필요도 없음
		a=20; b=20;
		c = (++a > 20) || (++b > 20);
		System.out.println(a+","+b+","+c);

	}

}
