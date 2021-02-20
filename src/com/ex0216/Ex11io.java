package com.ex0216;

import java.io.File;
import java.util.Calendar;

public class Ex11io {

	public static void main(String[] args) {
		String appDir=System.getProperty("user.dir");
		String pathname=appDir+File.separator+"ex.txt";
		File f=new File(pathname);
		if(!f.exists()) {
			System.out.println(pathname+" 없음");
			return;
		}
		
		if(!f.isFile()) {
			System.out.println(pathname+"파일이 아님");
			return;
		}
		
		String ext=pathname.substring(pathname.lastIndexOf("."));
		System.out.println(ext);
		
		String s=String.format("%1$tY%1$tm%1$td%1$tH%1$tM%1$tS", Calendar.getInstance());
		s+=System.nanoTime()+ext;
		System.out.println(s);
		
		try {
			String newPath = appDir+File.separator+s;
			File dest=new File(newPath);
			f.renameTo(dest);
			System.out.println("파일명 변경 완료");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
