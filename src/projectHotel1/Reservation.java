package projectHotel1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Reservation {
	
	private int reserveno=0;
	private Map<Integer, ReservationVO> list = new HashMap<Integer, ReservationVO>();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	//������
	public Reservation() {
		initialize();
	}
	
	//�ʱⰪ
	public void initialize() {
		try {
			for(int i=0; i<10; i++) {
				int cno=0; int rm=0; int cnum=0; String na=null; String sd=null; String ed=null;
				switch(i) {
				case 0: cno=1; rm=201; na="������"; sd="2021-09-08"; ed="2021-09-11"; break;
				case 1: cno=2; rm=202; na="������"; sd="2021-09-08"; ed="2021-09-12"; break;
				case 2: cno=3; rm=203; na="����ȯ"; sd="2021-09-08"; ed="2021-09-20"; break;
				case 3: cno=4; rm=204; na="����"; sd="2021-09-08"; ed="2021-09-22"; break;
				case 4: cno=5; rm=205; na="Ȳ��ȣ"; sd="2021-09-10"; ed="2021-09-20"; break;
				case 5: cno=1; rm=206; na="������"; sd="2021-09-10"; ed="2021-09-22"; break;
				case 6: cno=2; rm=207; na="������"; sd="2021-09-12"; ed="2021-09-18"; break;
				case 7: cno=3; rm=202; na="����ȯ"; sd="2021-09-12"; ed="2021-09-20"; break;
				case 8: cno=4; rm=208; na="����"; sd="2012-09-12"; ed="2021-09-20"; break;
				case 9: cno=5; rm=209; na="Ȳ��ȣ"; sd="2021-09-12"; ed="2021-09-22"; break;
				}
				ReservationVO vo = new ReservationVO(cno, rm, 1, sdf.parse(sd), sdf.parse(ed), na, 50000, "�𷰽�");
				reserveno++;
				list.put(reserveno, vo);
				}
		} catch (Exception e) {}
	}
	
	//��¥ �ùٸ��� �ۼ��ߴ��� Ȯ��
	public Date verifyDate(String day) throws Exception {
		Date date = sdf.parse(day);
		if(date==null)
			throw new Exception("��/���� �߸� �Է��ϼ̽��ϴ�."); // ���� ���� �����
		return date;
	}
	
	public void verifyBetweenDate(Date date1, Date date2) throws Exception {
		if(date1.after(date2))
			throw new Exception("üũ�� ��¥�� üũ�ƿ� ��¥���� ���� �� �����ϴ�."); // ���� ���� �����
		if(date1.equals(date2))
			throw new Exception("���� ȣ���� ���� ����� �Ұ����մϴ�."); //�������� �����
	}
	
	//���� ������ ��¥���� Ȯ��
	public void checkAvaliable(ReservationVO my_vo) throws Exception {
		
		String grade=my_vo.getRoom_grade();
		Date my_start=my_vo.getStartdate();
		Date my_end=my_vo.getEnddate();
		int head=0;
		int tail=0;
		
		//���߿� ���� ����, ��� �̸� ����� �ڵ� ����ǵ���
		if(grade.equals("�𷰽�")) {head=201; tail=10;}
		else if(grade.equals("�׷���")) {head=301; tail=8;}
		else if(grade.equals("����Ʈ")) {head=401; tail=5;}
		
		aa:
		for(int i=0; i<tail; i++) {
			int rm=head+i;
				for(int key:list.keySet()) {
					ReservationVO vo = list.get(key);
					if(vo.getRoomno()==rm) {
						Date start=vo.getStartdate();
						Date end=vo.getEnddate();
						if((my_start.before(end)&&my_end.before(end)&&(my_end.before(start)||my_end.equals(start)))
						||(my_end.after(start)&&my_start.after(start)&&(my_start.after(end)||my_start.equals(end))))
							break;
						continue aa;
					}
				}
				my_vo.setRoomno(rm);
				System.out.println(rm+"�� �� ���� �����մϴ�.");
				return;
		}
		if(my_vo.getRoomno()==0) throw new CannotReserveException("���� ��� ���� ������ �� �����ϴ�.");
	}
	
	public String verifychooseRoom(int clientnum, int chooseroom) throws Exception {
		if(chooseroom<0&&chooseroom>4)
			throw new Exception("�߸� �Է��ϼ̽��ϴ�.");
		if(clientnum>4&&chooseroom==4 || clientnum>5&&chooseroom==3)
			throw new Exception("�����Ͻ� ���� �ο� �ʰ��Դϴ�.");
		String s=null;
		switch(chooseroom) {
		case 2: s="����Ʈ"; break;
		case 3: s="�׷���"; break;
		case 4: s="�𷰽�"; break;
		}
		return s;
	}
	
	//��¥�� ���� ��Ȳ �˻�
	public void showRoomlist(String day) throws Exception {
		try {
			Date date=verifyDate(day);
			
			System.out.println(day+" ���� ��Ȳ");
			System.out.println("�̿� ����: ��, �̿� ��: ��, üũ��/üũ�ƿ�: ��");
			
			int head=0; int tail=0; String floor=null;
			
			for(int l=0; l<3; l++) {
				switch(l) {
				case 0: head=401; tail=5; floor="4��"; break;
				case 1: head=301; tail=8; floor="3��"; break;
				case 2: head=201; tail=10; floor="2��"; break;
				}
				
				System.out.print(floor+":\t");
				for(int i=0; i<tail; i++) 
					System.out.print(head+i+"ȣ\t");
				System.out.println();
				System.out.print("����:\t");
				
				aa:
				for(int i=0; i<tail; i++) {
					int availability=0; // �̿� ����:0, üũ��/üũ�ƿ�:1
					int rm=head+i;
					for(int key:list.keySet()) {
						ReservationVO vo = list.get(key);
					
						if(vo.getRoomno()==rm) {
							Date start=vo.getStartdate();
							Date end=vo.getEnddate();
				
							if(date.equals(start)||date.equals(end)) {
								if(availability==1) {
									System.out.print("��\t");
									continue aa;
								}
								availability=1;
							}
							else if(date.after(end)||date.before(start)) {}
							else {
								System.out.print("��\t");
								continue aa;
							}
						}	
					}
					switch(availability){
						case 0: System.out.print("��\t"); break;
						case 1: System.out.print("��\t"); break;
					}	
				}
			System.out.println();
			}
		}catch (Exception e) {
			throw e;
		}
	}
	
	//Ư�� ReservationVO�� ���� ����Ʈ �����ֱ�
	public void showListfromVO(ReservationVO vo) {
		System.out.println(vo.getClientno()+"\t"+vo.getClient_name()+"\t"+vo.getClientnum()+"\t"+sdf.format(vo.getStartdate())+"\t"+sdf.format(vo.getEnddate()));
		System.out.println(vo.getRoomno()+"\t"+vo.getRoom_grade()+"\t"+vo.getRoom_price());
	}
	
	//���� ���� Ȯ��
	public ReservationVO checkClient(int reserveno) {
		if(list.containsKey(reserveno))
			return list.get(reserveno);
		return null;
	}
	
	//���� ����
	public int inputInfo(ReservationVO vo) {
		reserveno++;
		list.put(reserveno, vo);
		return reserveno;
	}
	

}
