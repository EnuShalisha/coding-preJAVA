package projectHotel;

public class CheckInDateWrongException extends Exception {

	private static final long serialVersionUID = 1L;
	public CheckInDateWrongException(String msg) {
		super(msg);
	}
}