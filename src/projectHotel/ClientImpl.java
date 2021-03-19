package projectHotel;

import java.util.LinkedHashMap;
import java.util.Map;

public class ClientImpl implements Client {
	private Map<Integer, ClientVO> list = new LinkedHashMap<>();
	private int clientno=5;
	
	public ClientImpl() {
		initialize();
	}
	
	private void initialize() {
	
		ClientVO vo0 = new ClientVO("������", "����", "M", 20);
		ClientVO vo1 = new ClientVO("������", "��õ", "F", 25);
		ClientVO vo2 = new ClientVO("����ȯ", "����", "M", 27);
		ClientVO vo3 = new ClientVO("����", "��õ", "F", 23);
		ClientVO vo4 = new ClientVO("Ȳ��ȣ", "����", "M", 28);
		list.put(1, vo0);
		list.put(2, vo1);
		list.put(3, vo2);
		list.put(4, vo3);
		list.put(5, vo4);
	}
	
	@Override
	public ClientVO checkClient(int clientno) {
		if(list.containsKey(clientno))
			return list.get(clientno);
		return null;
	}
	

	@Override
	public void customerlist() {
		System.out.println("�̸�\t����\t����\t����");
		System.out.println("============================");
		for(int i:list.keySet()) {
			ClientVO vo = checkClient(i);
		 
			System.out.println(vo.getName()+"\t"+vo.getRegion()+"\t"+vo.getGender()+"\t"+vo.getAge());
			
		}
	}
	
	@Override
	public String verifyGender(String gender) throws NoGenderException {
		if(gender.equals("m")||gender.equals("M")) 
			return "M";
		else if(gender.equals("f")||gender.equals("F"))
			return "F";
		
		else if(gender.equals("M")||gender.equals("F")) {
			return gender;
		}
		else
			throw new NoGenderException("�ùٸ� ������ �ƴմϴ�.");
	}
	
	@Override
	public int inputInfo(ClientVO vo) {
		clientno++;
		list.put(clientno, vo);
		return clientno;
	}
}
