package japangi;

public class Exceptions{
	
}
class UnderZeroException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public UnderZeroException(String msg) {
		super(msg);
	}
}
class ANumberException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ANumberException(String msg) {
		super(msg);
	}
}
class ExistenceException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ExistenceException(String msg) {
		super(msg);
	}
}
