package com.ex0204;

public class Ex08 {

	public static void main(String[] args) {
		int a=10;
		long b;
		//long보다 int가 큼
		b=a;
		a=(int)b;
		System.out.println(b);
		
		// -> 레퍼런스 클래스
		Integer ii=10;
		Long ll;
		//ll=ii; 컴파일오류
		//ll=(Long)ii; 컴파일오류
		//즉 클래스는 상하관계에서만 형변환이 가능하다. Integer Long은 동등관계
		
		Number nm=ii; // Integer의 상위 클래스 Number - 업캐스팅
		System.out.println(nm);
		ll=(Long)nm;
		System.out.println(ll); // 여기서 nm은 Integer 가지고있음
		//즉 업스케일링 했던것만 "그대로" 다운스케일링 가능
		//이게 참조 변수의 다형성
		
		/*
		 * 상위클래스 객체명 = 하위클래스 객체;
		 * 인터페이스 객체명 = 구현클래스 객체;
		 * 
		 * 하위클래스 객체명 = (하위클래스) 상위클래스 객체;
		 * 구현클래스 객체명 = (구현클래스) 인터페이스 객체;
		 */
	}

}
