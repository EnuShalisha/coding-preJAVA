package projectHotel1;

public class MoneyVO2 {	//������Ȳ??
	
	private int deluxerevenue;
	private int grandrevenue;
	private int sweetrevenue;
	
	//private int revenue; // price+����+�ο��� // �Ѱ��ǰ���
		// ��޿� ���� ������ �ؼ� �� ���ľ� �ǳ�??
	
	private int deluxesoldrooms;
	private int grandsoldrooms;
	private int sweetsoldrooms;

	//private int soldrooms; //�ǸŵȰ��Ǽ�
	
	
	//private int refund; // ȯ���� �� �ݾ� // ���Ⱑ �ƴ϶� ������� �ִ� ���ΰ�??
	private int refundprofit;
		//refundprofit = (revenue*(20/100);
			//�����ᰡ 20%�� ��
	private int sales; //�� �����
	
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
