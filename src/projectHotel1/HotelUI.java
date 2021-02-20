package projectHotel1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;

public class HotelUI {
	private BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	private Reservation rsrv= new Reservation();
	
	public void hotelmanage() {
		int ch;
		
		while(true) {
			try {
				do {
					System.out.print("1.���Ǹ�� 2.���ǰ��� 3.������ȸ 4.������Ȳ(��������) 5.������ 6.���� =>");
					ch=Integer.parseInt(br.readLine());
				} while(ch<1||ch>6);
				
				if(ch==6) {
					sortFloorAsc(); // ���� ��� �������� ����
					// ��������...
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
		System.out.println("\n[���Ǹ��]...");
		// �ù迭 ����� ���� ���ɿ��α��� ��� 
		
		sortFloorAsc();
		//for(RoomVO vo:)
		
	}
	
	public void updateRoom() {
		System.out.println("\n[���� ����]");
		System.out.println("������ ���� ��ȣ ? ");
		System.out.println("���: ");
		System.out.println("����: ");
		System.out.println("�����ο�: ");
		
	}
	
	public void checkRoomlist() {
		System.out.println("\n[���ں� ���� ��ȸ]");
		System.out.println("��ȸ�ϰ��� �ϴ� ���ڸ� �Է��Ͻʽÿ�.");
		try {
			System.out.println("��[MM]");
			String mm=br.readLine();
			System.out.println("��[dd]");
			String dd=br.readLine();
			String day="2021-"+mm+"-"+dd;
			rsrv.showRoomlist(day);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void ReservationList() {
		System.out.println("\n[���� ��ȸ]");
		System.out.println("��ü ����Ʈ..");
		// ����� ���� ������ ���
		// ����� ��, ������, ������ ����(��ȭ��ȣ...)
		
	}
	
	public void revenueStatus() {
		System.out.println("\n[������Ȳ ��ȸ]");
		// ��޺��� ����� ������������ ���� 
	}
	
	public void customerInfo() {
		System.out.println("\n[������ ��ȸ]");
		// ��ü �� ����Ʈ 
	}
	
	public void sortRevDesc() { // ������Ȳ �ݾ׿� ���� �������� ���� 
		/*Comparator<MoneyVO> comp = new Comparator<MoneyVO>() 
		{
	         
	    @Override
	    public int compare(MoneyVO o1, MoneyVO o2) {
	       return -(o1.getRev()-o2.getRev());
	    	}
	    };
	    */		
	}
	
	public void sortFloorAsc() { // ���Ǹ�� ��޿� ���� �������� ���� 
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
