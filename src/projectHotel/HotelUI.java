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
		System.out.println("\n[���Ǹ��]");
		System.out.println();
		System.out.println("ȣ��\t����   ���Ǳݾ�\t���ǵ�� �⺻�����ο� �ִ������ο�");
		System.out.println("---------------------------------------------------");
		sortFloorAsc();
		
		for(RoomVO vo : room.listRoom()) {
			System.out.println(vo);
		}
		System.out.println();
	}
	
	public void updateRoom() {
		System.out.println("\n[���� ����]");
		int number;
		
		try {
			System.out.print("������ ���� ��ȣ ? ");
			number = Integer.parseInt(br.readLine());
			RoomVO vo=room.readRoom(number);
			if(vo==null) {
				System.out.println("��ϵ� ������ �ƴմϴ�...\n");
				return;
			}
			int price, peoplenum, maxnum;
			System.out.print("���� ? ");
			price=Integer.parseInt(br.readLine());
			System.out.print("�⺻ ���� �ο� ? ");
			peoplenum=Integer.parseInt(br.readLine());
			System.out.print("�ִ� ���� �ο� ? ");
			maxnum=Integer.parseInt(br.readLine());
			
			vo.setPrice(price);
			vo.setPeoplenum(peoplenum);
			vo.setMaxnum(maxnum);
			
			System.out.println("���� �Ϸᡦ\n");
			
		} catch (NumberFormatException e) {
			System.out.println("�������� ���ڸ� �Է� �����մϴ١�\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void checkRoomlist() {
		System.out.println("\n[���ں� ���� ��ȸ]");
		System.out.println("��ȸ�ϰ��� �ϴ� ���ڸ� �Է��Ͻʽÿ�.");
		try {
			System.out.println("��[MM]");
			String mm=br.readLine();
			System.out.println("��[dd]");
			String dd=br.readLine();

			reserve.showRoomlist(mm,dd);
		} catch (Exception e) {	
			
		}
	}
	  public void ReservationList() {
          System.out.println("\n[��ü ���� ��ȸ]");
          System.out.println(reserve.showList());

       }
	
	public void revenueStatus() {
		System.out.println("\n[������Ȳ ��ȸ]");
	
		 MoneyVO mvo = money.getVO();
         String one=room.getGrade(0).getGrade();
         String two=room.getGrade(1).getGrade();
         String three=room.getGrade(2).getGrade();
         System.out.println("\t\t[������Ȳ]\t\t");
         System.out.println();
         System.out.println("========================================");
         System.out.println("\t\t|"+one+"\t|"+two+"\t|"+three);
         System.out.println("�Ǹ� ���� ��\t|"+mvo.getSoldrooms1()+"\t|"+mvo.getSoldrooms2()+"\t|"+mvo.getSoldrooms3()); 
         System.out.println("���� ����\t\t|"+mvo.getRevenue1()+"\t|"+mvo.getRevenue2()+"\t|"+mvo.getRevenue3()); 
         System.out.println("ȯ�� ���� ��\t|"+mvo.getRefundrooms1()+"\t|"+mvo.getRefundrooms2()+"\t|"+mvo.getRefundrooms3());
         System.out.println("�����\t\t|"+mvo.getRefund1()+"\t|"+mvo.getRefund2()+"\t|"+mvo.getRefund3());  
         System.out.println();
         System.out.println("========================================");
         System.out.println("* ��ü �Ǹ� ���� ��:"+mvo.getSoldrooms());
         System.out.println("* �� ���� :"+mvo.getRevenue()); 
         System.out.println();
	}
	
	public void customerInfo() {
		System.out.println("\n[������ ��ȸ]");

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
