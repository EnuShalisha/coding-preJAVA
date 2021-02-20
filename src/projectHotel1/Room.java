package projectHotel1;

import java.util.List;

public interface Room {
	public void initialize();
	public void insertRoom(RoomVO vo);
	public RoomVO readRoom (int number);
	public List<RoomVO> listRoom();
	public void saveFile();
}
