package com.ex0202;

import java.util.Calendar;
import java.util.Scanner;

public class Ex06cal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String birth;
		
		do {
			System.out.println("생년월일[yyyy-mm-dd]? ");
			birth = sc.next();
		} while(!birth.matches("^(\\d{4}-\\d{2}-\\d{2})$"));
		
		String[]ss=birth.split("-");
		int y=Integer.parseInt(ss[0]);
		int m=Integer.parseInt(ss[1]);
		int d=Integer.parseInt(ss[2]);
		
		Calendar now = Calendar.getInstance();
		
		Calendar cal=Calendar.getInstance();
		cal.set(y,  m-1, d);
		System.out.printf("%tF\n", cal);
		
		// 나이 구하기
		int age=now.get(Calendar.YEAR)-cal.get(Calendar.YEAR);
		if(cal.get(Calendar.MONTH)>now.get(Calendar.MONTH)
				||cal.get(Calendar.MONTH)==now.get(Calendar.MONTH)
				&&cal.get(Calendar.DAY_OF_MONTH)>now.get(Calendar.DAY_OF_MONTH))
			age--;
		
		System.out.println("나이:"+age);
			
		/*주민번호
		xxxxxx-xxxyyyy 시군구
		1 2 2000 이전
		3 4 2000 이후
		5 6 영주권자/외국인 2000 이전
		7 8 외국인 2000 이후
		9 0 1800 사람
		
		나이 생년월일 
		*/
	}

}
