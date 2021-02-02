package com.ex0201;

import java.math.BigDecimal;

public class Ex06api {

	public static void main(String[] args) {
		BigDecimal a = new BigDecimal("123456789.123456789");
		
		BigDecimal b = a.movePointLeft(3);
		System.out.println(b);
		
		BigDecimal c = a.divide(b);
		c=a.divide(b, BigDecimal.ROUND_DOWN);
		System.out.println(c);

	}

}
