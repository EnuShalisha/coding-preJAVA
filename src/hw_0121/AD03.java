package hw_0121;

import java.util.Scanner;

public class AD03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("두 수? ");
		int a=sc.nextInt();
		int b=sc.nextInt();
		int d=0;
		int c=1;
		while(a>=c&&b>=c)
		{	
			if(a%c==0&&b%c==0)
				d=c;
			else {}
			c++;
		}
		System.out.println("GCD(최대공약수) "+d);
		System.out.println("LCM(최소공약수) "+(a/d*b/d)*d);
	}

}
