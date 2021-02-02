package hw_0129;

public class Trans {
	private int temp;
	
	public static void send(int money, BankVO vt){
		Trans tr = new Trans();
		tr.temp+=money;
		int tot=vt.getMoney();
		tot+=money;
		vt.setMoney(tot);
	}
}
