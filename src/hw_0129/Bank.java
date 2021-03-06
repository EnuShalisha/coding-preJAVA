package hw_0129;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Bank {

	private BankVO[][] list = new BankVO[10][10];

	// 1. 계좌등록

	public void setExample() {
		BankVO vo = new BankVO();
		vo.setName("한장희");
		vo.setMoney(2000000000);
		vo.setAccount("01");
		vo.setRgdate("20210129");
		list[0][1] = vo;
	}

	public BankVO already(String getname) { // 맨 앞에있는 배열에 이름이 같은 계좌만 검색되는 한계있음
		BankVO vo= new BankVO();
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				if(list[i][j]!=null)
				{vo=list[i][j];
					if(vo.getName().equals(getname))
						return vo;
				}
			}
		}
		return null;}
	
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
		int repw=tot/100;
		vo.setPw(repw);
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

	public int newVoucher(String name, BankVO vo) {
		int n=10000;
		n+=vo.getMoney();
		vo.setMoney(n);
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
	
	public boolean confirmPw(int pw, int sw, BankVO vo) {
		if(pw/100==vo.getPw()) {
			pw=pw-(pw/100*100);
			if(Pw2nd.confirmSnd(sw, pw))
				return true;
		}
		return false;
	}
	

	// 3. 송금

	public boolean existMoney(int money, BankVO vo) {
		int tot=vo.getMoney();
		if(tot-money>=0)
			return true;
		return false;
	}

	public void transmitMoney(int money, BankVO vo, BankVO vt) {
		int tot=vo.getMoney();
		tot-=money;
		vo.setMoney(tot);
		Trans.send(money, vt);
	}


	// 4. 비밀번호 변경
	
	public BankVO remove(int pw, int sw, BankVO vo) {
		pw=pw-(pw/100*100);
		Pw2nd.remove(sw, pw);
		vo.setPw(0);
		return vo;
	}
}
