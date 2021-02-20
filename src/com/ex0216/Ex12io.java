package com.ex0216;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex12io {

	public static void dirList(String pathname) {
		File file=new File(pathname);
		File[] ff=file.listFiles();
		//경로에 존재하는 모든 파일 또는 폴더에 대한 File 객체
		
		if(ff==null||ff.length==0) {
			return;
		}
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String s;
			for(File f:ff) {
				s=sdf.format(new Date(f.lastModified()));
				if(f.isFile()) {
					System.out.print(f.getName()+"\t");
					System.out.print(s+"\t");
					System.out.println(s.length());
				} else if(file.isDirectory()) {
					System.out.println("["+f.getName()+"]...");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	public static void main(String[] args) {
		dirList("c:\\windows");
		
	}

}
