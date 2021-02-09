package com.ex0209;

public class Ex05 {

	public static void main(String[] args) {
		Test5 t = new Test5();
		
		try {
			t.sub(-5);
			System.out.println(t.get());
		} catch (Exception e) {
			System.out.println(e);//print에선 e=e.toString()
		}
		
	}

}

class Test5{
	private int value;
	
	public void set(int value) throws Exception {
		if(value<0)
			throw new Exception("0이상만 가능");
			
		this.value=value;
	}
	
	public int get() {
		return value;
	}
	
	public void sub(int a) throws Exception{
		try {
			set(a);
		} catch (Exception e) {
			//throw e; // 1) catch한 예외를 다시 던짐
			throw new Exception("0이상"); // 2) 새로운 예외를 던짐
		}
	}
}