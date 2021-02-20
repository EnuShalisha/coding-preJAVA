package hotel;

public class CustomerUI {
	public void Reserve() {
		System.out.println("객실 예약을 시작합니다.");
		
		System.out.println("고객님의 정보를 받고 있습니다.");
		
		System.out.println("고객번호가 있으면 입력, 없으면 N을 입력하십시오.");
		if(!client.checkclient(br.readline()) {
			System.out.println("이름?");
			String name=br.readline();
			System.out.println("지역?");
			String region=br.readline();
			System.out.println("성별?(M/F)");
			char gender=client.verifygender(br.readline());
			System.out.println("나이?");
			int age=br.readline();
			
			int clientno=client.inputinfo; // 고객 정보 저장 메소드
			//메소드 리턴값을 고객번호로 하고 int로 받음
			System.out.println("고객님의 고유번호는"+clientno+"입니다.");
		}
		else {
			System.out.println(client.verifyno.getname()+"고객님 환영합니다.");
			//고객번호를 입력받고 vo를 리턴하는 메소드
			//getname에서 이름 받음
		}
		
		
		System.out.println("방은 다음과 같이 준비돼있습니다.");
		System.out.println("스위트: 기본 투숙인원 4명, 최대 투숙인원 6명");
		System.out.println("디럭스: 3/5");
		System.out.println("스탠다드: 2/4");
		System.out.println("투숙하시는 인원은 몇명입니까?");
		int clientnum=br.readline();
		reservation.verifyclientnumber(clientnum); // 투숙 인원 확인 메소드
		//위 메소드에서는 다음의 경우들에 대해 sysout을 한다.
		//1. 모든 방의 최대 투숙객보다 많은 경우 "저희 호텔에는 x명을 수용할 수 없습니다. 인원을 나누어 예약을 진행해주십시오."
		//2. 6명인 경우 "고객님께서 이용 가능하신 방은 스위트입니다."
		//3. 5명인 경우 "디럭스, 스위트"
		//4. 등등등) 
		System.out.println("어떤 방을 선택하시겠습니까?");
		System.out.println("1. 스위트 2. 디럭스 3. 스탠다드");
		int grade=br.readline();
		RoomVO room=reservation.priceinfo(grade, clientnum);
		//위 메소드에서는 방 등급과 투숙객을 파라미터로 받아서 다음을 sout한다.
		//1. 잘못 입력했을 경우 "잘못 선택하셨습니다."
		//2. 입력이 맞을 경우 "귀하의 객실 등급은 room.getgrade(), 추가 투숙인원 room.getaddnum()명으로 총 가격은 room.revenue()입니다.
		System.out.println("입력한 정보가 맞습니까?[Y/N]");
		if(br.readline()n||N) {
			System.out.println("에약이 취소되었습니다.");
			System.out.println("초기화면으로 돌아갑니다.");
		}
		System.out.println("예약정보는 다음과 같습니다.");
		reservation.find(room); //손님-4 예약정보 확인 메소드 그대로 키기
		System.out.println("예약하시겠습니까?[Y/N]");
		if(br.readline()n||N) {
			System.out.println("에약이 취소되었습니다.");
			System.out.println("초기화면으로 돌아갑니다.");
		}
		System.out.println("예약이 완료되었습니다.");
	}
	
	
	
	public void modifyReserve() {
		
	}
	public void removeReserve() {
		
	}
}
