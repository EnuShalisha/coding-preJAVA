package com.ex0125;

public class Ex03ar {

	public static void main(String[] args) {
		int a[] = new int[3];
		int b[] = a;
		
		a[0]=10; a[1]=20; a[2]=30; // new�� ���Ѱ� �߿�
		//new �ȳ����� �� �迭�� �޸� �ּҰ� �����Ƿ� ����ȭ
		//a= new int[3] {10, 20, 30}���� �ϸ� a ��ü�� �ƿ� �ʱ�ȭ
		//�� �� b �迭(old a)�� a �迭(new a)�� �ٸ� �޸� �ּҸ� ����.
		
		for(int i=0; i<a.length; i++) 
			System.out.print(a[i]+" ");
		
		System.out.println();
		System.out.println("----");
		
		for(int i=0; i<b.length; i++) 
			System.out.print(b[i]+" ");
		
		System.out.println();
		
		System.out.println(a); // �����ּ�
		System.out.println(b);
		
		System.out.println("---------");
		
		b[1]=50;
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}

	}

}
