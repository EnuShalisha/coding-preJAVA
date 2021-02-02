package com.ex0129;

import java.util.Calendar;

public class Mycalendar {
	private int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	private int year;
	private int month;
	private int day;
	
	public Mycalendar() {
		Calendar cal = Calendar.getInstance();
		int y=cal.get(Calendar.YEAR);
		int m=cal.get(Calendar.MONTH)+1;
		int d=cal.get(Calendar.DATE);
		
		set(y, m, d);
	}
	
	public Mycalendar(int year, int month, int day) {
		set(year, month, day);
	}
	public void set(int year, int month, int day) {
		this.year=year;
		this.month=month;
		this.day=day;
		
		if(isleapyear())
			days[1]=29;
		else
			days[1]=28;
		
	}
	
	public String getDate() {
		String s = year+"년 "+month+"월 "+day+"일";
		return s;
		
	}
	
	public boolean isleapyear() {
		return year%4==0&year%100!=0||year%400==0; // 여기 안에 이미 참이면 true 거짓이면 false가 들감 
	}
	
	//날짜 유효 검증
	public boolean isvalid() {
		return year>=1&&month>=1&&month<=12&&day>=1&&day<=days[month-1];
	}
	
	public int lastDays() {
		return days[month-1];
	}
	
	public int totalDays() {
		if(!isvalid())
			return -1;
		int s=0;
		s=(year-1)*365+(year-1)/4-(year-1)/100+(year-1)/400;
		for(int i=0; i<month-1; i++) {
			s+=days[i];
		}
		s+=day;
		return s;
	}
	public String getWeekday() {
		String[] ss = {"일", "월", "화","수","목","금","토"};
		
		int s= totalDays();
		if(s==-1) {
			return null;
		}
		return ss[s&7];
	}

	public String tti( ) {
		String[] t= {"원숭이", "닭", "개", "돼지", "쥐", "소", "호랑이", "토끼", "용", "뱀", "말", "양"};
		if(!isvalid())
			return null;
		return t[year%12];
	}
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
	
	

}
