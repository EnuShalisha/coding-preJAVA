package hw_0129;

import java.util.Scanner;

public class BankUI {
	private Scanner sc = new Scanner(System.in);
	private Bank bk = new Bank();
	
	public void menu() {
		bk.setExample();
		int ch;
		
		while(true) {
			do {
				System.out.print("1. 계좌등록 2. 계좌검색 3. 송금 4. 비밀번호 변경 5. 종료 => ");
				ch=sc.nextInt();
			}while(ch<1||ch>5);
			
			if(ch==5) return;
			
			switch(ch) { // 여기 스위치에 해당되는 메소드들은 일단 ui에 위치
			case 1:register(); break;
			case 2:search(); break;
			case 3:transmit(); break;
			//case 4:changepw();
			default: break;
			
			}
	}
	}
		
	public void register() {
		System.out.println("계좌 개설을 시작합니다.");
		
		BankVO vo = new BankVO();
		//public key가 없기 때문에 이에 해당하는 계좌번호를 먼저 생성
		//그 전에 가입이력을 먼저 확인
		
		System.out.println("이름?");
		vo.setName(sc.next());
		
		/*if(!bk.already(vo.name)) // boolean형
			{System.out.println("이미 계좌가 존재합니다.");
			return;} 구현 못하겠습니다 이미 너무 많아요*/
			
		vo=bk.createAccount(vo.getName());
		String n=vo.getAccount();
		System.out.printf("귀하의 계좌번호는 %s입니다.\n", n);
		
		while(true) {
			System.out.println("비밀번호를 4자리 입력하십시오.");
			vo.setPw(sc.nextInt()); 
		if(vo.getPw()<=9999&&vo.getPw()>=1000)
			break;
		}
		
		String m = bk.Pwsnd(vo);
		
		System.out.println("귀하의 2차 비밀번호는 "+m+"입니다.");
		
		bk.setRgdate();
		System.out.println("아무키나 누르시면 본 화면은 사라집니다!"); // 나중에 제대로구현
		sc.next();
		for (int i=0; i<80; i++)
			System.out.println();
		
		System.out.println("이 세상에서 제일 이쁘고 잘생긴 사람은?");
		String name=sc.next();
		int v=bk.newVoucher(name);
		System.out.printf("축하합니다. 계좌 개설 기념으로 %,d원이 입금됩니다.\n", v);
		}
	
	public void search() {
		BankVO vo = new BankVO();
		String s;
		System.out.println("계좌번호를 입력하십시오.");
		s=sc.next();
		vo=bk.readAccount(s);
		
		if(vo==null) {
			System.out.println("등록된 계좌가 없습니다.");
			return;
		}
		System.out.print("계좌번호 \t");
		System.out.print("이름 \t");
		System.out.print("개설일자 \n");
		System.out.print(vo.getAccount()+"\t");
		System.out.print(vo.getName()+"\t");
		System.out.print(vo.getRgdate()+"\n");	
	}
	
	public void transmit() {
		BankVO vo = new BankVO();
		while(true) {
		String fs;
		System.out.println("본인의 계좌번호를 입력하십시오.");
		fs=sc.next();
		vo=bk.readAccount(fs);
		if(vo!=null)
			break;
		System.out.println("계좌번호를 다시 입력하십시오.");
		}
		//틀릴시 다시 입력도 해야함
		
		int pw;
		while(true) {
			System.out.println("1차 비밀번호를 입력하십시오.");
			pw=sc.nextInt();
			if(bk.confirmPw(pw, vo))
				break;
			System.out.println("비밀번호가 틀렸습니다.");
			}
		pw-=(pw/100)*100;
		int sw;	
		while(true) {
			System.out.println("2차 비밀번호를 입력하십시오.");
			sw=sc.nextInt();
			if(Pw2nd.confirmSnd(sw, pw))
				break;
			System.out.println("비밀번호가 틀렸습니다.");
			}
		
		int money=0;
		String ts;
		/*
		System.out.println("보내고자 하는 금액을 입력하십시오.");
		money=sc.nextInt();
		if(!bk.goTemp(money)) {
			System.out.println("거래가 취소되었습니다.");
			return;
		}
		
		System.out.println("받는 분 예시) 01 한장희");
		while(true) {
			System.out.println("받는 분의 계좌번호를 입력하십시오.");
			ts=sc.next();
			bk.confirmAcc(ts);
		}
		
		BankVO vt = new BankVO();
		System.out.println("다음의 입금 대상, 금액이 맞습니까?(Y/N)");
		System.out.println("이름: "+vt.getName());
		System.out.println("계좌번호: "+vt.getAccount());
		System.out.println("금액: "+money);
		
		String cf=sc.next();
		if(cf=="Y") bk.Transmit();
		else {
			bk.Return();
			System.out.println("거래가 취소되었습니다.");
			return;
		}
		
		System.out.println("거래가 완료되었습니다.");
		
	}
	
	/*public void changepw() {
		System.out.println("본인의 계좌번호를 입력하십시오.");
		fs=sc.next();
		vf=bk.readAccount(fs);
		//틀릴시 다시 입력도 해야함
		
		int fw;
		int sw;
		while(true) {
			System.out.println("1차 비밀번호를 입력하십시오.");
			fw=sc.nextInt();
			bk.confirmPw(fw);
			if(!bk.confirmPw(fw))
				{System.out.println("비밀번호가 틀렸습니다.");
				break;
				}
			System.out.println("2차 비밀번호를 입력하십시오.");
			sw=sc.nextInt();
			if(!pw2nd.2nd(sw))
				{System.out.println("비밀번호가 틀렸습니다.");
				break;
				}
		}
		
		
		
	*/}
	
	
}
