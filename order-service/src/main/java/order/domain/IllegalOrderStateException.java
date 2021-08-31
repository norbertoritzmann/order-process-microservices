package order.domain;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Order request is not complete")
public class IllegalOrderStateException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public IllegalOrderStateException() {
	}

	public IllegalOrderStateException(final String message) {
		super(message);
	}

	public IllegalOrderStateException(final String message, final Throwable cause) {
		super(message, cause);
	}
}
