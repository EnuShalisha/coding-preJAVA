//thinkhan527@gmail.com
/* 
 * */
package hw_0120;

import java.util.Scanner;

public class HW5 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("근무시간 ? ");
		double a=sc.nextDouble();
		double t;
		if(a>8) {
			t=10000*8+10000*1.5*(a-8);
		}
		else {
			t=10000*a;
		}
		System.out.printf("급여 : %,.0f원",t);
		sc.close();
	}

}
