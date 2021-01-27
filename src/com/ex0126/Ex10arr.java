package com.ex0126;

public class Ex10arr {

	public static void main(String[] args) {
		int a[][]= {{10, 20, 30},{40, 50, 60}};
		int b[][]= new int[a.length][a[0].length];
		
		System.out.println("a...");
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) 
				System.out.print(a[i][j]+" ");
			System.out.println();
		}
		
		System.out.println("a...");
		for(int i=0; i<b.length; i++) {
			for(int j=0; j<b[i].length; j++) 
				System.out.print(b[i][j]+" ");
			System.out.println();
		}
		
	b[1][1]=100;
	System.out.println(a[1][1]+" , "+b[1][1]);

	}

}
