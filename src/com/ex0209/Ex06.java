package com.ex0209;

public class Ex06 {

	public static void main(String[] args) {
		LoginVO vo=new LoginVO();
		Login login=new Login();
		vo.setId("test");
		vo.setPwd("ex");
		
		boolean b=login.check(vo);
		
		if(b) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}

	}

}

class LoginVO{
	private String id;
	private String pwd;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}

class Login{
	public boolean check(LoginVO vo) {
		return vo.getId().equals("test")&&vo.getPwd().equals("test");
	}
}