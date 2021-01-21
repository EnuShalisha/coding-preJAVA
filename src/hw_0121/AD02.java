package hw_0121;

import java.util.Scanner;

public class AD02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("수 ? ");
		int n=sc.nextInt();
		int a=1, t=10;
		while(n-t>=0) {
			t=t*10;
			a++;
		}
		System.out.printf("%d은 %d자리 정수", n, a);
		sc.close();
	}

}
