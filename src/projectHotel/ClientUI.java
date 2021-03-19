package projectHotel;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.InputMismatchException;

public class ClientUI {
	public ClientUI(MainUI mui){
		client = mui.getClient();
		room = mui.getRoom();
		money = mui.getMoney();
		reservation = mui.getReservation();
		login = mui.getLogin();
	}
	private BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
	private Client client;
	private RoomImpl room;
	private Money money;
	private Reservation reservation;
	private Login login;

	
	public void Reserve() {
	try {
		System.out.println("�ű� ������ ����[0]��,");
		System.out.println("����ȣ�� �����Ͻ� ������ [����ȣ]�� �Է��� �ּ���");
		int clientno = Integer.parseInt(br.readLine());
		ClientVO vo=client.checkClient(clientno);  
		if(vo==null) {  
			vo=new ClientVO();
			System.out.println("������ �Է����ֽʽÿ�.");
			vo.setName(br.readLine());
			System.out.println("�������� �Է����ֽʽÿ�.");
			vo.setRegion(br.readLine());
			System.out.println("������ �Է����ֽʽÿ�.[M/F]");
			vo.setGender(client.verifyGender(br.readLine()));
			System.out.println("���̸� �Է����ֽʽÿ�.");
			vo.setAge(Integer.parseInt(br.readLine()));
			
			clientno=client.inputInfo(vo); 
			
			System.out.println("������ ����ȣ�� "+clientno+"�Դϴ�.");
		}
		else {
			System.out.println(vo.getName()+" ���� ȯ���մϴ�.");	
			System.out.println("���� ȣ���� �ٽ� ã���ּż� �����մϴ�.");
		}
		
		System.out.println("�����Ͻô� �ο� ���� �������ֽʽÿ�.");
		int clientnum=Integer.parseInt(br.readLine());
		room.verifyClientnum(clientnum); 
		
		
		String grade=null;
		int chooseroom=0;
		room.chooseRoom(clientnum);  
		
		while(true) {
		try {
			System.out.print("����: ");
			chooseroom=Integer.parseInt(br.readLine());
			if(chooseroom==1) return; 
			grade=room.verifychooseRoom(clientnum, chooseroom-2); 
			 
			break;  
		}catch (Exception e) {
			System.out.println(e.getMessage());
			}
		}
		
		int price=room.setRoomprice(clientnum, chooseroom-2); 
		
		System.out.println("���� ����� �Ϸ�� "+price+"�޷��Դϴ�.");
		
		Date start=null;
		Date end=null;
		while(true) {
		try {
			System.out.println("�����Ͻô� ��¥�� �Է��Ͻʽÿ�.");
			System.out.println();
			System.out.println("<üũ�� ��¥> ");
			System.out.print("��: ");
			String st_mm = br.readLine();
			System.out.print("��: ");
			String st_dd = br.readLine();
			start = reservation.verifyDate(st_mm, st_dd);
			
			System.out.println();
			System.out.println("<üũ�ƿ� ��¥> ");
			System.out.print("��: ");
			String ed_mm=br.readLine();
			System.out.print("��: ");
			String ed_dd=br.readLine();
			end = reservation.verifyDate(ed_mm, ed_dd); 
			
			reservation.verifyBetweenDate(start, end); 
			price=reservation.calculateRevenue(start, end, price);
			break;
		} catch (Exception e) {
			System.out.println(e.getMessage());  
			System.out.println("������ �����Ͻðڽ��ϱ�?[Y/N]");
			String s= br.readLine();
			if(s.equals("Y")||s.equals("y"))
				return;
		}
	}
		
		
		ReservationVO rvotemp = new ReservationVO(clientno, 0, clientnum, start, end, 
				vo.getName(), price, grade); 
		reservation.checkAvaliable(rvotemp);  
		
		System.out.println("������ ������ �����Ͻðڽ��ϱ�?[Y/N]");
		System.out.println("����ȣ\t���̸�\t�����μ�\tüũ��\t\tüũ�ƿ�");
		System.out.println("���ȣ\t���\t����");
		System.out.println("===========================================");
		System.out.print(clientno+"\t");
		reservation.showListfromVO(rvotemp);
		String a=br.readLine();  
		if(a.equals("Y")||a.equals("y")) {
			switch(chooseroom-1) {
			case 1: money.setRevenue1(rvotemp.getRoom_price()); money.setSoldrooms1(1); break;
			case 2: money.setRevenue2(rvotemp.getRoom_price()); money.setSoldrooms2(1); break;
			case 3: money.setRevenue3(rvotemp.getRoom_price()); money.setSoldrooms3(1); break;
			}
			int rsrvno=reservation.inputInfo(rvotemp);
			System.out.println("������ �Ϸ�Ǿ����ϴ�.");
			System.out.println("������ �����ȣ�� "+rsrvno+"���Դϴ�.");
		}
		return;
	}catch (ExceedClientException e) {
		System.out.println(e.getMessage());
	}catch (UnderZeroException e) {
		System.out.println(e.getMessage());
	}catch (Exception e) {
		System.out.println(e.getMessage());
		System.out.println("�ʱ� ȭ������ ���ư��ϴ�.");
	}
	
}

