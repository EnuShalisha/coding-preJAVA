package com.ex0202;

public class Ex04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String p, s;
		s="123";
		
		//정규식을 이용해보자
		p="\\d{1,3}"; // 1~3까지
		s="123";
		System.out.println(s.matches(p)); // true
		
		p="\\d{1,4}";
		s="123";
		System.out.println(s.matches(p)); // true
	
		p="\\d{1,3}"; // 1~3까지
		s="1234";
		System.out.println(s.matches(p)); // false
		
		p="^[가-힣]+"; // 한글로 시작해야함. 
		
}

}
