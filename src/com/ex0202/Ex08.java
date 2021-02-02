package com.ex0202;

public class Ex08 {

	public static void main(String[] args) {
			String[] ss= {"서울", "부산", "대구", "인천", "광주", "대전"};
			
			print("source data", ss);
		int pass;
		String t;
		boolean b;
		
		pass=1;
		do {
			b=false;
			for(int i=0; i<ss.length-pass; i++){
				t=ss[i]; ss[i]=ss[i+1]; ss[i+1]=t;
				b=true;
			}
			pass++;
		} while(b);

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
