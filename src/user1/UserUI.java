package user1;

import java.util.Scanner;

public class UserUI {
	private Scanner sc=new Scanner(System.in);
	private User user = new User();
	private UserResult ur = new UserResult(user); // �̰� �ϳ��� �ϴ� �����������迡�� ���� Ŀ�ؼ� ����
	
	public void menu() {
		int ch;
		while(true) {
			do {
				System.out.print("1. �Է� 2. ��� 3. ����");
				ch=sc.nextInt();
			}while(ch<1||ch>3);
			if(ch==3) return;
			
			switch(ch) {
			case 1:input(); break;
			case 2:print(); break;
			}
		}
	}
	
	public void input() {
		System.out.println("������ �Է�");
		
		UserVO vo = new UserVO();
		System.out.print("�̸�?");
		vo.setName(sc.next());
		
		System.out.print("����??");
		vo.setAge(sc.nextInt());
		
		user.append(vo);
		
		System.out.println("�߰� �Ϸ�\n");
	}
	
	public void print() {
		System.out.println("������ ���");
		
		ur.write();
	}
	
	
}
