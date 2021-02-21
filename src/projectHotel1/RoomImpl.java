package projectHotel1;

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
		addprice=20000;
	}
	
	private List<RoomVO> list = new ArrayList<>();
	private List<RoomVO> grade = new ArrayList<RoomVO>();
	private int addprice;
	
	@Override
	public void initializeGrade() {
		RoomVO vo1 = new RoomVO("스위트", 150000, 4, 4, 6);
		RoomVO vo2 = new RoomVO("그랜드", 80000, 3, 3, 5);
		RoomVO vo3 = new RoomVO("디럭스", 50000, 2, 2, 4);
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
			RoomVO vo = vo1;
			vo.setNumber(401+i);
			insertRoom(vo);	
		}
		for(int i=0; i<8; i++) {
			RoomVO vo = vo2;
			vo.setNumber(301+i);
			insertRoom(vo);
		}
		for(int i=0; i<10; i++) {
			RoomVO vo = vo3;
			vo.setNumber(201+i);
			insertRoom(vo);
		}
		
	}
	
	@Override
	public RoomVO getGrade(int num) {
		RoomVO vo = grade.get(num);
		return vo;
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
			throw new ExceedClientException("저희 호텔은 최대 "+vo1.getMaxnum()+"명까지 수용할 수 있습니다.\n 예약을 여러번 진행해 주십시오.");
		}
		if(clientnum<0) {
			throw new UnderZeroException("0명 이하로 입력할 수 없습니다.");
		}
		return clientnum;
	}
	
	@Override
	public void chooseRoom(int clientnum) {
		System.out.println("방은 다음과 같이 준비돼있습니다.");
		System.out.println("추가요금: 기본 투숙인원 추가시 인당 2만원");
		
		RoomVO vo1=grade.get(0);
		RoomVO vo2=grade.get(1);
		RoomVO vo3=grade.get(2);
		
		String suite=vo1.getGrade()+": "+vo1.getPrice()+"원, 기본 인원 "+vo1.getPeoplenum()+"명, 최대 인원 "+vo1.getMaxnum()+"명";
		String grand=vo2.getGrade()+": "+vo2.getPrice()+"원, 기본 인원 "+vo2.getPeoplenum()+"명, 최대 인원 "+vo2.getMaxnum()+"명";
		String delxue=vo3.getGrade()+": "+vo3.getPrice()+"원, 기본 인원 "+vo3.getPeoplenum()+"명, 최대 인원 "+vo3.getMaxnum()+"명";
		String quest="어떤 방을 선택하시겠습니까?";
		String suite_menu="1. 예약 취소 2. "+vo1.getGrade();
		String grand_menu="1. 예약 취소 2. "+vo1.getGrade()+" 3. "+vo2.getGrade();
		String deluxe_menu="1. 예약 취소 2. "+vo1.getGrade()+" 3. "+vo2.getGrade()+" 4. "+vo3.getGrade();
		
		switch(clientnum) {
		case 6: System.out.println(suite+"\n"+quest+"\n"+suite_menu); break;
		case 5: System.out.println(suite+"\n"+grand+"\n"+quest+"\n"+grand_menu); break;
		default: System.out.println(suite+"\n"+grand+"\n"+delxue+"\n"+quest+"\n"+deluxe_menu); break;
		}
	}
	
	@Override
	public String verifychooseRoom(int clientnum, int chooseroom) throws Exception {
		if(chooseroom<0||chooseroom>4)
			throw new Exception("잘못 입력하셨습니다.");
		RoomVO vo = grade.get(chooseroom);
		if(clientnum>vo.getMaxnum())
			throw new Exception("선택하신 방은 인원 초과입니다.");
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
		
		try {
			oos=new ObjectOutputStream(new FileOutputStream(f));
			for(RoomVO vo:list) {
				oos.writeObject(vo);
			}
			System.out.println("파일 저장 완료 !!!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(oos!=null)
				try {
				} catch (Exception e2) {
				}
		}	
	}	
	@Override
	public void insertRoom(RoomVO vo)  {
		if(readRoom(vo.getNumber())!=null);
			
		list.add(vo);
	}

	@Override
	public void modifyRoom() {
		// TODO Auto-generated method stub
		
	}

	
}

