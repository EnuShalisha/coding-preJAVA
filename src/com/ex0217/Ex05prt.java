package com.ex0217;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Ex05prt {

	public static void main(String[] args) {
		try(PrintStream ps=new PrintStream("text.txt")) {
			ps.printf("%s, %d, %d\n", "홍길동", 80, 90);
			ps.print("JAVA");
			ps.print("HTML");
			ps.println("CSS");
			
			System.out.println("파일 저장 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//FileInputStream: 파일 -> byte 스트림
		//InputStreamReader: byte->문자 스트림
		//BufferedReader: 한줄씩 입력 가능 // 원래는 한문자씩밖에 입력이 안되는 걸
		BufferedReader br=null;
		String s;
		try {
			br=new BufferedReader(new InputStreamReader(new FileInputStream("text.txt")));
			while((s=br.readLine())!=null) {
				System.out.println(s);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if(br!=null) {
				try {
					br.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}

	}

}
