package com.ex0118;

import javax.sound.midi.Soundbank;

public class Ex4 {

	public static void main(String[] args) {
		
		int a=3657, b=-3657;
		System.out.println("a:"+a+",b:"+b);
		
		System.out.printf("%d %d\n", a, b);
		System.out.printf("%,d %,d\n", a, b);
		System.out.printf("%d", 2200000000L);
		System.out.printf("%10d%10d\n", a, b);
		System.out.printf("%010d\n", a);
		System.out.printf("%-10d*\n", a);
		System.out.printf("*%10d\n", a);
		System.out.printf("%2d\n", a);
		
		int c;
		a=20;
		b=7;
		c= a%b;
		System.out.printf("%d %% %d = %d\n", a, b, c);
		
		System.out.printf("%h\n", 267);
		System.out.printf("%6.2f\n", 123.24);
		System.out.printf("%.2f\n", 123.245);
		System.out.printf("%g\n", 123.123);
		System.out.printf("%g\n", 12312.37);
		System.out.printf("%.2g\n", 12312312.123);
		System.out.printf("%#x\n", 31);
		System.out.printf("%#o\n", 31);	
		System.out.printf("%c %c\n", 'c', 67);
		
		a=10;
		b=5; c=7;
		System.out.printf("%d %d %d %d %d\n", a, b, a, b, b);
		System.out.printf("%1$d %2$d %1$d %2$d %2$d\n", a, b);
		
	}

}
