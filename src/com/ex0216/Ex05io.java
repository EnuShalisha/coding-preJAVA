package com.ex0216;

public class Ex05io {

	public static void main(String[] args) {
		//system.out: printstream 객체
		//printstream: 	다양한 출력이 가능한 출력 스트림(필터 스트림)
				//outputstream.write vs printstream.write
		//				IOException이 발생하지 않음
		System.out.write(65); //하위 1byte만 버퍼 출력
		System.out.write(66);
		System.out.write(67);
		
		System.out.write(180);
		System.out.write(235);
		System.out.write(199);
		System.out.write(209);
		System.out.flush(); //버퍼의 내용을 출력장치로 보냄
	}

}
