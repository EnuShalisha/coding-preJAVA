package projectHotel;

public class MoneyImpl implements Money {	
	
	MoneyVO mvo = new MoneyVO();
	ReservationVO rsvo = new ReservationVO();
	

	public MoneyImpl() {
		initialize();
	}
	

	@Override
	public void initialize() {
		mvo.setSoldrooms3(10);
		mvo.setRevenue3(4350);
	}
	
	@Override
	public MoneyVO getVO() {
		return mvo;
	}
	
	@Override
	public void setRevenue1(int price) {
		mvo.setRevenue1(mvo.getRevenue1()+price);
	}
	
	@Override
	public void setRevenue2(int price) {
		mvo.setRevenue2(mvo.getRevenue2()+price);
	}
	
	@Override
	public void setRevenue3(int price) {
		mvo.setRevenue3(mvo.getRevenue3()+price);
	}
	

	@Override
	public void setSoldrooms1(int num) {
		mvo.setSoldrooms1(mvo.getSoldrooms1()+num);
	}
	@Override
	public void setSoldrooms2(int num) {
		mvo.setSoldrooms2(mvo.getSoldrooms2()+num);
	}
	@Override
	public void setSoldrooms3(int num) {
		mvo.setSoldrooms3(mvo.getSoldrooms3()+num);
	}
	

	
	@Override
	public void setRefund1(int price) {
		mvo.setRefund1(mvo.getRefund1()+price);
	}
	
	@Override
	public void setRefund2(int price) {
		mvo.setRefund2(mvo.getRefund2()+price);
	}
	
	@Override
	public void setRefund3(int price) {
		mvo.setRefund3(mvo.getRefund3()+price);
	}
	

	
	@Override
	public void setRefundrooms1(int num) {
		mvo.setRefundrooms1(mvo.getRefundrooms1()+num);
	}
	@Override
	public void setRefundrooms2(int num) {
		mvo.setRefundrooms2(mvo.getRefundrooms2()+num);
	}
	@Override
	public void setRefundrooms3(int num) {
		mvo.setRefundrooms3(mvo.getRefundrooms3()+num);
	}
	
	
}

	

