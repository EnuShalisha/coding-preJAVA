package japangi;

public class DealingVO extends StockVO {
	public DealingVO(String name) {
		super(name);
		//DealingVO�� �ҷ������� �ݵ�� �����, ����, ��� �Է�
	}

	private String date;
	private String cardnumber;
	private boolean cardcount;
	private String salesby;
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}
	public boolean isCardcount() {
		return cardcount;
	}
	public void setCardcount(boolean cardcount) {
		this.cardcount = cardcount;
	}
	public String getSalesby() {
		return salesby;
	}
	public void setSalesby(String salesby) {
		this.salesby = salesby;
	}
	
	@Override
	public String toString() {
		return date+"\t"+getName()+"\t"+getPrice()+"\t"+salesby;
	}
	
	
}
