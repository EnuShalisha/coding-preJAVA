package projectHotel1;

public class MoneyVO {	//������Ȳ??
	
	//private int deluxerevenue;
	//private int grandrevenue;
	//private int sweetrevenue;
	
	private int revenue; // price+����+�ο��� // �Ѱ��ǰ���
		// ��޿� ���� ������ �ؼ� �� ���ľ� �ǳ�??
	
	//private int deluxesoldrooms;
	//private int grandsoldrooms;
	//private int sweetsoldrooms;

	private int soldrooms; //�ǸŵȰ��Ǽ�
	
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
	 * �ؼ� ���� 
	 */
	
	//private int refund; // ȯ���� �� �ݾ� // ���Ⱑ �ƴ϶� ������� �ִ� ���ΰ�??
	private int refundprofit;
	//refundprofit = (revenue*(20/100);
			//�����ᰡ 20%�� ��
	
	private int sales; //�� �����
	
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
