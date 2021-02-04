package com.ex0203;

import java.util.Calendar;

public class Ex01cal {

	public static void main(String[] args) {
		//아주 간단히 한주 구하는법
		int sy, sm, sd, ey, em, ed;
		
		Calendar cal = Calendar.getInstance();
		
		int y=2021;
		int m=2;
		int d=3;
		
		cal.set(y, m-1, d);
		
		for(int n=1; n<=6; n++){
			//월의 주 설정
			cal.set(Calendar.WEEK_OF_MONTH, n);
			
			//해당주 일요일
			cal.set(Calendar.DAY_OF_WEEK, 1);
			
			//6주 에러 수정
			if(cal.get(Calendar.YEAR)>y||cal.get(Calendar.MONTH)>=m)
				break;
			
			sy=cal.get(Calendar.YEAR);
			sm=cal.get(Calendar.MONTH)+1;
			sd=cal.get(Calendar.DAY_OF_MONTH);
			
			//해당주 토요일
			cal.set(Calendar.DAY_OF_WEEK, 7);
			ey=cal.get(Calendar.YEAR);
			em=cal.get(Calendar.MONTH)+1;
			ed=cal.get(Calendar.DAY_OF_MONTH);
			
			System.out.printf("%4d-%02d-%02d", sy, sm, sd);
			System.out.printf("~ %4d-%02d-%02d\n", ey, em, ed);
		}

	}

}
