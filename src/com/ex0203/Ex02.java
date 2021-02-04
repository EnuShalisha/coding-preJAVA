package com.ex0203;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex02 {

	public static void main(String[] args) {
		String s;
		Date date=new Date();
		
		//date->string 변환
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss");
		//이렇게 가져올거야.
		//인터넷도 업장가면 참고 못하는데 api 사전은 평소에 연습해두자
		s=sdf.format(date);
		System.out.println(s);
		
		//String->Date
		s="2000-10-10"; // 심플데이터 형식 문제점 1) 날짜형식이 잘못됐을때 2) sdf와 형식을 정확히 맞춰야함 
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date2=sdf2.parse(s);//문제 코드와 정상 코드가 혼재 -> try catch로 이 둘을 구분함
			System.out.println(date2);
		} catch (ParseException e) { // 예외 발생 -> 발생할때만 밑 실행
			e.printStackTrace(); 
		} // 문제점 3) 예외처리해야함 - 그냥 대입 불가
		
		//d day같은 날짜 연산
		
	}
	

}
