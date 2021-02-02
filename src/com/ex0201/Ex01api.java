package com.ex0201;

public class Ex01api {

	public static void main(String[] args) {
		Test7 t1 = new Test7();
		Test7 t2 = new Test7();
		
		Test7 t3 = t1;
		
		System.out.println(t1);
		System.out.println(t1.toString());
		
		System.out.println(t1==t2);
		System.out.println(t1.hashCode());
		System.out.printf("%X\n", t1.hashCode());
		System.out.println(t1==t3);
		System.out.println(t1.equals(t3));
	}

}

class Test7{
	private int a;
	public void set(int a) {
		this.a=a;
	}
	
	public int get() {
		return a;
	}
}