package com.ex0121;

<<<<<<< HEAD
import java.util.Scanner;

public class Ex01wh {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 입력: ");
		int a=sc.nextInt();
		int n=1; int s=0;
		if(a<0) 
			System.out.println("오류입니다.");
		else {while(n<=a)
				{s+=n;
				n+=2;
		}
		System.out.printf("1부터 %d까지의 홀수합은 %d입니다.", a, s);}

=======
public class Ex01wh {

	public static void main(String[] args) {
		int s, n;
		/*s=0; n=0;
		while(n<100) {
			n+=2;
			s+=n;
			System.out.println(n);
		}
		System.out.println("결과: "+s);*/
		
		s=0; n=1;
		while(n<100) {
			s+=n;
			n+=2;
			System.out.println(n);
		}
		System.out.println("결과: "+s);
		//test4
>>>>>>> refs/heads/test2
	}

}
