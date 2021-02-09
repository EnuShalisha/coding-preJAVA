package bankForm;

public class BankImpl implements Bank {
	private  Account[] accountList; // 계좌 정보
    private int totalAccount; // 총 계좌수
    
    public BankImpl() {
    	// 최대 계좌수는 50, 또는 초기 10 부족하면 10개씩 증가
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
    	
    	return null;
    }

	@Override
    public long deposit(String accountNo, long amount) {
    	// 입금
    	
    	return 0L;
    }

	@Override
    public long withdraw(String accountNo, long amount) {
    	// 출금
    	
    	return 0L;
    }
    
	@Override
	public long accountTransfer(String fromAccountNo, String toAccountNo, long amount) {
    	// 계좌이체
    	
    	return 0L;
    }

	@Override
    public long balance(String accountNo) {
    	// 잔액조회
    	
    	return 0L;
    }

	@Override
    public TransactionVO[] transactionHistory(String accountNo) {
    	// 거래내역조회
    	
    	return null;
    }

	@Override
    public Account readAccount(String accountNo) {
    	// 계좌-번호검색
    	
    	return null;
    }

	@Override
    public Account[] getAccountList(String owner) {
    	// 계좌-이름검색
    	
    	return null;
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
