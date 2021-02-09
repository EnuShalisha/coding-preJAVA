package com.ex0209;

public class Ex02 {
//checked 예외는 이렇게 만들어진다
	public static void main(String[] args) {//JVM으로 예외 던지지 말것
		Test2 t = new Test2();
		try {
			t.setValue(-5); // 얘가 예외처리를 안해서 컴파일 오류
			System.out.println(t.getValue());
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
//예외처리 안한경우

class Test2 {
	private int value;
	public void setValue(int value) throws Exception{
		if(value<0)
			//return; 대신에
			throw new Exception("0이상만 가능");
		//꼭 try catch일 필요는 없는듯 - 예외처리를 다른곳에서 하도록 명시
		
		this.value=value;
	}
	
	public int getValue() {
		return value;
	}
}