package hotel;

public class Reservation {
	
	Room room = new Room(); // 방은 reservation의 예약 정보에 의존한다
	Client client = new Client(); // 고객은 reservation의 예약 정보에 의존한다
}
