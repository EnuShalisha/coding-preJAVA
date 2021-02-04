package com.ex0203;

import java.util.Date;

public class Ex01 {

	public static void main(String[] args) {
		Date date1 = new Date();// 종류: Date.util, Date.sql
		System.out.println(date1); // 오늘 날짜 출력
		
		int y=date1.getYear()+1900; //년월일 - 권장하지 않음
		int m=date1.getMonth()+1;
		int d=date1.getDate();
		System.out.println(y+"-"+m+"-"+d);
		
		long a=date1.getTime();
		System.out.println("밀리초:"+a); // 1970 1월 1일 기준으로 현시간을 ms로 환산
		
		Date date2=new Date(1000*60*60*24L); // 1970.1.1에서 하루를 더해줌
		System.out.println(date2); // 1970 1월 2일 9:00
		
		System.out.println(date1.after(date2)); // true false
		
		//formatter는 부모, format은 자식
		//우리가 실제로 쓰는건 자식 클래스
		//formatter-format-dateformat-simpledateformat
	}

}
