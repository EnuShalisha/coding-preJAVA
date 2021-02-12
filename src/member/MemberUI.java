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
		System.out.println("\n[ȸ����������]");
		
		MemberVO vo = login.getLoginMember();
		if(vo==null)
			return;
		
		try {
			System.out.print("������ �н�����?");
			vo.setPwd(br.readLine());
			
			System.out.print("��ȭ��ȣ? ");
			vo.setTel(br.readLine());
			
			System.out.println("���� �Ϸ�");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
	}
	//12
	public void delete() {
		System.out.println("\n[ȸ��Ż��]");
		MemberVO vo = login.getLoginMember();
		if(vo==null) {
			return;
		}
		
		try {
			System.out.println("ȸ���� Ż���Ͻðڽ��ϱ�[Y/N]? ");
			char ch= br.readLine().charAt(0);
			if(ch!='Y'&&ch!='y')
				return;
			member.deleteMember(vo.getId());
			login.logout();
			
			System.out.println("ȸ��Ż�� �Ϸ�");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//11
	public void listAll() {
		System.out.println("\n[ȸ������Ʈ]");
		
		System.out.println("�� ȸ��: "+member.listMember().size());
		for(MemberVO vo:member.listMember()) {
			System.out.println(vo);
		}
		System.out.println();
	}
	//13
	public void findByName() {
		System.out.println("\n[ȸ���˻�]");
		
		String name;
		
		try {
			System.out.print("�˻��� �̸�? ");
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
