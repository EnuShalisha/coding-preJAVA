package com.ex0208;

public class Ex06 {

	public static void main(String[] args) {
		Sample6 ss = new Sample6();
		String s="10a";
		
		System.out.println(ss.isInt(s)); // 3rd : 여기선 return이 boolean이므로 false
			//정수가 아님
			//예외 유무 상관없이 실행
			//false
		
		
		System.out.println(ss.isInt("10"));
			//예외 유무 상관없이 실행
			//true

	}

}

class Sample6 {
	public int toInt(String s) {
		int n;
		
		try {
			n=Integer.parseInt(s);
			return n;
		} catch (Exception e) {
			//문제가 있으면 -> 리턴 안됨+되면 안됨 -> 메소드 리턴타입 컴파일 에러
			throw new RuntimeException("숫자가 아님");
			//문제가 있으면 -> 런타임에러를 이유로 던짐 -> 리턴 x
		} finally {// catch 없어도 파이널리만 넣을수 있기는함
			System.out.println("예외 유무 상관없이 실행");
		}
	}
	
	public boolean isInt(String s) {
		
		try {
			//int n= 어차피 int로 리턴도 안하므로
			Integer.parseInt(s);
			return true;
		} catch (Exception e) {
			System.out.println("정수가 아님"); // 1st
			return false;
		} finally {
			System.out.println("예외 유무 상관없이 실행"); // 2nd
			//return, break를 만나도 반드시 실행
			//system.exit(0);으로 프로그램 강제 종료하면 실행 x
		}
	}
}