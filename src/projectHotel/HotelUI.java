package projectHotel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class HotelUI {
	public HotelUI(MainUI mui){
		client = mui.getClient();
		room = mui.getRoom();
		money = mui.getMoney();
		reserve = mui.getReservation();
	}
	private BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
	private Client client;
	private RoomImpl room;
	private Money money;
	private Reservation reserve;
	
	public void listRoom() {
		System.out.println("\n[객실목록]");
		System.out.println();
		System.out.println("호실\t층수   객실금액\t객실등급 기본투숙인원 최대투숙인원");
		System.out.println("---------------------------------------------------");
		sortFloorAsc();
		
		for(RoomVO vo : room.listRoom()) {
			System.out.println(vo);
		}
		System.out.println();
	}
	
	public void updateRoom() {
		System.out.println("\n[객실 수정]");
		int number;
		
		try {
			System.out.print("수정할 객실 번호 ? ");
			number = Integer.parseInt(br.readLine());
			RoomVO vo=room.readRoom(number);
			if(vo==null) {
				System.out.println("등록된 객실이 아닙니다...\n");
				return;
			}
			int price, peoplenum, maxnum;
			System.out.print("가격 ? ");
			price=Integer.parseInt(br.readLine());
			System.out.print("기본 투숙 인원 ? ");
			peoplenum=Integer.parseInt(br.readLine());
			System.out.print("최대 투숙 인원 ? ");
			maxnum=Integer.parseInt(br.readLine());
			
			vo.setPrice(price);
			vo.setPeoplenum(peoplenum);
			vo.setMaxnum(maxnum);
			
			System.out.println("수정 완료…\n");
			
		} catch (NumberFormatException e) {
			System.out.println("수정값은 숫자만 입력 가능합니다…\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void checkRoomlist() {
		System.out.println("\n[일자별 객실 조회]");
		System.out.println("조회하고자 하는 일자를 입력하십시오.");
		try {
			System.out.println("월[MM]");
			String mm=br.readLine();
			System.out.println("일[dd]");
			String dd=br.readLine();

			reserve.showRoomlist(mm,dd);
		} catch (Exception e) {	
			
		}
	}
	  public void ReservationList() {
          System.out.println("\n[전체 예약 조회]");
          System.out.println(reserve.showList());

       }
	
	public void revenueStatus() {
		System.out.println("\n[매출현황 조회]");
	
		 MoneyVO mvo = money.getVO();
         String one=room.getGrade(0).getGrade();
         String two=room.getGrade(1).getGrade();
         String three=room.getGrade(2).getGrade();
         System.out.println("\t\t[매출현황]\t\t");
         System.out.println();
         System.out.println("========================================");
         System.out.println("\t\t|"+one+"\t|"+two+"\t|"+three);
         System.out.println("판매 객실 수\t|"+mvo.getSoldrooms1()+"\t|"+mvo.getSoldrooms2()+"\t|"+mvo.getSoldrooms3()); 
         System.out.println("객실 수익\t\t|"+mvo.getRevenue1()+"\t|"+mvo.getRevenue2()+"\t|"+mvo.getRevenue3()); 
         System.out.println("환불 객실 수\t|"+mvo.getRefundrooms1()+"\t|"+mvo.getRefundrooms2()+"\t|"+mvo.getRefundrooms3());
         System.out.println("위약금\t\t|"+mvo.getRefund1()+"\t|"+mvo.getRefund2()+"\t|"+mvo.getRefund3());  
         System.out.println();
         System.out.println("========================================");
         System.out.println("* 전체 판매 객실 수:"+mvo.getSoldrooms());
         System.out.println("* 총 수익 :"+mvo.getRevenue()); 
         System.out.println();
	}
	
	public void customerInfo() {
		System.out.println("\n[고객정보 조회]");

		client.customerlist();
		
		System.out.println();
	}
	

	public void sortFloorAsc() {  
		List<RoomVO> list = room.listRoom();
		
		Comparator<RoomVO> comp = new Comparator<RoomVO>() {
			@Override
			public int compare(RoomVO o1, RoomVO o2) {
			    return (o1.getFloor()-o2.getFloor());
			}
		};	
		
		Collections.sort(list,comp);
	}
	
}
