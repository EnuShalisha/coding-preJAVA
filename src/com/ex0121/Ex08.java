package com.ex0121;

public class Ex08 {

	public static void main(String[] args) {
		int s, n;
		/*s=0;
		n=0;
		while(n<10) {
			n++;
			s+=n;
			System.out.println(n);
		}
		System.out.println("결과: "+s);*/
		/*s=0;
		n=10;
		while(n<10) {
			n++;
			s+=n;
			System.out.println(n);
		}
		System.out.println("n: "+n+"결과 :"+s);*/
		/*s=0;
		n=0;
		while(n++<10) { // 연산 순서 1) 0<10 2) n++ | 9<10 n++ | 10<10 n++ => n=11
			s+=n;
			System.out.println(n);
		}
		System.out.println("n: "+n+"결과 :"+s);*/
		
		s=0;
		n=0;
		while(++n<10) { // 연산 순서 1) ++n 1<10 | ++n 9<10 | ++n 10<10 => n=10
			s+=n;
			System.out.println(n);
		}
		System.out.println("n: "+n+"결과 :"+s);
		
	}

}
