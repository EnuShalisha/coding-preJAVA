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
				case 0: cno=1; rm=201; na="한장희"; sd="2021-09-08"; ed="2021-09-11"; break;
				case 1: cno=2; rm=202; na="정주희"; sd="2021-09-08"; ed="2021-09-12"; break;
				case 2: cno=3; rm=203; na="최재환"; sd="2021-09-08"; ed="2021-09-20"; break;
				case 3: cno=4; rm=204; na="고여울"; sd="2021-09-08"; ed="2021-09-22"; break;
				case 4: cno=5; rm=205; na="황성호"; sd="2021-09-10"; ed="2021-09-20"; break;
				case 5: cno=1; rm=206; na="한장희"; sd="2021-09-10"; ed="2021-09-22"; break;
				case 6: cno=2; rm=207; na="정주희"; sd="2021-09-12"; ed="2021-09-18"; break;
				case 7: cno=3; rm=202; na="최재환"; sd="2021-09-12"; ed="2021-09-20"; break;
				case 8: cno=4; rm=208; na="고여울"; sd="2021-09-12"; ed="2021-09-20"; break;
				case 9: cno=5; rm=209; na="황성호"; sd="2021-09-12"; ed="2021-09-22"; break;
				}
				ReservationVO vo = new ReservationVO(cno, rm, 1, sdf.parse(sd), sdf.parse(ed), na, 50, "디럭스");
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
		         throw new Exception("월을 잘못 입력하셨습니다.[1~12월]");
		      Calendar cal = Calendar.getInstance();
		      cal.set(2021, Integer.parseInt(mm)-1, Integer.parseInt(dd));
		      if(Integer.parseInt(dd)<1||Integer.parseInt(dd)>cal.getActualMaximum(Calendar.DAY_OF_MONTH))
		         throw new Exception("일을 잘못 입력하셨습니다.[0 이하나 해당월의 최댓값 초과로 입력할 수 없습니다]");
		      Date date=sdf.parse("2021-"+mm+"-"+dd);
		      return date;
		   }
	
	@Override
	public void verifyBetweenDate(Date date1, Date date2) throws Exception {
		if(date1.after(date2))
			throw new CheckInDateWrongException("체크인 날짜는 체크아웃 날짜보다 늦을 수 없습니다."); 
		if(date1.equals(date2))
			throw new TheDayReserveException("저희 호텔은 대실이 불가능합니다."); 
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
		
		
		if(grade.equals("디럭스")) {head=201; tail=10;}
		else if(grade.equals("그랜드")) {head=301; tail=8;}
		else if(grade.equals("스위트")) {head=401; tail=5;}
		
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
				System.out.println(rm+"번 방 예약 가능합니다.");
				return;
		}
		if(my_vo.getRoomno()==0) throw new CannotReserveException("만실로 인하여 예약할 수 없습니다.");
	}
	
	@Override
	public String verifychooseRoom(int clientnum, int chooseroom) throws Exception {
		if(chooseroom<0&&chooseroom>4)
			throw new Exception("잘못 입력하셨습니다.");
		if(clientnum>4&&chooseroom==4 || clientnum>5&&chooseroom==3)
			throw new CannotReserveException("선택하신 방은 인원 초과입니다.");
		String s=null;
		switch(chooseroom) {
		case 2: s="스위트"; break;
		case 3: s="그랜드"; break;
		case 4: s="디럭스"; break;
		}
		return s;
	}
	

	@Override
	public void showRoomlist(String mm, String dd) throws Exception {
	      try {
	         Date date=verifyDate(mm, dd);
	         String day=sdf.format(date);
	         System.out.println("["+day+" 예약 현황]");
	         System.out.println("*이용 가능: ○, 이용 중: ●, 체크인/체크아웃: ◎");
	         
	         int head=0; int tail=0; String floor=null;
	         
	         for(int l=0; l<3; l++) {
	            switch(l) {
	            case 0: head=401; tail=5; floor="4층"; break;
	            case 1: head=301; tail=8; floor="3층"; break;
	            case 2: head=201; tail=10; floor="2층"; break;
	            }
	            System.out.println();
	            System.out.print(floor+":\t");
	            for(int i=0; i<tail; i++) 
	               System.out.print(head+i+"호\t");
	            System.out.println();
	            System.out.print("가능:\t");
	            
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
	                           System.out.print("●\t");
	                           continue aa;
	                        }
	                        availability=1;
	                     }
	                     else if(date.after(end)||date.before(start)) {}
	                     else {
	                        System.out.print("●\t");
	                        continue aa;
	                     }
	                  }   
	               }
	               switch(availability){
	                  case 0: System.out.print("○\t"); break;
	                  case 1: System.out.print("◎\t"); break;
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
	      StringBuilder sb = new StringBuilder("예약번호\t고객이름\t투숙인수\t체크인\t\t체크아웃\n");
	      sb.append("방번호\t등급\t가격\n");
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
		         throw new Exception("예약정보가 존재하지 않습니다.");
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
			System.out.println("에러가 발생했습니다. 다시 이용해주세요.");
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
