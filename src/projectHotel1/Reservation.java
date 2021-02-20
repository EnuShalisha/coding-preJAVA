package projectHotel1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Reservation {
	
	private int reserveno=0;
	private Map<Integer, ReservationVO> list = new HashMap<Integer, ReservationVO>();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public Reservation() {
		initialize();
	}
	
	public void initialize() {
		try {
			for(int i=0; i<9; i++) {
				int rm=0;
				String na=null;
				String sd=null;
				String ed=null;
				switch(i) {
				case 0: rm=201; na="������"; sd="2021-09-08"; ed="2021-09-11"; break;
				case 1: rm=202; na="������"; sd="2021-09-08"; ed="2021-09-12"; break;
				case 2: rm=203; na="����ȯ"; sd="2021-09-08"; ed="2021-09-20"; break;
				case 3: rm=204; na="����"; sd="2021-09-08"; ed="2021-09-22"; break;
				case 4: rm=205; na="Ȳ��ȣ"; sd="2021-09-10"; ed="2021-09-20"; break;
				case 5: rm=206; na="������"; sd="2021-09-10"; ed="2021-09-22"; break;
				case 6: rm=207; na="����ȯ"; sd="2021-09-12"; ed="2021-09-18"; break;
				case 7: rm=208; na="����"; sd="2021-09-12"; ed="2021-09-20"; break;
				case 8: rm=209; na="Ȳ��ȣ"; sd="2021-09-12"; ed="2021-09-22"; break;
				}
				ReservationVO vo = new ReservationVO(1, rm, sdf.parse(sd), sdf.parse(ed), na, 50000, "�𷰽�");
				reserveno++;
				list.put(reserveno, vo);
				}
		} catch (Exception e) {
		}
		
	}
	
	public void checkAvaliable(ReservationVO my_vo) throws Exception {
		
		String grade=my_vo.getRoom_grade();
		Date my_start=my_vo.getStartdate();
		Date my_end=my_vo.getEnddate();
		int head=0;
		int tail=0;
		if(grade.equals("�𷰽�")) {head=201; tail=10;}
		else if(grade.equals("�׷���")) {head=301; tail=8;}
		else if(grade.equals("����Ʈ")) {head=401; tail=5;}
		
		aa:
		for(int i=0; i<tail; i++) {
			int rm=head+i;
				for(int key:list.keySet()) {
					ReservationVO vo = list.get(key);
					if(vo.getRoomnum()==rm) {
						Date start=vo.getStartdate();
						Date end=vo.getEnddate();
						if((	my_start.before(end)&&my_end.before(start)&&(my_end.before(end)||my_end.equals(end)))
						||(my_end.after(start)&&my_start.after(start)&&(my_start.after(end)||my_start.equals(end))))
							break;
						continue aa;
					}
				}
				my_vo.setRoomnum(rm);
				System.out.println(rm+"�� ������ ����Ǿ����ϴ�.");
				return;
		}
		if(my_vo.getRoomnum()==0) throw new CannotReserveException("���� ��� ���� ������ �� �����ϴ�.");
	}
	
	public void verifyClientnum(int clientnum) throws Exception {
		if(clientnum>6) {
			throw new ExceedClientException("���� ȣ���� �ִ� 6����� ������ �� �ֽ��ϴ�.\n ������ ������ ������ �ֽʽÿ�.");
		}
		if(clientnum<0) {
			throw new UnderZeroException("0�� ���Ϸ� �Է��� �� �����ϴ�.");
		}
		
		String s;
		switch(clientnum) {
		case 6: s="����Ʈ"; break;
		case 5: s="����Ʈ, �׷���"; break;
		default: s="����Ʈ, �׷���, �𷰽�"; break;
		}
		System.out.println("���Բ��� �̿� �����Ͻ� ����"+s+" �Դϴ�.");
	}
	
	public void showRoomlist(String day) throws Exception {
		try {
			Date date = sdf.parse(day);
			if(date==null)
				throw new Exception("��/���� �߸� �Է��ϼ̽��ϴ�."); // ���� ���� �����
			
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
				for(int i=0; i<tail; i++) {
					System.out.print(head+i+"ȣ\t");
				}
				System.out.println();
				System.out.print("����:\t");
				aa:
				for(int i=0; i<tail; i++) {
					int availability=0; // �̿� ����:0, �̿� ��:1
					int rm=head+i;
					for(int key:list.keySet()) {
						ReservationVO vo = list.get(key);
					
						if(vo.getRoomnum()==rm) {
							Date start=vo.getStartdate();
							Date end=vo.getEnddate();
				
							if(date.equals(start)||date.equals(end)) {
								System.out.print("��\t");
								continue aa;}
							
							else if(date.after(end)||date.before(start))
								availability=0;
							
							else 
								availability=1;
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
	
	
	public ReservationVO checkClient(int reserveno) {
		if(list.containsKey(reserveno))
			return list.get(reserveno);
		return null;
	}
	
	public int inputInfo(ReservationVO vo) {
		reserveno++;
		list.put(reserveno, vo);
		return reserveno;
	}
	

}
