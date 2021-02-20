package fscore1;

public class DuplicationException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private String msg;
	
	public DuplicationException(String msg) {
		super(msg);
		
		this.msg=msg;
	}

	@Override
	public String getMessage() {
		return msg;
	}
}
