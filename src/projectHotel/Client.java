package projectHotel;

public interface Client {

	ClientVO checkClient(int clientno);

	void customerlist();

	String verifyGender(String gender) throws NoGenderException;

	int inputInfo(ClientVO vo);

}