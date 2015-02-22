package nl.rdehaard.webapp.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 1511667662520594105L;

	public BadRequestException() {
	}

	public BadRequestException(Throwable cause) {
		super(cause);
	}
}
