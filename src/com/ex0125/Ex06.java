package com.ex0125;

public class Ex06 {

	public static void main(String[] args) {
		int cnt=0;
		long start=System.nanoTime();
		gogo:
		for(int i=2; i<=100; i++) {
			
			for(int j=2; j<=i/2; j++) { // ������ �޼ҵ� ��������� �ݺ�Ƚ�� �ξ� ���� �� �־�
				//���� �����ٱ����� ���ϸ� ������ �׳��� /2�� ������ ����
				if(i%j==0) 
					continue gogo; // continue ������ boolean �ʿ� ����
			}
			System.out.printf("%5d", i);
			cnt++;
			if(cnt%10==0) 
				System.out.println();
				}
		System.out.println();
		long end=System.nanoTime();
		end-=start;
		System.out.println(end);
			}
		
	}

