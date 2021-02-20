package com.ex0217;

import java.io.File;
import java.io.FileOutputStream;

public class Ex04 {

	public static void main(String[] args) {
		String pathname="test.txt";
		File f=new File(pathname);
		try(FileOutputStream fos=new FileOutputStream(f, true)) {
			//		없으면 만들고, 있으면 append (추가 삽입)
			//cf. 	없으면 만들고 있으면 지우고 만듬 - new Fileoutputstream(f);
			
			int data;
			System.out.println("문자열 입력[종료:ctrl+z]");
			while((data=System.in.read())!=-1) {
				fos.write(data);
			}
			fos.flush();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
