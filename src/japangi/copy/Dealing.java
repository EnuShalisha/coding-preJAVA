package japangi.copy;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

//����
public class Dealing {

	private List<DealingVO> list = new ArrayList<>();

//ī��ŷ�

	public String validnumber(String cardnumber) throws Exception {
		try {
			if (Integer.parseInt(cardnumber) > 9999)
				throw new CardDigitsException("�ùٸ��� ���� ī���ȣ�Դϴ�.");
			if (Integer.parseInt(cardnumber) < 1000)
				throw new UnderZeroException("�ùٸ��� ���� ī���ȣ�Դϴ�.");
		} catch (CardDigitsException e) {
			throw e;
		} catch (UnderZeroException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return cardnumber;

	}

	public void dealbyCard(StockVO svo, String cardnumber) {
		svo.setStock(svo.getStock() - 1);
		svo.setSales(svo.getSales() + 1);
		svo.setRevenue(svo.getRevenue() + svo.getPrice());
		DealingVO vo = new DealingVO(svo.getName());
		vo.setName(svo.getName());
		vo.setPrice(svo.getPrice());
		vo.setCardnumber(cardnumber);
		vo.setSalesby("ī��");
		vo.setDate(dealDate());
		list.add(vo);
		System.out.println(svo.getName() + " ������ �Ϸ�Ǿ����ϴ�.");
	}

//���ݰŷ�

	public int dealbyCash(StockVO svo, int change) throws Exception {
		try {
			if (svo.getStock() == 0)
				throw new OutofStockException("��� �����ϴ�.");
			if (change < svo.getPrice())
				throw new OutofMoneyException("�ܾ��� �����մϴ�.");
			change -= svo.getPrice();

			svo.setStock(svo.getStock() - 1);
			svo.setSales(svo.getSales() + 1);
			svo.setRevenue(svo.getRevenue() + svo.getPrice());
			DealingVO vo = new DealingVO(svo.getName());
			vo.setName(svo.getName());
			vo.setPrice(svo.getPrice());
			vo.setSalesby("����");
			vo.setDate(dealDate());
			list.add(vo);
			System.out.println(svo.getName() + " ������ �Ϸ�Ǿ����ϴ�.");
			return change;
		} catch (OutofStockException e) {
			throw e;
		} catch (OutofMoneyException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}

	}

	public String dealDate() {
		Calendar cal = Calendar.getInstance();
		String s = String.format("%tA %tT", cal, cal);
		return s;
	}

	public List<DealingVO> listDealing() {
		return list;
	}
}
