package hw_0129;

import java.util.Scanner;

public class BankUI {
	private Scanner sc = new Scanner(System.in);
	private Bank bk = new Bank();
	//메뉴 선택창
	public void menu() {
		bk.setExample(); // 송금을 위해서 예시 계좌 1개 개설
		int ch;
		
		while(true) {
			do {
				System.out.print("1. 계좌등록 2. 계좌검색 3. 송금 4. 비밀번호 변경 5. 종료 => ");
				ch=sc.nextInt();
			}while(ch<1||ch>5);
			
			if(ch==5) return;
			
			switch(ch) { 
			case 1:register(); break;
			case 2:search(); break;
			case 3:transmit(); break;
			case 4:changepw(); break;
			
			}
	}
	}
	//1. 계좌 등록 선택시
	public void register() {
		System.out.println("계좌 개설을 시작합니다.");
		
		BankVO vo = new BankVO();
		
		System.out.println("이름?");
		vo.setName(sc.next());
		
		//계좌 중복성 확인
		BankVO vk=bk.already(vo.getName());
		if(vk!=null) 
			{System.out.println("같은 이름으로 다음의 계좌가 존재합니다. 귀하의 계좌입니까?(Y/N)");
			System.out.print("계좌번호 \t");
			System.out.print("이름 \t");
			System.out.print("개설일자 \n");
			System.out.print(vk.getAccount()+"\t");
			System.out.print(vk.getName()+"\t");
			System.out.print(vk.getRgdate()+"\n");
			char yn=sc.next().charAt(0);
			if(yn=='Y') {
				System.out.println("두개 이상 계좌를 개설할 수 없습니다.");
				return;
			}
		} 
		
		//public key가 없기 때문에 이에 해당하는 계좌번호를 먼저 생성	
		vo=bk.createAccount(vo.getName());
		String n=vo.getAccount();
		System.out.printf("귀하의 계좌번호는 %s입니다.\n", n);
		
		//1차 비밀번호 입력+2차 비밀번호 변수
		String m;
		while(true) {
			System.out.println("비밀번호를 4자리 입력하십시오.");
			vo.setPw(sc.nextInt()); 
		if(vo.getPw()<=9999&&vo.getPw()>=1000) {
		//비밀번호 4글자 받을 시 2차 비밀번호 생성으로 이동
			m=bk.Pwsnd(vo);
			break;
		}
			}
		System.out.println("귀하의 2차 비밀번호는 "+m+"입니다.");
		bk.setRgdate(); // 개설일자 입력
		
		//2차 비밀번호 화면에서 제거 - 나중에 제대로 구현
		System.out.println("계좌번호와 비밀번호를 잘 기억해두세요.");
		System.out.println("아무 글자나 입력하시면 본 화면은 사라집니다!");
		sc.next();
		for (int i=0; i<80; i++)
			System.out.println();
		
		//바우처 지급(입출금을 구현하지 않았기때문에)
		System.out.println("이 세상에서 제일 이쁘고 잘생긴 사람은?");
		String name=sc.next();
		int v=bk.newVoucher(name, vo);
		System.out.printf("축하합니다. 계좌 개설 기념으로 %,d원이 입금됩니다.\n", v);
		}
	
	//2. 계좌 검색 선택시
	public void search() {
		
		//계좌 검색
		BankVO vo = new BankVO();
		String s;
		System.out.println("계좌번호를 입력하십시오.");
		s=sc.next();
		vo=bk.readAccount(s);
		
		//계좌 유효성 검사
		if(vo==null) {
			System.out.println("등록된 계좌가 없습니다.");
			return;
		}
		
		//비밀번호 검사
		int pw, sw;
		while(true) {
			System.out.println("1차 비밀번호를 입력하십시오.");
			pw=sc.nextInt();
			System.out.println("2차 비밀번호를 입력하십시오.");
			sw=sc.nextInt();
			if(bk.confirmPw(pw, sw, vo))
				break;
			System.out.println("비밀번호가 틀렸습니다.");
			}
		
		//2차 비밀번호 화면에서 제거 - 나중에 제대로 구현
			System.out.println("아무 글자나 입력하시면 본 화면은 사라집니다!");
			sc.next();
			for (int i=0; i<80; i++)
				System.out.println();
		
		//계좌 정보 output
		System.out.print("계좌번호 \t");
		System.out.print("이름 \t");
		System.out.print("개설일자 \n");
		System.out.print(vo.getAccount()+"\t");
		System.out.print(vo.getName()+"\t");
		System.out.print(vo.getRgdate()+"\n");	
	}
	
