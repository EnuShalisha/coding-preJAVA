package projectHotel;

public class CannotReserveException extends Exception{

	private static final long serialVersionUID = 1L;
	public CannotReserveException(String msg) {
		super(msg);
}
}