package com.ex0223;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class Ex03 {

	public static void main(String[] args) {
		String s1, s2;
		
		try {
			s1="자바abc 123"; s2=URLEncoder.encode(s1,"UTF-8");
			System.out.println(s1+"-인코딩 결과: "+s2);
			
			s1=URLDecoder.decode(s2, "UTF-8");
			System.out.println(s2+"- 디코딩 결과: "+s1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
