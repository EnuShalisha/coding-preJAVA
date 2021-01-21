package hw_0121;

import java.util.Scanner;

public class AD04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("개수 ? ");
		int time=sc.nextInt();
		int count=0;
		int a=0, b=1, t=0;
		while(count!=time) {
			System.out.printf("%d ", a);
			t=a;
			a+=b;
			b=t;
			count++;
		}
		sc.close();

	}

}
