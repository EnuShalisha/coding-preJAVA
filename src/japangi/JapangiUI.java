package japangi;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class JapangiUI {
	private Stock stock = new Stock(); // ���� �����ڴ� �ѹ��� �����ؾ��ϴ� �����ϼ���
	private int minimum=300;//�ڵ� ��ȯ�ݾ� �ʱⰪ
	private int change=0;
	
	public void beveragedeal() {
		System.out.println("���� �ŷ��� �����մϴ�.");
		showMenu();
		System.out.println("���� ������ �����ϼ���.");
		//if 1�̸� bycash, 2���̸� bycard�� ���ϴ�.
		
	}
	
	
	public void selectMenu(int by) {
		try(Scanner sc=new Scanner(System.in)){
			StockVO vo=null;
			
			aa:
			while(true) {
			
				System.out.println("���Ͻô� �׸��� �����ϼ���.");
			
				for(StockVO v:stock.listStock()) {
					int idx=stock.listStock().indexOf(v)+1;
					System.out.print(idx+"."+v.getName()+"   ");}
				int other=stock.listStock().size()+1;
				if(by==1) {
					System.out.println(other+". �߰�����"+(other+1)+".����");}
				else {
					System.out.println((other+1)+".����");}
				
				int n=sc.nextInt();
				vo=stock.listStock().get(n-1);
				
				if(vo!=null) {
					System.out.println(vo.getName());
					break;}
				else if(n==other)	{
					//insertchange();
					System.out.println("�߰� ���� �Ϸ�Ǿ����ϴ�.");
					continue aa;}
				else if(n==(other+1)) 	return;	
			
				else {
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
					continue aa;}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void byCash() {
		
		
		
	}
	
	public void showMenu() {
		System.out.println("���Ǳ� �޴�");
		System.out.println("����\t����\t����\tǰ��");
		for(StockVO vo:stock.listStock()) {
			System.out.println(vo.getName()+"\t"+vo.getPrice()+"\t"+stock.available(change, vo)+"\t"+stock.soldout(vo));
		}
		System.out.println();
	}
	
	public void dealingStatus() {
		System.out.println("�Ǹ� ��Ȳ");
		System.out.println("����\t����\t���\t�Ǹŷ�\t�Ǹż���");
		for(StockVO vo:stock.listStock()) {
			System.out.println(vo);
		}
		System.out.println();
	}
	
	public void returnchanges() {
		int a=123455678;
		int[] list={1000, 500, 100, 50, 10};
		for(int i:list) {
			
			int b=a/i;
			
		}
		
	}
	
	public void insert() {
		
		try(Scanner sc=new Scanner(System.in)) {
			System.out.println("�̸� �Է�");
			String name=sc.next();
			System.out.println("���� �Է�");
			int pr=stock.registerPrice(sc.nextInt());
			System.out.println("��� �Է�");
			int st=stock.registerStock(sc.nextInt());
			StockVO vo=new StockVO(name, pr, st);
			stock.insertDrink(vo);
			if(pr<minimum+10) minimum=pr-10; 
			// �ڵ���ȯ�ݾ� �����Դϴ�.
			// 10 ���ϰ� ���°� ���ᰡ�ݺ��� �����Ұ�� �ڵ���ȯ�̶� �׷���
			System.out.println("���� ����� �Ϸ�Ǿ����ϴ�.");
		} catch (IOException e) {
			System.out.println("�Է°��� �����ϴ�.");
		} catch (InputMismatchException e) {
			System.out.println("���ݰ� ���� �������� �Է��Ͻʽÿ�.");
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
			System.out.println("���� �߻�");
		}
		System.out.println("���� �ܰ�� ���ư��ϴ�.");
	
	}
	
	//���� �����Դϴ�.
	public void readingMember() {
		String name="�ݶ�";
		StockVO vo=stock.readStock(name);
	}
	
	
	//�Ǹ���Ȳ�Դϴ�.
	
	
	
}


