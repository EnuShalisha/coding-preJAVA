package com.ex0205;

public class Ex03 {

	public static void main(String[] args) {
		Demo03 ob =new Test03(); // 업캐스팅
		ob.print();
		
		// ob.sub(); 컴파일오류, interface에게 정의된 메소드 x
		Test03 aa = (Test03)ob;
		aa.sub();

	}

}

interface Demo03{
	public void print();
	//void print(); == public abstract void print();로 자동변경, 컴파일할 때
	//즉 인터페이스 안의 메소드는 추상메소드이자 퍼블릭
}

class Test03 implements Demo03{ // 언임플리드 메소드를 임플라이 해야지
//인터페이스가 갖고있는 모든 메소드를 재정의해야함, 추상클래스 제외
//인터페이스와 그를 구현한 클래스는 상하관계

	@Override
	public void print() {
		System.out.println("print");
		
	}
	
	public void sub() {
		System.out.println("sub");
	}
	
}