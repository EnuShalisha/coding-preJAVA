package projectHotel1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class RoomImpl implements Room{
	private String pathname="room.txt";
	
	public RoomImpl() {
		initialize();
	}
	
	private List<RoomVO> list = new ArrayList<>();

	@Override
	public void initialize() {
		for(int i=0; i<10; i++) {
			RoomVO vo = new RoomVO("디럭스", 50000, 2, 201+i, 2, 4);
			insertRoom(vo);
			
		}
		for(int i=0; i<8; i++) {
			RoomVO vo = new RoomVO("그랜드", 80000, 3, 301+i, 3, 5);
			insertRoom(vo);
		}
		for(int i=0; i<5; i++) {
			RoomVO vo = new RoomVO("스위트", 150000, 4, 401+i, 4, 6);
			insertRoom(vo);
		}
		
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

