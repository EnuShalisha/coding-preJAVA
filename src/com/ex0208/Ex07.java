package com.ex0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex07 {
	//메인메소드는 vm이 부름
	//즉 vm에서 throws에 해당하는 예외를 예외처리해야함
	//문제: 이외에 발생할 수 있는 예외 명시 안하면 똑같이 프로그램 터짐
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		int a, b, c;
		
		System.out.print("수1 ? ");
		a=Integer.parseInt(br.readLine());
		
		System.out.print("수2 ? ");
		b=Integer.parseInt(br.readLine());
		
		c=a+b;
		
		
		
	}

}
