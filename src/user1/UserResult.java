package user1;

public class UserResult {
	private User user; // user 개체를 이렇게 선언
	
	public UserResult(User user) {
		this.user = user; // userui에서 받았던 user 개체와 여기 user를 동치
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
