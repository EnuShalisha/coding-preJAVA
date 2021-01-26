package com.ex0126;

public class Ex02bubble {

	public static void main(String[] args) {
		int[] arr = {60, 23, 5, 84, 3};
		int temp;
		
		for(int l=1; l<arr.length; l++)
			for(int i=0; i<arr.length-l; i++) {
				if(arr[i]>arr[i+1]) {
					temp=arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=temp;
				}
			}
			System.out.print("source data: ");
			for(int a:arr) 
				System.out.print(a+" ");
			System.out.println();

	}

}
