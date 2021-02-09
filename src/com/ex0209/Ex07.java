package com.ex0209;
//예외의 상황에 따른 분류 - 사용자 정의 예외클래스
public class Ex07 {

	public static void main(String[] args) {
		LoginVO2 vo=new LoginVO2();
		Login2 login=new Login2();
		vo.setId("test");
		vo.setPwd("ex");
		
		try {
			login.check(vo);
		} catch (LoginException e) {
			System.out.println("아이디 또는 패스워드가 일치하지 않습니다.");
		}catch (Exception e) {
			e.printStackTrace();
		}
		}

	}

class LoginException extends Exception{

	private static final long serialVersionUID = 1L; // 직렬화 나중에 배움
	
	public LoginException(String msg) {
		super(msg);
	}
	
}


class LoginVO2{
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

class Login2{
	public void check(LoginVO2 vo) throws Exception{
		if(!vo.getId().equals("test")||!vo.getPwd().equals("test"))
			throw new Exception("로그인 에러");
	}
}