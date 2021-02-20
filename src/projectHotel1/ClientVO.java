package projectHotel1;

public class ClientVO {
	String name;
	String region;
	String gender;
	int age;
	
	public ClientVO() {}
	public ClientVO(String name, String region, String gender, int age) {
		this.name=name; this.region=region; this.gender=gender;
		this.age=age;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
