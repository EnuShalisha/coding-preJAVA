package projectHotel1;

public class Reservation {

	public void verifyClientnum(int clientnum) throws Exception {
		if(clientnum>6) {
			throw new ExceedClientException("저희 호텔은 최대 6명까지 수용할 수 있습니다.\n 예약을 여러번 진행해 주십시오.");
		}
		if(clientnum<0) {
			throw new UnderZeroException("0명 이하로 입력할 수 없습니다.");
		}
		
		String s;
		switch(clientnum) {
		case 6: s="스위트"; break;
		case 5: s="스위트, 그랜드"; break;
		default: s="스위트, 그랜드, 디럭스"; break;
		}
		System.out.println("고객님께서 이용 가능하신 방은"+s+" 입니다.");
	}
	
	public void 
}
