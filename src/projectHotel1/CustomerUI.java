package projectHotel1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class CustomerUI {
	private BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
	private Client client = new Client();
	private RoomImpl room = new RoomImpl();
	//private Money money = new Money();
	private Reservation reservation = new Reservation();
	
	public void menu() {
		int ch;
		
		while(true) {
			try {
				
				
				do {
					System.out.println("1.객실예약 2.예약수정 3.예약취소 4.예약정보확인 5. 예약정보인쇄 6.나가기");
					ch=Integer.parseInt(br.readLine());
				}while(ch<1||ch>6);
				
				
				
				if(ch==6) {
					return;
				}
				switch(ch) {
				case 1: Reserve(); break;
				case 2: modifyReserve(); break;
				case 3: removeReserve(); break;
				case 4: resevationCheck(); break;
				case 5: reservationPrint(); break;
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void Reserve() {
	System.out.println("객실 예약을 시작합니다.");
	System.out.println("고객님의 정보를 받고 있습니다.");
	
	try {
		System.out.println("고객번호가 있으면 입력, 없으면 0을 입력하십시오.");
		int clientno = Integer.parseInt(br.readLine());
		ClientVO vo=client.checkClient(clientno); // 고객번호 존재 확인 메소드 - 존재하면 vo로 리턴
		if(vo==null) { // 존재하면 else로, 없으면 고객 생성
			vo=new ClientVO();
			System.out.println("이름?");
			vo.setName(br.readLine());
			System.out.println("지역?");
			vo.setRegion(br.readLine());
			System.out.println("성별?(M/F)");
			vo.setGender(client.verifyGender(br.readLine()));
			System.out.println("나이?");
			vo.setAge(Integer.parseInt(br.readLine()));
			
			clientno=client.inputInfo(vo); // 고객 정보 저장 메소드
			System.out.println("고객님의 고객번호는 "+clientno+"입니다.");
		}
		else {
			System.out.println(vo.getName()+" 고객님 환영합니다.");	
		}
		
		System.out.println("투숙하시는 인원은 몇명입니까?");
		int clientnum=Integer.parseInt(br.readLine());
		room.verifyClientnum(clientnum); // 투숙인원이 음수, 또는 최대 인원 초과인지 확인
		
		String grade=null;
		int chooseroom=0;
		room.chooseRoom(clientnum); // 방 리스트(인원수에 따라 리스트가 다름) 보여줌 
		while(true) { 
		try {
			System.out.print("선택: ");
			chooseroom=Integer.parseInt(br.readLine());
			if(chooseroom==1) return; //1번은 예약취소이므로 리턴,
			grade=room.verifychooseRoom(clientnum, chooseroom-2); // 방을 잘못 선택하진 않았는지 다시한번 확인
			break; // 방 제대로 고르기 전까지 계속 방 선택
		} catch (Exception e) {
			System.out.println(e.getMessage());
			}
		}
		
		int price=room.setRoomprice(clientnum, chooseroom-2); // 객실 요금 산정 메소드
		System.out.println("객실 요금은"+price+"원입니다.");
		
		Date start=null;
		Date end=null;
		while(true) {
		try {
			System.out.println("투숙하시는 날짜를 선택하십시오.");
			System.out.println("체크인 날짜: ");
			System.out.print("월: ");
			String st_mm=br.readLine();
			System.out.print("일: ");
			String st_dd=br.readLine();
			String st="2021-"+st_mm+"-"+st_dd;
			start = reservation.verifyDate(st); // 날짜가 제대로 리턴되는지 확인 - 근데 월일 엄청 크게적어도 다 넘겨주니까(ex. 13월 -> +1년 1월) 수정 필요할듯
			
			System.out.println();
			System.out.println("체크아웃 날짜: ");
			System.out.print("월: ");
			String ed_mm=br.readLine();
			System.out.print("일: ");
			String ed_dd=br.readLine();
			String ed="2021-"+ed_mm+"-"+ed_dd;
			end = reservation.verifyDate(ed); // 위와 동일
			
			reservation.verifyBetweenDate(start, end); // 날짜가 똑같으면 대실 안됨으로 반환, 시작날짜보다 끝날짜 늦으면 예외발생
			break;
		} catch (Exception e) {
			System.out.println(e.getMessage()); // 예외 뜨면 예약 종료할건지 여기서 물어봄
			System.out.println("예약을 종료하시겠습니까?[Y/N]");
			String s= br.readLine();
			if(s.equals("Y")||s.equals("y"))
				return;
		}
		}
		
		//new ReservationVO 넣는거 디따 중요함 특히 예약 수정 구현하는사람
		//예약 리스트가 이미 만들어진 뒤에 예약 수정하면 하나 할때마다 vo에 즉시 반영돼
		//rvotemp같은걸 new로 하나 만들고 마지막에 vo=rvotemp로 vo에 대입해줘
		ReservationVO rvotemp = new ReservationVO(clientno, 0, clientnum, start, end, vo.getName(), price, grade); 
		reservation.checkAvaliable(rvotemp); // 객실 확인 메소드
		
		System.out.println("다음의 정보로 예약하시겠습니까?[Y/N]");
		System.out.println("고객번호\t고객이름\t투숙인수\t체크인\t\t체크아웃");
		System.out.println("방번호\t등급\t가격");
		System.out.println("===========================================");
		reservation.showListfromVO(rvotemp);//위에 양식대로 정보 띄워주는거임
		String a=br.readLine(); // Y,y면 예약완료, 그 외엔 예약 취소
		if(a.equals("Y")||a.equals("y")) {
			int rsrvno=reservation.inputInfo(rvotemp);
			System.out.println("예약이 완료되었습니다.");
			System.out.println("고객님의 예약번호는 "+rsrvno+"번입니다.");
		}
		return;
	} catch (Exception e) {
		System.out.println(e.getMessage());
		System.out.println("초기 화면으로 돌아갑니다.");
	}
	
	
}
	
	private String readLine() {
		// TODO Auto-generated method stub
		return null;
	}

	public void modifyReserve() {
		String name;
		int peoplenum;
		int grade;
		int money=0;
		int refund=0;
		int ch;
		try {
			System.out.println("[예약수정]");

			System.out.println("성함을 입력하세요");
			name= br.readLine();
			//reservevo vo= readreservation(name) -> exception(등록되어있지 않은 고객)
			System.out.println("변경하고자 하시는 등급을 선택하세요.");
			grade= Integer.parseInt(br.readLine());
			//verifygrade(grade) -> exception(동일한 등급)
			System.out.println("투숙인원을 입력하세요.");
			peoplenum = Integer.parseInt(br.readLine());
			//vertifypeoplenum(grade, peoplenum) -> exception
			
			//reservation.modify.(name, grade, peoplenum) 성공할 경우 여기에 저장 완료
			
			System.out.println("결제할 금액은"+money+"원입니다.");
			//RoomVO room = reservation.priceinfo/ 에서 돈을 불러옵니다. money= grade+peoplenum
			
			System.out.println("환불된 금액은"+refund+"원입니다.");
			//RoomVO의 reservation에 저장되어있는 것을 불러온다. 
			//자동 환불 후 재 결제 되는 방식이다.
			
			
			System.out.println("결제하시겠습니까?");
			System.out.println("1.예 2.아니요");
			ch = Integer.parseInt(br.readLine());
			////RoomVO room = reservation.priceinfo/ 에서 돈을 계산해서 불러옵니다. 그리고 이걸로 정보를 변경합니다.
			
			System.out.println("결제가 완료됐습니다.");
		} catch (Exception e) {
			
		}
	}
	public void removeReserve() {
		String name;
		try {
			System.out.println("[예약 취소]");
			System.out.println("성함을 입력하세요");
			name=br.readLine();
			//reservevo vo= readreservation(name) -> exception(등록되어있지 않은 고객)
			
			/*
			if(client.cancleclient(name)) {
				System.out.println("예약이 정상적으로 취소되었습니다.");
			}else {
				System.out.println("예약목록에 존재하지 않습니다.");
			}
			*/

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void resevationCheck() {
		//예약정보확인 누르면
		try {
			System.out.println("예약 정보를 확인해드리겠습니다.");
			System.out.print("고객님의 성함을 입력해 주세요\n");
			String name = br.readLine(); // 예외 - 여긴 문자열이라 예외 적용 못해 ㅋㅋㅋ

			System.out.println("고객님의 예약번호를 입력해 주세요.\n");
			int reserveno = Integer.parseInt(br.readLine());//예외 - 여기는 정수라 InputMismatchException 들어갈거고
			
			
			System.out.println();
			System.out.println("(cname + ) 고객님의 정보를 받고 있습니다.\n");
			System.out.println("(cname + ) 고객님이 예약하신 객실의 정보는");
			System.out.println("No.\"+객실번호+\"|\"+이용객실층+\"층 |\"+객실등급+\"|\"+객실가격+\"원|\"+이용인원+\"명|입니다.\n");
			//System.out.println("No."+객실번호+"|"+이용객실층+"층 |"+객실등급+"|"+객실가격+"원|"+이용인원+"명|");
			//("No."+객실번호+"|"+이용객실층+"층 |"+객실등급+"|"+객실가격+"원|"+이용인원+"명|");

			System.out.println("예약정보확인을 종료합니다.");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	
	public void reservationPrint() {
		System.out.println("[예약 정보 인쇄]");
		
		try {
			
			System.out.println("성함을 입력하세요.");
			String name= br.readLine();//예외
			
			System.out.println("고객님의 예약번호를 입력해 주세요.\n");
			String reserveNum = br.readLine();//예외
			
			System.out.println();
			
			//reservation.print(name,reserveNum);   
			
			
			System.out.println("인쇄가 완료됐습니다.");
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}