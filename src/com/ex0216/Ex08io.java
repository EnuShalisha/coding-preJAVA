package com.ex0216;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex08io {

	public static void main(String[] args) {
		String appDir=System.getProperty("user.dir");
		System.out.println("현재 작업 경로:"+appDir);
		
		String pathname=appDir+File.separator+"ex.txt";
		System.out.println(pathname);
		
		//File: 파일이나 폴더의 정보, 폴더 생성, 생성등
		File f=new File(pathname);
		
		if(!f.exists()) {
			System.out.println(pathname+"파일이 존재하지 않습니다");
			return;
		}
		
		try {
			String s;
			long n;
			
			System.out.println("파일정보");
			s=f.getName();
			System.out.println("파일명: "+s);
			System.out.println("경로:"+f.getPath());
			System.out.println("절대경로:"+f.getAbsolutePath());
			System.out.println("표준경로:"+f.getCanonicalPath());
			System.out.println("부모경로:"+f.getParent());
			
			n=f.length();
			System.out.println("파일길이(byte): "+n);
			System.out.println("파일생성일:"+new Date(f.lastModified()));
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			System.out.println("파일생성일:"+sdf.format(new Date(f.lastModified())));
			
			System.out.println("읽기속성:"+f.canRead());
			System.out.println("쓰기속성:"+f.canWrite());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
