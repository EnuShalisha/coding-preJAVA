package com.ex0203;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ex03 {
	
	public static void main(String[] args) {
		
		Test3 t = new Test3();
		String s1="2021-100-10"; // 100을 10월로 인식해버림
		String s2="2021-02-03";
		
		int n=t.toDiffDays(s1, s2);
		System.out.println("날짜차이: "+n);
}
}

class Test3{
	public int toDiffDays(String startDate, String endDate) {
		int result=0;
		
		if(!isValidDate(startDate)||!isValidDate(endDate)) {
			throw new IllegalArgumentException("날짜 입력 형식 오류...");
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		try {
			Date begin=sdf.parse(startDate);
			Date end=sdf.parse(endDate);
			
			result=(int)((end.getTime()-begin.getTime())/(1000*60*60*24)); // 일자로 나누기
			//String을 Date로 변환 못하는 경우(예외 발생)
		} catch (ParseException e) {
			throw new IllegalArgumentException("날짜 입력 형식 오류..");
		}
		
		
		return result;
	}
	
	public boolean isValidDate(String date) {
		date=date.replaceAll("(\\.|\\-|\\/)", "-");
		
		
		try {
			String[]ss=date.split("-");
			int y=Integer.parseInt(ss[0]);
			int m=Integer.parseInt(ss[1]);
			int d=Integer.parseInt(ss[2]);
			
			Calendar cal = Calendar.getInstance();
			cal.set(y,m-1, d);
			cal.set(Calendar.YEAR, y);
			cal.set(Calendar.MONTH, m-1);
			cal.set(Calendar.DATE, d);
			
			int y1=cal.get(Calendar.YEAR);
			int m1=cal.get(Calendar.MONTH)+1;
			int d1=cal.get(Calendar.DATE);
			
			if(y!=y1||m!=m1|d!=d1)
				return false;
			
			
		}catch(Exception e) {
		return false;
		
		}
		
		return true;
	}
}