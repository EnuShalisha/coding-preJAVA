package japangi.copy;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class JapangiUI {
	Scanner sc = new Scanner(System.in);
	Money money = new Money();
	Stock stock = new Stock();
	Dealing dealing = new Dealing();
	private int change = 0;// 소비자가 넣은 잔돈 저장
	private int minimum = 290; // 음료 최소값

	public void menu() {
		int ch;
		System.out.println("<4조의 자판기입니다>");
		while (true) {
			try {
				do {
					System.out.println("1.음료거래 2.거래내역 3.잔돈반환 4.판매현황");
					System.out.println("5.재고등록 6.재고수정 7.재고삭제 8.판매자 잔돈채우기 9.종료");
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

	public void startMenu() { // 음료 리스트
		System.out.println("음료\t가격\t재고");
		for (StockVO vo : stock.listStock()) {
			System.out.println(vo.getName() + "\t" + vo.getPrice() + "\t" + stock.soldout(vo));
		}
		System.out.println();
	}

	public void showMenu() { // 음료 리스트
		System.out.println("음료\t가격\t가능\t재고");
		for (StockVO vo : stock.listStock()) {
			System.out.println(vo.getName() + "\t" + vo.getPrice() + "\t" + stock.available(change, vo) + "\t"
					+ stock.soldout(vo));
		}
		System.out.println();
	}

	public void beveragedeal() { // 결제수단선택
		System.out.println("음료 거래를 시작합니다.");

		startMenu();

		if (change != 0) {
			System.out.println("카드 거래를 이용하는 경우,현금 반환 전에는 이용할 수 없습니다");
			System.out.println("잔돈을 반환하시겠습니까?[y or n]");
			char ch = sc.next().charAt(0);
			if (ch == 'Y' || ch == 'y') {
				change = money.returnchange(change);
				return;
			} else
				selectMenu(1);
		} else {
			while (true) {
				try {
					System.out.println("결제 수단을 선택하세요.");
					System.out.println("1. 현금 2. 카드");
					int by = sc.nextInt();
					if (!(by == 1 || by == 2))
						throw new Exception();
					selectMenu(by);
					return;
				} catch (Exception e) {
					System.out.println("잘못 입력하셨습니다.");
				}
			}
		}
	}

	public void selectMenu(int by) { // 음료선택
		try {
			StockVO vo = null;
			String cardnumber = "0000";
			if (by == 2) {
				System.out.println("카드번호를 입력하세요(4자리)");
				cardnumber = dealing.validnumber(sc.next());
			}
			aa: while (true) {

				int other = stock.listStock().size() + 1;

				if (by == 1) {// 현금 투입
					insertcustomchange();
					showMenu();
					System.out.println((other-1)+other+ ".종료");

				} else {// 카드
					System.out.println("원하시는 항목을 선택하세요.");
					stock.selectMenu();

					System.out.println(other + ".종료");
				}

				int n = sc.nextInt();

				if (n == other)
					return;

				else if (n < other && n > 0) {
					vo = stock.listStock().get(n - 1);
					if (by == 1) {
						change = dealing.dealbyCash(vo, change);
						if (change < minimum) {
							System.out.println("잔돈이 자동반환됩니다.");
							change = money.returnchange(change);
						}
					}
					if (by == 2)
						dealing.dealbyCard(vo, cardnumber);
					return;
				}

				else {
					System.out.println("잘못 입력하셨습니다.");
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
			System.out.println("가격과 재고는 정수값을 입력하십시오.");
			sc.nextLine();
		} catch (Exception e) {
			System.out.println("오류 발생");
		}
	}

	public void dealinglist() {// 거래내역
		System.out.println("거래내역");
		System.out.println("거래시간\t\t음료\t가격\t결제수단");
		for (DealingVO vo : dealing.listDealing()) {
			System.out.println(vo);
		}

	}

	public void insertcustomchange() { // 소비자 현금 투입 현황

		System.out.println("현금을 투입하시겠습니까?");
		System.out.println("1.네 2.아니요");
		int n = sc.nextInt();
		if (n != 1) {
			return;
		}
		System.out.println("투입할 돈의 갯수를 입력하십시오.");
		try {
			int[] listsc = new int[5];
			System.out.println("1000원");
			listsc[0] = sc.nextInt();
			System.out.println("500원");
			listsc[1] = sc.nextInt();
			System.out.println("100원");
			listsc[2] = sc.nextInt();
			System.out.println("50원");
			listsc[3] = sc.nextInt();
			System.out.println("10원");
			listsc[4] = sc.nextInt();
			change = money.inputcustomchange(listsc);
		} catch (InputMismatchException e) {
			System.out.println("정수만 입력 가능합니다.");
		} catch (Exception e) {
			System.out.println("오류가 발생했습니다");
		}

		System.out.println("현금 추가가 완료됐습니다.");
	}

	public void returnchange() { // 잔돈반환
		int n;
		try {
			System.out.println("잔돈을 반환하시겠습니까?");
			System.out.println("1.네 2.아니요");
			n = sc.nextInt();
			if (n != 1) {
				return;
			}
			if (change == 0) {
				throw new UnderZeroException("잔돈이 존재하지 않습니다");
			}
			change = money.returnchange(change);

		} catch (UnderZeroException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void dealingstatus() { // 판매현황
		System.out.println("[판매 현황]");
		System.out.println("음료\t가격\t재고\t판매량\t판매수익");
		for (StockVO vo : stock.listStock()) {
			System.out.println(vo);
		}
		System.out.println();
	}

	public void insertstock() { // 재고 등록
		try {
			System.out.println("재고 등록할 음료명 입력하십시오.");
			String name = sc.next();
			System.out.println("음료 가격 입력하십시오.");
			int pr = stock.registerPrice(sc.nextInt());
			System.out.println("음료 재고 입력하십시오.");
			int st = stock.registerStock(sc.nextInt());
			StockVO vo = new StockVO(name, pr, st);
			stock.insertStock(vo);
			if (pr < minimum + 10)
				minimum = pr - 10;
			// 자동반환금액 설정입니다.
			// 10 더하고 빼는건 음료가격보다 부족할경우 자동반환이라 그래요
			System.out.println("음료 등록이 완료되었습니다.");
		} catch (IOException e) {
			System.out.println("입력값이 없습니다.");
		} catch (InputMismatchException e) {
			System.out.println("가격과 재고는 정수값을 입력하십시오.");
		} catch (UnderZeroException e) {
			System.out.println(e);
		} catch (ANumberException e) {
			System.out.println(e);
		} catch (ExistenceException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println("오류 발생");
		}
		System.out.println("이전 단계로 돌아갑니다.");
	}

	public void modifystock() { // 재고수정
		try {
			System.out.println("수정할 음료명을 입력하십시오.");
			String name = sc.next();
			StockVO vo = stock.readStock(name);
			if (vo == null) {
				System.out.println("등록된 음료가 아닙니다.");
				return;
			}
			System.out.println("가격 수정");
			int pr = stock.registerPrice(sc.nextInt());
			System.out.println("재고 수정");
			int st = stock.registerStock(sc.nextInt());
			vo.setPrice(pr);
			vo.setStock(st);
			System.out.println("수정이 완료되었습니다.");
		} catch (IOException e) {
			System.out.println("입력값이 없습니다.");
		} catch (InputMismatchException e) {
			System.out.println("가격과 재고는 정수값을 입력하십시오.");
		} catch (UnderZeroException e) {
			System.out.println(e);
		} catch (ANumberException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println("오류 발생");
		}

	}

	public void deletestock() { // 재고삭제
		try {
			System.out.println("삭제할 음료명을 입력하십시오.");
			String name = sc.next();
			if (!stock.deleteStock(name)) {
				System.out.println("등록된 음료가 아닙니다.");
				return;
			}
			System.out.println("삭제가 완료되었습니다.");
		} catch (Exception e) {
			System.out.println("오류 발생");
		}
	}

	public void insertchange() { // 잔돈채우기

		int[] list = money.changelist();
		// 잔돈현황

		System.out.println("[잔돈 현황]");
		System.out.println("1000원\t500원\t100원\t50원\t10원");
		for (int i = 0; i < 5; i++) {
			System.out.print(list[i] + "\t");
		}
		System.out.println();

		System.out.println("잔돈을 채우시겠습니까?");
		System.out.println("1.네 2.아니요");
		int n = sc.nextInt();
		if (n != 1) {
			return;
		}
		System.out.println("투입할 잔돈의 갯수를 입력하십시오.");
		try {
			int[] listsc = new int[5];
			System.out.println("1000원");
			listsc[0] = sc.nextInt();
			System.out.println("500원");
			listsc[1] = sc.nextInt();
			System.out.println("100원");
			listsc[2] = sc.nextInt();
			System.out.println("50원");
			listsc[3] = sc.nextInt();
			System.out.println("10원");
			listsc[4] = sc.nextInt();
			money.inputchange(listsc);
		} catch (InputMismatchException e) {
			System.out.println("정수만 입력 가능합니다.");
		} catch (Exception e) {
			System.out.println("오류가 발생했습니다.");
		}

		System.out.println("잔돈 추가가 완료됐습니다.");
	}

}
