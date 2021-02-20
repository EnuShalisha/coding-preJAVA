package com.ex0217;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Ex10bw {

	public static void main(String[] args) {
		try(BufferedWriter bw=new BufferedWriter(new FileWriter("test.txt"))) {
			bw.write("대한");
			bw.write("민국");
			bw.write("서울");
			bw.newLine();
			bw.write("자바");
			bw.newLine();
			
			System.out.println("저장 완료");
			
		} 
		catch (Exception e) {
			// TODO: handle exception
		}

	}

}
