package projectHotel1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CustomerUI {
	private BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
	private Client client = new Client();
	private RoomImpl room = new RoomImpl();
	private Reservation reservation = new Reservation();
	
	public void menu() {
		int ch;
		
		while(true) {
			try {
				do {
					System.out.println("1.���ǿ��� 2.������� 3.������� 4.��������Ȯ�� 5. ���������μ� 6.������");
					ch=Integer.parseInt(br.readLine());
				}while(ch<1||ch>6);
				
				if(ch==6) {
					return;
				}
				switch(ch) {
				case 1: Reserve(); break;
				case 2: modifyReserve(); break;
				case 3: removeReserve(); break;
				case 4: resevationCheck(); break;
				case 5: reservationPrint(); break;
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void Reserve() {
	System.out.println("���� ������ �����մϴ�.");
	System.out.println("������ ������ �ް� �ֽ��ϴ�.");
	
	try {
		System.out.println("����ȣ�� ������ �Է�, ������ 0�� �Է��Ͻʽÿ�.");
		ClientVO vo=client.checkClient(Integer.parseInt(readLine()));
		if(vo==null) {
			
			System.out.println("�̸�?");
			vo.setName(br.readLine());
			
			System.out.println("����?");
			vo.setRegion(br.readLine());
			
			System.out.println("����?(M/F)");
			vo.setGender(client.verifyGender(br.readLine()));
			
			System.out.println("����?");
			vo.setAge(Integer.parseInt(br.readLine()));
			
			
			int clientNo=client.inputInfo(vo); // �� ���� ���� �޼ҵ�
			
			System.out.println("������ ����ȣ��"+clientNo+"�Դϴ�.");
		}
		else {
			System.out.println(vo.getName()+"���� ȯ���մϴ�.");	
		}

		System.out.println("�����Ͻô� �ο��� ����Դϱ�?");
		int clientnum=Integer.parseInt(br.readLine());
		reservation.verifyClientnum(clientnum);
		
		System.out.println("���� ������ ���� �غ���ֽ��ϴ�.");
		System.out.println("����Ʈ: �⺻ �����ο� 4��, �ִ� �����ο� 6��");
		System.out.println("�׷���: �⺻ �����ο� 3��, �ִ� �����ο� 5��");
		System.out.println("�𷰽�: �⺻ �����ο� 2��, �ִ� �����ο� 4��");
		
		//�� �޼ҵ忡���� ������ ���鿡 ���� sysout�� �Ѵ�.
		//1. ��� ���� �ִ� ���������� ���� ��� "���� ȣ�ڿ��� x���� ������ �� �����ϴ�. �ο��� ������ ������ �������ֽʽÿ�."
		//2. 6���� ��� "���Բ��� �̿� �����Ͻ� ���� ����Ʈ�Դϴ�."
		//3. 5���� ��� "�𷰽�, ����Ʈ"
		//4. ����) 
		
		System.out.println("� ���� �����Ͻðڽ��ϱ�?");
		System.out.println("1. ����Ʈ 2. �𷰽� 3. ���Ĵٵ�");
		int grade=Integer.parseInt(br.readLine());
	//	RoomVO room=reservation.priceinfo(grade, clientnum);
		//�� �޼ҵ忡���� �� ��ް� �������� �Ķ���ͷ� �޾Ƽ� ������ sout�Ѵ�.
		//1. �߸� �Է����� ��� "�߸� �����ϼ̽��ϴ�."
		//2. �Է��� ���� ��� "������ ���� ����� room.getgrade(), �߰� �����ο� room.getaddnum()������ �� ������ room.revenue()�Դϴ�.
		System.out.println("�Է��� ������ �½��ϱ�?[Y/N]");
		/*
		if(br.readLine()n||N) {
			System.out.println("������ ��ҵǾ����ϴ�.");
			System.out.println("�ʱ�ȭ������ ���ư��ϴ�.");
		}
		System.out.println("���������� ������ �����ϴ�.");
		reservation.find(room); //�մ�-4 �������� Ȯ�� �޼ҵ� �״�� Ű��
		System.out.println("�����Ͻðڽ��ϱ�?[Y/N]");
		if(br.readLine()n||N) {
			System.out.println("������ ��ҵǾ����ϴ�.");
			System.out.println("�ʱ�ȭ������ ���ư��ϴ�.");
		}
		*/
		System.out.println("������ �Ϸ�Ǿ����ϴ�.");
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	
}
	
	private String readLine() {
		// TODO Auto-generated method stub
		return null;
	}

	public void modifyReserve() {
		String name;
		int peoplenum;
		int grade;
		int money=0;
		int refund=0;
		int ch;
		try {
			System.out.println("[�������]");

			System.out.println("������ �Է��ϼ���");
			name= br.readLine();
			//reservevo vo= readreservation(name) -> exception(��ϵǾ����� ���� ��)
			System.out.println("�����ϰ��� �Ͻô� ����� �����ϼ���.");
			grade= Integer.parseInt(br.readLine());
			//verifygrade(grade) -> exception(������ ���)
			System.out.println("�����ο��� �Է��ϼ���.");
			peoplenum = Integer.parseInt(br.readLine());
			//vertifypeoplenum(grade, peoplenum) -> exception
			
			//reservation.modify.(name, grade, peoplenum) ������ ��� ���⿡ ���� �Ϸ�
			
			System.out.println("������ �ݾ���"+money+"���Դϴ�.");
			//RoomVO room = reservation.priceinfo/ ���� ���� �ҷ��ɴϴ�. money= grade+peoplenum
			
			System.out.println("ȯ�ҵ� �ݾ���"+refund+"���Դϴ�.");
			//RoomVO�� reservation�� ����Ǿ��ִ� ���� �ҷ��´�. 
			//�ڵ� ȯ�� �� �� ���� �Ǵ� ����̴�.
			
			
			System.out.println("�����Ͻðڽ��ϱ�?");
			System.out.println("1.�� 2.�ƴϿ�");
			ch = Integer.parseInt(br.readLine());
			////RoomVO room = reservation.priceinfo/ ���� ���� ����ؼ� �ҷ��ɴϴ�. �׸��� �̰ɷ� ������ �����մϴ�.
			
			System.out.println("������ �Ϸ�ƽ��ϴ�.");
		} catch (Exception e) {
			
		}
	}
	public void removeReserve() {
		String name;
		try {
			System.out.println("[���� ���]");
			System.out.println("������ �Է��ϼ���");
			name=br.readLine();
			//reservevo vo= readreservation(name) -> exception(��ϵǾ����� ���� ��)
			
			/*
			if(client.cancleclient(name)) {
				System.out.println("������ ���������� ��ҵǾ����ϴ�.");
			}else {
				System.out.println("�����Ͽ� �������� �ʽ��ϴ�.");
			}
			*/

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void resevationCheck() {
		//��������Ȯ�� ������
		try {
			System.out.println("���� ������ Ȯ���ص帮�ڽ��ϴ�.");
			System.out.print("������ ������ �Է��� �ּ���\n");
			String name = br.readLine(); // ���� - ���� ���ڿ��̶� ���� ���� ���� ������

			System.out.println("������ �����ȣ�� �Է��� �ּ���.\n");
			int reserveno = Integer.parseInt(br.readLine());//���� - ����� ������ InputMismatchException ���Ű�
			
			
			System.out.println();
			System.out.println("(cname + ) ������ ������ �ް� �ֽ��ϴ�.\n");
			System.out.println("(cname + ) ������ �����Ͻ� ������ ������");
			System.out.println("No.\"+���ǹ�ȣ+\"|\"+�̿밴����+\"�� |\"+���ǵ��+\"|\"+���ǰ���+\"��|\"+�̿��ο�+\"��|�Դϴ�.\n");
			//System.out.println("No."+���ǹ�ȣ+"|"+�̿밴����+"�� |"+���ǵ��+"|"+���ǰ���+"��|"+�̿��ο�+"��|");
			//("No."+���ǹ�ȣ+"|"+�̿밴����+"�� |"+���ǵ��+"|"+���ǰ���+"��|"+�̿��ο�+"��|");

			System.out.println("��������Ȯ���� �����մϴ�.");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	
	public void reservationPrint() {
		System.out.println("[���� ���� �μ�]");
		
		try {
			
			System.out.println("������ �Է��ϼ���.");
			String name= br.readLine();//����
			
			System.out.println("������ �����ȣ�� �Է��� �ּ���.\n");
			String reserveNum = br.readLine();//����
			
			System.out.println();
			
			//reservation.print(name,reserveNum);   
			
			
			System.out.println("�μⰡ �Ϸ�ƽ��ϴ�.");
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}