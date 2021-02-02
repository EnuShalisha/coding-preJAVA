package com.ex0202;

import java.util.Arrays;

public class Ex07 {

	public static void main(String[] args) {
		String[] ss= {"서울", "부산", "대구", "인천", "광주", "대전"};
		
		print("source data", ss);
		
		Arrays.sort(ss);
		
		print("sort data", ss);

	}
	
	public static void print(String title, String[] ss) {
		System.out.print(title+":");
		for(String s:ss) {
			System.out.print(s+" ");
		}
		System.out.println();
	}

}
