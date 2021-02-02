package com.ex0202;

public class Ex09 {

	public static void main(String[] args) {
		String s= "020-080-000000071";
		
		String s1=s.substring(0, s.lastIndexOf("-"));
		String s2=s.substring(s.lastIndexOf("-")+1);
		int n=Integer.parseInt(s2);
		n++;
		
		String s3=s1+"-"+String.format("%08d", n);
		System.out.println(s3);
		

	}

}
