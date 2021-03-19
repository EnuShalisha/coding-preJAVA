package projectHotel;

public interface Money {

	void initialize();

	MoneyVO getVO();

	void setRevenue1(int price);

	void setRevenue2(int price);

	void setRevenue3(int price);

	void setSoldrooms1(int num);

	void setSoldrooms2(int num);

	void setSoldrooms3(int num);

	void setRefund1(int price);

	void setRefund2(int price);

	void setRefund3(int price);

	void setRefundrooms1(int num);

	void setRefundrooms2(int num);

	void setRefundrooms3(int num);

}