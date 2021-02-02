package com.ex0201;

public class Ex02 {

	public static void main(String[] args) {
		Test02 t1 = new Test02();
		Test02 t2 = new Test02();
		
		t1.set(10);
		t2.set(20);
		
		t1.print();
		t2.print();
		
	}

}

class Test02{
	private int a;
	
	public void set(int a) {
		this.a=a; // this ��ü�� �޼ҵ� �ۿ� �ִ� ��� ������Ʈ�� �ҷ��� �� ����
	}
	
	public void print() {
		System.out.println(this.a);
	}
}
