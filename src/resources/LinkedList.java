package resources;

public class LinkedList {
	private Node firstNode;
	private Node lastNode;
	
	public LinkedList(){
		
	}
	
	// Adds an object to the end of the list
	public void add(Object obj){
		// If the list is empty we create a new node with no next node
		if (firstNode == null){		
			firstNode = new Node(obj, null);
			lastNode = firstNode;
			lastNode.setNext(firstNode);
			return;
		} else {
			Node newNode = new Node(obj, lastNode.getNext());
			lastNode.setNext(newNode);
			lastNode = newNode;
		}
	}
	
	// Tirar error si el índice es menor a 0 o mayor al último
	public void add(int index, Object obj) {
		if ((index == 0) && (firstNode == null)) {
			add(obj);
			return;
		}
		
		if (index == size() - 1){
			add(obj);
			return;
		}
		
		Node currentNode = getNode(index);
		Node newNode = new Node(obj, currentNode);

		if (index == 0) { 
			firstNode = newNode;
			lastNode.setNext(firstNode);
		} else {
			Node previousNode = getNode(index - 1);
			
			previousNode.setNext(newNode);
		}
		
		lastNode = getNode(size() - 1);
	}
	
	public void remove(int index){
		if (firstNode == null) { throw new NonExistentListIndex(0); }
		if ((index < 0) || (index > (size() - 1))) { throw new NonExistentListIndex(index); }
		
		Node currentNode;
		Node previousNode;
		
		if (index == 0) {
			currentNode = firstNode;
			previousNode = lastNode;
			previousNode.setNext(currentNode.getNext());
			firstNode = lastNode.getNext();
		} else {
			currentNode = getNode(index);
			previousNode = getNode(index - 1);
		}
		
		previousNode.setNext(currentNode.getNext());
		 
		lastNode = getNode(size() - 1);
	}
	
	public void removeLast() throws NonExistentListIndex{
		if (firstNode == null) { throw new NonExistentListIndex(0); }
		remove(size() - 1);
	}
	
	private Node getNode(int index){
		Node currentNode = firstNode;
		
		for (int i = 0; i < index; i++){
			currentNode = currentNode.getNext();
		}
		
		return currentNode;
	}
		
	public Object get(int index) throws NonExistentListIndex{
		if (firstNode == null) { throw new NonExistentListIndex(0); }
		if ((index < 0) || (index > (size() - 1))) { throw new NonExistentListIndex(index); }
		
		Node currentNode = firstNode;
		
		for (int i = 0; i < index; i++){
			currentNode = currentNode.getNext();
			
			if (currentNode.equals(firstNode)) {
				throw new NonExistentListIndex(index);
			}
		}
		
		return currentNode.getObject();
	}
	
	public Object getLast() throws NonExistentListIndex {
		if (firstNode == null){
			throw new NonExistentListIndex(0);
		} else {
			return get(size() - 1);
		}
	}	
	
	public int size(){
		int size = 0;
		Node currentNode = firstNode;
		
		if (currentNode == null) { return size; }
		
		do {
			currentNode = currentNode.getNext();
			size++;
		} while (!(currentNode.equals(firstNode)));
		
		return size;
	}
	
	public void clear(){ 
		firstNode = null;
		lastNode = null;
	}
	
	public void reverse() throws NonExistentListIndex {
		if (firstNode == null) { throw new NonExistentListIndex(0); }
		
		LinkedList reversedList = new LinkedList();
		
		for (int i = (size() - 1); i >=0; i--) {
			reversedList.add(this.get(i));
		}
		
		clear();
		
		for (int i = 0; i < reversedList.size(); i++){
			add(reversedList.get(i));
		}
	}
	
	public String toString(){
		if (firstNode == null) { return "[ ]"; }
		
		String text = "[ ";
		Node currentNode = firstNode;
		
		do {
			text = text + currentNode.toString();
			
			if (currentNode.getNext().equals(firstNode)) {
				text += " ]";
			} else {
				text += ", ";
			}
			
			if (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
		} while (!(currentNode.equals(firstNode)));
		
		return text;
	}
}
