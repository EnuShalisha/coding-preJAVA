package hw_0120;

import java.util.Scanner;

public class HW7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�̸�? ");
		String n=sc.next();
		System.out.println("������ ����? ");
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		double d=(double) ((a+b+c)/3);
		String e="���հ�";
		if(d>=60)
		{if(a>=40&&b>=40&&c>=40) {
			e="�հ�";
			}
		else {
			e="����";
			}
		}
		System.out.printf("%s���� %s �Դϴ�.", n, e);
	}

}
