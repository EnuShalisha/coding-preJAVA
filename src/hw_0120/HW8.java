package hw_0120;

import java.util.Scanner;

public class HW8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�й� ?");
		int a=sc.nextInt();
		System.out.println("�̸� ?");
		String b=sc.next();
		System.out.println("�߰���� ���� ?");
		int c=sc.nextInt();
		System.out.println("�⸻��� ���� ?");
		int d=sc.nextInt();
		System.out.println("�ἮȽ�� ?");
		int p=sc.nextInt();
		System.out.println("����Ʈ ���� ?");
		int f=sc.nextInt();
		int e=0;
		if(p<6)
			{if(p<2) {
				e=100;}
			else if(p<4) {
				e=80;}
			else {
				e=60;}
			}
		int g=(int)(c*0.4+d*0.4+e*0.1+f*0.1);
		char h='F';
		if (g>=60) {
			if(g>=90) {
				h='A';}
			else if(g>=80) {
				h='B';}
			else if(g>=70) {
				h='C';}
			else {
				h='D';}
			}
		
		System.out.printf("�й�    �̸� �߰���� �⸻��� �⼮���� ����Ʈ �ջ����� ����\n %d  %s  %d  %d  %d  %d  %d  %c"
				, a, b, c, d, e, f, g, h);
	}

}
