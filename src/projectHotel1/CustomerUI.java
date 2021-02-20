package projectHotel1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CustomerUI {
	private BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
	private Client client = new Client();
	private RoomImpl room = new RoomImpl();
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
		ClientVO vo=client.checkClient(Integer.parseInt(readLine()));
		if(vo==null) {
			
			System.out.println("이름?");
			vo.setName(br.readLine());
			
			System.out.println("지역?");
			vo.setRegion(br.readLine());
			
			System.out.println("성별?(M/F)");
			vo.setGender(client.verifyGender(br.readLine()));
			
			System.out.println("나이?");
			vo.setAge(Integer.parseInt(br.readLine()));
			
			
			int clientNo=client.inputInfo(vo); // 고객 정보 저장 메소드
			
			System.out.println("고객님의 고객번호는"+clientNo+"입니다.");
		}
		else {
			System.out.println(vo.getName()+"고객님 환영합니다.");	
		}

		System.out.println("투숙하시는 인원은 몇명입니까?");
		int clientnum=Integer.parseInt(br.readLine());
		reservation.verifyClientnum(clientnum);
		
		System.out.println("방은 다음과 같이 준비돼있습니다.");
		System.out.println("스위트: 기본 투숙인원 4명, 최대 투숙인원 6명");
		System.out.println("그랜드: 기본 투숙인원 3명, 최대 투숙인원 5명");
		System.out.println("디럭스: 기본 투숙인원 2명, 최대 투숙인원 4명");
		
		//위 메소드에서는 다음의 경우들에 대해 sysout을 한다.
		//1. 모든 방의 최대 투숙객보다 많은 경우 "저희 호텔에는 x명을 수용할 수 없습니다. 인원을 나누어 예약을 진행해주십시오."
		//2. 6명인 경우 "고객님께서 이용 가능하신 방은 스위트입니다."
		//3. 5명인 경우 "디럭스, 스위트"
		//4. 등등등) 
		
		System.out.println("어떤 방을 선택하시겠습니까?");
		System.out.println("1. 스위트 2. 디럭스 3. 스탠다드");
		int grade=Integer.parseInt(br.readLine());
	//	RoomVO room=reservation.priceinfo(grade, clientnum);
		//위 메소드에서는 방 등급과 투숙객을 파라미터로 받아서 다음을 sout한다.
		//1. 잘못 입력했을 경우 "잘못 선택하셨습니다."
		//2. 입력이 맞을 경우 "귀하의 객실 등급은 room.getgrade(), 추가 투숙인원 room.getaddnum()명으로 총 가격은 room.revenue()입니다.
		System.out.println("입력한 정보가 맞습니까?[Y/N]");
		/*
		if(br.readLine()n||N) {
			System.out.println("예약이 취소되었습니다.");
			System.out.println("초기화면으로 돌아갑니다.");
		}
		System.out.println("예약정보는 다음과 같습니다.");
		reservation.find(room); //손님-4 예약정보 확인 메소드 그대로 키기
		System.out.println("예약하시겠습니까?[Y/N]");
		if(br.readLine()n||N) {
			System.out.println("에약이 취소되었습니다.");
			System.out.println("초기화면으로 돌아갑니다.");
		}
		*/
		System.out.println("예약이 완료되었습니다.");
	} catch (Exception e) {
		// TODO: handle exception
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