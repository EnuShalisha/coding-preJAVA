package bank;

import java.util.Calendar;

public class BankImpl implements Bank {
	private  Account[] accountList; // ���� ����
    private int totalAccount; // �� ���¼�
    
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
    
    // ���� ��ȣ �����
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
		// ���� ���
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
    	// �Ա� ------------------
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
    	vo.setKind("�Ա�");
    	vo.setInfo("����");
		
    	boolean b = account.addTransaction(vo);
    	if(! b) {
    		return -2L;
    	}
    	
    	return balance;
    }

	@Override
    public long withdraw(String accountNo, long amount) {
    	// ���
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
    	vo.setKind("���");
    	vo.setInfo("����");
		
    	boolean b = account.addTransaction(vo);
    	if(! b) {
    		return -3L;
    	}
    	
    	return balance;
    }
    
	@Override
	public long accountTransfer(String fromAccountNo, String toAccountNo, long amount) {
    	// ������ü
		
		// ����� ����
		Account fromAccount=readAccount(fromAccountNo);
		if(fromAccount==null) {
			return -1L;
		}
		
		// �Ա��� ����
		Account toAccount=readAccount(toAccountNo);
		if(toAccount==null) {
			return -2L;
		}
		
		// ����� ������ �ܰ�
		long fromBalance=balance(fromAccountNo);
		if(amount>fromBalance) {
			return -3L;
		}
		fromBalance-=amount;
		
		// �Ա��� ������ �ܰ�
		long toBalance=balance(toAccountNo);
		toBalance+=amount;
		
		// ��/��� ����
		Calendar cal=Calendar.getInstance();
		String transaction_date = String.format("%1$tF %1$tT", cal);
		
    	TransactionVO fromVo=new TransactionVO();
    	TransactionVO toVo=new TransactionVO();
    	
    	// ����� ������ �ŷ� ����
    	fromVo.setTransaction_date(transaction_date);
    	fromVo.setAmount(amount);
    	fromVo.setBalance(fromBalance);
    	fromVo.setKind("���");
    	fromVo.setInfo("������ü");
    	fromAccount.addTransaction(fromVo);
		String name=fromAccount.getAccountVO().getOwner();
				
    	// �Ա��� ������ �ŷ� ����
    	toVo.setTransaction_date(transaction_date);
    	toVo.setAmount(amount);
    	toVo.setBalance(toBalance);
    	toVo.setKind("�Ա�");
    	toVo.setInfo(name);
    	toAccount.addTransaction(toVo);
    	
    	// ����� ������ �ܾ�
    	return fromBalance;
    }

	@Override
    public long balance(String accountNo) {
    	// �ܾ���ȸ ------------------
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
    	// �ŷ�������ȸ ------------------
		Account account=readAccount(accountNo);
		if(account == null) {
			return null;
		}
		
    	return account.getTransactionList();
    }

	@Override
    public Account readAccount(String accountNo) {
    	// ����-��ȣ�˻� ------------------
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
    	// ����-�̸��˻�
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
		// ����-��ü����Ʈ
		return accountList;
	}

	@Override
	public int getTotalAccount() {
		// ����-��ü���¼�
		return totalAccount;
	}
}
