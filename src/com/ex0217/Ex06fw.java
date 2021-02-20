package com.ex0217;

import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.Reader;

public class Ex06fw {

	public static void main(String[] args) {
		String pathname="ex.txt";
		int data;
		
		try(FileWriter fw=new FileWriter(pathname)) {
			//Writer wt=new OutputStreamWriter(new FileoutputStream(pathname));
		
			System.out.println("문자열 입력[ctrl+z:입력완료]");
			Reader rd=new InputStreamReader(System.in);
			while((data=rd.read())!=-1)
				fw.write(data);
			
		} catch (Exception e) {
			
		}

	}

}
