package com.ex0119;

public class Ex12 {

	/**
	 * 짝수인지 판별하는 메소드
	 * <p> 정수를 2로 나눈 나머지가 0이면 짝수이다</p>
	 * @param num 짝수인지 판별할 수 <code>int</code>
	 * @return 짝수 여부를 반환 <code>boolean</code>
	 */
	public boolean isEven(int num) {
		
		if(num%2==0)
			return true;
		return false;
	}
}
