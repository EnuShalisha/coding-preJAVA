package com.ex0126;

public class Ex01selection {

	public static void main(String[] args) {
		int arr[] = {30, 25, 17, 27, 16};
		int temp=0;
		
		for(int l=0; l<arr.length-1; l++)
		for(int i=l+1; i<arr.length; i++) {
			if(arr[l]>arr[i]) {
				temp=arr[l];
				arr[l]=arr[i];
				arr[i]=temp;
			}
		}
		System.out.print("source data: ");
		for(int a:arr) 
			System.out.print(a+" ");
		System.out.println();
	}
		

}
