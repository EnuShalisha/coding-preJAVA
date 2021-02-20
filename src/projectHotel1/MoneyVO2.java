package projectHotel1;

public class MoneyVO2 {	//매출현황??
	
	private int deluxerevenue;
	private int grandrevenue;
	private int sweetrevenue;
	
	//private int revenue; // price+방등급+인원수 // 총객실가격
		// 등급에 따라 가격을 해서 다 합쳐야 되나??
	
	private int deluxesoldrooms;
	private int grandsoldrooms;
	private int sweetsoldrooms;

	//private int soldrooms; //판매된객실수
	
	
	//private int refund; // 환불해 줄 금액 // 여기가 아니라 예약취소 있는 쪽인가??
	private int refundprofit;
		//refundprofit = (revenue*(20/100);
			//수수료가 20%일 때
	private int sales; //총 매출액
	
	//----------------------------------
	
	public MoneyVO2() {
	}

	//-----------------------------------
	
	public int getrevenue() {
		return deluxerevenue+grandrevenue+sweetrevenue;
	}
	public int getsoldrooms() {
		return deluxesoldrooms + grandsoldrooms + sweetsoldrooms;
	}
	
	//----------------------------------
	
	
	public int getDeluxerevenue() {
		return deluxerevenue;
	}
	

	public void setDeluxerevenue(int deluxerevenue) {
		this.deluxerevenue = deluxerevenue;
	}

	public int getGrandrevenue() {
		return grandrevenue;
	}

	public void setGrandrevenue(int grandrevenue) {
		this.grandrevenue = grandrevenue;
	}

	public int getSweetrevenue() {
		return sweetrevenue;
	}

	public void setSweetrevenue(int sweetrevenue) {
		this.sweetrevenue = sweetrevenue;
	}

	public int getDeluxesoldrooms() {
		return deluxesoldrooms;
	}

	public void setDeluxesoldrooms(int deluxesoldrooms) {
		this.deluxesoldrooms = deluxesoldrooms;
	}

	public int getGrandsoldrooms() {
		return grandsoldrooms;
	}

	public void setGrandsoldrooms(int grandsoldrooms) {
		this.grandsoldrooms = grandsoldrooms;
	}

	public int getSweetsoldrooms() {
		return sweetsoldrooms;
	}

	public void setSweetsoldrooms(int sweetsoldrooms) {
		this.sweetsoldrooms = sweetsoldrooms;
	}

}
