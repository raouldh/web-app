package nl.rdehaard.webapp.core.services.exceptions;

public class AccountDoesNotExistException extends RuntimeException {
	private static final long serialVersionUID = -5631423519017229693L;

	public AccountDoesNotExistException(Throwable cause) {
		super(cause);
	}

	public AccountDoesNotExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public AccountDoesNotExistException(String message) {
		super(message);
	}

	public AccountDoesNotExistException() {
	}
}
