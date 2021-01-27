package com.ex0127;

public class Ex01 {

	public static void main(String[] args) { // 앞으로 메인 함수에 연산 짤 일은 없음
		Rect ob;
		ob = new Rect(); //객체 메모리 할당
		System.out.println(ob.height); //0
		
		ob.width = 10;
		ob.height = 5;
		System.out.println("넓이: "+ob.area());
		System.out.println("둘레: "+ob.len());

	}

}

/*
 보통 하나의 자바에 하나의 독립된 클래스
 만약 하나의 자바 안에 2개 클래스
 public은 하나만 지정 가능, 그 public 클래스명으로 자바 저장
 */

/*
 클래스 작성 순서
 1. 객체 모델링 - 특성 기능 도출
 2. 클래스 설계 = 객체의 필드와 메소드 설계
 3. 메인 함수에객체 생성, 활용
 */
class Rect {
	//필드 만들기 - 초기화하지 않으면 숫자는 0으로 초기화
	int width, height;
	
	//메소드 만들기 - 한번에 두 가지 일을 수행하지 않는다
	public int area() {
		return width*height;
	}
	public int len() {
		return (width+height)*2;
	}
	
}
