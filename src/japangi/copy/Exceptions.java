package japangi.copy;
// ��������� ���ܹ� �������� ��
public class Exceptions {

}

class OutofStockException extends Exception {// ��� 0�� ��� ���� �߻�
	private static final long serialVersionUID = 1L;

	public OutofStockException(String msg) {
		super(msg);
	}
}

class OutofMoneyException extends Exception {// ���Աݾ�(change)�� ����ݾ׺��� ������ ��� ���� �߻�
	private static final long serialVersionUID = 1L;

	public OutofMoneyException(String msg) {
		super(msg);
	}
}

class UnderZeroException extends Exception {// ���� ��Ͻ� ����, ��� 0 �̸��� ��� ���� �߻�
	private static final long serialVersionUID = 1L;

	public UnderZeroException(String msg) {
		super(msg);
	}
}

class ANumberException extends Exception {// ���ݿ��� ���Ǵ����� 0�� �ƴҰ�� ���� �߻�
	private static final long serialVersionUID = 1L;

	public ANumberException(String msg) {
		super(msg);
	}
}

class ExistenceException extends Exception {// ���ᰡ �̹� ������ ��� ���� �߻�
	private static final long serialVersionUID = 1L;

	public ExistenceException(String msg) {
		super(msg);
	}
}

class UnchangableException extends Exception { // ���Ǳ� �� �ܵ� �������� ��ȯ �Ұ��� ��� ���� �߻�
	private static final long serialVersionUID = 1L;

	public UnchangableException(String msg) {
		super(msg);
	}
}

class CardDigitsException extends Exception {// ī�� �ڸ����� 4�ڸ��� �ƴѰ�� ���� �߻�
	private static final long serialVersionUID = 1L;

	public CardDigitsException(String msg) {
		super(msg);
	}
}