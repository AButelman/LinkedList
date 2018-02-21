package exceptions;

public class ObjectNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private static final String name = "ObjectNotFound";
	private String message;
	
	public ObjectNotFound(){ message = "Object not found on the list"; }
	
	@Override
	public String getMessage(){ return message;	}
	
	@Override
	public String toString(){
		return name + ". " + getMessage();
	}

}
