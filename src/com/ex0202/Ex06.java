package com.ex0202;

public class Ex06 {

	public static void main(String[] args) {
		
		int n=1;
		String s;
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				s=Integer.toString(n);
				s=s.replaceAll("(3|6|9)", "*");
				if(s.indexOf("*")!=-1)
					s="*";
					//s=s.replaceAll("\\d", "");
				System.out.print(s+"\t");
				n++;
			}
			System.out.println();
		}
		
		
		

	}

}
