package com.ex0217;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex01BufferedReader {

	public static void main(String[] args) {
		//system.in: 표준입력, byte 스트림
		//inputstreamreader : byte -> 문자 스트림으로 변환
		//bufferedreader: 문자 스트림으로 필터 스트림
		BufferedReader br = new BufferedReader
				(new InputStreamReader(System.in));
		
		String name;
		int age;
		
		try {
			System.out.print("이름?");
			name=br.readLine();
			System.out.print("나이?");
			age=Integer.parseInt(br.readLine());
			System.out.println(name+":"+age);
		} catch (NumberFormatException e) {
			System.out.println("나이는 숫자만");
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
