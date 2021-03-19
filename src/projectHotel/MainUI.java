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
		System.out.println("�������. 4�� ȣ���Դϴ�.");
		System.out.println("�̿��Ͻ� �޴��� ���� �� �ּ���.");
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
					System.out.println("1.���ǿ���|2.�������|3.�������|4.��������Ȯ��|5.���������μ�|6.�������|7.������");
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
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	public void HotelUIMenu() {
		int ch;
		try {
				do {
					System.out.println("-------------------------------------------------------------------------");
					System.out.println("1.���Ǹ��|2.������ȸ|3.��ü������ȸ|4.������Ȳ|5.���Ǽ���|6.������|7.�����ڸ��|8.������");
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
				System.out.println("���ڸ� �Է� �����մϴ�.");
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
