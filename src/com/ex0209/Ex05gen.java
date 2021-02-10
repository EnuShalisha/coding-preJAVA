package com.ex0209;

public class Ex05gen {

	public static void main(String[] args) {
		Demo5<Integer> dd=new Demo5<>();
		dd.print(new Integer(10));
		
		//Demo5<String> dd2=new Demo5<>(); // 타입 미스로 인한 컴파일 오류

	}

}
//제한된 타입 파라미터
class Demo5<T extends Number>{
	public void print(T t) {
		System.out.println(t.getClass().getName()+","+t);
	}
}