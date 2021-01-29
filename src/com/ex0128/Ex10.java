package com.ex0128;

public class Ex10 {

	public static void main(String[] args) {
		Test10 t1 = new Test10();
		t1.set(10);
		t1.print();

	}

}

class Test10{
	private int a;
	
	public void set(int a) {
		this.a=a+10;
		System.out.println("set:"+a);
	}
	public void print() {
		System.out.println(a);
	}
}