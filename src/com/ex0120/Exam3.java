package com.ex0120;

public class Exam3 {

	public static void main(String[] args) {
		char a='A';
		char b='A'+10;
		System.out.println(a+","+b);
		
		b='A'+3; // ���ͷ�+���ͷ� -> ����ȯ x
		System.out.println(b);
		//b=a+3; ����+���ͷ� -> int������ �ڵ���ȯ�� �ƴϰ�, �׳� ������ ����
		b=(char)(a+3);
		System.out.println(b);
		
		double x=15/2; // 15�� 2�� �Ѵ� �������ͷ� -> ����ȯ �Ͼ�� �ʰ� ������ ���
		double y=15.0/2.0; // �Ѵ� �������϶��� ����� �������·�
		System.out.println(x+" "+y);

	}

}
