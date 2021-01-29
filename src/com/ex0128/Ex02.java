package com.ex0128;

public class Ex02 {

	public static void main(String[] args) {
		Test2 t1 = new Test2();
		Test2 t2 = new Test2();
		
		System.out.println(t1+":"+t2);
		
		t1.a=10;
		t1.print();
		t2.print();
		
		t2=t1; // 원래 t2 메모리 참조 불가 -> jvm에 의해 회수됨
		System.out.println(t1+":"+t2);
		System.out.println(t1.a+","+t2.a);
	}

}

class Test2{
	int a;
	public void print() {
		System.out.println(a);
	}
}