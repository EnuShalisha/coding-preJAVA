package bankForm;

import java.util.Scanner;

// ȭ�� �����
public class BankUI {
	private Scanner sc=new Scanner(System.in);
	
	public void menu() {
		int ch;
		while(true) {
			do {
				System.out.println("-----------------------------------------------------");
				System.out.println("1.���°���  2.�Ա�  3.���  4.������ü  5.�ܾ���ȸ  6.�ŷ�����");
				System.out.println("7.���¹�ȣ�˻�  8.�̸��˻�  9.���¸���Ʈ  10.����");
				System.out.println("-----------------------------------------------------");
				System.out.print("����=> ");
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
		System.out.println("\n[����-���� ����]");
		
	}

	public void deposit() {
		System.out.println("\n[����-�Ա�]");
	}

	public void withdraw() {
		System.out.println("\n[����-���]");
	}

	public void accountTransfer() {
		System.out.println("\n[����-������ü]");
	}

	public void balance() {
		System.out.println("\n[����-�ܾ���ȸ]");
	}

	public void transactionHistory() {
		System.out.println("\n[����-�ŷ�������ȸ]");
	}
	
	public void findByAccountNo() {
		System.out.println("\n[����-���¹�ȣ��ȸ]");
	}

	public void findByOwner() {
		System.out.println("\n[����-�̸��˻�]");
	}

	public void accountList() {
		System.out.println("\n[����-������ü����Ʈ]");
	}
}
