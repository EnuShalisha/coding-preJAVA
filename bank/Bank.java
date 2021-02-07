package bank;

public interface Bank {
	// 계좌 등록
    public Account addAccount(String owner);
    // 입금
    public long deposit(String accountNo, long amount);
    // 출금
    public long withdraw(String accountNo, long amount);
    // 계좌이체
    public long accountTransfer(String fromAccountNo, String toAccountNo, long amount);
    // 잔액조회
    public long balance(String accountNo);
    // 거래내역조회
    public TransactionVO[] transactionHistory(String accountNo);
    // 계좌-번호검색
    public Account readAccount(String accountNo);
    // 계좌-이름검색
    public Account[] getAccountList(String owner);
    // 계좌-전체리스트
	public Account[] getAccountList();
	// 계좌-전체계좌수
	public int getTotalAccount();
}
