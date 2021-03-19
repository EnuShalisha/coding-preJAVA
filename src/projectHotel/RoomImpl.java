package projectHotel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class RoomImpl implements Room{
	private String pathname="room.txt";
	
	public RoomImpl() {
		initializeGrade();
		initializeRoom();
		addprice=20;
	}
	private List<RoomVO> list = new ArrayList<>();
	private List<RoomVO> grade = new ArrayList<RoomVO>();
	private int addprice;
	
	@Override
	public void initializeGrade() {
		RoomVO vo1 = new RoomVO("����Ʈ", 150, 4, 4, 6);
		RoomVO vo2 = new RoomVO("�׷���", 80, 3, 3, 5);
		RoomVO vo3 = new RoomVO("�𷰽�", 50, 2, 2, 4);
		
		grade.add(vo1);
		grade.add(vo2);
		grade.add(vo3);
	}

	   @Override
	   public void initializeRoom() {
	      RoomVO vo1=grade.get(0);
	      RoomVO vo2=grade.get(1);
	      RoomVO vo3=grade.get(2);
	      
	      for(int i=0; i<5; i++) {
	         RoomVO vo=new RoomVO(vo1.getGrade(), vo1.getPrice(), vo1.getFloor(), vo1.getPeoplenum(), vo1.getMaxnum());
	         vo.setNumber(401+i);
	         insertRoom(vo);   
	      }
	      for(int i=0; i<8; i++) {
	         RoomVO vo=new RoomVO(vo2.getGrade(), vo2.getPrice(), vo2.getFloor(), vo2.getPeoplenum(), vo2.getMaxnum());
	         vo.setNumber(301+i);
	         insertRoom(vo);
	      }
	      for(int i=0; i<10; i++) {
	         RoomVO vo=new RoomVO(vo3.getGrade(), vo3.getPrice(), vo3.getFloor(), vo3.getPeoplenum(), vo3.getMaxnum());
	         vo.setNumber(201+i);
	         insertRoom(vo);
	      }
	   }
	@Override
	public RoomVO getGrade(int num) {
		RoomVO vo = grade.get(num);
		return vo;
	}
	
	public RoomVO getGrade(String gradename) {
		RoomVO vo1 = grade.get(0);
		RoomVO vo2 = grade.get(1);
		RoomVO vo3 = grade.get(2);
		if(vo1.getGrade().equals(gradename)) 
			return vo1;
		else if(vo2.getGrade().equals(gradename))
			return vo2;
		else if(vo3.getGrade().equals(gradename))
			return vo3;
		else
			return null;
	}
	@Override
	public RoomVO readRoom(int i) {
		RoomVO vo=null;
		for(RoomVO vv:list) {
			if(vv.getNumber()==i) {
				vo=vv;
				break;
			}
		}
		return vo;
	}
	@Override
	public int verifyClientnum(int clientnum) throws Exception {
		RoomVO vo1=grade.get(0);
		if(clientnum>vo1.getMaxnum()) {
			throw new ExceedClientException("���� ȣ���� �ִ� "+vo1.getMaxnum()+
					"����� ������ �� �ֽ��ϴ�.\n ������ �ٽ� ������ �ֽʽÿ�.");
		}
		if(clientnum<1) {
			throw new UnderZeroException("������ ���� �߸� �Է��ϼ̽��ϴ�. �޴��� ���ư��ϴ�.");
		}
		return clientnum;
	}
	@Override
	public void chooseRoom(int clientnum) {
		
		System.out.println("���� ������ ���� �غ�Ǿ��ֽ��ϴ�.");
		System.out.println("(������ �⺻ �����ο� �̻��� ������ ��� �δ� "+addprice+"�޷��� �ΰ��˴ϴ�)");
		
		RoomVO vo1=grade.get(0);
		RoomVO vo2=grade.get(1);
		RoomVO vo3=grade.get(2);
		System.out.println("*  *  *  *  *  *  *  *  *  *  *  *  *  *  ");
		String suite=vo1.getGrade()+"| "+vo1.getPrice()+"�޷�| �⺻ �ο� "+vo1.getPeoplenum()+"��| �ִ� �ο� "+vo1.getMaxnum()+"��";
		String grand=vo2.getGrade()+"| "+vo2.getPrice()+"�޷� | �⺻ �ο� "+vo2.getPeoplenum()+"��| �ִ� �ο� "+vo2.getMaxnum()+"��";
		String delxue=vo3.getGrade()+"| "+vo3.getPrice()+"�޷� | �⺻ �ο� "+vo3.getPeoplenum()+"��| �ִ� �ο� "+vo3.getMaxnum()+"��";
		
		String quest="������ ������ �ֽʽÿ�.";
		String suite_menu="1. ���� ��� 2. "+vo1.getGrade();
		String grand_menu="1. ���� ��� 2. "+vo1.getGrade()+" 3. "+vo2.getGrade();
		String deluxe_menu="1. ���� ��� 2. "+vo1.getGrade()+" 3. "+vo2.getGrade()+" 4. "+vo3.getGrade();
		
		switch(clientnum) {
		case 6: System.out.println(suite+"\n"+quest+"\n"+suite_menu); break;
		case 5: System.out.println(suite+"\n"+grand+"\n"+quest+"\n"+grand_menu); break;
		default: System.out.println(suite+"\n"+grand+"\n"+delxue+"\n"+quest+"\n"+deluxe_menu); break;
		}
	}
	
	@Override
	public String verifychooseRoom(int clientnum, int chooseroom) throws Exception {
		if(chooseroom<0||chooseroom>4)
			throw new Exception("�߸� �Է��ϼ̽��ϴ�.");
		RoomVO vo = grade.get(chooseroom);
		if(clientnum>vo.getMaxnum())
			throw new ExceedClientException("�����Ͻ� ���� �ο� �ʰ��Դϴ�.");
		return vo.getGrade();
	}
	
	@Override
	public int setRoomprice(int clientnum, int choosenum) {
		RoomVO grade = getGrade(choosenum);
		if(clientnum<=grade.getPeoplenum())
			return grade.getPrice();
		else
			return grade.getPrice()+(clientnum-grade.getPeoplenum())*addprice;
	}

	@Override
	public List<RoomVO> listRoom() {
		return list;
	}

	@Override
	public void saveFile() {
		File f=new File(pathname);
		
		ObjectOutputStream oos=null;
		String s="���ȣ\t��\t����\t���\t�⺻�ο�\t�ִ��ο�\n";
		try {
			oos=new ObjectOutputStream(new FileOutputStream(f));
			for(RoomVO vo:list) {
				oos.writeObject(s);
				oos.writeObject(vo.toString());
			}
			System.out.println("���� ���� �Ϸ� !!!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(oos!=null)
				try {
				} catch (Exception e) {
			}
		}	
	}	
	@Override
	public void insertRoom(RoomVO vo)  {
		if(readRoom(vo.getNumber())!=null);
			
		list.add(vo);
	}

}