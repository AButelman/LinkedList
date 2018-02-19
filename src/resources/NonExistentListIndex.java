package resources;

public class NonExistentListIndex extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private static final String name = "NonExistentListIndex";
	private int indexNumber;
	private String message;
	
	public NonExistentListIndex(int index){
		indexNumber = index;
		
		if (indexNumber == 0) {
			message = "Empty list.";
		} else {
			message = indexNumber + " is an out of range index number.";
		}
	}

	@Override
	public String getMessage(){ return message;	}
	
	@Override
	public String toString(){
		return name + ". " + getMessage();
	}
}
