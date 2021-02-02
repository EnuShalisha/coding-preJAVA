package com.ex0202;

public class Ex03str {

	public static void main(String[] args) {
		// 10자리 임시 패스워드
		String s="qwer1234!@#$";
		StringBuffer sb=new StringBuffer();
		
		int n;
		for(int i=0; i<10; i++) {
			n=(int)(Math.random()*s.length());
			sb.append(s.subSequence(n, n+1));
		}
		System.out.println(sb.toString());
		
	}

}
