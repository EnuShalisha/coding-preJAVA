package com.ex0118;

import java.util.Scanner;

public class ScannerEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name;
		int age;
		char gender;
		double h;
		
		System.out.print("�̸� ?");
		name=sc.next();
		System.out.print("���� ?");
		age=sc.nextInt();
		System.out.print("����(m/f) ?");
		gender=sc.next().charAt(0);
		System.out.print("Ű ?");
		h=sc.nextDouble();
		
		System.out.println("�̸�: "+name);
		System.out.println("����: "+age);
		System.out.println("����: "+gender);
		System.out.println("Ű: "+h+"cm");
		
		sc.close();

	}

}
