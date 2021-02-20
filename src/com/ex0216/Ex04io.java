package com.ex0216;

import java.io.OutputStream;

public class Ex04io {

	public static void main(String[] args) {
		byte[] b= {65, 66, 67, 68, 69};
		try {
			//outputStream: 출력 byte 스트림
			OutputStream os = System.out;
			
			os.write(b[0]);
			System.out.println();
			
			os.write(b); // 바이트 배열의 내용을 출력 //ABCDE
			System.out.println();
			
			os.write(b, 2, 3); // CDE
			System.out.println();
			
			os.write(b, 0, b.length);
			System.out.println();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
