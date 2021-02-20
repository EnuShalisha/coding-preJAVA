package com.ex0217;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//파일인풋
public class Ex05 {

	public static void main(String[] args) {
		int data;
		String pathname="test.txt";
		
		try(FileInputStream fis = new FileInputStream(pathname)) {
			System.out.println("파일내용");
			while((data=fis.read())!=-1) {
				// 메소드는 똑같음
				System.out.write(data);
			}
			System.out.flush();
		} catch (FileNotFoundException e) {
			// inputstream은 파일 존재하지 않으면 filenotfoundexception 예외 발생
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}

	}

}
