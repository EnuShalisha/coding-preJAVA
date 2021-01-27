package com.ex0127;

public class Ex04 {

	public static void main(String[] args) {
		Test04 t1 = new Test04();
		/*int a[]=t1.random();
		for(int i:a)
		System.out.print(i+" "); // 배열 범위 for일 경우 각 배열의 elements 대표값 i만 써주면 됨
		*/
		int b[]=t1.random(1000, 40);
		int cnt=0;
		for(int i:b) {
			System.out.print(i+" ");
			cnt++;
			if(cnt%10==0)
				System.out.println();}
	}

}

class Test04{
	public int[] random() {
		int arr[]=new int[10];
		for(int i=0; i<10; i++) {
			arr[i]=(int)(Math.random()*100)+1;	
		}
		return arr;
	}
	public int[] random(int n, int size) {
		int arr[]=new int[size];
		int cnt=0;
		for(int i=0; i<size; i++) {
			arr[i]=(int)(Math.random()*n)+1;
		}
		return arr;
	}
}