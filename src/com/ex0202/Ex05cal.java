package com.ex0202;

import java.util.Calendar;

public class Ex05cal {

	public static void main(String[] args) {
		//2020-12-03의 주 시작일 / 주 마지막일
		Calendar cal = Calendar.getInstance();
		cal.set(2020, 12-1, 3);
		System.out.printf("날짜:%tF\n", cal);
		
		// 주 시작
		Calendar scal=(Calendar)cal.clone();
		int w=cal.get(Calendar.DAY_OF_WEEK)-1;
		scal.add(Calendar.DAY_OF_MONTH, -w);
		System.out.printf("날짜:%tF\n", scal);

		//주의 끝
		Calendar ecal=(Calendar)cal.clone();
		int d=cal.get(Calendar.DAY_OF_WEEK);
		ecal.add(Calendar.DAY_OF_MONTH, 7-d);
		System.out.printf("날짜:%tF\n", ecal);
		
		//1주 전체 날짜
		for(int i=0; i<7; i++) {
			System.out.printf("날짜:%tF\n", scal);
			scal.add(Calendar.DAY_OF_MONTH, 1);
		}
	}

}
