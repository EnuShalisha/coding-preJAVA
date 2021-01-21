package hw_0121;

import java.util.Scanner;

public class AD05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("금액 ? ");
		int total=sc.nextInt();
		int grade=50000, temp=0;
		while(grade>1) {
			temp=total/grade;
			System.out.printf("%d원권/개수 : %d\n", grade, temp);
			total-=temp*grade;
			temp=0;
			grade/=5;
			temp=total/grade;
			System.out.printf("%d원권/개수 : %d\n", grade, temp);
			total-=temp*grade;
			temp=0;
			grade/=2;
		}
		sc.close();
	}

}
