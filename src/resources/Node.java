package resources;

public class Node<T> {
	private T obj;
	private Node<T> next;
	
	Node(T obj, Node<T> next){
		this.obj = obj;
		this.next = next;
	}
	
	public T getObject() { return obj; }
	
	public Node<T> getNext() { return next; }
	public void setNext(Node<T> next){ this.next = next; }
	
	public String toString(){ return obj.toString(); }
}
