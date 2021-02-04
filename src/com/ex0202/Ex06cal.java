package com.ex0202;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Ex06cal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String birth;
		
		do {
			System.out.println("주민번호[xxxxxx-x]? ");
			birth = sc.next();
		} while(!birth.matches("^(\\d{6}-\\d{1})$"));
		
		Get g = new Get();
		g.split(birth);
		
		g.sorting();
		g.dating();
		g.age();
		
		if(!g.age())
			System.out.println("유효하지 않은 날짜입니다.");
		
		else{
			System.out.println("나이:"+g.getAge());
		System.out.println("국적:"+g.getForeign());
		System.out.println("성별:"+g.getGender());
		System.out.printf("생년월일: %d-%02d-%02d", g.getY(), g.getM(), g.getD());
		
		}	
		System.out.println();
		String str;
		str=g.toWeekStart("2021-02-03");
		System.out.println(str);
		str=g.toWeekEnd("2021-02-03");
		System.out.println(str);
	}

}

class Get{
	/**
	 * 주민등록번호를 이용하여 생년월일 구하기
	 * @param birth 주민번호
	 * @return 		생년월일
	 */
	
	private int year;
	private int date;
	private int sort;
	private String foreign;
	private String gender;
	private int y;
	private int m;
	private int d;
	private int age;
	private Calendar cal;
	
	public void split(String birth) {
		String[]ss=birth.split("-");
		date=Integer.parseInt(ss[0]);
		sort=Integer.parseInt(ss[1]);
		this.date=date; this.sort=sort;
	}
	
	public void sorting(){
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
		this.foreign=foreign; this.gender=gender; this.year=year;
	}
	
	public void dating() {
		String day=Integer.toString(date);
		y=Integer.parseInt(day.substring(0,2));
		m=Integer.parseInt(day.substring(2,4));
		d=Integer.parseInt(day.substring(4,6));
		y=y+year;
		this.y=y; this.m=m; this.d=d;
	}
	
	public boolean age() {
		Calendar now = Calendar.getInstance();
		
		Calendar cal=Calendar.getInstance();
		cal.set(y,  m-1, d);
		this.cal=cal;
		
		int y1=cal.get(Calendar.YEAR);
		int m1=cal.get(Calendar.MONTH)+1;
		int d1=cal.get(Calendar.DATE);
		
		if(y!=y1||m!=m1||d!=d1) // 날짜 오류를 딱 정리해놓을수 있는 방법
			return false;
		
		int age=now.get(Calendar.YEAR)-cal.get(Calendar.YEAR);
		if(cal.get(Calendar.MONTH)>now.get(Calendar.MONTH)
				||cal.get(Calendar.MONTH)==now.get(Calendar.MONTH)
				&&cal.get(Calendar.DAY_OF_MONTH)>now.get(Calendar.DAY_OF_MONTH))
			age--;
		
		this.age=age;
		return true;
	}
	
	/**
	 * 날짜(date)의 주시작일을 반환
	 * @param date	한주의 특정 날짜
	 * @return		주시작일
	 */
	public String toWeekStart(String date) {
		String result=null;
		y=Integer.parseInt(date.substring(0,2));
		m=Integer.parseInt(date.substring(2,4));
		d=Integer.parseInt(date.substring(4,6));
		cal.set(y,  m-1, d);
		cal.set(Calendar.DAY_OF_WEEK, 1); //주의 첫째요일(일)로 설정
		result=String.format("%tF", cal); // %tF가 연월일 형식 
		
		return result;
	}
	
	public String toWeekEnd(String date) {
		String result=null;
		String[]ss=date.split("-");
		y=Integer.parseInt(ss[0]);
		m=Integer.parseInt(ss[1]);
		d=Integer.parseInt(ss[2]);
		cal.set(y,  m-1, d);
		cal.set(Calendar.DAY_OF_WEEK, 7); //주의 마지막요일(토)로 설정
		result=String.format("%tF", cal); // %tF가 연월일 형식 
		
		return result;
	}
	
	/**
	 *두날짜(endDate-startDate) 사이의 차이를 일자로 반환
	 * @param startDate	시작날짜
	 * @param endDate	끝날짜
	 * @return			차이(일자)
	 */
	public int toDiffDays(String startDate, String endDate) {
		int result=0;
		
		startDate=startDate.replaceAll("(\\-|\\.|\\/)", "");
		endDate=endDate.replaceAll("(\\-|\\.|\\/)", "");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		try {
			Date begin=sdf.parse(startDate);
			Date end=sdf.parse(endDate);
			
			result=(int)((end.getTime()-begin.getTime())/(1000*60*60*24)); // 일자로 나누기
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return result;
	}
	
	public int getYear() {
		return year;
	}

	public int getDate() {
		return date;
	}

	public int getSort() {
		return sort;
	}

	public String getForeign() {
		return foreign;
	}

	public String getGender() {
		return gender;
	}

	public int getY() {
		return y;
	}

	public int getM() {
		return m;
	}

	public int getD() {
		return d;
	}

	public int getAge() {
		return age;
	}

	
	
}