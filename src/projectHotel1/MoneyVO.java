package projectHotel1;

public class MoneyVO {	//매출현황??
	
	//private int deluxerevenue;
	//private int grandrevenue;
	//private int sweetrevenue;
	
	private int revenue; // price+방등급+인원수 // 총객실가격
		// 등급에 따라 가격을 해서 다 합쳐야 되나??
	
	//private int deluxesoldrooms;
	//private int grandsoldrooms;
	//private int sweetsoldrooms;

	private int soldrooms; //판매된객실수
	
//	public int getrevenue() {
//		return deluxerevenue+grandrevenue+sweetrevenue;
//	}
	
	/*
	 * g2revenue
	 * g3revenue
	 * g4revenue
	 * 
	 * revenue = g2r + g3r + g4r
	 * 
	 * g2soldrooms
	 * g3soldrooms
	 * g4soldrooms
	 * 
	 * sdrs = 
	 * 
	 * 해서 따로 
	 */
	
	//private int refund; // 환불해 줄 금액 // 여기가 아니라 예약취소 있는 쪽인가??
	private int refundprofit;
	//refundprofit = (revenue*(20/100);
			//수수료가 20%일 때
	
	private int sales; //총 매출액
	
	//-----------------------
	public MoneyVO() {
	}
	
	public MoneyVO(int revenue, int soldrooms, int refundprofit, int sales) {
		this.revenue = revenue;
		this.soldrooms = soldrooms;
		this.refundprofit = refundprofit;
		this.sales = sales;
	}
	//------------------------

	public int getRevenue() {
		return revenue;
	}

	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}

	public int getSoldrooms() {
		return soldrooms;
	}

	public void setSoldrooms(int soldrooms) {
		this.soldrooms = soldrooms;
	}

	public int getRefundprofit() {
		return refundprofit;
	}

	public void setRefundprofit(int refundprofit) {
		this.refundprofit = refundprofit;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}
	
	
	    
}
