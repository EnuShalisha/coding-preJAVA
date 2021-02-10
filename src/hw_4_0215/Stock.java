package hw_4_0215;

public class Stock {
	
	private StockVO[] list;
	
	public Stock() {
		allocation(10);
		initialize();
	}
	
	private void allocation(int capacity) {
		StockVO[] temp = new StockVO[capacity];
		if(list!=null&&list.length>0 ) {
			System.arraycopy(list, 0, temp, 0, list.length);
		}
		list=temp;
	}
	
	private void initialize() {
		list[0].setName("콜라");
		list[1].setName("사이다");
		list[2].setName("환타");
		list[0].setPrice(1000);
		list[1].setPrice(600);
		list[2].setPrice(300);
		list[0].setStock(10);
		list[1].setStock(10);
		list[2].setStock(10);
		
	}
	

}

