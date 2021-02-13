package japangi;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class JapangiUI {
	private Stock stock = new Stock(); // ���� �����ڴ� �ѹ��� �����ؾ��ϴ� �����ϼ���
	private int minimum=300;//�ڵ� ��ȯ�ݾ� �ʱⰪ
	
	//���� ��� �� ����ó���Դϴ�.
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
	public void dealingStatus() {
		System.out.println("�Ǹ� ��Ȳ");
		System.out.println("����\t����\t���\t�Ǹŷ�\t�Ǹż���");
		for(StockVO vo:stock.listStock()) {
			System.out.println(vo);
		}
		System.out.println();
	}
}


