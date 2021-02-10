package com.ex0209;

public class Ex04gen {

	public static void main(String[] args) {
		Test4<Integer> t=new TestImpl4<>();
		t.print(100);

	}

}

interface Test4<T> {
	public void print(T t);
		
}

class TestImpl4<T> implements Test4<T>{

	@Override
	public void print(T t) {
		System.out.println(t.getClass().getName()+","+t);
		
	}
	
}