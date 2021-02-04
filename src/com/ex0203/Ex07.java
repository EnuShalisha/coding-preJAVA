package com.ex0203;

import java.text.DecimalFormat;

public class Ex07 {

	public static void main(String[] args) {
		//DecimalFormat fmt = new DecimalFormat("#,##0.0");
		DecimalFormat fmt = new DecimalFormat("#,###.0"); // 일의자리가 1~9일경우 그대로 출력하나, 0이면 출력 x
		
		String s=fmt.format(123456.789);
		System.out.println(s);
		s=fmt.format(0.73);
		System.out.println(s);

		s=fmt.format(5); // format("#,###.#");면 .0이 안나옴 
		System.out.println(s);
	}

}
