package com.ex0217;

import java.io.File;
import java.io.FileOutputStream;

public class Ex03io {

	public static void main(String[] args) {
		String pathname="text.txt";
		File f=new File(pathname);
			//파일 안에 내용을 넣어보자
			//파일처리 본격적으로 시작
			//파일이 있으면 덮어씀
		int data;
		try(FileOutputStream fos=new FileOutputStream(f)) { // try에 넣을경우 자동 close 되는걸 이용한 예시
			//요걸 try resources라고 함
			System.out.println("문자열 입력[종료: ctrl+z]...");
			while((data=System.in.read())!=-1) {
				fos.write(data); // 이건 하위 1byte만 파일에 저장
			}
			fos.flush(); // 버퍼 밀어줌
			//생략 가능함 - fos.close를 finally로 넣을 경우
			System.out.println("파일 저장 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
			}
			
	
		

	}
