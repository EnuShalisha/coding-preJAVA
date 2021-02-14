package japangi.copy;

//������
public class Money {
	MoneyVO vo = new MoneyVO();

	public Money() {
		initialize();

	}

	public void initialize() {
		vo.setThousand(10);
		vo.setF_hundred(10);
		vo.setHundred(10);
		vo.setFifty(10);
		vo.setTen(10);

	}

	// �ܵ����
	public int[] changelist() {
		int[] list = { vo.getThousand(), vo.getF_hundred(), vo.getHundred(), vo.getFifty(), vo.getTen() };
		return list;
	}

	public void setchangelist(int[] list) {
		vo.setThousand(list[0]);
		vo.setF_hundred(list[1]);
		vo.setHundred(list[2]);
		vo.setFifty(list[3]);
		vo.setTen(list[4]);
	}

	// �ܵ���ȯ
	public int returnchange(int change) {
		int[] list = changelist();
		int[] listrt = { 1000, 500, 100, 50, 10 };
		int temp = change;
		int[] templist = list;

		try {
			for (int i = 0; i < 5; i++) {
				while (templist[i] > 0 && temp >= listrt[i] && temp > 0) {
					temp = temp - listrt[i];
					templist[i] -= 1;
				}
				;
			}
			if (temp != 0)
				throw new UnchangableException("���Ǳ� �� �ܵ� ���� - �����ڿ��� �����ϼ���.");
			System.out.println(change + "���� ��ȯ�ƽ��ϴ�");
			change = temp;
			setchangelist(templist);
		} catch (UnchangableException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return change;
	}

	// ������ �ܵ� ä���
	public void inputchange(int listsc[]) {
		int[] list = changelist();
		for (int i = 0; i < 5; i++) {
			list[i] += listsc[i];
		}
		setchangelist(list);
	}

	// �մ� �ܵ� ä���
	public int inputcustomchange(int listsc[]) {
		int[] list = changelist();
		for (int i = 0; i < 5; i++) {
			list[i] += listsc[i];
		}
		setchangelist(list);

		int[] listrt = { 1000, 500, 100, 50, 10 };
		int change = 0;
		for (int i = 0; i < 5; i++) {
			change += listrt[i] * listsc[i];
		}
		return change;
	}

}
