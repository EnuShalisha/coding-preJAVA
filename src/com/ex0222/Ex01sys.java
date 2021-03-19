package com.ex0222;

import java.util.Enumeration;
import java.util.Properties;

public class Ex01sys {

	public static void main(String[] args) {
		System.out.println("OS: "+System.getProperty("os.name"));
		System.out.println("Encoding: "+System.getProperty("file.encoding"));
		System.out.println("작업경로 :"+System.getProperty("user.dir"));
		System.out.println();
		
		System.out.println("전체 환경설정");
		Properties p = System.getProperties();
		
		Enumeration<?> e = p.propertyNames();
		while(e.hasMoreElements()) {
			String key=(String)e.nextElement();
			String value=p.getProperty(key);
			System.out.println(key+"->"+value);
		}

	}

}
