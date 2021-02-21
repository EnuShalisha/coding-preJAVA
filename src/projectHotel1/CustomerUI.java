package projectHotel1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class CustomerUI {
	private BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
	private Client client = new Client();
	private RoomImpl room = new RoomImpl();
	//private Money money = new Money();
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
		int clientno = Integer.parseInt(br.readLine());
		ClientVO vo=client.checkClient(clientno); // ����ȣ ���� Ȯ�� �޼ҵ� - �����ϸ� vo�� ����
		if(vo==null) { // �����ϸ� else��, ������ �� ����
			vo=new ClientVO();
			System.out.println("�̸�?");
			vo.setName(br.readLine());
			System.out.println("����?");
			vo.setRegion(br.readLine());
			System.out.println("����?(M/F)");
			vo.setGender(client.verifyGender(br.readLine()));
			System.out.println("����?");
			vo.setAge(Integer.parseInt(br.readLine()));
			
			clientno=client.inputInfo(vo); // �� ���� ���� �޼ҵ�
			System.out.println("������ ����ȣ�� "+clientno+"�Դϴ�.");
		}
		else {
			System.out.println(vo.getName()+" ���� ȯ���մϴ�.");	
		}
		
		System.out.println("�����Ͻô� �ο��� ����Դϱ�?");
		int clientnum=Integer.parseInt(br.readLine());
		room.verifyClientnum(clientnum); // �����ο��� ����, �Ǵ� �ִ� �ο� �ʰ����� Ȯ��
		
		String grade=null;
		int chooseroom=0;
		room.chooseRoom(clientnum); // �� ����Ʈ(�ο����� ���� ����Ʈ�� �ٸ�) ������ 
		while(true) { 
		try {
			System.out.print("����: ");
			chooseroom=Integer.parseInt(br.readLine());
			if(chooseroom==1) return; //1���� ��������̹Ƿ� ����,
			grade=room.verifychooseRoom(clientnum, chooseroom-2); // ���� �߸� �������� �ʾҴ��� �ٽ��ѹ� Ȯ��
			break; // �� ����� ���� ������ ��� �� ����
		} catch (Exception e) {
			System.out.println(e.getMessage());
			}
		}
		
		int price=room.setRoomprice(clientnum, chooseroom-2); // ���� ��� ���� �޼ҵ�
		System.out.println("���� �����"+price+"���Դϴ�.");
		
		Date start=null;
		Date end=null;
		while(true) {
		try {
			System.out.println("�����Ͻô� ��¥�� �����Ͻʽÿ�.");
			System.out.println("üũ�� ��¥: ");
			System.out.print("��: ");
			String st_mm=br.readLine();
			System.out.print("��: ");
			String st_dd=br.readLine();
			String st="2021-"+st_mm+"-"+st_dd;
			start = reservation.verifyDate(st); // ��¥�� ����� ���ϵǴ��� Ȯ�� - �ٵ� ���� ��û ũ����� �� �Ѱ��ִϱ�(ex. 13�� -> +1�� 1��) ���� �ʿ��ҵ�
			
			System.out.println();
			System.out.println("üũ�ƿ� ��¥: ");
			System.out.print("��: ");
			String ed_mm=br.readLine();
			System.out.print("��: ");
			String ed_dd=br.readLine();
			String ed="2021-"+ed_mm+"-"+ed_dd;
			end = reservation.verifyDate(ed); // ���� ����
			
			reservation.verifyBetweenDate(start, end); // ��¥�� �Ȱ����� ��� �ȵ����� ��ȯ, ���۳�¥���� ����¥ ������ ���ܹ߻�
			break;
		} catch (Exception e) {
			System.out.println(e.getMessage()); // ���� �߸� ���� �����Ұ��� ���⼭ ���
			System.out.println("������ �����Ͻðڽ��ϱ�?[Y/N]");
			String s= br.readLine();
			if(s.equals("Y")||s.equals("y"))
				return;
		}
		}
		
		//new ReservationVO �ִ°� ��� �߿��� Ư�� ���� ���� �����ϴ»��
		//���� ����Ʈ�� �̹� ������� �ڿ� ���� �����ϸ� �ϳ� �Ҷ����� vo�� ��� �ݿ���
		//rvotemp������ new�� �ϳ� ����� �������� vo=rvotemp�� vo�� ��������
		ReservationVO rvotemp = new ReservationVO(clientno, 0, clientnum, start, end, vo.getName(), price, grade); 
		reservation.checkAvaliable(rvotemp); // ���� Ȯ�� �޼ҵ�
		
		System.out.println("������ ������ �����Ͻðڽ��ϱ�?[Y/N]");
		System.out.println("����ȣ\t���̸�\t�����μ�\tüũ��\t\tüũ�ƿ�");
		System.out.println("���ȣ\t���\t����");
		System.out.println("===========================================");
		reservation.showListfromVO(rvotemp);//���� ��Ĵ�� ���� ����ִ°���
		String a=br.readLine(); // Y,y�� ����Ϸ�, �� �ܿ� ���� ���
		if(a.equals("Y")||a.equals("y")) {
			int rsrvno=reservation.inputInfo(rvotemp);
			System.out.println("������ �Ϸ�Ǿ����ϴ�.");
			System.out.println("������ �����ȣ�� "+rsrvno+"���Դϴ�.");
		}
		return;
	} catch (Exception e) {
		System.out.println(e.getMessage());
		System.out.println("�ʱ� ȭ������ ���ư��ϴ�.");
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