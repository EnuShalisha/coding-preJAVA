package com.ex0128;

public class Ex11 {

	public static void main(String[] args) {
		Test11 t1 = new Test11();
		Test11 t2 = new Test11();
		
		t1.set(5); /// 이경우의 this는 t1의 인스턴스 a
		t1.print();
		
		t2.set(20); // 이경우의 this는 t2의 인스턴스 a
		t2.print();

	}

}

class Test11{
	private int a;
	public void set(int a) {
		this.a = a+10;
		System.out.println("set:"+this.a+","+a);}
		
	public void print() {
			System.out.println(this.a);
	}
}
