package com.ex0203;

import java.util.Random;

public class Ex02ran {

	/*public static String toNumber5() {
		StringBuilder sb=new StringBuilder();
		Random rd=new Random();
		int n;
		for(int i=0; i<5; i++) {
			n=rd.nextInt(10);
			sb.append(Integer.toString(n));
		}
			
		
		return sb.toString();
	}*/
	
	public static String toNumber3() {
		StringBuilder sb=new StringBuilder();
		Random rd=new Random();
		String n;
		for(int i=0; i<3; i++) {
			n=Integer.toString(rd.nextInt(9)+1);
			if(sb.indexOf(n)>=0) {
				i--;
				continue;
			}
			sb.append(n);
		}
			return sb.toString();
	}
		
	
	public static void main(String[] args) {
		//System.out.println(toNumber5());
		Random rd=new Random();
		int n=rd.nextInt(100000);
		System.out.printf("%05d\n", n);
		
		System.out.println(toNumber3());
		

	}

}
