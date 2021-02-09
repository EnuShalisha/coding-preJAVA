package com.ex0209;

public class Ex01 {

	public static void main(String[] args) {
		Test1 t = new Test1();
		t.setValue(-5); // 0으로 나오고, 오류
		System.out.println(t.getValue());

	}

}
//예외처리 안한경우

class Test1 {
	private int value;
	public void setValue(int value) {
		if(value<0)
			return;
		
		this.value=value;
	}
	
	public int getValue() {
		return value;
	}
}