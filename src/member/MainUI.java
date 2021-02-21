package member;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainUI {
	private Scanner sc=new Scanner(System.in);
	private Member member = new MemberImpl();
	private Login login = new LoginImpl(member);
	
	private GuestUI guestUI = new GuestUI(member, login);
	private MemberUI memberUI = new MemberUI(member, login);

	public void menu() throws IOException {
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
				System.out.print("1.�α��� 2.ȸ������ 3.���� => ");
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
	
	private void menuMember() throws IOException {
		try {
			int ch;
			
			System.out.print("["+login.getLoginMember().getName()+"] ��");
			do {
				System.out.print("1.�������� 2.ȸ���˻� 3.�α׾ƿ� 4.ȸ��Ż�� 5.����Ʈ 6. �μ� => ");
				ch = sc.nextInt();
			} while(ch<1 || ch>6);
			
			switch(ch) {
			case 1: memberUI.update(); break;
			case 2: memberUI.findByName(); break;
			case 3: login.logout(); System.out.println(); break;
			case 4: memberUI.delete(); break;
			case 5: memberUI.listAll(); break;
			case 6: memberUI.saveMember(); break;
			}
			
		} catch (InputMismatchException e) {
			sc.nextLine();
		}
	}
}
