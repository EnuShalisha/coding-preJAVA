package com.ex0201;

public class Ex05 {

	public static void main(String[] args) {
		//Test5 t = new Test5();
		//t.print();
		
		Test5 t = Test5.getInstance();
		Test5 t2 = Test5.getInstance();
		
		System.out.println(t == t2);
	}

}

// singleton
class Test5{
	private static Test5 t = null;
	
	private Test5() {
		
	}
	
	public static Test5 getInstance() {
		if(t==null) {
			t=new Test5();
		}
	return t;
	}
}