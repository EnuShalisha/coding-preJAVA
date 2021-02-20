package com.ex0216;

import java.io.InputStreamReader;
import java.io.Reader;

public class Ex06io {

	public static void main(String[] args) {
		int data;
		char ch;
		
		try {
			//InputStreamReader: byte 스트림을 문자스트림으로 (bridgestream)
			//ex. "대": byte스트림은 2번 입력, 문자스트림은 1번만 입력
			//"ABC대한엔터" - bytestream:inputstream = 9:7
			//엔터는 상관없이 두번:두글자이기 때문
			//그러나 형식을 바꿔버리기 때문에 멀티미디어에 맞지 않음
			Reader rd = new InputStreamReader(System.in);
			System.out.println("문자열입력[ctrl+z:종료]");
			while((data=rd.read())!=-1) {
				//System.out.println(data);
				ch=(char)data;
				//System.out.write(ch);//2byte문자를 1byte출력하므로 깨짐
				System.out.print(ch);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
