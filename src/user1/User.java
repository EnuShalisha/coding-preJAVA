package user1;

public class User {
	private UserVO[] list; // 중요한 변수
	private int count;
	
	public User() {
		allocation(10);
	}
	
	private void allocation(int capacity) {
		UserVO[] temp = new UserVO[capacity];
		if(list!=null && count>0) {
			System.arraycopy(list, 0, temp, 0, count);
		}
		list=temp;
	}
	
	public int append(UserVO vo) {
		if(count>=list.length) {
			allocation(list.length+10);
		}
		list[count++] = vo;
		
		return count;
	}
	
	public int getCount() {
		return count;
	}
	
	public UserVO[] listUser() {
		return list;
	}
}
