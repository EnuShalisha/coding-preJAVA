package com.ex0225;

public class Ex05 {

	public static void main(String[] args) {
		//User5 u = (n) -> String.valueOf(n);
		User5 u = String::valueOf; // 메소드 참조
		
		String s=u.convert(100);
		System.out.println(s);

	}

}

interface User5 {
	public String convert(Integer num);
}

