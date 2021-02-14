package japangi.copy;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

//고여울
public class Dealing {

	private List<DealingVO> list = new ArrayList<>();

//카드거래

	public String validnumber(String cardnumber) throws Exception {
		try {
			if (Integer.parseInt(cardnumber) > 9999)
				throw new CardDigitsException("올바르지 않은 카드번호입니다.");
			if (Integer.parseInt(cardnumber) < 1000)
				throw new UnderZeroException("올바르지 않은 카드번호입니다.");
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
		vo.setSalesby("카드");
		vo.setDate(dealDate());
		list.add(vo);
		System.out.println(svo.getName() + " 결제가 완료되었습니다.");
	}

//현금거래

	public int dealbyCash(StockVO svo, int change) throws Exception {
		try {
			if (svo.getStock() == 0)
				throw new OutofStockException("재고가 없습니다.");
			if (change < svo.getPrice())
				throw new OutofMoneyException("잔액이 부족합니다.");
			change -= svo.getPrice();

			svo.setStock(svo.getStock() - 1);
			svo.setSales(svo.getSales() + 1);
			svo.setRevenue(svo.getRevenue() + svo.getPrice());
			DealingVO vo = new DealingVO(svo.getName());
			vo.setName(svo.getName());
			vo.setPrice(svo.getPrice());
			vo.setSalesby("현금");
			vo.setDate(dealDate());
			list.add(vo);
			System.out.println(svo.getName() + " 결제가 완료되었습니다.");
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
