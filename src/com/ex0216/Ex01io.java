package com.ex0216;

import java.io.IOException;

public class Ex01io {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data;
		char ch;
		
		//InputStream: byte 입력 스트림의 최상위 추상클래스
		//System.in: byte 입력 스트림으로 InputStream 객체
		//InputStream 	read(): 1byte 문자를 읽어 들여 ascii 코드 반환
		//				read()로 한글을 입력받으려면 두번 입력해야함(한글은 2byte이므로)
		///				read()는 checked exception이므로 예외처리 필수(IOException)
		
		//ex. "ABC엔터"를 입력하면
		//65 66 67 13 10 => 5번 입력됨(엔터는 2byte: \r\n)
		
		try {
			System.out.println("문자열 입력[ctrl+z:종료]");
			while((data=System.in.read())!=-1) {
				ch=(char)data;
				//System.out.println(ch);
				//2BYTE 문자를 1BYTE로만 읽어 2BYTE로 출력하려니 깨질수밖에
				//System.out.write(ch); // 한글 안깨지는 방법
				System.out.write(data); // char형 말고 그대로 data를 받아도 됨
				//4byte 중 하위 1byte만 출력
				//위를 1BYTE로 출력하는 방법
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
