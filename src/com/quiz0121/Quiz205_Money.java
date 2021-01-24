package com.quiz0121;
import java.util.Scanner;

public class Quiz205_Money {
	public static void main(String[] args) {
/*		
		금액을 입력 받아 화폐별 매수를 반복문을 이용하여 작성
*/		
		Scanner sc=new Scanner(System.in);

        int unit = 50000; // 화폐단위 : 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1
        int num = 0; // 화폐 매수
        boolean sw = false;

        int money;
		System.out.print("금액 ? ");
		money=sc.nextInt();
		
        while (true) {
            num = money / unit;
            System.out.println(unit + "원권/개수 : " + num);

            if (unit <= 1) {
                break;
            }
            
            money = money - unit * num; // 나머지 금액
            
            if(sw) { // 화폐의 다음 단위
                unit /= 2;
			} else {
                unit /= 5; 
            }
            
			sw = !sw;
        }
        
        sc.close();
	}
}
