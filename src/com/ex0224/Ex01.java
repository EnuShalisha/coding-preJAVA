package com.ex0224;

public class Ex01 {

	public static void main(String[] args) {
		User1 ob = new UserImp1();
		ob.write();
		System.out.println();

		
		//익명 클래스
		User1 uu = new User1() {
			
			@Override
			public void write() {
				System.out.println("익명 클래스");
				
			}
		};
		uu.write();
		//문제점: 위에서 코드 2줄만 추가하고싶으면?
		
		//람다식
		User1 u1 = () -> {System.out.println("람다식");};
		u1.write();
	}

}

interface User1 {
	public void write();
}

class UserImp1 implements User1 {
	@Override
	public void write() {
		System.out.println("구현 클래스");
		
	}
}