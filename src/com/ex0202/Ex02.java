package com.ex0202;

import java.util.Calendar;

public class Ex02 {

	public static void main(String[] args) {
		int n=12345678;
		int a, b;
		String s;
		
		s=String.format("%,d", n);
		System.out.println(s);
		
		a=10; b=5;
		s=String.format("%1$d, %2$d, %1$d", a, b);
		System.out.println(s);
		
		Calendar cal = Calendar.getInstance();
		s=String.format("%tF %tA %tT", cal, cal, cal); // 어쨌든 뒤 인수를 지칭하려면 $1 $2
		System.out.println(s);
		
		s="KOREA";
		byte[] bb = s.getBytes(); // 문자열의 ascii 코드값을 byte 코드값으로 리턴
		for(byte c:bb) {
			System.out.print(c+" ");
		}
		System.out.println();
		
		String s1=new String(bb);
		System.out.println(s1);

}

}