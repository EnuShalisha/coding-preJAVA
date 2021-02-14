package japangi.copy;

//고여울
public class DealingVO extends StockVO {

	public DealingVO(String name) {
		super(name);
		// DealingVO를 불러오려면 반드시 음료명 입력
	}

	private String date;
	private String cardnumber;
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

	public String getSalesby() {
		return salesby;
	}

	public void setSalesby(String salesby) {
		this.salesby = salesby;
	}

	@Override
	public String toString() {
		return date + "\t" + getName() + "\t" + getPrice() + "\t" + salesby;
	}

}
