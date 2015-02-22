package nl.rdehaard.webapp.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
	private static final long serialVersionUID = 8494726012791676203L;

	public NotFoundException() {
	}

	public NotFoundException(Throwable cause) {
		super(cause);
	}
}