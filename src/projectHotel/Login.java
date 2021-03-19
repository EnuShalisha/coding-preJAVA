package projectHotel;

public class Login {
	private int get;
	private int password=1234;
	
	public void setGet(int get) {
		this.get = get;
	}

	public boolean mode() {
		if(password==get)
			return true;
		return false;
		
}

}
