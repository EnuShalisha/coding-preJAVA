package com.ex0125;

public class Ex04ar {

	public static void main(String[] args) {
		int a[] = new int[3];
		
		a[0]=10; a[1]=20; a[2]=30;
		
		for(int i=0; i<a.length; i++) 
			System.out.print(a[i]+" ");
		
		System.out.println();
		System.out.println("----");
		
		System.out.println(a);
		a=new int[5]; // new, 또는 '조작'을 통해서만 영역의 확장/축소가 가능 
		System.out.println(a);
		for(int i=0; i<a.length; i++)
			System.out.print(a[i]+" ");
		
		System.out.println();
	}

}
