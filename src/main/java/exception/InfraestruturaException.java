package exception;

public class InfraestruturaException extends RuntimeException {

	private final static long serialVersionUID = 1;

	public InfraestruturaException(Exception msg) {
		super(msg);
	}
}