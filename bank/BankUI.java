package bank;

import java.text.NumberFormat;
import java.util.Scanner;

// 화면 입출력
public class BankUI {
	private Scanner sc=new Scanner(System.in);
	
	private Bank bank = new BankImpl();
	
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
		
		String owner;
		System.out.print("이름 ? ");
		owner = sc.next();
		
		Account account = bank.addAccount(owner);
		if(account==null) {
			System.out.println("계좌 개설이 실패 했습니다.\n");
			return;
		}
		
		AccountVO vo = account.getAccountVO();
		System.out.println("개설계좌번호:"+vo.getAccountNo()+"\n");
	}

	public void deposit() {
		System.out.println("\n[개인-입금]");
		
		String accountNo;
		long amount;
		
		System.out.print("입금 계좌 번호 ? ");
		accountNo = sc.next();
		
		System.out.print("입금액 ? ");
		amount = sc.nextLong();
		
		long balance = bank.deposit(accountNo, amount);
		if(balance==-1L) {
			System.out.println("등록된 계좌가 아닙니다.\n");
		} else if(balance==-2L) {
			System.out.println("입금이 실패 했습니다.\n");
		} else {
			System.out.println("입금후 잔액 : " + balance+"\n");
		}
	}

	public void withdraw() {
		System.out.println("\n[개인-출금]");
		
		String accountNo;
		long amount;
		
		System.out.print("출금 계좌 번호 ? ");
		accountNo = sc.next();
		
		System.out.print("출금액 ? ");
		amount = sc.nextLong();
		
		long balance = bank.withdraw(accountNo, amount);
		if(balance==-1L) {
			System.out.println("등록된 계좌가 아닙니다.\n");
		} else if(balance==-2L) {
			System.out.println("잔액이 부족합니다.\n");
		} else if(balance==-3L) {
			System.out.println("출금이 실패했습니다.\n");
		} else {
			System.out.println("출금후 잔액 : " + balance+"\n");
		}
	}

	public void accountTransfer() {
		System.out.println("\n[개인-계좌이체]");
		
		String fromAccountNo, toAccountNo;
		long amount;
		
		System.out.print("출금할 계좌 번호 ? ");
		fromAccountNo = sc.next();
		
		System.out.print("출금액 ? ");
		amount = sc.nextLong();
		
		System.out.print("입금할 계좌 번호 ? ");
		toAccountNo = sc.next();
		
		long balance = bank.accountTransfer(fromAccountNo, toAccountNo, amount);
		if(balance==-1L) {
			System.out.println("등록된 출금 계좌가 아닙니다.\n");
		} else if(balance==-2L) {
			System.out.println("등록된 입금 계좌가 아닙니다.\n");
		} else if(balance==-3L) {
			System.out.println("잔고가 부족합니다.\n");
		} else {
			System.out.println("출금(계좌이체)후 잔액 : " + balance+"\n");
		}
		
	}

	public void balance() {
		System.out.println("\n[개인-잔액조회]");
		
		String accountNo;
		long amount;
		
		System.out.print("조회할 계좌 번호 ? ");
		accountNo = sc.next();
		
		amount = bank.balance(accountNo);
		if(amount==-1L) {
			System.out.println("등록된 계좌가 아닙니다.\n");
			return;
		}
		
		System.out.print("계좌번호:"+accountNo+"\t");
		System.out.println("잔액:"+amount);
		
		System.out.println();
	}

	public void transactionHistory() {
		System.out.println("\n[개인-거래내역조회]");

		String accountNo;
		System.out.print("조회 할 계좌 번호 ? ");
		accountNo = sc.next();
		
		TransactionVO[] historys = bank.transactionHistory(accountNo);
		if(historys==null) {
			System.out.println("등록된 계좌가 아닙니다.\n");
			return;
		}
		int count = bank.readAccount(accountNo).getTotalTransaction();
		
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String s;
		
		System.out.println("거래일자\t\t\t구분\t금액\t잔고\t내역");
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
		System.out.println("\n[은행-계좌번호조회]");
		
		String accountNo;
		System.out.print("조회 할 계좌 번호 ? ");
		accountNo = sc.next();
		
		Account account=bank.readAccount(accountNo);
		if(account==null) {
			System.out.println("등록된 계좌가 아닙니다.\n");
			return;
		}
		
		AccountVO vo = account.getAccountVO();
		long balance = bank.balance(vo.getAccountNo());
		System.out.println(vo+"\t"+balance);
		System.out.println();
	}

	public void findByOwner() {
		System.out.println("\n[은행-이름검색]");
		
		String name;
		System.out.print("조회 할 이름 ? ");
		name = sc.next();
		
		Account[] accounts=bank.getAccountList(name);
		System.out.println("계좌번호\t\t이름\t개설일자\t\t\t잔고");
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
		System.out.println("\n[은행-계좌전체리스트]");

		Account[] accountList=bank.getAccountList();
		int totalAccount=bank.getTotalAccount();
		
		System.out.println("계좌번호\t\t이름\t개설일자\t\t\t잔고");
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
