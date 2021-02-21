package projectHotel1;

import java.util.List;

public interface Room {
	public void initializeGrade();
	public void initializeRoom();
	public RoomVO getGrade(int num);
	public void insertRoom(RoomVO vo);
	public int verifyClientnum(int clientnum) throws Exception;
	public String verifychooseRoom(int clientnum, int chooseroom) throws Exception;
	public void chooseRoom(int clientnum);
	public RoomVO readRoom (int number);
	public List<RoomVO> listRoom();
	public void saveFile();
	public void modifyRoom();
	public int setRoomprice(int clientnum, int choosenum);
}
