package com.ex0203;

import java.text.NumberFormat;
import java.util.Locale;

public class Ex05 {

	public static void main(String[] args) {
		String s;
		NumberFormat nf = NumberFormat.getInstance();
		//추상 클래스라 new로는 개체 생성 x
		int a=12345;
		
		s=nf.format(a);
		System.out.println(s);
		
		double b=31456.2569;
		s=nf.format(b);
		System.out.println(b);
		
		NumberFormat nf2 = NumberFormat.getInstance();
		nf2.setMaximumFractionDigits(4);
		nf2.setMinimumFractionDigits(2);
		System.out.println(nf2.format(1234.56789));
		System.out.println(nf2.format(1234.5));
		
		NumberFormat nf3 = NumberFormat.getCurrencyInstance();
		System.out.println(nf3.format(12345));
		
		// Locale.US : 국가별 설정을 미국으로 변경
		NumberFormat nf4 = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println(nf4.format(12345));
	}

}
