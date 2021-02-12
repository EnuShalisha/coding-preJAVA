package member;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainUI {
	private Scanner sc=new Scanner(System.in);
	private Member member = new MemberImpl();
	private Login login = new LoginImpl(member);
	
	private GuestUI guestUI = new GuestUI(member, login);
	private MemberUI memberUI = new MemberUI(member, login);

	public void menu() {
		while(true) {
			if(login.getLoginMember()==null) {
				menuGuest();
			} else {
				menuMember();
			}
		}
	}
	
	private void menuGuest() {
		try {
			int ch;
			
			do {
				System.out.print("1.로그인 2.회원가입 3.종료 => ");
				ch = sc.nextInt();
			} while(ch<1 || ch>3);
			
			if(ch==3) {
				System.exit(0);
			}
			
			switch(ch) {
			case 1: guestUI.login(); break;
			case 2: guestUI.register(); break;
			}
			
		} catch (InputMismatchException e) {
			sc.nextLine();
		}
	}
	
	private void menuMember() {
		try {
			int ch;
			
			System.out.print("["+login.getLoginMember().getName()+"] 님");
			do {
				System.out.print("1.정보수정 2.회원검색 3.로그아웃 4.회원탈퇴 5.리스트 => ");
				ch = sc.nextInt();
			} while(ch<1 || ch>5);
			
			switch(ch) {
			case 1: memberUI.update(); break;
			case 2: memberUI.findByName(); break;
			case 3: login.logout(); System.out.println(); break;
			case 4: memberUI.delete(); break;
			case 5: memberUI.listAll(); break;
			}
			
		} catch (InputMismatchException e) {
			sc.nextLine();
		}
	}
}
