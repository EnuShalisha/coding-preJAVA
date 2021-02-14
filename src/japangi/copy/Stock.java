package japangi.copy;

import java.util.ArrayList;
import java.util.List;

//Ȳ��ȣ
public class Stock implements Source {

//�ʱ�ȭ
	public Stock() {
		initialize();
	}

	private List<StockVO> list = new ArrayList<>();

	@Override
	public void initialize() {
		StockVO vo1 = new StockVO("�ݶ�", 1000, 10);
		StockVO vo2 = new StockVO("���̴�", 500, 10);
		StockVO vo3 = new StockVO("�̶���", 300, 10);
		try {
			insertStock(vo1);
			insertStock(vo2);
			insertStock(vo3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//������ ���� ����
	@Override
	public void insertStock(StockVO vo) throws Exception {
		try {
			if (readStock(vo.getName()) != null) {
				throw new ExistenceException("�̹� �����ϴ� �����Դϴ�.");
			}
			list.add(vo);

		} catch (ExistenceException e) {
			throw e;
		} catch (Exception e) {
			System.out.println("���� �߻�");
		}

	}

	@Override
	public boolean deleteStock(String name) {
		StockVO vo = readStock(name);
		if (vo == null) {
			return false;
		}
		list.remove(vo);
		return true;
	}

	@Override
	public int registerPrice(int price) throws Exception {
		try {
			if (price < 0) {
				throw new UnderZeroException("0 �̸��� ���� �������� �Է��� �� �����ϴ�.");
			}
			if (price % 10 != 0) {
				throw new ANumberException("���� ������ �������� �Է��� �� �����ϴ�.");
			}
		} catch (UnderZeroException e) {
			throw e;
		} catch (ANumberException e) {
			throw e;
		} catch (Exception e) {
			System.out.println("���� �߻�");
		}
		return price;
	}

	@Override
	public int registerStock(int stock) throws Exception {
		try {
			if (stock < 0) {
				throw new UnderZeroException("0 �̸��� ���� ���� �Է��� �� �����ϴ�.");
			}
		} catch (UnderZeroException e) {
			throw e;
		} catch (Exception e) {
			System.out.println("���� �߻�");
		}
		return stock;
	}

//������������
	@Override
	public StockVO readStock(String name) {
		for (StockVO vo : list) {
			if (vo.getName().equals(name)) {
				return vo;
			}
		}
		return null;
	}

	@Override
	public List<StockVO> listStock() {
		return list;
	}

	public String soldout(StockVO vo) {
		String s = "";
		if (vo.getStock() == 0)
			s = "ǰ��";

		return s;
	}

	public String available(int input, StockVO vo) {
		String s = "X";
		if (input >= vo.getPrice())
			s = "O";
		return s;
	}

	public void selectMenu() {
		for (StockVO v : listStock()) {
			int idx = listStock().indexOf(v) + 1;
			System.out.print(idx + "." + v.getName() + "   ");
		}
	}

}
