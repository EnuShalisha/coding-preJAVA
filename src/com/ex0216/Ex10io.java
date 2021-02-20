package com.ex0216;

import java.io.File;

public class Ex10io {

	public static void main(String[] args) {
		String pathname="C:"+File.separator+"user"+File.separator+"test";
		
		File f=new File(pathname);
		if(! f.exists()) {
			System.out.println(pathname+"은 존재하지 않습니다");
			return;
		}
		
		if(f.delete()) {
			System.out.println(pathname+"삭제 완료");
		}

	}

}
