package com.ex0202;

import java.util.Calendar;

public class Ex02cal {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		
		//2010년 10월 10일
		
		/*cal.set(2010, 9, 7);
		System.out.printf("%tF\n", cal);
		
		cal.set(Calendar.DATE, 35); // 날짜만 변경
		System.out.printf("%tF\n", cal);
		*/
		//김자바님이 태어나서 처음으로 2021-01-30일에 여자친구를 만났습니다
		//100일 후는?
		cal.set(2021, 0, 30);
		cal.add(Calendar.DATE, 100);
		System.out.printf("%tF\n", cal);

	}

}
