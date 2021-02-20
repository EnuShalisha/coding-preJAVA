package projectHotel1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Room implements Source{
	private String pathname="room.txt";
	
	public Room() {
		initialize();
	}
	
	private List<RoomVO> list = new ArrayList<>();

	@Override
	public void initialize() {
		RoomVO vo2 = new RoomVO("디럭스", 50000, 2, "201", 2);
		RoomVO vo3 = new RoomVO("그랜드", 80000, 3, "301", 4);
		RoomVO vo4 = new RoomVO("스위트", 150000, 4, "401", 6);
		try {
			insertRoom(vo2);
			insertRoom(vo3);
			insertRoom(vo4);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public RoomVO readRoom(String number) {
		RoomVO vo=null;
		for(RoomVO vv:list) {
			if(vv.getNumber().equals(number)) {
				vo=vv;
				break;
			}
		}
		return vo;
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
}

