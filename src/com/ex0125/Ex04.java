package com.ex0125;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n;
		double num, s=0;
		System.out.println("5���� �Ǽ� �Է�:");
		for(n=0; n<5; n++) { // while �μ��� ++�� �� ���� ����
			//�迭 �޸𸮿� �µ��� 0���� ����, ���� ��ȣ �ȳְ� 5�� ������ 5�� �� �ִ°ɷ� ������ ���
			num=sc.nextDouble();
			if(num<=0)
				{n--;
				continue;}
			s+=num;
			//n++;�� ���⿡ �ٿ��� ����
		}
		System.out.println("��: "+s);
		sc.close();
	}

	}

