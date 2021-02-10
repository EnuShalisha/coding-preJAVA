package com.ex0209;

public class Ex03gen {

	public static void main(String[] args) {
		Demo3<String, Integer> ob=new Demo3<>();
		ob.set("서울", 1000);
		ob.print();

	}

}

class Demo3<T, U> {
	private T t;
	private U u;
	
	public void set(T t, U u) {
		this.u=u;
		this.t=t;
	}
	
	public void print() {
		System.out.println("T:"+t.getClass().getName()+", "+t);
		System.out.println("U:"+u.getClass().getName()+", "+u);
	}
}