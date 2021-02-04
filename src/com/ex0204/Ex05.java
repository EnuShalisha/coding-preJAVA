package com.ex0204;

public class Ex05 {

	public static void main(String[] args) {
		Demo5 dd = new Demo5();		
		// TODO Auto-generated method stub
		dd.print();
		dd.disp();

	}

}

/*
오버라이딩 예시
object에서 equals(obj) : 주소를 비교한다
(자식) string에서 equals(obj): 값을 비교한다
string이 object의 equals 메소드를 오버라이딩 함. 이로인해 다형성 구현함.

이경우엔 동적 바인딩. 즉 컴파일시가 아닌 실행시에 주소를 찾아간다.
*/

//오버라이딩은 반드시 상속 관계가 있어야한다.
//static, final, private 메소드는 오버라이딩 할 수 없음.
//static은 클래스 접근제한자므로 상속과 관계 x

/*
경우의 수
접근제어자, 파라미터, 예외 같음 : 오버라이딩
파라미터 다름 : 오버로딩
접근제어자 범위 작음 : 컴파일 오류
리턴타입 다름 : 컴파일 오류
예외 추가함 : 컴파일 오류
*/

class Test5{
	int a=10;
	int b=20;
	
	public void print() {
		System.out.println("super:"+a+","+b);
	}
}

class Demo5 extends Test5{
	int b=100;
	int c=200;
	
	//재정의 명시 방법 - 어노테이션
	//컴파일러에게 코드 문법 에러를 체크하도록 제공
	@Override
	public void print() { // 여기서 print2 메소드로 바꾸면 오버라이드가 아니므로 컴파일오류
		System.out.println("sub:"+a+","+b+","+c);
	}
	
	public void disp() {
		print();
		super.print();
	}
}