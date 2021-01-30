package hw_0129;

public class BankVO {
	private String name;
	private String Account;
	private int Pw;
	private String Rgdate; // 자료형 다시 설정?
	private int money;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount() {
		return Account;
	}
	public void setAccount(String account) {
		Account = account;
	}
	public int getPw() {
		return Pw;
	}
	public void setPw(int pw) {
		this.Pw = pw;
	}
	public String getRgdate() {
		return Rgdate;
	}
	public void setRgdate(String rgdate) {
		Rgdate = rgdate;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	
}
