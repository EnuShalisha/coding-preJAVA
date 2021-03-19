package com.ex0222;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Ex01 {

	public static void main(String[] args) {
		try {
			Class<?> cls = Class.forName("com.ex0222.Test1");
			//모든 자료형을 다 가져올 수 있음
			
			//객체 생성
			Constructor<?> con = cls.getConstructor(); // 이거 선언하려면 생성자 만들어야함
			Object obj = con.newInstance();
			
			//메소드 정의
			Method m1=cls.getDeclaredMethod("hap", Integer.class, Integer.class);
			Method m2=cls.getDeclaredMethod("sub", int.class, int.class);
			Method m3=cls.getDeclaredMethod("write", String.class, int.class);
			Method m4=cls.getDeclaredMethod("print"); // 파라미터가 없는 경우
			
			//메소드 호출 - 얘가 중요
			Object rt1 = m1.invoke(obj, 20, 5);
			m3.invoke(obj, "합", rt1);
			
			int rt2=(int)m2.invoke(obj, 20, 5);
			m3.invoke(obj, "차", rt2);
			
			m4.invoke(obj);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}

class Test1 {
	public Test1() {}
	
	public Integer hap(Integer a, Integer b) {
		return a+b;
	}
	
	public int sub(int a, int b) {
		return a-b;
	}
	
	public void write(String title, int result) {
		System.out.println(title+"->"+result);
	}
	
	public void print() {
		System.out.println("print...");
	}
}