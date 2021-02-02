package com.ex0202;

import java.util.StringTokenizer;

public class Ex04str {

	public static void main(String[] args) {
		String s="자바,오라클,서블릿,스프링";
		
		StringTokenizer st = new StringTokenizer(s, ",", true);
		System.out.println("파싱된 문자열 총수:"+st.countTokens());
		
		String a;
		while(st.hasMoreTokens()) {
			a=st.nextToken();
			System.out.println(a);
		}

	}

}
