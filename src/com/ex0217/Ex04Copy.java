package com.ex0217;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Ex04Copy {

	public final static int BUFFER_SIZE=2048;
	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		String source, dest;
		BufferedOutputStream bos=null;
		BufferedInputStream bis=null;

		File f;
		int len;
		byte[] b=new byte[BUFFER_SIZE];
		
		try {
			System.out.print("원본파일명.확장자?");
			source=br.readLine(); // c:\source\a.exe
			
			System.out.print("복사할 파일명.확장자?");
			dest=br.readLine(); // c:\source\b.exe
			
			bis=new BufferedInputStream(new FileInputStream(source));
			bos=new BufferedOutputStream(new FileOutputStream(dest), BUFFER_SIZE);
			
			//바이트배열 b의 길이만킄씩 읽어들여 b에 저장하고 실제 읽어들인 길이를 반환
			//허나 2048바이트를 다 받지 못하는 마지막 페리티가 있음
			long s=System.currentTimeMillis();
			while((len=bis.read(b))!=-1)
				bos.write(b, 0, len); //0번째부터 시작해서 len까지
			bos.flush();
			long e=System.currentTimeMillis();
			System.out.println("파일 복사 완료");
			System.out.println("복사시간:"+(e-s)+"ms");
			
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않음");
		} 
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(bis!=null) {
				try {
					bis.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			if(bos!=null) {
				try {
					bos.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}

	}

}
