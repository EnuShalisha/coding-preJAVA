package com.ex0216;

import java.io.File;

public class Ex09io {

	public static void main(String[] args) {
		String pathname="C:"+File.separator+"user"+File.separator+"test";
		
		try {
			File f=new File(pathname);
			if(!f.exists()) {
				f.mkdirs();
				System.out.println("폴더 생성");
			}
			System.out.println("폴더명:"+pathname);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
