package japangi.copy;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class JapangiUI {
	Scanner sc = new Scanner(System.in);
	Money money = new Money();
	Stock stock = new Stock();
	Dealing dealing = new Dealing();
	private int change = 0;// �Һ��ڰ� ���� �ܵ� ����
	private int minimum = 290; // ���� �ּҰ�

	public void menu() {
		int ch;
		System.out.println("<4���� ���Ǳ��Դϴ�>");
		while (true) {
			try {
				do {
					System.out.println("1.����ŷ� 2.�ŷ����� 3.�ܵ���ȯ 4.�Ǹ���Ȳ");
					System.out.println("5.����� 6.������ 7.������ 8.�Ǹ��� �ܵ�ä��� 9.����");
					System.out.print("=>");
					ch = sc.nextInt();
				} while (ch < 1 || ch > 9);

				if (ch == 9) {
					sc.close();
					System.exit(0);
				}
	            switch (ch) {
	            
	            case 1:
	               beveragedeal();break;
	            case 2:
	               dealinglist();break;
	            case 3:
	            	returnchange();break;
	            case 4:
	            	dealingstatus();break;
	            case 5:
	            	insertstock();break;
	            case 6:
	            	modifystock();break;
	            case 7:
	            	deletestock();break;
	            case 8:
	            	insertchange();break;
	            }
				sc.nextLine();
			} catch (InputMismatchException e) {
				sc.nextLine();
			} catch (Exception e) {
				sc.nextLine();
			}
		}
	}

	public void startMenu() { // ���� ����Ʈ
		System.out.println("����\t����\t���");
		for (StockVO vo : stock.listStock()) {
			System.out.println(vo.getName() + "\t" + vo.getPrice() + "\t" + stock.soldout(vo));
		}
		System.out.println();
	}

	public void showMenu() { // ���� ����Ʈ
		System.out.println("����\t����\t����\t���");
		for (StockVO vo : stock.listStock()) {
			System.out.println(vo.getName() + "\t" + vo.getPrice() + "\t" + stock.available(change, vo) + "\t"
					+ stock.soldout(vo));
		}
		System.out.println();
	}

	public void beveragedeal() { // �������ܼ���
		System.out.println("���� �ŷ��� �����մϴ�.");

		startMenu();

		if (change != 0) {
			System.out.println("ī�� �ŷ��� �̿��ϴ� ���,���� ��ȯ ������ �̿��� �� �����ϴ�");
			System.out.println("�ܵ��� ��ȯ�Ͻðڽ��ϱ�?[y or n]");
			char ch = sc.next().charAt(0);
			if (ch == 'Y' || ch == 'y') {
				change = money.returnchange(change);
				return;
			} else
				selectMenu(1);
		} else {
			while (true) {
				try {
					System.out.println("���� ������ �����ϼ���.");
					System.out.println("1. ���� 2. ī��");
					int by = sc.nextInt();
					if (!(by == 1 || by == 2))
						throw new Exception();
					selectMenu(by);
					return;
				} catch (Exception e) {
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				}
			}
		}
	}

	public void selectMenu(int by) { // ���ἱ��
		try {
			StockVO vo = null;
			String cardnumber = "0000";
			if (by == 2) {
				System.out.println("ī���ȣ�� �Է��ϼ���(4�ڸ�)");
				cardnumber = dealing.validnumber(sc.next());
			}
			aa: while (true) {

				int other = stock.listStock().size() + 1;

				if (by == 1) {// ���� ����
					insertcustomchange();
					showMenu();
					System.out.println((other-1)+other+ ".����");

				} else {// ī��
					System.out.println("���Ͻô� �׸��� �����ϼ���.");
					stock.selectMenu();

					System.out.println(other + ".����");
				}

				int n = sc.nextInt();

				if (n == other)
					return;

				else if (n < other && n > 0) {
					vo = stock.listStock().get(n - 1);
					if (by == 1) {
						change = dealing.dealbyCash(vo, change);
						if (change < minimum) {
							System.out.println("�ܵ��� �ڵ���ȯ�˴ϴ�.");
							change = money.returnchange(change);
						}
					}
					if (by == 2)
						dealing.dealbyCard(vo, cardnumber);
					return;
				}

				else {
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
					continue aa;
				}

			}
		} catch (OutofStockException e) {
			System.out.println(e);
		} catch (OutofMoneyException e) {
			System.out.println(e);
		} catch (CardDigitsException e) {
			System.out.println(e);
		} catch (UnderZeroException e) {
			System.out.println(e);
		} catch (InputMismatchException e) {
			System.out.println("���ݰ� ���� �������� �Է��Ͻʽÿ�.");
			sc.nextLine();
		} catch (Exception e) {
			System.out.println("���� �߻�");
		}
	}

	public void dealinglist() {// �ŷ�����
		System.out.println("�ŷ�����");
		System.out.println("�ŷ��ð�\t\t����\t����\t��������");
		for (DealingVO vo : dealing.listDealing()) {
			System.out.println(vo);
		}

	}

	public void insertcustomchange() { // �Һ��� ���� ���� ��Ȳ

		System.out.println("������ �����Ͻðڽ��ϱ�?");
		System.out.println("1.�� 2.�ƴϿ�");
		int n = sc.nextInt();
		if (n != 1) {
			return;
		}
		System.out.println("������ ���� ������ �Է��Ͻʽÿ�.");
		try {
			int[] listsc = new int[5];
			System.out.println("1000��");
			listsc[0] = sc.nextInt();
			System.out.println("500��");
			listsc[1] = sc.nextInt();
			System.out.println("100��");
			listsc[2] = sc.nextInt();
			System.out.println("50��");
			listsc[3] = sc.nextInt();
			System.out.println("10��");
			listsc[4] = sc.nextInt();
			change = money.inputcustomchange(listsc);
		} catch (InputMismatchException e) {
			System.out.println("������ �Է� �����մϴ�.");
		} catch (Exception e) {
			System.out.println("������ �߻��߽��ϴ�");
		}

		System.out.println("���� �߰��� �Ϸ�ƽ��ϴ�.");
	}

	public void returnchange() { // �ܵ���ȯ
		int n;
		try {
			System.out.println("�ܵ��� ��ȯ�Ͻðڽ��ϱ�?");
			System.out.println("1.�� 2.�ƴϿ�");
			n = sc.nextInt();
			if (n != 1) {
				return;
			}
			if (change == 0) {
				throw new UnderZeroException("�ܵ��� �������� �ʽ��ϴ�");
			}
			change = money.returnchange(change);

		} catch (UnderZeroException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void dealingstatus() { // �Ǹ���Ȳ
		System.out.println("[�Ǹ� ��Ȳ]");
		System.out.println("����\t����\t���\t�Ǹŷ�\t�Ǹż���");
		for (StockVO vo : stock.listStock()) {
			System.out.println(vo);
		}
		System.out.println();
	}

	public void insertstock() { // ��� ���
		try {
			System.out.println("��� ����� ����� �Է��Ͻʽÿ�.");
			String name = sc.next();
			System.out.println("���� ���� �Է��Ͻʽÿ�.");
			int pr = stock.registerPrice(sc.nextInt());
			System.out.println("���� ��� �Է��Ͻʽÿ�.");
			int st = stock.registerStock(sc.nextInt());
			StockVO vo = new StockVO(name, pr, st);
			stock.insertStock(vo);
			if (pr < minimum + 10)
				minimum = pr - 10;
			// �ڵ���ȯ�ݾ� �����Դϴ�.
			// 10 ���ϰ� ���°� ���ᰡ�ݺ��� �����Ұ�� �ڵ���ȯ�̶� �׷���
			System.out.println("���� ����� �Ϸ�Ǿ����ϴ�.");
		} catch (IOException e) {
			System.out.println("�Է°��� �����ϴ�.");
		} catch (InputMismatchException e) {
			System.out.println("���ݰ� ���� �������� �Է��Ͻʽÿ�.");
		} catch (UnderZeroException e) {
			System.out.println(e);
		} catch (ANumberException e) {
			System.out.println(e);
		} catch (ExistenceException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println("���� �߻�");
		}
		System.out.println("���� �ܰ�� ���ư��ϴ�.");
	}

	public void modifystock() { // ������
		try {
			System.out.println("������ ������� �Է��Ͻʽÿ�.");
			String name = sc.next();
			StockVO vo = stock.readStock(name);
			if (vo == null) {
				System.out.println("��ϵ� ���ᰡ �ƴմϴ�.");
				return;
			}
			System.out.println("���� ����");
			int pr = stock.registerPrice(sc.nextInt());
			System.out.println("��� ����");
			int st = stock.registerStock(sc.nextInt());
			vo.setPrice(pr);
			vo.setStock(st);
			System.out.println("������ �Ϸ�Ǿ����ϴ�.");
		} catch (IOException e) {
			System.out.println("�Է°��� �����ϴ�.");
		} catch (InputMismatchException e) {
			System.out.println("���ݰ� ���� �������� �Է��Ͻʽÿ�.");
		} catch (UnderZeroException e) {
			System.out.println(e);
		} catch (ANumberException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println("���� �߻�");
		}

	}

	public void deletestock() { // ������
		try {
			System.out.println("������ ������� �Է��Ͻʽÿ�.");
			String name = sc.next();
			if (!stock.deleteStock(name)) {
				System.out.println("��ϵ� ���ᰡ �ƴմϴ�.");
				return;
			}
			System.out.println("������ �Ϸ�Ǿ����ϴ�.");
		} catch (Exception e) {
			System.out.println("���� �߻�");
		}
	}

	public void insertchange() { // �ܵ�ä���

		int[] list = money.changelist();
		// �ܵ���Ȳ

		System.out.println("[�ܵ� ��Ȳ]");
		System.out.println("1000��\t500��\t100��\t50��\t10��");
		for (int i = 0; i < 5; i++) {
			System.out.print(list[i] + "\t");
		}
		System.out.println();

		System.out.println("�ܵ��� ä��ðڽ��ϱ�?");
		System.out.println("1.�� 2.�ƴϿ�");
		int n = sc.nextInt();
		if (n != 1) {
			return;
		}
		System.out.println("������ �ܵ��� ������ �Է��Ͻʽÿ�.");
		try {
			int[] listsc = new int[5];
			System.out.println("1000��");
			listsc[0] = sc.nextInt();
			System.out.println("500��");
			listsc[1] = sc.nextInt();
			System.out.println("100��");
			listsc[2] = sc.nextInt();
			System.out.println("50��");
			listsc[3] = sc.nextInt();
			System.out.println("10��");
			listsc[4] = sc.nextInt();
			money.inputchange(listsc);
		} catch (InputMismatchException e) {
			System.out.println("������ �Է� �����մϴ�.");
		} catch (Exception e) {
			System.out.println("������ �߻��߽��ϴ�.");
		}

		System.out.println("�ܵ� �߰��� �Ϸ�ƽ��ϴ�.");
	}

}
