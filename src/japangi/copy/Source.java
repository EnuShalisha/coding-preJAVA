package japangi.copy;

import java.util.List;
//stock
public interface Source {
	public void initialize();
	public StockVO readStock (String name);
	public void insertStock(StockVO vo) throws Exception;
	public boolean deleteStock(String name);
	public int registerPrice(int price) throws Exception;
	public int registerStock(int stock) throws Exception;
	public List<StockVO> listStock();
	public String soldout(StockVO vo);
	public String available(int input, StockVO vo);
	public void selectMenu();
}