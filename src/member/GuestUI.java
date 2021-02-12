package member;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GuestUI {
	private BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	private Member member;
	private Login login;
	
	public GuestUI(Member member, Login login) {
		this.member = member;
		this.login = login; // ���⼭ login ȣ��
	}
	//9
	public void register() { 
		System.out.println("\n[ȸ������]");
		
		MemberVO vo = new MemberVO();
		
		try { // �ϴ� ���δ� string���� �Է�
			System.out.print("���̵�? ");
			vo.setId(br.readLine());
			
			System.out.print("�н�����? ");
			vo.setPwd(br.readLine());
			
			System.out.print("�̸�? ");
			vo.setName(br.readLine());
			
			System.out.print("�������? ");
			vo.setBirth(br.readLine());
			
			System.out.print("��ȭ��ȣ? ");
			vo.setTel(br.readLine());
			
			boolean b=member.insertMember(vo);
			
			if(b) {
				System.out.println("ȸ�� ���� �Ϸ�");
			}else {
				System.out.println("���� ����");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//10
	public void login() {
		System.out.println("\n[�α���]");
		
		String id, pwd;
		
		try {
			System.out.print("���̵�? ");
			id=br.readLine();
			
			System.out.print("�н�����? ");
			pwd=br.readLine();
			
			if(! login.login(id, pwd)) {
				System.out.println("���̵� �Ǵ� �н����尡 ��ġ���� �ʽ��ϴ�.\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
