package resources;

public class ArrayNotLargeEnough extends RuntimeException {
	private String message;
	private int indexLeft;

	ArrayNotLargeEnough(int indexLeft) { 
		this.indexLeft = indexLeft;
		message = "Array not large enough to hold the LinkedList, " + indexLeft + " short.";
	}

	public String getMessage(){ return message; }
	
}