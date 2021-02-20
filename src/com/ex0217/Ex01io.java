package com.ex0217;

import java.io.File;

public class Ex01io {

	public static void removeDir(String pathname) {
		try {
			File f=new File(pathname);
			if(f.isDirectory()) {
				removeSubDir(pathname);
			}
			f.delete(); // 파일 또는 폴더 삭제
						// 한번에 하나만 삭제가능
						// 폴더는 비어 있어야 삭제 가능
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private static void removeSubDir(String pathname) {
		File[] ff=new File(pathname).listFiles(); // 경로안에 존재하는 모든 파일, 폴더에 대한 파일객체
		try {
			if(ff.length==0) {
				return;
			}
			for(File f:ff) {
				if(f.isDirectory())
					removeSubDir(f.getPath()); // 재귀호출
				f.delete();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args) {
		removeDir("C:\\user");

	}

}
