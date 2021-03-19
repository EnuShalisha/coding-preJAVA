package com.ex0225;

public class Ex01 {

	public static void main(String[] args) {
		User1 u=(a, b) -> {return a+b;};
		
		int x=u.add(10, 5);
		System.out.println(x);
	}

}

@FunctionalInterface 
interface User1{//에러 - 람다에 부적합 - 2개 이상 메소드는 x
	public int add(int a, int b);
}