package com.ex0201;

import java.math.BigInteger;

public class Ex05api {

	public static void main(String[] args) {
		BigInteger a= new BigInteger("123456789123456789123456789123456789");
		BigInteger b= new BigInteger("123456789123456789123456789123456789");
		BigInteger c;
		
		c=a.add(b);
		System.out.println(c);
		
		c=a.subtract(b);
		System.out.println(c);
		
		c=a.multiply(b);
		System.out.println(c);
		
		c=a.divide(b);
		System.out.println(c);
		
		BigInteger x = new BigInteger("23");
		System.out.println(x.pow(100));

	}

}
