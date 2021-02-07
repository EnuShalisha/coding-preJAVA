package bank;

import java.text.NumberFormat;
import java.util.Scanner;

// ȭ�� �����
public class BankUI {
	private Scanner sc=new Scanner(System.in);
	
	private Bank bank = new BankImpl();
	
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
		
		String owner;
		System.out.print("�̸� ? ");
		owner = sc.next();
		
		Account account = bank.addAccount(owner);
		if(account==null) {
			System.out.println("���� ������ ���� �߽��ϴ�.\n");
			return;
		}
		
		AccountVO vo = account.getAccountVO();
		System.out.println("�������¹�ȣ:"+vo.getAccountNo()+"\n");
	}

	public void deposit() {
		System.out.println("\n[����-�Ա�]");
		
		String accountNo;
		long amount;
		
		System.out.print("�Ա� ���� ��ȣ ? ");
		accountNo = sc.next();
		
		System.out.print("�Աݾ� ? ");
		amount = sc.nextLong();
		
		long balance = bank.deposit(accountNo, amount);
		if(balance==-1L) {
			System.out.println("��ϵ� ���°� �ƴմϴ�.\n");
		} else if(balance==-2L) {
			System.out.println("�Ա��� ���� �߽��ϴ�.\n");
		} else {
			System.out.println("�Ա��� �ܾ� : " + balance+"\n");
		}
	}

	public void withdraw() {
		System.out.println("\n[����-���]");
		
		String accountNo;
		long amount;
		
		System.out.print("��� ���� ��ȣ ? ");
		accountNo = sc.next();
		
		System.out.print("��ݾ� ? ");
		amount = sc.nextLong();
		
		long balance = bank.withdraw(accountNo, amount);
		if(balance==-1L) {
			System.out.println("��ϵ� ���°� �ƴմϴ�.\n");
		} else if(balance==-2L) {
			System.out.println("�ܾ��� �����մϴ�.\n");
		} else if(balance==-3L) {
			System.out.println("����� �����߽��ϴ�.\n");
		} else {
			System.out.println("����� �ܾ� : " + balance+"\n");
		}
	}

	public void accountTransfer() {
		System.out.println("\n[����-������ü]");
		
		String fromAccountNo, toAccountNo;
		long amount;
		
		System.out.print("����� ���� ��ȣ ? ");
		fromAccountNo = sc.next();
		
		System.out.print("��ݾ� ? ");
		amount = sc.nextLong();
		
		System.out.print("�Ա��� ���� ��ȣ ? ");
		toAccountNo = sc.next();
		
		long balance = bank.accountTransfer(fromAccountNo, toAccountNo, amount);
		if(balance==-1L) {
			System.out.println("��ϵ� ��� ���°� �ƴմϴ�.\n");
		} else if(balance==-2L) {
			System.out.println("��ϵ� �Ա� ���°� �ƴմϴ�.\n");
		} else if(balance==-3L) {
			System.out.println("�ܰ� �����մϴ�.\n");
		} else {
			System.out.println("���(������ü)�� �ܾ� : " + balance+"\n");
		}
		
	}

	public void balance() {
		System.out.println("\n[����-�ܾ���ȸ]");
		
		String accountNo;
		long amount;
		
		System.out.print("��ȸ�� ���� ��ȣ ? ");
		accountNo = sc.next();
		
		amount = bank.balance(accountNo);
		if(amount==-1L) {
			System.out.println("��ϵ� ���°� �ƴմϴ�.\n");
			return;
		}
		
		System.out.print("���¹�ȣ:"+accountNo+"\t");
		System.out.println("�ܾ�:"+amount);
		
		System.out.println();
	}

	public void transactionHistory() {
		System.out.println("\n[����-�ŷ�������ȸ]");

		String accountNo;
		System.out.print("��ȸ �� ���� ��ȣ ? ");
		accountNo = sc.next();
		
		TransactionVO[] historys = bank.transactionHistory(accountNo);
		if(historys==null) {
			System.out.println("��ϵ� ���°� �ƴմϴ�.\n");
			return;
		}
		int count = bank.readAccount(accountNo).getTotalTransaction();
		
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String s;
		
		System.out.println("�ŷ�����\t\t\t����\t�ݾ�\t�ܰ�\t����");
		for(int i=0; i<count; i++) {
			TransactionVO vo=historys[i];
			
			System.out.print(vo.getTransaction_date()+"\t");
			System.out.print(vo.getKind()+"\t");
			s = nf.format(vo.getAmount());
			System.out.print(s+"\t");
			s = nf.format(vo.getBalance());
			System.out.print(s+"\t");
			System.out.print(vo.getInfo()+"\n");
		}
		System.out.println();
	}
	
	public void findByAccountNo() {
		System.out.println("\n[����-���¹�ȣ��ȸ]");
		
		String accountNo;
		System.out.print("��ȸ �� ���� ��ȣ ? ");
		accountNo = sc.next();
		
		Account account=bank.readAccount(accountNo);
		if(account==null) {
			System.out.println("��ϵ� ���°� �ƴմϴ�.\n");
			return;
		}
		
		AccountVO vo = account.getAccountVO();
		long balance = bank.balance(vo.getAccountNo());
		System.out.println(vo+"\t"+balance);
		System.out.println();
	}

	public void findByOwner() {
		System.out.println("\n[����-�̸��˻�]");
		
		String name;
		System.out.print("��ȸ �� �̸� ? ");
		name = sc.next();
		
		Account[] accounts=bank.getAccountList(name);
		System.out.println("���¹�ȣ\t\t�̸�\t��������\t\t\t�ܰ�");
		for(Account acc:accounts) {
			if(acc==null) {
				break;
			}
			AccountVO vo = acc.getAccountVO();
			long balance = bank.balance(vo.getAccountNo());
			System.out.println(vo+"\t"+balance);
		}
		System.out.println();
	}

	public void accountList() {
		System.out.println("\n[����-������ü����Ʈ]");

		Account[] accountList=bank.getAccountList();
		int totalAccount=bank.getTotalAccount();
		
		System.out.println("���¹�ȣ\t\t�̸�\t��������\t\t\t�ܰ�");
		for(int i=0; i<totalAccount; i++) {
			Account account = accountList[i];
			AccountVO vo = account.getAccountVO();
			long balance = bank.balance(vo.getAccountNo());
/*			
			System.out.print(vo.getAccountNo()+"\t");
			System.out.print(vo.getOwner()+"\t");
			System.out.print(vo.getLaunch_date()+"\t");
			System.out.print(0+"\n");
*/
			System.out.println(vo+"\t"+balance);
		}
		System.out.println();
	}
}
