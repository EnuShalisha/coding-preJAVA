package projectHotel1;

import java.text.SimpleDateFormat;

public class Labatory {

	public static void main(String[] args) throws Exception {
		RoomImpl room=new RoomImpl();
		Reservation rsrv = new Reservation();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String st="2021-"+"09"+"-"+"10";
		String ed="2021-09-20";
		ReservationVO vo= new ReservationVO(5, 0, sdf.parse(st), sdf.parse(ed), "김가나", 50000, "디럭스");
		try {
			rsrv.inputInfo(vo);
			rsrv.checkAvaliable(vo);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		rsrv.showRoomlist("2021-09-12");
		
		

	}

}
