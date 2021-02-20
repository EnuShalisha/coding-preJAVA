package projectHotel1;

import java.util.List;

public interface Source {
	public void initialize();
	public void insertRoom(RoomVO vo);
	public RoomVO readRoom (String number);
	public List<RoomVO> listRoom();
	public void saveFile();
}
