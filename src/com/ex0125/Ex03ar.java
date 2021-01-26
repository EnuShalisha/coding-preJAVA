package com.ex0125;

public class Ex03ar {

	public static void main(String[] args) {
		int a[] = new int[3];
		int b[] = a;
		
		a[0]=10; a[1]=20; a[2]=30; // new를 안한게 중요
		//new 안넣으면 두 배열의 메모리 주소가 같으므로 동기화
		//a= new int[3] {10, 20, 30}으로 하면 a 자체가 아예 초기화
		//이 때 b 배열(old a)과 a 배열(new a)이 다른 메모리 주소를 가짐.
		
		for(int i=0; i<a.length; i++) 
			System.out.print(a[i]+" ");
		
		System.out.println();
		System.out.println("----");
		
		for(int i=0; i<b.length; i++) 
			System.out.print(b[i]+" ");
		
		System.out.println();
		
		System.out.println(a); // 시작주소
		System.out.println(b);
		
		System.out.println("---------");
		
		b[1]=50;
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}

	}

}
