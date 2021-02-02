package com.ex0202;

import java.util.Calendar;

public class Ex01cal {
// Calendar: 추상클래스, 객체 직접 생성 x
// 추상클래스: 미완성 클래스로 반드시 완성된 하위 클래스가 존재해야함
// Calendar의 하위 클래스는 GregoricanCalendar
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
	//또는 GregorianCalendar cal = new GregorianCalendar();
	//또는 Calendar cal = new GregorianCalendar();
		String s=String.format("%tF %tA %tT", cal, cal, cal);
		System.out.println(s);
		
		String week[]= {"일", "월", "화", "수", "목", "금", "토"};
		int y=cal.get(Calendar.YEAR);
		int m=cal.get(Calendar.MONTH)+1;
		int d=cal.get(Calendar.DATE);
		int w=cal.get(Calendar.DAY_OF_WEEK);
		
		System.out.printf("%d년 %d월 %d일 %s요일\n",
				y,m,d,week[w-1]);
		
		int lastDay = cal.getActualMaximum(Calendar.DATE);
		System.out.println("이번달 마지막 일자: "+lastDay);
		
		

	}

}
