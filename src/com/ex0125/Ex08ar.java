package com.ex0125;

public class Ex08ar {

	public static void main(String[] args) {
		int a[]= {10, 20, 30}; // 선언 동시에 초기화 하는경우에만 new int 생략 가능
		
		int b[];
		//b[]={1, 3, 5, 7, 9}; 이게 안된다는거
		b=new int[] {1, 3, 5, 7, 9};
		for(int n:a) 
			System.out.println(n+" ");
		for(int n:b) 
			System.out.println(n+" ");
		
	}

}
