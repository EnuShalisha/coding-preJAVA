package bankForm;

// ���� ���� �� ���� �ŷ� ���� ����
public class Account {
	private AccountVO accountVO;  // ��������
	private TransactionVO[] transactionList; // ���º��ŷ�����
	private int totalTransaction; // �ŷ������Ǽ�
	
	public Account() {
    	// �ִ� �ŷ������Ǽ��� 50, �Ǵ� �ʱ� 10���� ������ 10�� ����
		accountVO = new AccountVO();
		transactionList = new TransactionVO[50];
		totalTransaction = 0;
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
		return false;
	}
	
	public TransactionVO getLastTransaction() {
		// ������ �ŷ� ����
		return null;
	}
}
