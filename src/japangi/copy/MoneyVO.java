package japangi.copy;

//Á¤ÁÖÈñ
public class MoneyVO {
	private int thousand; // 1000
	private int f_hundred; // 500
	private int hundred; // 100
	private int fifty; // 50
	private int ten; // 10

	public int getThousand() {
		return thousand;
	}

	public void setThousand(int thousand) {
		this.thousand = thousand;
	}

	public int getF_hundred() {
		return f_hundred;
	}

	public void setF_hundred(int f_hundred) {
		this.f_hundred = f_hundred;
	}

	public int getHundred() {
		return hundred;
	}

	public void setHundred(int hundred) {
		this.hundred = hundred;
	}

	public int getFifty() {
		return fifty;
	}

	public void setFifty(int fifty) {
		this.fifty = fifty;
	}

	public int getTen() {
		return ten;
	}

	public void setTen(int ten) {
		this.ten = ten;
	}


	public int setTot() {
		return thousand * 1000 + f_hundred * 500 + hundred * 100 + fifty * 50 + ten * 10;
	}

	public int getTot() {
		return thousand * 1000 + f_hundred * 500 + hundred * 100 + fifty * 50 + ten * 10;
	}

	@Override
	public String toString() {
		return thousand + "\t" + f_hundred + "\t" + hundred + "\t" + fifty + "\t" + ten;
	}

}
