package com.ex0120;

import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int a, b;
		
		/*System.out.println("薑熱? ");
		a= sc.nextInt();
		b=a>0 ? a: -a;
		System.out.println(a+"曖 瞰渤高 : "+b);
		sc.close();*/

		/*System.out.println("薑熱? ");
		a=sc.nextInt();
		String s;
		s=a%2==0? "礎熱":"�汝�";
		System.out.println(a+"-> "+s);
		sc.close();*/
		
		System.out.println("薑熱? ");
		a=sc.nextInt();
		String s;
		s=a>0?"曄熱":(a<0?"擠熱":"艙");
		System.out.println(a+"->"+s);
		sc.close();
	}

}
