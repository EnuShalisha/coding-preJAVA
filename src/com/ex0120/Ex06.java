package com.ex0120;

import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int a, b;
		
		/*System.out.println("����? ");
		a= sc.nextInt();
		b=a>0 ? a: -a;
		System.out.println(a+"�� ���� : "+b);
		sc.close();*/

		/*System.out.println("����? ");
		a=sc.nextInt();
		String s;
		s=a%2==0? "¦��":"Ȧ��";
		System.out.println(a+"-> "+s);
		sc.close();*/
		
		System.out.println("����? ");
		a=sc.nextInt();
		String s;
		s=a>0?"���":(a<0?"����":"��");
		System.out.println(a+"->"+s);
		sc.close();
	}

}
