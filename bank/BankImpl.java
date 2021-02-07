package bank;

import java.util.Calendar;

public class BankImpl implements Bank {
	private  Account[] accountList; // 계좌 정보
    private int totalAccount; // 총 계좌수
    
    public BankImpl() {
    	allocation(10);
    	totalAccount = 0;
    }
    
    private void allocation(int capacity) {
		Account[] temp = new Account[capacity];
		if(accountList!=null && accountList.length>0) {
			System.arraycopy(accountList, 0, temp, 0, accountList.length);
		}
		accountList=temp;
	}
    
    // 계좌 번호 만들기
	protected String generateAccountNo() {
	    String s="020-08-0000000";
	    if(totalAccount>0) {
	    	s=accountList[totalAccount-1].getAccountVO().getAccountNo();
	    }
	    
	    String s1=s.substring(0, s.lastIndexOf("-"));
	    String s2=s.substring(s.lastIndexOf("-")+1);
			
	    int n=Integer.parseInt(s2)+1;
			
	    s=s1+"-"+String.format("%07d", n);
	    
	    return s;
	}
    
	@Override
    public Account addAccount(String owner) {
		// 계좌 등록
		if(totalAccount>=accountList.length) {
			allocation(accountList.length+10);
		}
		
		Calendar cal=Calendar.getInstance();
		
		String accountNo = generateAccountNo();
		String launch_date = String.format("%1$tF %1$tT", cal);
		
		Account account = new Account();
		AccountVO vo = account.getAccountVO();
		vo.setAccountNo(accountNo);
		vo.setOwner(owner);
		vo.setLaunch_date(launch_date);
		accountList[totalAccount++] = account;
    	
    	return account;
    }

	@Override
    public long deposit(String accountNo, long amount) {
    	// 입금 ------------------
		Account account=readAccount(accountNo);
		if(account==null) {
			return -1L;
		}
		
		Calendar cal=Calendar.getInstance();
		String transaction_date = String.format("%1$tF %1$tT", cal);
		
    	TransactionVO vo=new TransactionVO();
    	long balance=balance(accountNo);
   		balance+=amount;
    	
    	vo.setTransaction_date(transaction_date);
    	vo.setAmount(amount);
    	vo.setBalance(balance);
    	vo.setKind("입금");
    	vo.setInfo("본인");
		
    	boolean b = account.addTransaction(vo);
    	if(! b) {
    		return -2L;
    	}
    	
    	return balance;
    }

	@Override
    public long withdraw(String accountNo, long amount) {
    	// 출금
		Account account=readAccount(accountNo);
		if(account==null) {
			return -1L;
		}
		
		long balance=balance(accountNo);
		if(amount>balance) {
			return -2L;
		}
		
		Calendar cal=Calendar.getInstance();
		String transaction_date = String.format("%1$tF %1$tT", cal);
		
    	TransactionVO vo=new TransactionVO();
    	
   		balance-=amount;
    	
    	vo.setTransaction_date(transaction_date);
    	vo.setAmount(amount);
    	vo.setBalance(balance);
    	vo.setKind("출금");
    	vo.setInfo("본인");
		
    	boolean b = account.addTransaction(vo);
    	if(! b) {
    		return -3L;
    	}
    	
    	return balance;
    }
    
	@Override
	public long accountTransfer(String fromAccountNo, String toAccountNo, long amount) {
    	// 계좌이체
		
		// 출금할 계좌
		Account fromAccount=readAccount(fromAccountNo);
		if(fromAccount==null) {
			return -1L;
		}
		
		// 입금할 계좌
		Account toAccount=readAccount(toAccountNo);
		if(toAccount==null) {
			return -2L;
		}
		
		// 출금할 계좌의 잔고
		long fromBalance=balance(fromAccountNo);
		if(amount>fromBalance) {
			return -3L;
		}
		fromBalance-=amount;
		
		// 입금할 계좌의 잔고
		long toBalance=balance(toAccountNo);
		toBalance+=amount;
		
		// 입/출금 일자
		Calendar cal=Calendar.getInstance();
		String transaction_date = String.format("%1$tF %1$tT", cal);
		
    	TransactionVO fromVo=new TransactionVO();
    	TransactionVO toVo=new TransactionVO();
    	
    	// 출금할 계좌의 거래 내역
    	fromVo.setTransaction_date(transaction_date);
    	fromVo.setAmount(amount);
    	fromVo.setBalance(fromBalance);
    	fromVo.setKind("출금");
    	fromVo.setInfo("계좌이체");
    	fromAccount.addTransaction(fromVo);
		String name=fromAccount.getAccountVO().getOwner();
				
    	// 입금할 계좌의 거래 내역
    	toVo.setTransaction_date(transaction_date);
    	toVo.setAmount(amount);
    	toVo.setBalance(toBalance);
    	toVo.setKind("입금");
    	toVo.setInfo(name);
    	toAccount.addTransaction(toVo);
    	
    	// 출금한 계좌의 잔액
    	return fromBalance;
    }

	@Override
    public long balance(String accountNo) {
    	// 잔액조회 ------------------
		Account account=readAccount(accountNo);
		if(account==null) {
			return -1L;
		}
    	
		TransactionVO vo = account.getLastTransaction();
		long balance = 0;
		if(vo!=null) {
			balance = vo.getBalance();
		}
		
    	return balance;
    }

	@Override
    public TransactionVO[] transactionHistory(String accountNo) {
    	// 거래내역조회 ------------------
		Account account=readAccount(accountNo);
		if(account == null) {
			return null;
		}
		
    	return account.getTransactionList();
    }

	@Override
    public Account readAccount(String accountNo) {
    	// 계좌-번호검색 ------------------
		for(int i=0; i<totalAccount; i++) {
			Account account = accountList[i];
			AccountVO vo = account.getAccountVO();
			if(vo.getAccountNo().equals(accountNo)) {
				return account;
			}
		}
    	
    	return null;
    }

	@Override
    public Account[] getAccountList(String owner) {
    	// 계좌-이름검색
		Account[] accounts = new Account[totalAccount];
		int count=0;
		
		for(int i=0; i<totalAccount; i++) {
			Account account = accountList[i];
			AccountVO vo = account.getAccountVO();
			if(vo.getOwner().equals(owner)) {
				accounts[count++]=account;
			}
		}
    	
    	return accounts;
    }

	@Override
	public Account[] getAccountList() {
		// 계좌-전체리스트
		return accountList;
	}

	@Override
	public int getTotalAccount() {
		// 계좌-전체계좌수
		return totalAccount;
	}
}
