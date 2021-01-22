package com.ex0122;

public class Ex01 {

	public static void main(String[] args) {
		/*int n, s;
		s=0;
		for(n=1; n<=10; n++) {
			System.out.println("안:"+n);
			s+=n;
		}
		//n=1 n<=1- s+=n n++ n<=10 s+=n n++ ...
		System.out.println("밖: n:"+n+", "+s);*/
		
		/* int s=0;
		for(int n=1; n<=10; n++) { // for문에서만 실행되는 변수 선언 가능
			s+=n;
		} 
		//	System.out.println(n);
		System.out.println(s);*/
		
		/* for(in n=10; n<10; n++;) {
			System.out.println("안: "+n);
		}
		System.out.println("end..."); */
		
		/*int n;
		for(n=5; n>=1; n--) {
			System.out.println("안"+n);
		}
		System.out.println("밖"+n);*/
		int n=0;
		for(n=2; n<=10; n+=2) {
			System.out.println("안"+n);
		}
		System.out.println("밖"+n);
	}

}
