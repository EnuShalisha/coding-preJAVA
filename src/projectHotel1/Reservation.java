package projectHotel1;

public class Reservation {

	public void verifyClientnum(int clientnum) throws Exception {
		if(clientnum>6) {
			throw new ExceedClientException("���� ȣ���� �ִ� 6����� ������ �� �ֽ��ϴ�.\n ������ ������ ������ �ֽʽÿ�.");
		}
		if(clientnum<0) {
			throw new UnderZeroException("0�� ���Ϸ� �Է��� �� �����ϴ�.");
		}
		
		String s;
		switch(clientnum) {
		case 6: s="����Ʈ"; break;
		case 5: s="����Ʈ, �׷���"; break;
		default: s="����Ʈ, �׷���, �𷰽�"; break;
		}
		System.out.println("���Բ��� �̿� �����Ͻ� ����"+s+" �Դϴ�.");
	}
	
	public void 
}
