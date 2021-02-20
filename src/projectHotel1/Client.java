package projectHotel1;

import java.util.LinkedHashMap;
import java.util.Map;

public class Client {
	private Map<Integer, ClientVO> list = new LinkedHashMap<>();
	private int clientno=4;
	
	public Client() {
		initialize();
	}
	
	private void initialize() {
		//이름 지역 성별 나이
		ClientVO vo1 = new ClientVO("정주희", "인천", "F", 25);
		ClientVO vo2 = new ClientVO("최재환", "서울", "M", 27);
		ClientVO vo3 = new ClientVO("고여울", "인천", "F", 23);
		ClientVO vo4 = new ClientVO("황성호", "서울", "M", 20);
		
		list.put(1, vo1);
		list.put(2, vo2);
		list.put(3, vo3);
		list.put(4, vo4);
	}
	
	public ClientVO checkClient(int clientno) {
		if(list.containsKey(clientno))
			return list.get(clientno);
		return null;
	}
	
	public String verifyGender(String gender) throws NoGenderException {
		if(gender.equals("m")) 
			return "M";
		else if(gender.equals("w"))
			return "W";
		
		else if(gender.equals("M")||gender.equals("F")) {
			return gender;
		}
		else
			throw new NoGenderException("올바른 성별이 아닙니다.");
	}
	
	public int inputInfo(ClientVO vo) {
		clientno++;
		list.put(clientno, vo);
		return clientno;
	}
	
	
	
}
