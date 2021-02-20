package com.ex0215;

import java.io.FileInputStream;
import java.util.Properties;

public class Ex11 {

	public static void main(String[] args) {
		Properties p=new Properties();
		String pathname="subject.properties";
		
		try(FileInputStream fis=new FileInputStream(pathname)) {
			p.load(fis);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("불러온 데이터");
		p.list(System.out);
		
		System.out.println(p.getProperty("자바"));

	}

}
