package projectHotel1;

import java.util.Date;

public class ReservationVO {
	
	public ReservationVO() {}
	
	public ReservationVO(int clientnum, int roomnum, Date startdate, Date enddate, String client_name, int room_price,
			String room_grade) {
		this.clientnum = clientnum;
		this.roomnum = roomnum;
		this.startdate = startdate;
		this.enddate = enddate;
		this.client_name = client_name;
		this.room_price = room_price;
		this.room_grade = room_grade;
	}
	
	private int clientnum;
	private int roomnum;
	private Date startdate;
	private Date enddate;
	private String client_name;
	private int room_price;
	private String room_grade;
	
	public int getClientnum() {
		return clientnum;
	}
	public void setClientnum(int clientnum) {
		this.clientnum = clientnum;
	}
	public int getRoomnum() {
		return roomnum;
	}
	public void setRoomnum(int roomnum) {
		this.roomnum = roomnum;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	public int getRoom_price() {
		return room_price;
	}
	public void setRoom_price(int room_price) {
		this.room_price = room_price;
	}
	public String getRoom_grade() {
		return room_grade;
	}
	public void setRoom_grade(String room_grade) {
		this.room_grade = room_grade;
	}
	
	
}
