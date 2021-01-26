package com.ex0126;

public class Ex05arr {

	public static void main(String[] args) {
		int arr[][] = new int[4][5];
		int n=1;
		for(int i=0; i<arr.length; i++) {
			
			if(i%2==0)
			{for(int j=0; j<arr[i].length; j++) 	
				arr[i][j]=n++;}
			else
			{for(int j=0; j<arr[i].length; j++) 
				arr[i][4-j]=n++;}
			
		}
		for(int aa[]:arr) { 
			for(int a:aa) 	
			System.out.printf("%5d", a);
			System.out.println();
		}


	}

}
