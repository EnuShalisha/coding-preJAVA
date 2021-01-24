package com.quiz0121;
import java.util.Scanner;

public class Quiz206_Random {
	public static void main(String[] args) {
		// 1~100까지의 난수를 발생시켜 몇번에 맞추는지 출력하는 프로그램 작성
		Scanner sc = new Scanner(System.in);

		int com, user, cnt;

		com = (int) (Math.random() * 100) + 1;
		cnt=0;
		while (true) {
			System.out.print("수 ? ");
			user = sc.nextInt();

			cnt++;

			if (user == com) {
				System.out.println(cnt + "번 만에 성공했습니다.");
				break;
			} else if (user > com) {
				System.out.println("입력한 수보다는 적은수 입니다.");
			} else {
				System.out.println("입력한 수보다는 큰수 입니다.");
			}
		}
		
		sc.close();
	}
}
