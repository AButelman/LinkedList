package resources;

public class Node {
	private Object obj;
	private Node next;
	
	Node(Object obj, Node next){
		this.obj = obj;
		this.next = next;
	}
	
	public Object getObject() { return obj; }
	
	public Node getNext() { return next; }
	public void setNext(Node next){ this.next = next; }
	
	public String toString(){ return obj.toString(); }
}
