package japangi;

public class StockVO {
	private int price;
	private int stock;
	private String name;
	private int sales;
	private int revenue;
	
	public StockVO(String name, int price, int stock) {
		this.name=name; this.price=price; this.stock=stock;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	public int getRevenue() {
		return revenue;
	}
	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}
	@Override
	public String toString() {
		return getName()+"\t"+getPrice()+"\t"+getStock()+"\t"+sales+"\t"+revenue;
	}
	
	
}
