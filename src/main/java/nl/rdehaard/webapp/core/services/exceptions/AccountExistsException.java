package nl.rdehaard.webapp.core.services.exceptions;

public class AccountExistsException extends RuntimeException {
	private static final long serialVersionUID = 1520271323554034833L;

	public AccountExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public AccountExistsException(String message) {
		super(message);
	}

	public AccountExistsException() {
		super();
	}

}
