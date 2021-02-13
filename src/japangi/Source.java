package japangi;

import java.util.List;

public interface Source {
	public void initialize();
	public StockVO readStock (String name);
	public void insertDrink(StockVO vo) throws Exception;
	public boolean deleteStock(String name);
	public int registerPrice(int price) throws Exception;
	public int registerStock(int stock) throws Exception;
	public List<StockVO> listStock();

	
}