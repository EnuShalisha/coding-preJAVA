package bank;

// ���� ���� �� ���� �ŷ� ���� ����
public class Account {
	private AccountVO accountVO;  // ��������
	private TransactionVO[] transactionList; // ���º��ŷ�����
	private int totalTransaction; // �ŷ������Ǽ�
	
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
		// ��ü �ŷ� ����Ʈ
		return transactionList;
	}
	
	public int getTotalTransaction() {
		// ��ü �ŷ� �Ǽ�
		return totalTransaction;
	}
	
	public boolean addTransaction(TransactionVO vo) {
		// �ŷ� ���� ���
		if(totalTransaction>=transactionList.length) {
			allocation(transactionList.length+10);
		}
		
		transactionList[totalTransaction++]=vo;
		
		return true;
	}
	
	public TransactionVO getLastTransaction() {
		// ������ �ŷ� ����
		if(totalTransaction>0) {
			return transactionList[totalTransaction-1];
		}
		
		return null;
	}
}
