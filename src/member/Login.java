package member;

public interface Login {
	public boolean login(String id, String pwd);
	public void logout();
	public MemberVO getLoginMember();
}
