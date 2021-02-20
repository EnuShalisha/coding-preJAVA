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
		//�̸� ���� ���� ����
		ClientVO vo1 = new ClientVO("������", "��õ", "F", 25);
		ClientVO vo2 = new ClientVO("����ȯ", "����", "M", 27);
		ClientVO vo3 = new ClientVO("����", "��õ", "F", 23);
		ClientVO vo4 = new ClientVO("Ȳ��ȣ", "����", "M", 20);
		
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
			throw new NoGenderException("�ùٸ� ������ �ƴմϴ�.");
	}
	
	public int inputInfo(ClientVO vo) {
		clientno++;
		list.put(clientno, vo);
		return clientno;
	}
	
	
	
}
