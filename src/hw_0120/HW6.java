package hw_0120;

import java.util.Scanner;

public class HW6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�μ� ? ");
		int a=sc.nextInt();
		int b=sc.nextInt();
		System.out.println("������[+, -, *, /] ?");
		char c=sc.next().charAt(0);
		int d=0;
		if(c>=0) {
			if(c=='+') {
				d=a+b;
			}
			else if(c=='-') {
			d=a-b;
		}
			else if(c=='*') {
			d=a*b;
		}
			else if(c=='/') {
			d=a/b;
		}
			else {
			System.out.println("������ ����");
			}
		}
		System.out.printf("%d %c %d = %d", a, c, b, d);
		sc.close();
	}
}
