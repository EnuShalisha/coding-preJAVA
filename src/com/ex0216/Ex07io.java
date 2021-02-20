package com.ex0216;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class Ex07io {

	public static void main(String[] args) {
		int data;
		try {
			//문자입력 스트림
			Reader rd= new InputStreamReader(System.in);
			//문자출력 스트림
			Writer wt= new OutputStreamWriter(System.out);
			
			System.out.println("문자열[ctrl+z:종료]");
			while((data=rd.read())!=-1) {
				wt.write(data);
			}
			wt.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
