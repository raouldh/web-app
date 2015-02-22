package nl.rdehaard.webapp.core.services.exceptions;

public class BlogExistsException extends RuntimeException {
	private static final long serialVersionUID = -5351746431250430124L;

	public BlogExistsException() {
	}

	public BlogExistsException(String message) {
		super(message);
	}

	public BlogExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public BlogExistsException(Throwable cause) {
		super(cause);
	}
}
