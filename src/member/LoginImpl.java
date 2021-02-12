package member;

public class LoginImpl implements Login{
	private MemberVO loginMember;
	private Member member;
	//5. �����ڸ� �̿��� �������� ����
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
			//�α��� ������ ���
			loginMember=vo; // ��μ� loginmember�� ����
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
