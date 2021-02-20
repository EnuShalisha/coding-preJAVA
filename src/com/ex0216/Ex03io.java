package com.ex0216;

import java.io.IOException;

public class Ex03io {

	public static void main(String[] args) {
		int data;
		try {
			//연속된 문자열 출력
			System.out.println("ABCDEF 입력 후 엔터");
			data=System.in.read();//A를 입력받음
			System.out.write(data); // 출력 버퍼로 보냄. 출력 버퍼가 차지 않으면 출력 장치로 보내지 않음.
			System.in.skip(2); // 2byte만큼 버림 : BC
			data=System.in.read();
			System.out.write(data);
			System.in.skip(4);//EF엔터버림
			System.out.flush();//버퍼 내용을 출력장치로
			
		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}
