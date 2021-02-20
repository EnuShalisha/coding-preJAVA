package com.ex0217;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Ex03Copy {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		String source, dest;
		FileInputStream fis=null;
		FileOutputStream fos=null;
		File f;
		int data;
		
		try {
			System.out.print("원본파일명.확장자?");
			source=br.readLine(); // c:\source\a.exe
			
			System.out.print("복사할 파일명.확장자?");
			dest=br.readLine(); // c:\source\b.exe
			
			fis=new FileInputStream(source);
			fos=new FileOutputStream(dest);
			
			while((data=fis.read())!=-1)
				fos.write(data); // 얘가 1바이트씩을 받으니까 엄청느림
			fos.flush();
			System.out.println("파일 복사 완료");
			
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않음");
		} 
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			if(fos!=null) {
				try {
					fos.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}

	}

}
