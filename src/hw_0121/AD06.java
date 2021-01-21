package hw_0121;

import java.util.Scanner;

public class AD06 {

	public static void main(String[] args) {
		int n, num, cnt;
		num=(int)(Math.random()*100)+1;
		n=0; cnt=0;
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("수? ");
			n=sc.nextInt();
			cnt++;
			if(n==num)
				break;
			else if(num<n) 
				System.out.println("입력한 수보다는 작은수입니다.");
			else System.out.println("입력한 수보다는 큰수입니다.");
	}
		System.out.printf("%d번 만에 성공했습니다.", cnt);
		sc.close();

}}
