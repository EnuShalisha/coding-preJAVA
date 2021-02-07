package com.ex0205;

public class Ex05 {

	public static void main(String[] args) {
		Demo05 d = new Democl05();
		d.print();

	}

}

interface Aemo05{
	public void print();
}

interface Bemo05{
	public void write();
}

//인터페이스는 다른 인터페이스를 상속받을 수 있음
//다중 상속도 지원 - 인터페이스만

interface Demo05 extends Aemo05, Bemo05{
	public void sub();
}

class Democl05 implements Demo05 {

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sub() {
		// TODO Auto-generated method stub
		
	}
	
}