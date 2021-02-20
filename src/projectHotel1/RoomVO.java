package projectHotel1;

public class RoomVO {

	private String number;
	private int floor;
	private int price;
	private String grade;
	private int peoplenum;
	
	// private boolean stay;
	
	public RoomVO(String grade, int price, int floor, String number, int peoplenum) {
		this.grade = grade;
		this.price = price;
		this.floor = floor;
		this.number = number;
		this.peoplenum = peoplenum;
	}
	
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
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getPeoplenum() {
		return peoplenum;
	}
	public void setPeoplenum(int peoplenum) {
		this.peoplenum = peoplenum;
	}

	@Override
	public String toString() {
		if(number==null)
			return null;
		
		String s=number+"\t"+floor+"\t"+price+"\t"+grade+"\t"+peoplenum;
		return s;
	}
	
	
}
