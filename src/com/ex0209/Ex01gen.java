package com.ex0209;

import java.util.Arrays;

public class Ex01gen {

	public static void main(String[] args) {
		Object[] ob = new Object[5];
		
		ob[0]=new Integer(10);
		ob[1]=new Integer(5);
		ob[2]=new String("서울");
		ob[3]=new String("부산");
		ob[4]=new Integer(7);
		
		Arrays.sort(ob); // classCastException: object 안에 각각 다른 자료형이 있기때문
		Integer a = (Integer) ob[0]; // 원래는 다운캐스팅 필요
	}

}
