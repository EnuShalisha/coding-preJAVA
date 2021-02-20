package util;

public class Ex02rfl {

	public static void main(String[] args) {
		// User u = new UserImpl();
		
		// ?€λ₯? λ°©λ²?Όλ‘? κ°μ²΄ ??±"
		
		String clsName="git.ex0129.Ex02rfl";
		
		try {
			Class<?> cls = Class.forName(clsName);
			
			//κ°μ²΄ ??±
			
			User u=(User)cls.newInstance();
			
			int s=u.add(10, 5);
			u.print("?©", s);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}

interface User{
	public int add(int a, int b);
	public void print(String title, int result);
}

class UserImpl implements User{

	@Override
	public int add(int a, int b) {
		return a+b;
	}

	@Override
	public void print(String title, int result) {
		System.out.println(title+"->"+result);
		
	}
	
}