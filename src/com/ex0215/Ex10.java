package com.ex0215;

import java.io.FileOutputStream;
import java.util.Properties;

public class Ex10 {

	public static void main(String[] args) {
		Properties p=new Properties();
		
		
		p.setProperty("자바", "100");
		p.setProperty("오라클", "95");
		p.setProperty("서블릿", "70");
		p.setProperty("빅데이터", "90");
		p.setProperty("스프링", "85");
		
		String pathname="subject.properties";
		try(FileOutputStream fos=new FileOutputStream(pathname)) {
			p.store(fos, "과목별 성적 처리");
			System.out.println("파일 저장 완료");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
