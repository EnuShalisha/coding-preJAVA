package hw_0129;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Bank {

	private BankVO[][] list = new BankVO[10][10];

	// 1. 계좌등록

	public void setExample() {
		BankVO vo = new BankVO();
		vo.setName("Han");
		vo.setMoney(2000000000);
		vo.setAccount("01");
		vo.setRgdate("20210129");
		list[0][1] = vo;
	}

	public BankVO createAccount(String getname) {
		int i=0, j=0;
		while(true) {
		i=(int) (Math.random()*10);
		j=(int) (Math.random()*10);
		if(list[i][j]==null) {
			BankVO vo = new BankVO();
			vo.setName(getname);
			vo.setAccount(Integer.toString(i)+Integer.toString(j));
			list[i][j]=vo;
			return list[i][j];
		}
	}
	}

	public String Pwsnd(BankVO vo) {
		int tot=vo.getPw();
		int j=tot%10;
		int i=(tot-(tot/100)*100-j)/10;
		return Pw2nd.set(i, j);
	}

	public void setRgdate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar c1 = Calendar.getInstance();

		String today = sdf.format(c1.getTime());
		BankVO vo = new BankVO();
		vo.setRgdate(today);
	}

	public int newVoucher(String name) {
		int n=0;
		if(name.equals("선민지"))
			n=2000000000;
		else
			n=10000;
		return n;
	}

	// 2. 계좌검색
	public BankVO readAccount(String s) {
		int tot=Integer.parseInt(s);
		int j=tot%10;
		int i=(tot-j)/10;
		BankVO vo = list[i][j];
		return vo;
			
	}

	// 3. 송금
	public boolean confirmPw(int pw, BankVO vo) {
		if(pw==vo.getPw())
			return true;
		return false;
	}

	public boolean goTemp(int money) {
		int temp;
		return false;

	}

	public boolean confirmAcc(String ts) {
		return false;
	}

	public void Transmit() {

	}

	public void Return() {

	}

	// 4. 비밀번호 변경

}
