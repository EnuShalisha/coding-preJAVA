package projectHotel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ReservationImpl implements Reservation {
	
	private int reserveno=0;
	private Map<Integer, ReservationVO> list = new HashMap<Integer, ReservationVO>();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	
	public ReservationImpl() {
		initialize();
	}
	
	@Override
	public void initialize() {
		try {
			int cno=0; int rm=0; String na=null; String sd=null; String ed=null;
			for(int i=0; i<10; i++) {
				switch(i) {
				case 0: cno=1; rm=201; na="������"; sd="2021-09-08"; ed="2021-09-11"; break;
				case 1: cno=2; rm=202; na="������"; sd="2021-09-08"; ed="2021-09-12"; break;
				case 2: cno=3; rm=203; na="����ȯ"; sd="2021-09-08"; ed="2021-09-20"; break;
				case 3: cno=4; rm=204; na="����"; sd="2021-09-08"; ed="2021-09-22"; break;
				case 4: cno=5; rm=205; na="Ȳ��ȣ"; sd="2021-09-10"; ed="2021-09-20"; break;
				case 5: cno=1; rm=206; na="������"; sd="2021-09-10"; ed="2021-09-22"; break;
				case 6: cno=2; rm=207; na="������"; sd="2021-09-12"; ed="2021-09-18"; break;
				case 7: cno=3; rm=202; na="����ȯ"; sd="2021-09-12"; ed="2021-09-20"; break;
				case 8: cno=4; rm=208; na="����"; sd="2021-09-12"; ed="2021-09-20"; break;
				case 9: cno=5; rm=209; na="Ȳ��ȣ"; sd="2021-09-12"; ed="2021-09-22"; break;
				}
				ReservationVO vo = new ReservationVO(cno, rm, 1, sdf.parse(sd), sdf.parse(ed), na, 50, "�𷰽�");
				int price=calculateRevenue(vo.getStartdate(), vo.getEnddate(), vo.getRoom_price());
				vo.setRoom_price(price);
				reserveno++;
				list.put(reserveno, vo);
				}
		} catch (Exception e) {}
	}
	
	
	   @Override
	public Date verifyDate (String mm, String dd) throws Exception {
		      if(Integer.parseInt(mm)>12||Integer.parseInt(mm)<1)
		         throw new Exception("���� �߸� �Է��ϼ̽��ϴ�.[1~12��]");
		      Calendar cal = Calendar.getInstance();
		      cal.set(2021, Integer.parseInt(mm)-1, Integer.parseInt(dd));
		      if(Integer.parseInt(dd)<1||Integer.parseInt(dd)>cal.getActualMaximum(Calendar.DAY_OF_MONTH))
		         throw new Exception("���� �߸� �Է��ϼ̽��ϴ�.[0 ���ϳ� �ش���� �ִ� �ʰ��� �Է��� �� �����ϴ�]");
		      Date date=sdf.parse("2021-"+mm+"-"+dd);
		      return date;
		   }
	
	@Override
	public void verifyBetweenDate(Date date1, Date date2) throws Exception {
		if(date1.after(date2))
			throw new CheckInDateWrongException("üũ�� ��¥�� üũ�ƿ� ��¥���� ���� �� �����ϴ�."); 
		if(date1.equals(date2))
			throw new TheDayReserveException("���� ȣ���� ����� �Ұ����մϴ�."); 
	}
	
	@Override
	public int calculateRevenue (Date start, Date end, int price) {
		long days=(end.getTime()-start.getTime())/(24*60*60*1000);
		price*=days;
		return price;
	}
	

	@Override
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
		if(my_vo.getRoomno()==0) throw new CannotReserveException("���Ƿ� ���Ͽ� ������ �� �����ϴ�.");
	}
	
	@Override
	public String verifychooseRoom(int clientnum, int chooseroom) throws Exception {
		if(chooseroom<0&&chooseroom>4)
			throw new Exception("�߸� �Է��ϼ̽��ϴ�.");
		if(clientnum>4&&chooseroom==4 || clientnum>5&&chooseroom==3)
			throw new CannotReserveException("�����Ͻ� ���� �ο� �ʰ��Դϴ�.");
		String s=null;
		switch(chooseroom) {
		case 2: s="����Ʈ"; break;
		case 3: s="�׷���"; break;
		case 4: s="�𷰽�"; break;
		}
		return s;
	}
	

	@Override
	public void showRoomlist(String mm, String dd) throws Exception {
	      try {
	         Date date=verifyDate(mm, dd);
	         String day=sdf.format(date);
	         System.out.println("["+day+" ���� ��Ȳ]");
	         System.out.println("*�̿� ����: ��, �̿� ��: ��, üũ��/üũ�ƿ�: ��");
	         
	         int head=0; int tail=0; String floor=null;
	         
	         for(int l=0; l<3; l++) {
	            switch(l) {
	            case 0: head=401; tail=5; floor="4��"; break;
	            case 1: head=301; tail=8; floor="3��"; break;
	            case 2: head=201; tail=10; floor="2��"; break;
	            }
	            System.out.println();
	            System.out.print(floor+":\t");
	            for(int i=0; i<tail; i++) 
	               System.out.print(head+i+"ȣ\t");
	            System.out.println();
	            System.out.print("����:\t");
	            
	            aa:
	            for(int i=0; i<tail; i++) {
	               int availability=0;  
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
	

	@Override
	public String showListfromVO(ReservationVO vo) {
        String s1=vo.getClient_name()+"\t"+vo.getClientnum()+"\t"+sdf.format(vo.getStartdate())+"\t"+sdf.format(vo.getEnddate());
        String s2=vo.getRoomno()+"\t"+vo.getRoom_grade()+"\t"+vo.getRoom_price();
        System.out.println(s1);
        System.out.println(s2);
        
        return s1+"\n"+s2;
     }
	

	@Override
	public String showList() {
	      StringBuilder sb = new StringBuilder("�����ȣ\t���̸�\t�����μ�\tüũ��\t\tüũ�ƿ�\n");
	      sb.append("���ȣ\t���\t����\n");
	      System.out.println("===================================================");
	      try {
	         for(int a:list.keySet()) {
	            ReservationVO vo = checkReserve(a);
	            sb.append(a+"\t"+vo.getClient_name()+"\t"+vo.getClientnum()+"\t"+sdf.format(vo.getStartdate())+"\t"+sdf.format(vo.getEnddate())+"\n");
	            sb.append(vo.getRoomno()+"\t"+vo.getRoom_grade()+"\t"+vo.getRoom_price()+"\n");
	            
	         }
	         
	      } catch (Exception e) {
	        e.printStackTrace();
	      }
	      String s=sb.toString();
	      return s;
	      
	   }
	

	   @Override
	public ReservationVO checkReserve(int reserveno) throws Exception {
		      if(!list.containsKey(reserveno))
		         throw new Exception("���������� �������� �ʽ��ϴ�.");
		      return list.get(reserveno);
		   }
		   
	

	@Override
	public int inputInfo(ReservationVO vo) {
		reserveno++;
		list.put(reserveno, vo);
		return reserveno;
	}
	

	@Override
	public void modifyInfo(int reserveno, ReservationVO vo) {
		try {
			list.put(reserveno, vo);	
		} catch (Exception e) {
			System.out.println("������ �߻��߽��ϴ�. �ٽ� �̿����ּ���.");
		}
		
	}
	

	@Override
	public boolean deleteReserve(int reserveno) {
		ReservationVO vo;
		try {
			vo = checkReserve(reserveno);
			if(vo==null)
				return false;
			
			 list.remove(reserveno);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	@Override
	public Map<Integer, ReservationVO> listReservation() {
		return list;
	}

}
