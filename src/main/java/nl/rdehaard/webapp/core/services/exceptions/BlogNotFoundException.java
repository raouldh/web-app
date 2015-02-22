package nl.rdehaard.webapp.core.services.exceptions;

public class BlogNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 9029280074590857056L;

	public BlogNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public BlogNotFoundException(String message) {
		super(message);
	}

	public BlogNotFoundException() {
	}
}
