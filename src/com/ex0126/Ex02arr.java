package com.ex0126;

public class Ex02arr {

	public static void main(String[] args) {
		int arr[][] = new int[4][5];
		int cnt=1;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j]=cnt;
				cnt++;
			}
		}
		for(int aa[]:arr) { 
			for(int a:aa) 	
			System.out.printf("%5d", a);
			System.out.println();
		}
	}

}
