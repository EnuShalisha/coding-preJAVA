package japangi.copy;
// 사용자지정 예외문 만들어놓은 것
public class Exceptions {

}

class OutofStockException extends Exception {// 재고가 0일 경우 예외 발생
	private static final long serialVersionUID = 1L;

	public OutofStockException(String msg) {
		super(msg);
	}
}

class OutofMoneyException extends Exception {// 투입금액(change)가 음료금액보다 부족할 경우 예외 발생
	private static final long serialVersionUID = 1L;

	public OutofMoneyException(String msg) {
		super(msg);
	}
}

class UnderZeroException extends Exception {// 음료 등록시 가격, 재고가 0 미만일 경우 예외 발생
	private static final long serialVersionUID = 1L;

	public UnderZeroException(String msg) {
		super(msg);
	}
}

class ANumberException extends Exception {// 가격에서 일의단위가 0이 아닐경우 예외 발생
	private static final long serialVersionUID = 1L;

	public ANumberException(String msg) {
		super(msg);
	}
}

class ExistenceException extends Exception {// 음료가 이미 존재할 경우 예외 발생
	private static final long serialVersionUID = 1L;

	public ExistenceException(String msg) {
		super(msg);
	}
}

class UnchangableException extends Exception { // 자판기 내 잔돈 부족으로 반환 불가할 경우 예외 발생
	private static final long serialVersionUID = 1L;

	public UnchangableException(String msg) {
		super(msg);
	}
}

class CardDigitsException extends Exception {// 카드 자리수가 4자리가 아닌경우 예외 발생
	private static final long serialVersionUID = 1L;

	public CardDigitsException(String msg) {
		super(msg);
	}
}