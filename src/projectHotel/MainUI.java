package projectHotel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

public class MainUI {
	
	private ClientUI customerui=null;
	private HotelUI hotelui=null;
	
	private BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
	private Client client = new ClientImpl();
	private RoomImpl room = new RoomImpl();
	private Money money = new MoneyImpl();
	private Reservation reservation = new ReservationImpl();
	private Login login = new Login();
	
	public MainUI() {
		customerui = new ClientUI(this);
		hotelui = new HotelUI(this);
	}
	
	public void menu() throws IOException{
		System.out.println("어서오세요. 4조 호텔입니다.");
		System.out.println("이용하실 메뉴를 선택 해 주세요.");
		while(true) {
			if(login.mode())
				HotelUIMenu();
			else
				CustomerUIMenu();
		}
	}
	
	public void CustomerUIMenu() {
		int ch;
		
		try {
				do {
					System.out.println("-----------------------------------------------------------------");
					System.out.println("1.객실예약|2.예약수정|3.예약취소|4.예약정보확인|5.예약정보인쇄|6.관리모드|7.나가기");
					System.out.println("-----------------------------------------------------------------");
					ch=Integer.parseInt(br.readLine());
				}while(ch<1||ch>7);
				
				if(ch==7) {
					System.exit(0);
				}
				switch(ch) {
				case 1: customerui.Reserve(); break;
				case 2: customerui.modifyReserve(); break;
				case 3: customerui.removeReserve(); break;
				case 4: customerui.reservationCheck(); break;
				case 5: customerui.reservationPrint(); break;
				case 6: customerui.changeMode(); break;
				}

			} catch (InputMismatchException e) {
			System.out.println("잘못 입력하셨습니다.");
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	public void HotelUIMenu() {
		int ch;
		try {
				do {
					System.out.println("-------------------------------------------------------------------------");
					System.out.println("1.객실목록|2.객실조회|3.전체예약조회|4.매출현황|5.객실수정|6.고객정보|7.예약자모드|8.나가기");
					System.out.println("-------------------------------------------------------------------------");
					ch=Integer.parseInt(br.readLine());
				} while(ch<1||ch>8);
				
				if(ch==8) {
					System.exit(0);
				}
				switch(ch) {
				case 1:hotelui.listRoom(); break;
				case 2:hotelui.checkRoomlist(); break;
				case 3:hotelui.ReservationList(); break;
				case 4:hotelui.revenueStatus(); break;
				case 5:hotelui.updateRoom(); break;
				case 6:hotelui.customerInfo(); break;
				case 7:hotelui.sortFloorAsc(); room.saveFile(); login.setGet(0); break;
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력 가능합니다.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	
	public Client getClient() {
		return client;
	}

	public RoomImpl getRoom() {
		return room;
	}

	public Money getMoney() {
		return money;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public Login getLogin() {
		return login;
	}
}
