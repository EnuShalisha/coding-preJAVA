package com.ex0125;

import java.util.Scanner;

public class Ex09ar {

	public static void main(String[] args) {
		/*1.1.1~2021.7.1 ���� ��
		 * 2021�� y�� �ϸ�
		 * days=(y-1)*365+(y-1)/4-(y-1)/100+(y-1)/400
		 * ���� �ϸ� 2020.12.31���� ���
		 * 1~6��(m���� ��) ���� = 31*3+28*1+30*2
		 * +1
		 * 
		 */
		Scanner sc = new Scanner(System.in);
		
		int y, m;
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
		
		tot++;
		w=tot%7;
		
		System.out.printf("\t%d�� %d��\n", y, m);
		System.out.println("-----------------------------");
		System.out.println("   ��  ��   ȭ  ��   ��  ��   ��");
		System.out.println("-----------------------------");
		
		for(int i=1; i<=w; i++) 
			System.out.print("    ");
		for(int i=1; i<=days[m-1]; i++) {
			System.out.printf("%4d", i);
			w++;
			if(w%7==0) {
				System.out.println();
			}
		}
		System.out.println();
		/*System.out.println("�� �ϼ���: "+tot);*/
		
		sc.close();	
	}
		
		
		 

	}

