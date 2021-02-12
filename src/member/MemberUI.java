package member;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MemberUI {
	private BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	private Member member;
	private Login login;
	
	public MemberUI(Member member, Login login) {
		this.member = member;
		this.login = login;
	}
	//14
	public void update() {
		System.out.println("\n[회원정보수정]");
		
		MemberVO vo = login.getLoginMember();
		if(vo==null)
			return;
		
		try {
			System.out.print("수정할 패스워드?");
			vo.setPwd(br.readLine());
			
			System.out.print("전화번호? ");
			vo.setTel(br.readLine());
			
			System.out.println("수정 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
	}
	//12
	public void delete() {
		System.out.println("\n[회원탈퇴]");
		MemberVO vo = login.getLoginMember();
		if(vo==null) {
			return;
		}
		
		try {
			System.out.println("회원을 탈퇴하시겠습니까[Y/N]? ");
			char ch= br.readLine().charAt(0);
			if(ch!='Y'&&ch!='y')
				return;
			member.deleteMember(vo.getId());
			login.logout();
			
			System.out.println("회원탈퇴 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//11
	public void listAll() {
		System.out.println("\n[회원리스트]");
		
		System.out.println("총 회원: "+member.listMember().size());
		for(MemberVO vo:member.listMember()) {
			System.out.println(vo);
		}
		System.out.println();
	}
	//13
	public void findByName() {
		System.out.println("\n[회원검색]");
		
		String name;
		
		try {
			System.out.print("검색할 이름? ");
			name=br.readLine();
			
			for(MemberVO vo:member.listMember()) {
				if(vo.getName().indexOf(name)!=-1) {
					System.out.println(vo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
	}
}
