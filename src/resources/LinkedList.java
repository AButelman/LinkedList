// AGREGUÉ EL ITERADOR, AGREGAR LOS MÉTODOS QUE PUSE EN ORT CUANDO LOS TRAIGA
package resources;

import exceptions.*;

public class LinkedList<T> {
	private Node<T> firstNode;
	private Node<T> lastNode;
	
	public LinkedList(){ }
	
	// Inner method to find a Node object, specifying its index number
	private Node<T> getNode(int index){
		Node<T> currentNode = firstNode;
		
		for (int i = 0; i < index; i++){
			currentNode = currentNode.getNext();
		}
		
		return currentNode;
	}
	
	// Adds an object to the end of the list
	public void add(T obj){
		// If the list is empty we create a new node with no next node
		if (firstNode == null){		
			firstNode = new Node<T>(obj, null);
			lastNode = firstNode;
			lastNode.setNext(firstNode);
			return;
		} else {
			Node<T> newNode = new Node<T>(obj, lastNode.getNext());
			lastNode.setNext(newNode);
			lastNode = newNode;
		}
	}
	
	// Adds an object to the specified index of the list
	public void add(int index, T obj) throws NonExistentListIndex {
		if ((index < 0 ) || (index > size())) { throw new NonExistentListIndex(index); }
		
		if ((index == 0) && (firstNode == null)) {
			add(obj);
			return;
		}
		
		if (index == size()){
			add(obj);
			return;
		}
		
		Node<T> currentNode = getNode(index);
		Node<T> newNode = new Node<T>(obj, currentNode);

		if (index == 0) { 
			firstNode = newNode;
			lastNode.setNext(firstNode);
		} else {
			Node<T> previousNode = getNode(index - 1);
			
			previousNode.setNext(newNode);
		}
		
		lastNode = getNode(size() - 1);
	}
	
	// Removes an object from the list, according to its index number
	public void remove(int index){
		if (firstNode == null) { throw new NonExistentListIndex(0); }
		if ((index < 0) || (index > (size() - 1))) { throw new NonExistentListIndex(index); }
		
		Node<T> currentNode;
		Node<T> previousNode;
		
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
	
	// Removes the last of the list
	public void removeLast() throws NonExistentListIndex{
		if (firstNode == null) { throw new NonExistentListIndex(0); }
		remove(size() - 1);
	}
	
	// Removes from the list all the occurrences of the object passed as an argument 
	public void remove(T obj){
		for (int i = 0; i < size(); i++){
			if (get(i).equals(obj)) { remove(i); }
		}
	}
	
	// Removes from the list the first occurrence of the object passed as an argument 
	public void removeFirstOcurrence(T obj){
		for (int i = 0; i < size(); i++){
			if (get(i).equals(obj)) { 
				remove(i);
				break;
			}
		}
	}
	
	// NEW METHOD, ORT
	public void removeSubSet(int firstIndex, int lastIndex) {
		if (firstIndex > lastIndex) {
			int tempIndex = firstIndex;
			firstIndex = lastIndex;
			lastIndex = tempIndex;
		}

		for (int i = firstIndex; i <= lastIndex; i++){
			remove(i);
		}
	}

	// NEW METHOD, ORT
	public void toArray(T[] array) throws ArrayNotLargeEnough{
		if (array.length > size()) { throw ArrayNotLargeEnough(size() - array.length); }
		
		for (int i = 0; i < size(); i++){
			array[i] = get(i);
		}
	}
	
	// Returns the object stored at the specified index number
	public T get(int index) throws NonExistentListIndex{
		if (firstNode == null) { throw new NonExistentListIndex(0); }
		if ((index < 0) || (index > (size() - 1))) { throw new NonExistentListIndex(index); }
		
		Node<T> currentNode = firstNode;
		
		for (int i = 0; i < index; i++){
			currentNode = currentNode.getNext();
			
			if (currentNode.equals(firstNode)) {
				throw new NonExistentListIndex(index);
			}
		}
		
		return currentNode.getObject();
	}
	
	// Returns the object stored at the end of the list
	public T getLast() throws NonExistentListIndex {
		if (firstNode == null){
			throw new NonExistentListIndex(0);
		} else {
			return lastNode.getObject();
		}
	}
	
	// Replaces the object at the specified index number, with the object passed as an argument
	public void set(int index, T obj) {
		remove(index);
		add(index, obj);
	}
	
// Methods to use the LinkedList as a Stack	
	// Adds and object to the end of the list
	public void push(T obj) {
		add(obj);
	}
	
	// Removes the last item from the list and returns it.
	/* This method works as pop() but is less efficient than a real Stack as it does not 
	 * use a Stack pointer, but the removeLast() method, and therefore needs to go over 
	 * the whole list to get the the last object.  
	 */
	public T pop() {
		T poppedObject = getLast();
		removeLast();
		return poppedObject;
	}
	
	// Returns an int with the amount of items on the list
	public int size(){
		int size = 0;
		Node<T> currentNode = firstNode;
		
		if (currentNode == null) { return size; }
		
		do {
			currentNode = currentNode.getNext();
			size++;
		} while (!(currentNode.equals(firstNode)));
		
		return size;
	}
	
	// Removes all the items from the list
	public void clear(){ 
		firstNode = null;
		lastNode = null;
	}
	
	// Reverses the items on the list, from the last to the first
	public void reverse() throws NonExistentListIndex {
		if (firstNode == null) { throw new NonExistentListIndex(0); }
		
		LinkedList<T> reversedList = new LinkedList<T>();
		
		for (int i = (size() - 1); i >=0; i--) {
			reversedList.add(this.get(i));
		}
		
		clear();
		
		for (int i = 0; i < reversedList.size(); i++){
			add(reversedList.get(i));
		}
	}
	
	// Returns an in with the index of the Object passed as an argument
	public int indexOf(T obj) throws ObjectNotFound {
		int index = 0;
		
		for (;index < size(); index++) {
			if (get(index).equals(obj)) {
				return index;
			}
		}
		throw new ObjectNotFound();
	}
	
	// Returns a String with the format: [ E0.toString(), E1.toString()... ]
	@Override
	public String toString(){
		if (firstNode == null) { return "[ ]"; }
		
		String text = "[ ";
		Node<T> currentNode = firstNode;
		
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
	
	// Returns an Iterator object to use its methods to iterate trough the list items
	public Iterator getIterator(){
		return new ListIterator();
	}
	
	// Iterator object to return
	private class ListIterator implements Iterator{
		int index = 0;
		
		@Override
		public boolean hasNext() {
			if (index < size()) { return true; }
			return false;
		}

		@Override
		public boolean hasPrevious() {
			if ((index - 1) >= 0) { return true; }
			return false;
		}

		@Override
		public T next() {
			if (hasNext()) { 
				T obj = get(index);
				index++;
				return obj;
			}
			return null;
		}

		@Override
		public T previous() {
			if (hasPrevious()) {
				index--;
				T obj = get(index);
				return obj;
			}
			return null;
		}
		
	}
}
