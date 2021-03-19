package com.ex0224;

public class Ex02 {

	public static void main(String[] args) {
		
		//파라미터 있고 리턴타입은 없는 경우
		//User2 u = (int a) -> {int n=a+10; System.out.println(n);};
		//파라미터의 자료형은 생략 가능
		User2 u = a -> System.out.println(a+10); // 이런식으로 썼을 때 함수 구현처럼 보임
		
		u.sub(0); // 0 input -> 10 output
	}

}

interface User2 {
	public void sub(int a);
	
}