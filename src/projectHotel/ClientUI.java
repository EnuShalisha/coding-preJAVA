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
		System.out.println("신규 고객님은 숫자[0]을,");
		System.out.println("고객번호를 소지하신 고객님은 [고객번호]를 입력해 주세요");
		int clientno = Integer.parseInt(br.readLine());
		ClientVO vo=client.checkClient(clientno);  
		if(vo==null) {  
			vo=new ClientVO();
			System.out.println("성함을 입력해주십시오.");
			vo.setName(br.readLine());
			System.out.println("거주지를 입력해주십시오.");
			vo.setRegion(br.readLine());
			System.out.println("성별을 입력해주십시오.[M/F]");
			vo.setGender(client.verifyGender(br.readLine()));
			System.out.println("나이를 입력해주십시오.");
			vo.setAge(Integer.parseInt(br.readLine()));
			
			clientno=client.inputInfo(vo); 
			
			System.out.println("고객님의 고객번호는 "+clientno+"입니다.");
		}
		else {
			System.out.println(vo.getName()+" 고객님 환영합니다.");	
			System.out.println("저희 호텔을 다시 찾아주셔서 감사합니다.");
		}
		
		System.out.println("투숙하시는 인원 수를 기입해주십시오.");
		int clientnum=Integer.parseInt(br.readLine());
		room.verifyClientnum(clientnum); 
		
		
		String grade=null;
		int chooseroom=0;
		room.chooseRoom(clientnum);  
		
		while(true) {
		try {
			System.out.print("선택: ");
			chooseroom=Integer.parseInt(br.readLine());
			if(chooseroom==1) return; 
			grade=room.verifychooseRoom(clientnum, chooseroom-2); 
			 
			break;  
		}catch (Exception e) {
			System.out.println(e.getMessage());
			}
		}
		
		int price=room.setRoomprice(clientnum, chooseroom-2); 
		
		System.out.println("객실 요금은 하루당 "+price+"달러입니다.");
		
		Date start=null;
		Date end=null;
		while(true) {
		try {
			System.out.println("투숙하시는 날짜를 입력하십시오.");
			System.out.println();
			System.out.println("<체크인 날짜> ");
			System.out.print("월: ");
			String st_mm = br.readLine();
			System.out.print("일: ");
			String st_dd = br.readLine();
			start = reservation.verifyDate(st_mm, st_dd);
			
			System.out.println();
			System.out.println("<체크아웃 날짜> ");
			System.out.print("월: ");
			String ed_mm=br.readLine();
			System.out.print("일: ");
			String ed_dd=br.readLine();
			end = reservation.verifyDate(ed_mm, ed_dd); 
			
			reservation.verifyBetweenDate(start, end); 
			price=reservation.calculateRevenue(start, end, price);
			break;
		} catch (Exception e) {
			System.out.println(e.getMessage());  
			System.out.println("예약을 종료하시겠습니까?[Y/N]");
			String s= br.readLine();
			if(s.equals("Y")||s.equals("y"))
				return;
		}
	}
		
		
		ReservationVO rvotemp = new ReservationVO(clientno, 0, clientnum, start, end, 
				vo.getName(), price, grade); 
		reservation.checkAvaliable(rvotemp);  
		
		System.out.println("다음의 정보로 예약하시겠습니까?[Y/N]");
		System.out.println("고객번호\t고객이름\t투숙인수\t체크인\t\t체크아웃");
		System.out.println("방번호\t등급\t가격");
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
			System.out.println("예약이 완료되었습니다.");
			System.out.println("고객님의 예약번호는 "+rsrvno+"번입니다.");
		}
		return;
	}catch (ExceedClientException e) {
		System.out.println(e.getMessage());
	}catch (UnderZeroException e) {
		System.out.println(e.getMessage());
	}catch (Exception e) {
		System.out.println(e.getMessage());
		System.out.println("초기 화면으로 돌아갑니다.");
	}
	
}

	public void modifyReserve() {
	
		String grade;
		int price;
		int clientnum;
		int chooseroom;
		System.out.println("[예약수정]입니다.");
		try {
			System.out.println("예약번호를 입력해 주세요");
			int reserveno=Integer.parseInt(br.readLine());
			ReservationVO vo = reservation.checkReserve(reserveno);
			if(vo==null) {
				System.out.println("올바르지 않은 번호입니다.");
				return;
			}
			System.out.println("투숙하시는 인원은 몇명입니까?");
			clientnum = Integer.parseInt(br.readLine());
			room.verifyClientnum(clientnum); 
			
			grade=null;
			chooseroom=0;
			room.chooseRoom(clientnum);
			
			while(true) {
				try {
					System.out.print("선택: ");
					chooseroom=Integer.parseInt(br.readLine());
					if(chooseroom==1) return; 
					grade=room.verifychooseRoom(clientnum, chooseroom-2); 
					break; 
				}catch (Exception e) {
					System.out.println(e.getMessage());
					}
				}
			price=room.setRoomprice(clientnum, chooseroom-2); 
			System.out.println("이전 결제 금액 "+vo.getRoom_price()+"달러가 환불됩니다.");
			System.out.println("당 예약의 결제 금액은 하루당 "+price+"달러입니다.");
		
			
			reservation.deleteReserve(reserveno);
			
			Date start=null;
			Date end=null;
			while(true) {
			try {
				System.out.println("투숙하시는 날짜를 입력하십시오.");
				System.out.println();
				System.out.println("<체크인 날짜> ");
				System.out.print("월: ");
				String st_mm = br.readLine();
				System.out.print("일: ");
				String st_dd = br.readLine();
				start = reservation.verifyDate(st_mm, st_dd);
				
				System.out.println();
				System.out.println("<체크아웃 날짜> ");
				System.out.print("월: ");
				String ed_mm=br.readLine();
				System.out.print("일: ");
				String ed_dd=br.readLine();
				end = reservation.verifyDate(ed_mm, ed_dd); 
				
				reservation.verifyBetweenDate(start, end);  
				price=reservation.calculateRevenue(start, end, price);
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage()); 
				System.out.println("예약 수정을 종료하시겠습니까?[Y/N]");
				String s= br.readLine();
				if(s.equals("Y")||s.equals("y"))
					return;
			}
		}
			ReservationVO rvotemp = new ReservationVO(vo.getClientno(), 0, clientnum, start, end, 
					vo.getClient_name(), price, grade); 
			reservation.checkAvaliable(rvotemp);  
			
			System.out.println("다음의 정보로 예약하시겠습니까?[Y/N]");
			System.out.println("고객번호\t고객이름\t투숙인수\t체크인\t\t체크아웃");
			System.out.println("방번호\t등급\t가격");
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
				System.out.println("예약 수정이 완료되었습니다.");
				return;
			}
			reservation.modifyInfo(reserveno, vo);
			System.out.println("예약 수정이 취소되었습니다.");
			return;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("초기 화면으로 돌아갑니다.");
		}
	}

	public void removeReserve() {
	      int reserveno;
	      String s;
	      System.out.println("[예약 취소]");
	      try {
	         System.out.println("예약번호를 입력해 주세요");
	         reserveno=Integer.parseInt(br.readLine());
	         ReservationVO vo=reservation.checkReserve(reserveno);
	         reservation.showListfromVO(vo);
	         System.out.println("예약 취소 요금의 20%의 위약금이 발생합니다.");
	         System.out.println("예약을 취소하시겠습니까?[Y/N]");
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
	            System.out.println("예약이 정상적으로 취소되었습니다.\n");
	            
	         }else {
	            System.out.println("예약정보가 존재하지 않습니다.\n");
	         }

	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }

	public void reservationCheck() {
        int reserveno;
        System.out.println("[예약 정보확인]");
        try {
           System.out.println("고객님의 예약번호를 입력해 주세요.\n");
           reserveno = Integer.parseInt(br.readLine());
          
           ReservationVO vo=reservation.checkReserve(reserveno);
           System.out.println("예약번호\t고객이름\t투숙인수\t체크인\t\t체크아웃");
           System.out.println("방번호\t등급\t가격");
           System.out.println("==================================================");
           System.out.print(reserveno+"\t");
           reservation.showListfromVO(vo);

           System.out.println();
           
        }catch (InputMismatchException e) {
           System.out.println("숫자만 입력해 주세요.");
        }catch (Exception e) {
           e.printStackTrace();
        }
     }

	public void reservationPrint() {
        System.out.println("[예약 정보 인쇄]");
        
       
        String dest=null;
        ReservationVO vo=null;
        int reserveno=0;
        try {
        	System.out.println("고객님의 예약번호를 입력해 주세요.\n");
            reserveno = Integer.parseInt(br.readLine());
             vo=reservation.checkReserve(reserveno);
             dest="reservationInform"+reserveno+".txt";
		} catch (Exception e) {
			// TODO: handle exception
		}
        File f=new File(dest);  
            try(ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream(f))) {
            String a="예약번호\t고객이름\t투숙인수\t체크인\t\t체크아웃\n";
              String b="방번호\t등급\t가격\n"; 
             
                System.out.print(a+b);
                System.out.println("===================================================");
                System.out.print(reserveno+"\t");
                String s=reserveno+"\t"+reservation.showListfromVO(vo);
                ois.writeObject(a);
                ois.writeObject(b);
                ois.writeObject(s);
                System.out.println();
                 System.out.println(dest+"에 인쇄가 완료되었습니다.");
                 System.out.println();
           
        }catch (EOFException e) {
        }catch (Exception e) {
        	e.printStackTrace();
        }

     }
		public void changeMode() {
			try {
				System.out.println("관리자 비밀번호를 입력하세요.[****]");
				int get=Integer.parseInt(br.readLine());
				login.setGet(get);
			} catch (Exception e) {}
			
		}
}