	public void modifyReserve() {
	
		String grade;
		int price;
		int clientnum;
		int chooseroom;
		System.out.println("[�������]�Դϴ�.");
		try {
			System.out.println("�����ȣ�� �Է��� �ּ���");
			int reserveno=Integer.parseInt(br.readLine());
			ReservationVO vo = reservation.checkReserve(reserveno);
			if(vo==null) {
				System.out.println("�ùٸ��� ���� ��ȣ�Դϴ�.");
				return;
			}
			System.out.println("�����Ͻô� �ο��� ����Դϱ�?");
			clientnum = Integer.parseInt(br.readLine());
			room.verifyClientnum(clientnum); 
			
			grade=null;
			chooseroom=0;
			room.chooseRoom(clientnum);
			
			while(true) {
				try {
					System.out.print("����: ");
					chooseroom=Integer.parseInt(br.readLine());
					if(chooseroom==1) return; 
					grade=room.verifychooseRoom(clientnum, chooseroom-2); 
					break; 
				}catch (Exception e) {
					System.out.println(e.getMessage());
					}
				}
			price=room.setRoomprice(clientnum, chooseroom-2); 
			System.out.println("���� ���� �ݾ� "+vo.getRoom_price()+"�޷��� ȯ�ҵ˴ϴ�.");
			System.out.println("�� ������ ���� �ݾ��� �Ϸ�� "+price+"�޷��Դϴ�.");
		
			
			reservation.deleteReserve(reserveno);
			
			Date start=null;
			Date end=null;
			while(true) {
			try {
				System.out.println("�����Ͻô� ��¥�� �Է��Ͻʽÿ�.");
				System.out.println();
				System.out.println("<üũ�� ��¥> ");
				System.out.print("��: ");
				String st_mm = br.readLine();
				System.out.print("��: ");
				String st_dd = br.readLine();
				start = reservation.verifyDate(st_mm, st_dd);
				
				System.out.println();
				System.out.println("<üũ�ƿ� ��¥> ");
				System.out.print("��: ");
				String ed_mm=br.readLine();
				System.out.print("��: ");
				String ed_dd=br.readLine();
				end = reservation.verifyDate(ed_mm, ed_dd); 
				
				reservation.verifyBetweenDate(start, end);  
				price=reservation.calculateRevenue(start, end, price);
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage()); 
				System.out.println("���� ������ �����Ͻðڽ��ϱ�?[Y/N]");
				String s= br.readLine();
				if(s.equals("Y")||s.equals("y"))
					return;
			}
		}
			ReservationVO rvotemp = new ReservationVO(vo.getClientno(), 0, clientnum, start, end, 
					vo.getClient_name(), price, grade); 
			reservation.checkAvaliable(rvotemp);  
			
			System.out.println("������ ������ �����Ͻðڽ��ϱ�?[Y/N]");
			System.out.println("����ȣ\t���̸�\t�����μ�\tüũ��\t\tüũ�ƿ�");
			System.out.println("���ȣ\t���\t����");
			System.out.println("===========================================");
			System.out.print(vo.getClientno()+"\t");
			reservation.showListfromVO(rvotemp);
			String a=br.readLine(); 
			if(a.equals("Y")||a.equals("y")) {
				RoomVO rvo = room.getGrade(vo.getRoom_grade());
				switch(rvo.getFloor()) {
				case 4: money.setRevenue1(-vo.getRoom_price()); money.setSoldrooms1(-1); break;
				case 3: money.setRevenue2(-vo.getRoom_price()); money.setSoldrooms2(-1); break;
				case 2: money.setRevenue3(-vo.getRoom_price()); money.setSoldrooms3(-1); break;
				}
				reservation.modifyInfo(reserveno, rvotemp);
				switch(chooseroom-1) {
				case 1: money.setRevenue1(rvotemp.getRoom_price()); money.setSoldrooms1(1); break;
				case 2: money.setRevenue2(rvotemp.getRoom_price()); money.setSoldrooms2(1); break;
				case 3: money.setRevenue3(rvotemp.getRoom_price()); money.setSoldrooms3(1); break;
				}
				System.out.println("���� ������ �Ϸ�Ǿ����ϴ�.");
				return;
			}
			reservation.modifyInfo(reserveno, vo);
			System.out.println("���� ������ ��ҵǾ����ϴ�.");
			return;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("�ʱ� ȭ������ ���ư��ϴ�.");
		}
	}

	public void removeReserve() {
	      int reserveno;
	      String s;
	      System.out.println("[���� ���]");
	      try {
	         System.out.println("�����ȣ�� �Է��� �ּ���");
	         reserveno=Integer.parseInt(br.readLine());
	         ReservationVO vo=reservation.checkReserve(reserveno);
	         reservation.showListfromVO(vo);
	         System.out.println("���� ��� ����� 20%�� ������� �߻��մϴ�.");
	         System.out.println("������ ����Ͻðڽ��ϱ�?[Y/N]");
	         s= br.readLine();
	         if(!s.equals("Y")&&!s.equals("y"))
	            return;
	         int refund=(int)(vo.getRoom_price()*0.2);
	         RoomVO rvo = room.getGrade(vo.getRoom_grade());
	         switch(rvo.getFloor()) {
	         case 4: money.setRevenue1(-vo.getRoom_price()); money.setSoldrooms1(-1);
	         money.setRefund1(refund); money.setRefundrooms1(1); break;
	         case 3: money.setRevenue2(-vo.getRoom_price()); money.setSoldrooms2(-1);
	         money.setRefund2(refund); money.setRefundrooms2(1); break;
	         case 2: money.setRevenue3(-vo.getRoom_price()); money.setSoldrooms3(-1);
	         money.setRefund3(refund); money.setRefundrooms3(1); break;
	         }
	         if(reservation.deleteReserve(reserveno)) {
	            System.out.println("������ ���������� ��ҵǾ����ϴ�.\n");
	            
	         }else {
	            System.out.println("���������� �������� �ʽ��ϴ�.\n");
	         }

	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }

	public void reservationCheck() {
        int reserveno;
        System.out.println("[���� ����Ȯ��]");
        try {
           System.out.println("������ �����ȣ�� �Է��� �ּ���.\n");
           reserveno = Integer.parseInt(br.readLine());
          
           ReservationVO vo=reservation.checkReserve(reserveno);
           System.out.println("�����ȣ\t���̸�\t�����μ�\tüũ��\t\tüũ�ƿ�");
           System.out.println("���ȣ\t���\t����");
           System.out.println("==================================================");
           System.out.print(reserveno+"\t");
           reservation.showListfromVO(vo);

           System.out.println();
           
        }catch (InputMismatchException e) {
           System.out.println("���ڸ� �Է��� �ּ���.");
        }catch (Exception e) {
           e.printStackTrace();
        }
     }

	public void reservationPrint() {
        System.out.println("[���� ���� �μ�]");
        
       
        String dest=null;
        ReservationVO vo=null;
        int reserveno=0;
        try {
        	System.out.println("������ �����ȣ�� �Է��� �ּ���.\n");
            reserveno = Integer.parseInt(br.readLine());
             vo=reservation.checkReserve(reserveno);
             dest="reservationInform"+reserveno+".txt";
		} catch (Exception e) {
			// TODO: handle exception
		}
        File f=new File(dest);  
            try(ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream(f))) {
            String a="�����ȣ\t���̸�\t�����μ�\tüũ��\t\tüũ�ƿ�\n";
              String b="���ȣ\t���\t����\n"; 
             
                System.out.print(a+b);
                System.out.println("===================================================");
                System.out.print(reserveno+"\t");
                String s=reserveno+"\t"+reservation.showListfromVO(vo);
                ois.writeObject(a);
                ois.writeObject(b);
                ois.writeObject(s);
                System.out.println();
                 System.out.println(dest+"�� �μⰡ �Ϸ�Ǿ����ϴ�.");
                 System.out.println();
           
        }catch (EOFException e) {
        }catch (Exception e) {
        	e.printStackTrace();
        }

     }
		public void changeMode() {
			try {
				System.out.println("������ ��й�ȣ�� �Է��ϼ���.[****]");
				int get=Integer.parseInt(br.readLine());
				login.setGet(get);
			} catch (Exception e) {}
			
		}
}