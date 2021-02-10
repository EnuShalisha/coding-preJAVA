package hw_4_0215;

public class Selling {
	
	private moneyVO money;
	public Selling() {
		initialize();
	}
	
	private void initialize() {
		money.setHundred(10);
		money.setOne(10);
		money.setTen(10);
		money.setThousand(10);
		money.setTotal();
	}
}
