package com.ex0125;

public class Ex02 {

	public static void main(String[] args) {
		int n=0, s=0;
		while(n<100) {
			n++;
			if(n%2==0)
				continue; // switch case���� ��� �Ұ���
			s+=n; // continue�� if �ۿ� ����� �� �ڵ� ���� �Ұ� -> ������ ����
		}
	System.out.println("���:"+s);
	}

}
