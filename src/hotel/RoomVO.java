package hotel;

public class RoomVO {
	private String number;
	private int floor;
	private int price;
	private int grade;
	private int peoplenum;
	private boolean stay;
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getPeoplenum() {
		return peoplenum;
	}
	public void setPeoplenum(int peoplenum) {
		this.peoplenum = peoplenum;
	}
	public boolean isStay() {
		return stay;
	}
	public void setStay(boolean stay) {
		this.stay = stay;
	}
}
