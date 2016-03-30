package exception;

public class LivroDaoException extends GenericException{

	private static final long serialVersionUID = -5116807674076248444L;
	
	public LivroDaoException(){
		super();
	}
	
	public LivroDaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public LivroDaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public LivroDaoException(String message) {
		super(message);
	}

	public LivroDaoException(Throwable cause) {
		super(cause);
	}

}
