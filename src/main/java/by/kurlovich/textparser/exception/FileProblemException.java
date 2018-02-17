package by.kurlovich.textparser.exception;

public class FileProblemException extends Exception {
	private static final long serialVersionUID = 1L;

	public FileProblemException() {
		super();
	}

	public FileProblemException(String message) {
		super(message);
	}

	public FileProblemException(Exception e) {
		super(e);
	}

	public FileProblemException(String message, Exception e) {
		super(message, e);
	}
}
