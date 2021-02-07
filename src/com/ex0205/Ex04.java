package com.ex0205;

public class Ex04 {

	public static void main(String[] args) {
		Test04 t = new Test04();
		
		Demo04 d = t; // 이것도 업캐스팅
		d.print();
		//d.sub(); 서브가 갖고있기 때문
		
		((Test04)d).sub(); // test04의 sub 메소드 호출
		

	}

}

interface Demo04{
	public int a=10; // public static 'final' int - 인터페이스 안의 필드일경우
	public void print(); // public abstract void print()
}

interface Sample04{
	public void sub();
}

class Test04 implements Demo04, Sample04 {

	@Override
	public void sub() {
		System.out.println("sub");
		
	}

	@Override
	public void print() {
		System.out.println("print");
		
	}
	
}