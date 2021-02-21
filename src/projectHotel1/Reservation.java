package projectHotel1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Reservation {
	
	private int reserveno=0;
	private Map<Integer, ReservationVO> list = new HashMap<Integer, ReservationVO>();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	//생성자
	public Reservation() {
		initialize();
	}
	
	//초기값
	public void initialize() {
		try {
			for(int i=0; i<10; i++) {
				int cno=0; int rm=0; int cnum=0; String na=null; String sd=null; String ed=null;
				switch(i) {
				case 0: cno=1; rm=201; na="한장희"; sd="2021-09-08"; ed="2021-09-11"; break;
				case 1: cno=2; rm=202; na="정주희"; sd="2021-09-08"; ed="2021-09-12"; break;
				case 2: cno=3; rm=203; na="최재환"; sd="2021-09-08"; ed="2021-09-20"; break;
				case 3: cno=4; rm=204; na="고여울"; sd="2021-09-08"; ed="2021-09-22"; break;
				case 4: cno=5; rm=205; na="황성호"; sd="2021-09-10"; ed="2021-09-20"; break;
				case 5: cno=1; rm=206; na="한장희"; sd="2021-09-10"; ed="2021-09-22"; break;
				case 6: cno=2; rm=207; na="정주희"; sd="2021-09-12"; ed="2021-09-18"; break;
				case 7: cno=3; rm=202; na="최재환"; sd="2021-09-12"; ed="2021-09-20"; break;
				case 8: cno=4; rm=208; na="고여울"; sd="2012-09-12"; ed="2021-09-20"; break;
				case 9: cno=5; rm=209; na="황성호"; sd="2021-09-12"; ed="2021-09-22"; break;
				}
				ReservationVO vo = new ReservationVO(cno, rm, 1, sdf.parse(sd), sdf.parse(ed), na, 50000, "디럭스");
				reserveno++;
				list.put(reserveno, vo);
				}
		} catch (Exception e) {}
	}
	
	//날짜 올바르게 작성했는지 확인
	public Date verifyDate(String day) throws Exception {
		Date date = sdf.parse(day);
		if(date==null)
			throw new Exception("월/일을 잘못 입력하셨습니다."); // 무슨 예외 블라블라
		return date;
	}
	
	public void verifyBetweenDate(Date date1, Date date2) throws Exception {
		if(date1.after(date2))
			throw new Exception("체크인 날짜는 체크아웃 날짜보다 늦을 수 없습니다."); // 무슨 예외 블라블라
		if(date1.equals(date2))
			throw new Exception("저희 호텔은 당일 대실이 불가능합니다."); //무슨예외 블라블라
	}
	
	//예약 가능한 날짜인지 확인
	public void checkAvaliable(ReservationVO my_vo) throws Exception {
		
		String grade=my_vo.getRoom_grade();
		Date my_start=my_vo.getStartdate();
		Date my_end=my_vo.getEnddate();
		int head=0;
		int tail=0;
		
		//나중에 수정 예정, 등급 이름 변경시 자동 적용되도록
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
		if(my_vo.getRoomno()==0) throw new CannotReserveException("방이 모두 차서 예약할 수 없습니다.");
	}
	
	public String verifychooseRoom(int clientnum, int chooseroom) throws Exception {
		if(chooseroom<0&&chooseroom>4)
			throw new Exception("잘못 입력하셨습니다.");
		if(clientnum>4&&chooseroom==4 || clientnum>5&&chooseroom==3)
			throw new Exception("선택하신 방은 인원 초과입니다.");
		String s=null;
		switch(chooseroom) {
		case 2: s="스위트"; break;
		case 3: s="그랜드"; break;
		case 4: s="디럭스"; break;
		}
		return s;
	}
	
	//날짜별 예약 현황 검색
	public void showRoomlist(String day) throws Exception {
		try {
			Date date=verifyDate(day);
			
			System.out.println(day+" 예약 현황");
			System.out.println("이용 가능: ○, 이용 중: ●, 체크인/체크아웃: ◎");
			
			int head=0; int tail=0; String floor=null;
			
			for(int l=0; l<3; l++) {
				switch(l) {
				case 0: head=401; tail=5; floor="4층"; break;
				case 1: head=301; tail=8; floor="3층"; break;
				case 2: head=201; tail=10; floor="2층"; break;
				}
				
				System.out.print(floor+":\t");
				for(int i=0; i<tail; i++) 
					System.out.print(head+i+"호\t");
				System.out.println();
				System.out.print("가능:\t");
				
				aa:
				for(int i=0; i<tail; i++) {
					int availability=0; // 이용 가능:0, 체크인/체크아웃:1
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
	
	//특정 ReservationVO의 예약 리스트 보여주기
	public void showListfromVO(ReservationVO vo) {
		System.out.println(vo.getClientno()+"\t"+vo.getClient_name()+"\t"+vo.getClientnum()+"\t"+sdf.format(vo.getStartdate())+"\t"+sdf.format(vo.getEnddate()));
		System.out.println(vo.getRoomno()+"\t"+vo.getRoom_grade()+"\t"+vo.getRoom_price());
	}
	
	//예약 여부 확인
	public ReservationVO checkClient(int reserveno) {
		if(list.containsKey(reserveno))
			return list.get(reserveno);
		return null;
	}
	
	//예약 저장
	public int inputInfo(ReservationVO vo) {
		reserveno++;
		list.put(reserveno, vo);
		return reserveno;
	}
	

}
