package com.ex0125;

import java.util.Scanner;

public class Ex10ar {

	public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
		
		int y, m, d;
		int tot, w;
		int days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		do {
			System.out.println("�⵵ ? ");
			y=sc.nextInt();
		}while(y<1);
		
		days[1] = y%4==0&&y%100!=0||y%400==0? 29:28;
		tot=(y-1)*365+(y-1)/4-(y-1)/100+(y-1)/400;
		
		do {
			System.out.println("��? ");
			m=sc.nextInt();
		}while(m<1||m>12);
		for(int i=1; i<m; i++) // 1������ m�� ������
			tot+=days[i-1]; // m�� �������� ���� m-1�� �ּҿ��� ã��
		
		do {
			System.out.println("��? ");
			d=sc.nextInt();
		} while(d<1||d>days[m-1]);
		tot+=d;
		
		w=tot%7;
		
		String x[]= {"��", "��", "ȭ", "��", "��", "��", "��"}; // w�� ������ 0:�Ͽ��Ϻ��� 6:����ϱ���
		
		System.out.printf("\t%d�� %d�� %d���� %s�����Դϴ�.\n", 
				y, m, d, x[w]); // ���� w-1�� ��� -1���� ��Ÿ�� ���� �߻�
		
		
		
		System.out.println();
		/*System.out.println("�� �ϼ���: "+tot);*/
		
		sc.close();	

	}

}
