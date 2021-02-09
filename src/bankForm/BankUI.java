package bankForm;

import java.util.Scanner;

// 화면 입출력
public class BankUI {
	private Scanner sc=new Scanner(System.in);
	
	public void menu() {
		int ch;
		while(true) {
			do {
				System.out.println("-----------------------------------------------------");
				System.out.println("1.계좌개설  2.입금  3.출금  4.계좌이체  5.잔액조회  6.거래내역");
				System.out.println("7.계좌번호검색  8.이름검색  9.계좌리스트  10.종료");
				System.out.println("-----------------------------------------------------");
				System.out.print("선택=> ");
				ch=sc.nextInt();
			} while(ch<1||ch>10);
			
			if(ch==10) {
				return;
			}
			
			switch(ch) {
			case 1:addAccount(); break;
			case 2:deposit(); break;
			case 3:withdraw(); break;
			case 4:accountTransfer(); break;
			case 5:balance(); break;
			case 6:transactionHistory(); break;
			case 7:findByAccountNo(); break;
			case 8:findByOwner(); break;
			case 9:accountList(); break;
			}
		}
	}
	
	public void addAccount() {
		System.out.println("\n[개인-계좌 개설]");
		
	}

	public void deposit() {
		System.out.println("\n[개인-입금]");
	}

	public void withdraw() {
		System.out.println("\n[개인-출금]");
	}

	public void accountTransfer() {
		System.out.println("\n[개인-계좌이체]");
	}

	public void balance() {
		System.out.println("\n[개인-잔액조회]");
	}

	public void transactionHistory() {
		System.out.println("\n[개인-거래내역조회]");
	}
	
	public void findByAccountNo() {
		System.out.println("\n[은행-계좌번호조회]");
	}

	public void findByOwner() {
		System.out.println("\n[은행-이름검색]");
	}

	public void accountList() {
		System.out.println("\n[은행-계좌전체리스트]");
	}
}
