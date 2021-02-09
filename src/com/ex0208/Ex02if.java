package com.ex0208;

public class Ex02if {

	public static void main(String[] args) {
		//Demo2 d =new Demo2(); 컴파일 오류 - 인터페이스 객체생성 x
		
		//익명 클래스
		//클래스파일도 생성: ~~$1.class로 클래스파일 생성
		Demo2 d = new Demo2() {
			
			@Override
			public void write() {
				System.out.println("write");
				
			}
		};
		
		d.write();
		
		
		//나중에 배울 람다식
		Demo2 d2 = () -> System.out.println("람다 write");
		d2.write(); //객체지향 아닌 함수지향
	}

}

interface Demo2{
	public void write();
}

//저 인터페이스만 써도 더이상 쓰지 않아도 되는, 이름없는 클래스