package member;

public class LoginImpl implements Login{
	private MemberVO loginMember;
	private Member member;
	//5. 생성자를 이용한 의존관계 설정
	public LoginImpl(Member member) {
		this.member = member;
	}
	
	@Override //6
	public boolean login(String id, String pwd) {
		loginMember=null;
		
		MemberVO vo = member.readMember(id);
		if(vo==null) {
			return false;
		}
		
		if(vo.getPwd().equals(pwd)) {
			//로그인 성공의 경우
			loginMember=vo; // 비로소 loginmember에 전달
			return true;
		}
		return false;
	}

	@Override //7
	public void logout() {
		loginMember=null;
	}

	@Override //8
	public MemberVO getLoginMember() {
		return loginMember;
	}
}
