package com.ex0129;

public class Ex7 {

	public static void main(String[] args) {
		Mycalendar mc = new Mycalendar();
		//mc.set(2020, 10, 10);
		
		System.out.println(mc.getDate());
		System.out.println(mc.getWeekday());
		
		Mycalendar mc2 = new Mycalendar(1994,12,12);
		System.out.println(mc2.getDate());
		System.out.println(mc2.getWeekday());
		
		int n=mc.totalDays()-mc2.totalDays();
		System.out.println("살아온날수:" +n);

	}

}
