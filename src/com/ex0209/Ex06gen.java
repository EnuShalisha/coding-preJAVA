package com.ex0209;

public class Ex06gen {

	public static void main(String[] args) {
		Demo6 d = new Demo6();
		d.print(100);
		d.print("seoul"); // 이경우엔 어떤 타입이던 다 받을 수 있음

	}

}
class Demo6{
	//제네릭 메소드
	public <U> void print(U u) {
		 System.out.println(u.getClass().getName()+","+u);
	}
}