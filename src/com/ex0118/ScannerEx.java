package com.ex0118;

import java.util.Scanner;

public class ScannerEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name;
		int age;
		char gender;
		double h;
		
		System.out.print("이름 ?");
		name=sc.next();
		System.out.print("나이 ?");
		age=sc.nextInt();
		System.out.print("성별(m/f) ?");
		gender=sc.next().charAt(0);
		System.out.print("키 ?");
		h=sc.nextDouble();
		
		System.out.println("이름: "+name);
		System.out.println("나이: "+age);
		System.out.println("성별: "+gender);
		System.out.println("키: "+h+"cm");
		
		sc.close();

	}

}
