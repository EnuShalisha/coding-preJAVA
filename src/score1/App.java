package score1;

import java.util.Scanner;

public class App {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ch;
		Score ss=new Score();
		
		while(true) {
			do {
				System.out.print("1. 입력 2. 출력 3. 평점출력 4. 종료 => ");
				ch=sc.nextInt();
			} while(ch<1||ch>4);
			if(ch==4) break;
			
			switch(ch) {
			case 1: ss.input(); break;
			case 2: ss.print(); break;
			case 3: ss.printgrade(); break;
			}
				
		}
		sc.close();
	}

}
