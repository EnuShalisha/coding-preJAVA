package user1;

import java.util.Scanner;

public class UserUI {
	private Scanner sc=new Scanner(System.in);
	private User user = new User();
	private UserResult ur = new UserResult(user); // 이거 하나로 일단 강한의존관계에서 변수 커넥션 형성
	
	public void menu() {
		int ch;
		while(true) {
			do {
				System.out.print("1. 입력 2. 출력 3. 종료");
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
		System.out.println("데이터 입력");
		
		UserVO vo = new UserVO();
		System.out.print("이름?");
		vo.setName(sc.next());
		
		System.out.print("나이??");
		vo.setAge(sc.nextInt());
		
		user.append(vo);
		
		System.out.println("추가 완료\n");
	}
	
	public void print() {
		System.out.println("데이터 출력");
		
		ur.write();
	}
	
	
}
