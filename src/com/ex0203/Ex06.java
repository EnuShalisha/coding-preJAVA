package com.ex0203;

import java.text.NumberFormat;
import java.text.ParseException;

public class Ex06 {

	public static void main(String[] args) {
		String s1="1000";
		String s2="1,234"; // 여기서 parseint하면 터짐 - 런타임 에러
		String s3="1000.12";
		
		System.out.println(Double.parseDouble(s3));
		
		//문자열->숫자
		NumberFormat nf = NumberFormat.getInstance(); // 원래 정수는 Long로 처리
		try {
			Number n1 = nf.parse(s2); // number: integer, long, double 등의 상위 클래스
			//parse를 그대로 받는 건 long, double로만 가능
			//Long ll= (Long)nf.parse(s2);
			System.out.println(n1);
			
			//정수형으로만 처리하도록 설정
			nf.setParseIntegerOnly(true);
			Number n2=nf.parse(s3);
			System.out.println(n2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
