package projectHotel;

public class MoneyVO {	
	

	private int revenue1;
	private int revenue2;
	private int revenue3;
	public int revenue;
	

	private int soldrooms1;
	private int soldrooms2;
	private int soldrooms3;

	

	private int refund1;
	private int refund2;
	private int refund3;
	

	private int refundrooms1;
	private int refundrooms2;
	private int refundrooms3;
	

	public int getRevenue() {
		return revenue1+revenue2+revenue3+refund1 + refund2 + refund3;
	}
	
	
	public int getSoldrooms() {
		return soldrooms1 + soldrooms2 + soldrooms3;
	}


	public int getRevenue1() {
		return revenue1;
	}

	public void setRevenue1(int revenue1) {
		this.revenue1 = revenue1;
	}

	public int getRevenue2() {
		return revenue2;
	}

	public void setRevenue2(int revenue2) {
		this.revenue2 = revenue2;
	}

	public int getRevenue3() {
		return revenue3;
	}

	public void setRevenue3(int revenue3) {
		this.revenue3 = revenue3;
	}

	public int getSoldrooms1() {
		return soldrooms1;
	}

	public void setSoldrooms1(int soldrooms1) {
		this.soldrooms1 = soldrooms1;
	}

	public int getSoldrooms2() {
		return soldrooms2;
	}

	public void setSoldrooms2(int soldrooms2) {
		this.soldrooms2 = soldrooms2;
	}

	public int getSoldrooms3() {
		return soldrooms3;
	}

	public void setSoldrooms3(int soldrooms3) {
		this.soldrooms3 = soldrooms3;
	}

	public int getRefund1() {
		return refund1;
	}

	public void setRefund1(int refund1) {
		this.refund1 = refund1;
	}

	public int getRefund2() {
		return refund2;
	}

	public void setRefund2(int refund2) {
		this.refund2 = refund2;
	}

	public int getRefund3() {
		return refund3;
	}

	public void setRefund3(int refund3) {
		this.refund3 = refund3;
	}

	public int getRefundrooms1() {
		return refundrooms1;
	}

	public void setRefundrooms1(int refundrooms1) {
		this.refundrooms1 = refundrooms1;
	}

	public int getRefundrooms2() {
		return refundrooms2;
	}

	public void setRefundrooms2(int refundrooms2) {
		this.refundrooms2 = refundrooms2;
	}

	public int getRefundrooms3() {
		return refundrooms3;
	}

	public void setRefundrooms3(int refundrooms3) {
		this.refundrooms3 = refundrooms3;
	}
	
	
	
}
