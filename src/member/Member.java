package member;

import java.util.List;

public interface Member {
	public boolean insertMember(MemberVO vo);
	public MemberVO readMember(String id);
	public boolean deleteMember(String id);
	public List<MemberVO> listMember();
}
