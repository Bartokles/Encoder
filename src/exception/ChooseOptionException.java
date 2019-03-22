package exception;

public class ChooseOptionException extends Exception {

 	private static final String MESSAGE = "Wybierz rodzaj szyfrowania!";
	
 	public ChooseOptionException() {
 		super(MESSAGE);
 	}
 	
	public ChooseOptionException(String message) {
		super(message);
	}
	
}
