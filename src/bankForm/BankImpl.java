package bankForm;

public class BankImpl implements Bank {
	private  Account[] accountList; // ���� ����
    private int totalAccount; // �� ���¼�
    
    public BankImpl() {
    	// �ִ� ���¼��� 50, �Ǵ� �ʱ� 10 �����ϸ� 10���� ����
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
    	
    	return null;
    }

	@Override
    public long deposit(String accountNo, long amount) {
    	// �Ա�
    	
    	return 0L;
    }

	@Override
    public long withdraw(String accountNo, long amount) {
    	// ���
    	
    	return 0L;
    }
    
	@Override
	public long accountTransfer(String fromAccountNo, String toAccountNo, long amount) {
    	// ������ü
    	
    	return 0L;
    }

	@Override
    public long balance(String accountNo) {
    	// �ܾ���ȸ
    	
    	return 0L;
    }

	@Override
    public TransactionVO[] transactionHistory(String accountNo) {
    	// �ŷ�������ȸ
    	
    	return null;
    }

	@Override
    public Account readAccount(String accountNo) {
    	// ����-��ȣ�˻�
    	
    	return null;
    }

	@Override
    public Account[] getAccountList(String owner) {
    	// ����-�̸��˻�
    	
    	return null;
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
