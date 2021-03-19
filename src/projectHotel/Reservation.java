package projectHotel;

import java.util.Date;
import java.util.Map;

public interface Reservation {

	void initialize();

	Date verifyDate(String mm, String dd) throws Exception;

	void verifyBetweenDate(Date date1, Date date2) throws Exception;

	int calculateRevenue(Date start, Date end, int price);

	void checkAvaliable(ReservationVO my_vo) throws Exception;

	String verifychooseRoom(int clientnum, int chooseroom) throws Exception;

	void showRoomlist(String mm, String dd) throws Exception;

	String showListfromVO(ReservationVO vo);

	String showList();

	ReservationVO checkReserve(int reserveno) throws Exception;

	int inputInfo(ReservationVO vo);

	void modifyInfo(int reserveno, ReservationVO vo);

	boolean deleteReserve(int reserveno);

	Map<Integer, ReservationVO> listReservation();

}