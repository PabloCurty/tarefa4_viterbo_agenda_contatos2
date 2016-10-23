package exception;


public class UsernameException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public UsernameException(String msg){
		super(msg);
	}

}
