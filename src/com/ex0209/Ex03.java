package com.ex0209;

public class Ex03 {
//unchecked 예외는 이렇게 만든다
	public static void main(String[] args) {
		Test3 t = new Test3();
		try {
			t.setValue(-5); // 0으로 나오고, 오류
			System.out.println(t.getValue());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

	}

}
//예외처리 안한경우

class Test3 {
	private int value;
	public void setValue(int value) {
		if(value<0)
			throw new RuntimeException("0이상만 가능");
		//런타임 예외기때문에 위 조건에 해당되면 프로그램 뻗음
		//즉 throw 예외를 만들 필요 x
		
		this.value=value;
	}
	
	public int getValue() {
		return value;
	}
}