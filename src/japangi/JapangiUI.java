package japangi;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class JapangiUI {
	private Stock stock = new Stock(); // 스톡 생성자는 한번만 선언해야하니 조심하세요
	private int minimum=300;//자동 반환금액 초기값
	private int input=800;
	
	public void dealing() {
		System.out.println("음료 거래를 시작합니다.");
		showMenu();
		System.out.println("결제 수단을 선택하세요.");
		//if 1이면 bycash, 2번이면 bycard로 갑니다.
		
	}
	
	public void byCash() {
		System.out.println("다음을 선택하세요.");
		for(StockVO vo:stock.listStock()) {
			int idx=stock.listStock().indexOf(vo)+1;
			System.out.priㄴnt(idx+"."+vo.getName()+"   ");}
		int other=stock.listStock().size()+1;
		System.out.println(other+". 추가투입"+(other+1)+".종료");	
		
		
	}
	
	public void showMenu() {
		System.out.println("자판기 메뉴");
		System.out.println("음료\t가격\t가능\t품절");
		for(StockVO vo:stock.listStock()) {
			System.out.println(vo.getName()+"\t"+vo.getPrice()+"\t"+stock.available(input, vo)+"\t"+stock.soldout(vo));
		}
		System.out.println();
	}
	
	public void dealingStatus() {
		System.out.println("판매 현황");
		System.out.println("음료\t가격\t재고\t판매량\t판매수익");
		for(StockVO vo:stock.listStock()) {
			System.out.println(vo);
		}
		System.out.println();
	}
	
	public void insert() {
		
		try(Scanner sc=new Scanner(System.in)) {
			System.out.println("이름 입력");
			String name=sc.next();
			System.out.println("가격 입력");
			int pr=stock.registerPrice(sc.nextInt());
			System.out.println("재고 입력");
			int st=stock.registerStock(sc.nextInt());
			StockVO vo=new StockVO(name, pr, st);
			stock.insertDrink(vo);
			if(pr<minimum+10) minimum=pr-10; 
			// 자동반환금액 설정입니다.
			// 10 더하고 빼는건 음료가격보다 부족할경우 자동반환이라 그래요
			System.out.println("음료 등록이 완료되었습니다.");
		} catch (IOException e) {
			System.out.println("입력값이 없습니다.");
		} catch (InputMismatchException e) {
			System.out.println("가격과 재고는 정수값을 입력하십시오.");
			Scanner sc=new Scanner(System.in);
			sc.nextLine();
			sc.close();
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
	
	//음료 리딩입니다.
	public void readingMember() {
		String name="콜라";
		StockVO vo=stock.readStock(name);
	}
	
	
	//판매현황입니다.
	
	
	
}


