package com.ex0203;

import java.sql.Date;

public class Ex04 {

	public static void main(String[] args) {
		// sql date 클래스
		java.util.Date now = new java.util.Date();
		
		//java.sql.Date: 데이터베이스의 날짜 처리
		Date date = new Date(now.getTime());
		String s=date.toString();
		System.out.println(s);
		

	}

}
