package com.ex0217;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Ex02Copy {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		String source, dest;
		FileInputStream fis=null;
		FileOutputStream fos=null;
		File f;
		int len;
		byte[] b=new byte[2048];
		
		try {
			System.out.print("원본파일명.확장자?");
			source=br.readLine(); // c:\source\a.exe
			
			System.out.print("복사할 파일명.확장자?");
			dest=br.readLine(); // c:\source\b.exe
			
			fis=new FileInputStream(source);
			fos=new FileOutputStream(dest);
			
			//바이트배열 b의 길이만킄씩 읽어들여 b에 저장하고 실제 읽어들인 길이를 반환
			//허나 2048바이트를 다 받지 못하는 마지막 페리티가 있음
			long s=System.currentTimeMillis();
			while((len=fis.read(b))!=-1)
				fos.write(b, 0, len); //0번째부터 시작해서 len까지
			fos.flush();
			long e=System.currentTimeMillis();
			System.out.println("파일 복사 완료");
			System.out.println("복사시간:"+(e-s)+"ms");
			
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
