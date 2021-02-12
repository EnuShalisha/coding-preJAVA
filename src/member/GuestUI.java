package member;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GuestUI {
	private BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	private Member member;
	private Login login;
	
	public GuestUI(Member member, Login login) {
		this.member = member;
		this.login = login; // 여기서 login 호출
	}
	//9
	public void register() { 
		System.out.println("\n[회원가입]");
		
		MemberVO vo = new MemberVO();
		
		try { // 일단 전부다 string으로 입력
			System.out.print("아이디? ");
			vo.setId(br.readLine());
			
			System.out.print("패스워드? ");
			vo.setPwd(br.readLine());
			
			System.out.print("이름? ");
			vo.setName(br.readLine());
			
			System.out.print("생년월일? ");
			vo.setBirth(br.readLine());
			
			System.out.print("전화번호? ");
			vo.setTel(br.readLine());
			
			boolean b=member.insertMember(vo);
			
			if(b) {
				System.out.println("회원 가입 완료");
			}else {
				System.out.println("가입 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//10
	public void login() {
		System.out.println("\n[로그인]");
		
		String id, pwd;
		
		try {
			System.out.print("아이디? ");
			id=br.readLine();
			
			System.out.print("패스워드? ");
			pwd=br.readLine();
			
			if(! login.login(id, pwd)) {
				System.out.println("아이디 또는 패스워드가 일치하지 않습니다.\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
