package com.ex0119;

public class Ex5 {

	public static void main(String[] args) {
		float a;
		double b;
		int c;
		
		a=10; // a->int���� float�� ���� -> 10.0
		
		//a=0.5;  0.5�� double�� ���ͷ� -> ����
		b=0.5;
		
		a=0.5f; // float���� ��ȯ �Ϸ�
		c=100;
		b=c; // int�� float�� ������ ����
		//c=b;  float�� int�� ���� �Ұ���

	}

}
