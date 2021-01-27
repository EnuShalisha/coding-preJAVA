package com.ex0126;

public class Ex08arr {
	public static void main(String[] args) {
		String s1[]={"java", "oracle", "spring"};
		String s2[]=new String[s1.length+3];
		
		System.arraycopy(s1, 0, s2, 1, s1.length-1);
		
		System.out.println("s1...");
		for(String s:s1) 
			System.out.print(s+" ");
		System.out.println();
		
		System.out.println("s2...");
		for(String s:s2) 
			System.out.print(s+" ");
		System.out.println();
	}

}
