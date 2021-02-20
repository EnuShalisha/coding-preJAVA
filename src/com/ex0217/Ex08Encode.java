package com.ex0217;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class Ex08Encode {

	public static void main(String[] args) {
		// MS949(euc-kr/완성형 코드) 형식의 데이터를 UTF-8로 저장
		String pathname="test.txt";
		int data;
		
		Reader rd=null;
		
		try(Writer wt=new OutputStreamWriter(new FileOutputStream(pathname), "UTF-8")) {
			rd=new InputStreamReader(System.in, "MS949");
			
			System.out.println("문자열[종료]:ctrl+z]");
			while((data=rd.read())!=-1) {
				wt.write(data);
			}
			wt.flush();
			System.out.println("파일 저장 완료");
			
		} catch (FileNotFoundException e) {
			System.out.println("파일 존재하지 않음");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
