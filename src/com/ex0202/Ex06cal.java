package com.ex0202;

import java.util.Calendar;
import java.util.Scanner;

public class Ex06cal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String birth;
		String foreign;
		String gender;
		
		do {
			System.out.println("주민번호[xxxxxx-x]? ");
			birth = sc.next();
		} while(!birth.matches("^(\\d{6}-\\d{1})$"));
		
		String[]ss=birth.split("-");
		int date=Integer.parseInt(ss[0]);
		int sort=Integer.parseInt(ss[1]);
		int year;
		
		switch(sort) {
		case 1:foreign="내국인"; gender="남자"; year=1900; break;
		case 2:foreign="내국인"; gender="여자"; year=1900; break;
		case 3:foreign="내국인"; gender="남자"; year=2000; break;
		case 4:foreign="내국인"; gender="여자"; year=2000; break;
		case 5:foreign="외국인/영주권자"; gender="남자"; year=1900; break;
		case 6:foreign="외국인/영주권자"; gender="여자"; year=1900; break;
		case 7:foreign="외국인/영주권자"; gender="남자"; year=1900; break;
		case 8:foreign="외국인/영주권자"; gender="여자"; year=1900; break;
		case 9:foreign="내국인"; gender="남자"; year=1800; break;
		default:foreign="내국인"; gender="여자"; year=1800; break;
		}
		
		String day=Integer.toString(date);
		int y=Integer.parseInt(day.substring(0,2));
		int m=Integer.parseInt(day.substring(2,4));
		int d=Integer.parseInt(day.substring(4,6));
		y=y+year;
		
		Calendar now = Calendar.getInstance();
		
		Calendar cal=Calendar.getInstance();
		cal.set(y,  m-1, d);
		System.out.printf("%tF\n", cal);
		
		int age=now.get(Calendar.YEAR)-cal.get(Calendar.YEAR);
		if(cal.get(Calendar.MONTH)>now.get(Calendar.MONTH)
				||cal.get(Calendar.MONTH)==now.get(Calendar.MONTH)
				&&cal.get(Calendar.DAY_OF_MONTH)>now.get(Calendar.DAY_OF_MONTH))
			age--;
		
		System.out.println("나이:"+age);
		System.out.println("국적:"+foreign);
		System.out.println("성별:"+gender);
		System.out.printf("생년월일: %d-%02d-%02d", y, m, d);
			
		/*주민번호
		xxxxxx-xxxyyyy 시군구
		1 2 2000 이전
		3 4 2000 이후
		5 6 영주권자/외국인 2000 이전
		7 8 외국인 2000 이후
		9 0 1800 사람
		
		나이 생년월일 성별
		*/
	}

}
