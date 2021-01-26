package com.ex0126;

import java.util.Iterator;

public class Ex04insertion {

	public static void main(String[] args) {
		int arr[] = {25, 10, 8, 5, 12, 9, 18, 16, 20, 13};
		int i, j, key;
		
		System.out.println("source data: ");
		for(int a:arr) 
			System.out.print(a+" ");
		System.out.println();
		System.out.println("--------------------");
		
		for(i=1; i<arr.length; i++) {
			key=arr[i];
			for(j=i-1; j>=0; j--) {
				if(key<arr[j])
					arr[j+1]=arr[j];
				else
					break;
			}
			arr[j+1]=key;
		}
		System.out.println("sort data: ");
		for(int a:arr) 
			System.out.print(a+" ");
	}

}
