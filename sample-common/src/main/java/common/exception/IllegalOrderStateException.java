package common.exception;

public class IllegalOrderStateException extends RuntimeException
{

	private static final long serialVersionUID = 1L;

	public IllegalOrderStateException()
	{
	}

	public IllegalOrderStateException(final String message)
	{
		super(message);
	}

	public IllegalOrderStateException(final String message, final Throwable cause)
	{
		super(message, cause);
	}
}
