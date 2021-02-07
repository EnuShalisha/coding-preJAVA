package bank;

// 계좌 정보 및 계좌 거래 내역 정보
public class Account {
	private AccountVO accountVO;  // 계좌정보
	private TransactionVO[] transactionList; // 계좌별거래내역
	private int totalTransaction; // 거래내역건수
	
	public Account() {
		accountVO = new AccountVO();
		allocation(10);
		totalTransaction = 0;
	}
	
	private void allocation(int capacity) {
		TransactionVO[] temp = new TransactionVO[capacity];
		if(transactionList!=null && transactionList.length>0) {
			System.arraycopy(transactionList, 0, temp, 0, transactionList.length);
		}
		transactionList=temp;
	}
	
	public AccountVO getAccountVO() {
		return accountVO;
	}
	
	public TransactionVO[] getTransactionList() {
		// 전체 거래 리스트
		return transactionList;
	}
	
	public int getTotalTransaction() {
		// 전체 거래 건수
		return totalTransaction;
	}
	
	public boolean addTransaction(TransactionVO vo) {
		// 거래 내역 등록
		if(totalTransaction>=transactionList.length) {
			allocation(transactionList.length+10);
		}
		
		transactionList[totalTransaction++]=vo;
		
		return true;
	}
	
	public TransactionVO getLastTransaction() {
		// 마지막 거래 내역
		if(totalTransaction>0) {
			return transactionList[totalTransaction-1];
		}
		
		return null;
	}
}
