package resources;

import exceptions.*;

public class LinkedList<T> {
	private Node<T> firstNode;
	private Node<T> lastNode;
	
	public LinkedList(){ }
	
	// Inner method to find a Node element, specifying its index number
	private Node<T> getNode(int index){
		Node<T> currentNode = firstNode;
		
		for (int i = 0; i < index; i++){
			currentNode = currentNode.getNext();
		}
		
		return currentNode;
	}
	
	// Adds an element to the end of the list
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
	
	// Adds an element to the specified index number
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
	
	// Removes an element, depending on its index number
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
	
	// Removes the last element of the list
	public void removeLast() throws NonExistentListIndex{
		if (firstNode == null) { throw new NonExistentListIndex(0); }
		remove(size() - 1);
	}
	
	// Removes from the list all the occurrences of the element passed as an argument 
	public void remove(T obj){
		for (int i = 0; i < size(); i++){
			if (get(i).equals(obj)) { remove(i); }
		}
	}
	
	// Removes from the list the first occurrence of the element passed as an argument 
	public void removeFirstOcurrence(T obj){
		for (int i = 0; i < size(); i++){
			if (get(i).equals(obj)) { 
				remove(i);
				break;
			}
		}
	}
	
	// Removes from the list the elements from the first to the last index numbers
	public void removeSubSet(int firstIndex, int lastIndex) throws NonExistentListIndex{
		if (firstIndex > lastIndex) {	// If the first index number is larger than the second one, swap them
			int tempIndex = firstIndex;
			firstIndex = lastIndex;
			lastIndex = tempIndex;
		}
		
		if (firstIndex < 0) { throw new NonExistentListIndex(firstIndex); }	// Indexes validation
		if (lastIndex >= (size())) { throw new NonExistentListIndex(lastIndex); }

		Node<T> nextNode;
		Node<T> previousNode;
		
		if ((firstIndex == 0) && (lastIndex == (size() - 1))) {	// If the subset is the whole list
			clear();
			return;
		}
		
		if (firstIndex == 0) {		// If the subset begins with the first Node
			nextNode = getNode(lastIndex).getNext();
			previousNode = lastNode;
			previousNode.setNext(nextNode);
			firstNode = nextNode;
		} else {
			nextNode = getNode(lastIndex).getNext();
			previousNode = getNode(firstIndex - 1);
			previousNode.setNext(nextNode);
			
			if (lastIndex == (size() - 1)) {	// If the subset ends with the last node
				lastNode = previousNode;
			}
		}
	}

	// Copies the Linked List to an array of elements of the same type
	public void toArray(T[] array) throws ArrayNotLargeEnough{	// If the array is not large enough, throw an exception
		if (array.length < size()) { throw new ArrayNotLargeEnough(size() - array.length); }
		
		for (int i = 0; i < size(); i++){
			array[i] = get(i);
		}
	}
	
	// Returns the element stored at the specified index number
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
	
	// Returns the element stored at the end of the list
	public T getLast() throws NonExistentListIndex {
		if (firstNode == null){
			throw new NonExistentListIndex(0);
		} else {
			return lastNode.getObject();
		}
	}
	
	// Replaces the element at the specified index number, with the element passed as an argument
	public void set(int index, T obj) {
		remove(index);
		add(index, obj);
	}
	
// Methods to use the LinkedList as a Stack	
	// Adds and element to the end of the list (similar to add(), added for terminology reasons)
	public void push(T obj) {
		add(obj);
	}
	
	// Returns the last element of the list and removes it.
	/* This method works as pop() but is less efficient than a real Stack as it does not 
	 * use a Stack pointer, but the removeLast() method, and therefore needs to go over 
	 * the whole list to get the last element.  
	 */
	public T pop() {
		T poppedObject = getLast();
		removeLast();
		return poppedObject;
	}
	
	// Returns an int with the amount of elements on the list
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
	
	// Removes all the elements from the list
	public void clear(){ 
		firstNode = null;
		lastNode = null;
	}
	
	// Reverses the elements on the list, from the last to the first
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
	
	// Returns an in with the index of the element passed as an argument
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
	
	// Returns an Iterator element to use its methods to iterate trough the list elements
	public Iterator getIterator(){
		return new ListIterator();
	}
	
	// Iterator element to return
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
