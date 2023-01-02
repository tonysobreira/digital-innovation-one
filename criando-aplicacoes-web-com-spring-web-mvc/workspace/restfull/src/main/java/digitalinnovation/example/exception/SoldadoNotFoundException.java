package digitalinnovation.example.exception;

public class SoldadoNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public SoldadoNotFoundException() {
	}

	public SoldadoNotFoundException(String message) {
		super(message);
	}

}