	//3. 송금 선택시
	public void transmit() {
		
		//계좌번호 입력 및 유효성 검사
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
		
		//비밀번호 검사
		int pw, sw;
		while(true) {
			System.out.println("1차 비밀번호를 입력하십시오.");
			pw=sc.nextInt();
			System.out.println("2차 비밀번호를 입력하십시오.");
			sw=sc.nextInt();
			if(bk.confirmPw(pw, sw, vo))
				break;
			System.out.println("비밀번호가 틀렸습니다.");
			}

		//2차 비밀번호 화면에서 제거 - 나중에 제대로 구현
		System.out.println("아무 글자나 입력하시면 본 화면은 사라집니다!");
		sc.next();
		for (int i=0; i<80; i++)
			System.out.println();
		
		//보내는 금액 설정
		int money=0;
		String ts;
		System.out.println("보내고자 하는 금액을 입력하십시오.");
		money=sc.nextInt();
		if(!bk.existMoney(money, vo)) {
			System.out.println("잔액이 부족합니다.");
			System.out.println("거래가 취소되었습니다.");
			return;
		}
		
		//받는 사람 계좌 입력 및 유효성 검사
		System.out.println("받는 분 예시) 01 한장희");
		BankVO vt = new BankVO();
		while(true) {
			System.out.println("받는 분의 계좌번호를 입력하십시오.");
			ts=sc.next();
			BankVO tmp=bk.readAccount(ts);
			if(vo!=null)
				{vt=tmp;
				break;}
			System.out.println("계좌번호를 다시 입력하십시오.");
		}
		
		//재확인
		System.out.println("다음의 입금 대상, 금액이 맞습니까?(Y/N)");
		System.out.println("이름: "+vt.getName());
		System.out.println("계좌번호: "+vt.getAccount());
		System.out.println("금액: "+money);
		char yn=sc.next().charAt(0);
		
		//Y는 송금, N은 거래 취소
		if(yn=='Y') bk.transmitMoney(money, vo, vt);
		else {
			System.out.println("거래가 취소되었습니다.");
			return;
		}
		System.out.println("잔액: "+vo.getMoney()+"원");
		System.out.println("거래가 완료되었습니다.");
		
	}
	
	//4. 비밀번호 변경 선택시
	public void changepw() {
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
		
		//비밀번호 검사
		int pw, sw;
		while(true) {
			System.out.println("1차 비밀번호를 입력하십시오.");
			pw=sc.nextInt();
			System.out.println("2차 비밀번호를 입력하십시오.");
			sw=sc.nextInt();
			if(bk.confirmPw(pw, sw, vo))
				break;
			System.out.println("비밀번호가 틀렸습니다.");
			}
		
		//기존 비밀번호 삭제
		vo=bk.remove(pw, sw, vo);
		
		//2차 비밀번호 화면에서 제거 - 나중에 제대로 구현
		System.out.println("아무 글자나 입력하시면 본 화면은 사라집니다!");
		sc.next();
		for (int i=0; i<80; i++)
			System.out.println();
		
		//이하 1번과 동일
		//1차 비밀번호 설정
		while(true) {
			System.out.println("비밀번호를 4자리 입력하십시오.");
			vo.setPw(sc.nextInt()); 
		if(vo.getPw()<=9999&&vo.getPw()>=1000) {
		//비밀번호 4글자 받을 시 2차 비밀번호 생성으로 이동
			bk.Pwsnd(vo);
			break;
		}
			}
		String m = bk.Pwsnd(vo);
		System.out.println("귀하의 2차 비밀번호는 "+m+"입니다.");
		
		//2차 비밀번호 화면에서 제거 - 나중에 제대로 구현
		System.out.println("계좌번호와 비밀번호를 잘 기억해두세요.");
		System.out.println("아무 글자나 입력하시면 본 화면은 사라집니다!");
		sc.next();
		for (int i=0; i<80; i++)
			System.out.println();
	}
	
}
