package com.ex0125;

public class Ex08ar {

	public static void main(String[] args) {
		int a[]= {10, 20, 30}; // ���� ���ÿ� �ʱ�ȭ �ϴ°�쿡�� new int ���� ����
		
		int b[];
		//b[]={1, 3, 5, 7, 9}; �̰� �ȵȴٴ°�
		b=new int[] {1, 3, 5, 7, 9};
		for(int n:a) 
			System.out.println(n+" ");
		for(int n:b) 
			System.out.println(n+" ");
		
	}

}
