package user1;

public class UserResult {
	private User user; // user ��ü�� �̷��� ����
	
	public UserResult(User user) {
		this.user = user; // userui���� �޾Ҵ� user ��ü�� ���� user�� ��ġ
	}
	
	public void write() {
		for(int i=0; i<user.getCount(); i++) {
			UserVO vo = user.listUser()[i];
			System.out.print(vo.getName()+"\t");
			System.out.print(vo.getAge()+"\t");
			System.out.println(vo.getAdult());
		}
		System.out.println();
	}
}
