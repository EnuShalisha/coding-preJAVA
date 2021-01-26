package com.ex0125;

public class Ex01ar {

	public static void main(String[] args) {
		int num[]= {10, 21};
		System.out.println(num[0]);
		num=new int[5]; // 새로운 메모리 주소 5개 - 기존 주소 삭제
		
		//num은 reference 변수 -> 각 값은 각각의 주소에 담겨있음
		int a;// 얘는 기본 자료형
		String c="a"; // 얘는 객체(메모리가 할당돼있지 않으면 null)
		//System.out.println(a); 컴파일 에러
		System.out.println(num[0]); // 새로운 값 0이 들어가있음
		
		// System.out.println(num[5]);  5를 쓸 경우 런타임 에러

		num= new int[] {2, 4, 6, 8, 10};
		System.out.println(num.length+"개의 인수");
		for(a=0; a<num.length; a++) 
			System.out.println(num[a]+" ");
		System.out.println("---------------------------");
		
		//새로운 for문
		for(int i:num) {
			System.out.print(i+" ");
		}
		System.out.println();
	}

}
