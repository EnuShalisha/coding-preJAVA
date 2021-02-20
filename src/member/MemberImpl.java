package member;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MemberImpl implements Member {
	private List<MemberVO> list = new ArrayList<>();

	@Override//2
	public boolean insertMember(MemberVO vo) {
		if(readMember(vo.getId())!=null) {
			return false;
		}
		boolean b=list.add(vo);
		return b;
	}

	@Override //1
	public MemberVO readMember(String id) {
		for(MemberVO vo : list) {
			if(vo.getId().equals(id)) {
				return vo;
			}
		}
		return null;
	}

	@Override //3
	public boolean deleteMember(String id) {
		MemberVO vo = readMember(id);
		if(vo==null) {
			return false;
		}
		list.remove(vo);
		return true;
	}

	@Override // 4
	public List<MemberVO> listMember() {
		return list;
	}
	
	public boolean SaveMember(MemberVO vo) {
		String pathname="ex.txt";
		
		if(vo==null)
			return false;
		try(BufferedWriter bw=new BufferedWriter(new FileWriter("test.txt"))) {
			bw.write(vo.getId()+"\n");
			bw.write(vo.getPwd()+"\n");
			bw.write(vo.getName()+"\n");
			bw.write(vo.getTel());
			
			System.out.println("저장 완료");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return true;
	}
}
