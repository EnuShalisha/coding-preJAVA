package com.ex0219;

public class Ex02rfl {

	public static void main(String[] args) {
		// User u = new UserImpl();
		
		// 다른 방법으로 객체 생성"
		
		String clsName="com.ex0219.UserImpl";
		
		try {
			Class<?> cls = Class.forName(clsName);
			
			//객체 생성
			
			User u=(User)cls.newInstance();
			
			int s=u.add(10, 5);
			u.print("합", s);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}

interface User{
	public int add(int a, int b);
	public void print(String title, int result);
}

class UserImpl implements User{

	@Override
	public int add(int a, int b) {
		return a+b;
	}

	@Override
	public void print(String title, int result) {
		System.out.println(title+"->"+result);
		
	}
	
}