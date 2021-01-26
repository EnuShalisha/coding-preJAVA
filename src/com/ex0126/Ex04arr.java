package com.ex0126;

public class Ex04arr {

	public static void main(String[] args) {
		char arr[][] = new char[5][5];
		char n='A';
		for(int i=0; i<5; i++) {
			for(int j=4; j>-1; j--) {
				arr[j][i]=n;
				n++;
			}
		}
		for(char aa[]:arr) { 
			for(char a:aa) 	
			System.out.printf("%5c", a);
			System.out.println();
		}

	}

	}

