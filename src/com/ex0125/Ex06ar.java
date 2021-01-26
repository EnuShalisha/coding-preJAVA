package com.ex0125;

public class Ex06ar {

	public static void main(String[] args) {
		int a[]=new int[] {10, 20, 30};
		int b[]=a;
		
		a=new int[5];
		for(int i=0; i<a.length; i++) 
			System.out.print(a[i]+" ");
		System.out.println();
		for(int i=0; i<a.length; i++) 
			System.out.print(b[i]+" ");

	}

}
