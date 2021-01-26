package com.ex0126;

public class Ex03bubble {

	public static void main(String[] args) {
		int[] arr = {2, 3, 5, 6, 8, 9, 10, 31, 20};
		int temp, pass=1;
		boolean flag=false;
		
		do {
			flag=false;
			for(int i=0; i<arr.length-pass; i++) {
				if(arr[i]>arr[i+1]) {
					temp=arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=temp;
					flag=true;
				}
			}
			pass++;
		}while(flag);
			
			System.out.print("source data: ");
			for(int a:arr) 
				System.out.print(a+" ");
			System.out.println();
			System.out.println("실행횟수: "+(pass-1));

	}

}
