package com.ex0202;

import java.util.Calendar;

public class Ex04cal {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.set(2020, 10, 10);
		System.out.printf("%tF\n", cal);
		
		Calendar cal2 = Calendar.getInstance();
		cal.set(2020, 10, 10);
		System.out.printf("%tF\n", cal);

		System.out.println(cal); // 캘린더 주소가 나올거임
		System.out.println(cal2);
		
		//객체 복제 - 주소는 다르고 필드의 값이 같게
		Calendar cal3 = (Calendar)cal.clone(); // 리턴타입 오브젝트. 
		System.out.printf("%tF\n", cal3);
		System.out.println(cal==cal3);
		
	}

}
