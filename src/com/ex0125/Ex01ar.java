package com.ex0125;

public class Ex01ar {

	public static void main(String[] args) {
		int num[]= {10, 21};
		System.out.println(num[0]);
		num=new int[5]; // ���ο� �޸� �ּ� 5�� - ���� �ּ� ����
		
		//num�� reference ���� -> �� ���� ������ �ּҿ� �������
		int a;// ��� �⺻ �ڷ���
		String c="a"; // ��� ��ü(�޸𸮰� �Ҵ������ ������ null)
		//System.out.println(a); ������ ����
		System.out.println(num[0]); // ���ο� �� 0�� ������
		
		// System.out.println(num[5]);  5�� �� ��� ��Ÿ�� ����

		num= new int[] {2, 4, 6, 8, 10};
		System.out.println(num.length+"���� �μ�");
		for(a=0; a<num.length; a++) 
			System.out.println(num[a]+" ");
		System.out.println("---------------------------");
		
		//���ο� for��
		for(int i:num) {
			System.out.print(i+" ");
		}
		System.out.println();
	}

}
