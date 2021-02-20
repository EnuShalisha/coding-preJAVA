package projectHotel1;

public class RoomVO {

	private int number;
	private int floor;
	private int price;
	private String grade;
	private int peoplenum;
	private int maxnum;
	
	// private boolean stay;
	
	public RoomVO() {}
	
	public RoomVO(String grade, int price, int floor, int number, int peoplenum, int maxnum) {
		this.grade = grade;
		this.price = price;
		this.floor = floor;
		this.number = number;
		this.peoplenum = peoplenum;
		this.maxnum = maxnum;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
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
	

	public int getMaxnum() {
		return maxnum;
	}

	public void setMaxnum(int maxnum) {
		this.maxnum = maxnum;
	}

	@Override
	public String toString() {
		if(number==0)
			return null;
		
		String s=number+"\t"+floor+"\t"+price+"\t"+grade+"\t"+peoplenum;
		return s;
	}
	
	
}
