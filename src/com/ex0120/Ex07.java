package com.ex0120;

public class Ex07 {

	public static void main(String[] args) {
		int a, b;
		a=12; b=6;
		System.out.printf("~a %d a&b %d a|b %d a^b %d \n", 
				~a, a&b, a|b, a^b);
		
		String s;
		// s= a%2==0?"¦":"Ȧ"; ���� ������ �� ������
		s = (a&1)==0?"¦":"Ȧ"; // ���ڸ��� 1�̱⸸ �ϸ� Ȧ���ϱ�
		//��ȣ �������, & ������ ���� ���� �ʱ� ����
		System.out.println(s);
		
	}

}
