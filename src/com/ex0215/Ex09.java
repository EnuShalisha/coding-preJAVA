package com.ex0215;

import java.util.Iterator;
import java.util.Properties;

public class Ex09 {

	public static void main(String[] args) {
		//properties: Hashtable를 상속 받음
		//키와 값이 모두 문자열만 가능
		//파일저장 및 불러오기가 간단하여 환경설정에서 많이 사용
		Properties p=new Properties();
		
		
		p.setProperty("자바", "100");
		p.setProperty("오라클", "95");
		p.setProperty("서블릿", "70");
		p.setProperty("빅데이터", "90");
		p.setProperty("스프링", "85");
		
		Iterator<Object> it=p.keySet().iterator();
		while(it.hasNext()) {
			String key=(String) it.next();
			String value=p.getProperty(key);
			System.out.println(key+":"+value);
		}
		System.out.println();
		
		p.list(System.out);
	}

}
