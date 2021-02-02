package com.ex0202;

public class Ex02str {

	public void stringTest() {
		long start=System.currentTimeMillis();
		String s="a";
		for(int i=1; i<100000; i++) {
			s+="a";
		}
		System.out.println("길이:"+s.length());
		long end=System.currentTimeMillis();
		
		System.out.println("String 시간: "+(end-start)+"ms");
	}
	
	public void stringBufferTest() {
		long start=System.currentTimeMillis();
		StringBuffer sb = new StringBuffer("a");
		for(int i=1; i<100000; i++) {
			sb.append("a");
		}
		System.out.println("길이: "+sb.length());
		long end=System.currentTimeMillis();
		System.out.println("StringBuffer 시간: "+(end-start)+"ms");
	}
	public static void main(String[] args) {
		Ex02str t = new Ex02str();
		t.stringTest();
		t.stringBufferTest();
			
		

		
	
	}
	
}
