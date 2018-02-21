package exceptions;

public class ArrayNotLargeEnough extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private String message;

	public ArrayNotLargeEnough(int indexLeft) { 
		message = "Array not large enough to hold the LinkedList, it is " + indexLeft + " values short.";
	}

	public String getMessage(){ return message; }
	
}