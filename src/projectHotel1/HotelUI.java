package projectHotel1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;

public class HotelUI {
	private BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public void hotelmanage() {
		int ch;
		
		while(true) {
			try {
				do {
					System.out.print("1.객실목록 2.객실관리 3.예약조회 4.매출현황(내림차순) 5.고객정보 6.종료 =>");
					ch=Integer.parseInt(br.readLine());
				} while(ch<1||ch>6);
				
				if(ch==6) {
					sortFloorAsc(); // 객실 등급 오름차순 정렬
					// 파일저장...
					return;
				}
				
				switch(ch) {
				case 1:listRoom(); break;
				case 2:updateRoom(); break;
				case 3:ReservationList(); break;
				case 4:revenueStatus(); break;
				case 5:customerInfo(); break;
				}
			} catch (NumberFormatException e) {
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void listRoom() {
		System.out.println("\n[객실목록]...");
		// 시배열 만들고 예약 가능여부까지 출력 
		
		sortFloorAsc();
		//for(RoomVO vo:)
		
	}
	
	public void updateRoom() {
		System.out.println("\n[객실 수정]");
		System.out.println("수정할 객실 번호 ? ");
		System.out.println("등급: ");
		System.out.println("가격: ");
		System.out.println("투숙인원: ");
		
	}
	
	public void ReservationList() {
		System.out.println("\n[예약 조회]");
		System.out.println("전체 리스트..");
		// 예약된 방을 층별로 출력
		// 예약된 방, 예약자, 예약자 정보(전화번호...)
		
	}
	
	public void revenueStatus() {
		System.out.println("\n[매출현황 조회]");
		// 등급별로 매출액 내림차순으로 정렬 
	}
	
	public void customerInfo() {
		System.out.println("\n[고객정보 조회]");
		// 전체 고객 리스트 
	}
	
	public void sortRevDesc() { // 매출현황 금액에 따라 내림차순 정렬 
		/*Comparator<MoneyVO> comp = new Comparator<MoneyVO>() 
		{
	         
	    @Override
	    public int compare(MoneyVO o1, MoneyVO o2) {
	       return -(o1.getRev()-o2.getRev());
	    	}
	    };
	    */		
	}
	
	public void sortFloorAsc() { // 객실목록 등급에 따라 오름차순 정렬 
		Comparator<RoomVO> comp = new Comparator<RoomVO>() {
	         
		@Override
		public int compare(RoomVO o1, RoomVO o2) {
		    return (o1.getFloor()-o2.getFloor());
		}
		};	
	}
	
	public static void main(String[] args) {
	
	}

}
