package com.quiz0121;
import java.util.Scanner;

public class Quiz205_Money {
	public static void main(String[] args) {
/*		
		�ݾ��� �Է� �޾� ȭ�� �ż��� �ݺ����� �̿��Ͽ� �ۼ�
*/		
		Scanner sc=new Scanner(System.in);

        int unit = 50000; // ȭ����� : 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1
        int num = 0; // ȭ�� �ż�
        boolean sw = false;

        int money;
		System.out.print("�ݾ� ? ");
		money=sc.nextInt();
		
        while (true) {
            num = money / unit;
            System.out.println(unit + "����/���� : " + num);

            if (unit <= 1) {
                break;
            }
            
            money = money - unit * num; // ������ �ݾ�
            
            if(sw) { // ȭ���� ���� ����
                unit /= 2;
			} else {
                unit /= 5; 
            }
            
			sw = !sw;
        }
        
        sc.close();
	}
}
