package com.ex0209;

import java.io.FileOutputStream;
import java.io.IOException;

public class Ex08 {
	public static void main(String[] args) {
		int ch;
		/*FileOutputStream fos =null;
		
		try {
			System.out.println("문자열 입력[종료:ctrl+z]");
			fos=new FileOutputStream("test.txt"); 
			while((ch=System.in.read())!=-1) {
				fos.write(ch);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally{//에러가 발생해도 일단 fos를 닫아야 하니까
			if(fos!=null) {
				try {
					fos.close();
				}
				catch(Exception e2) {	
				}
				
			}
		}*/
		
		//try with resources - jdk 7 이상
		//try 괄호 안에 개체를 생성하면
		//finally를 따로 만들지 않아도
		//예외 발생 여부와 상관 없이 자동으로 리소스 close
		try(FileOutputStream fos=new FileOutputStream("test.txt")) {
			System.out.println("문자열입력[ctrl+z:종료]");
			
			while((ch=System.in.read())!=-1) {
				fos.write(ch);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
