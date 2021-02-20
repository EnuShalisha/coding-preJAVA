package com.ex0217;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Ex07fr {

	public static void main(String[] args) {
		String pathname="ex.txt";
		int data;
		
		try (FileReader fr=new FileReader(pathname)){
			//Reader rd=new InputStreamReader(new FileInputStream(pathname)));
			while((data=fr.read())!=-1) {
				char c=(char)data;
				System.out.print(c);
			}
			System.out.println();
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않음");
		}catch (Exception e) {
			// TODO: handle exception
		}

	}

}
