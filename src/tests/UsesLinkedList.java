package tests;

import resources.LinkedList;
import resources.Iterator;

public class UsesLinkedList {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		Integer aNumber = new Integer(642);
		String aString = "A String";
		Double aDouble = new Double(17.245);
		
		System.out.println("Using the LinkedList without generics, adding any type of objects: \n");
		System.out.println("Creating a new list...");
		list.add(aNumber);
		list.add(aString);
		list.add(aDouble);

		System.out.println(list + "\n");
		System.out.println("First Item: " + list.get(0));
		System.out.println("Last Item: " + list.getLast());
		System.out.println("List Size: " + list.size() + " items");
		System.out.println("");
		System.out.println("List Items:");
		
		for (int i = 0; i < list.size(); i++){
			System.out.println("\t" + (i+1) + ": " + list.get(i));
		}
		
		
		System.out.println("");
		System.out.println("Clearing the list...");
		list.clear();
		System.out.println("List Size: " + list.size() + " items\n");
		
		System.out.println("Creating a new list...");
		list.add("Another String");
		list.add(new Integer(242));
		list.add(true);
		list.add(new Double(10.42));
		
		System.out.println(list + "\n");
		System.out.println("Adding a String on the third index...");
		
		list.add(2, "Third Index");
		System.out.println(list + "\n");
		
		System.out.println("Removing the second item...");
		list.remove(1);
		System.out.println(list + "\n");
		
		System.out.println("Removing the last item...");
		list.removeLast();
		System.out.println(list + "\n");
		
		System.out.println("Removing the first item...");
		list.remove(0);
		System.out.println(list + "\n");
		
		System.out.println("Adding an Integer on the first index..");
		list.add(0, new Integer(43));
		System.out.println(list + "\n");
		
		System.out.println("Adding a Double on the last index..");
		list.add(3, new Double(1.99));
		System.out.println(list + "\n");
		
		System.out.println("Reversing the list..");
		list.reverse();
		System.out.println(list + "\n");
		
		System.out.println("Using the list's Iterator object to iterate through its items...\n ");
		Iterator iterator = list.getIterator();
		
		System.out.println("Iterating forward...");
		while (iterator.hasNext()){
			System.out.println("\t" + iterator.next());
		}
		
		System.out.println("");
		System.out.println("Iterating backwards...");
		while (iterator.hasPrevious()){
			System.out.println("\t" + iterator.previous());
		}
		
		System.out.println("");
		System.out.println("Using the LinkedList as a Stack with push() and pop()...\n");
		System.out.println("Pushing three objects...");
		
		list.push(new String("First pushed object"));
		list.push(new Integer(3));
		list.push(new Double(3.21));
		
		System.out.println(list + "\n");
		
		System.out.println("Popping two objects...");
		System.out.println(list.pop());
		System.out.println(list.pop());
		System.out.println(list + "\n");
		
		System.out.println("Replacing the third index with set()...");
		list.set(2, "3rd");
		System.out.println(list + "\n");
		
		System.out.println("Removing the true item with remove(E)...");
		list.remove(true);
		System.out.println(list + "\n");
		
		System.out.println("Adding to the list some similar objects to different index numbers..." );
		list.add(1, new Integer(10));
		list.add(new Integer(10));
		list.add(4, new Integer(10));
		System.out.println(list + "\n");
		
		System.out.println("Removing the first \"10\" item from the list using removeFirstOcurrence(E)...");
		list.removeFirstOcurrence(new Integer(10));
		System.out.println(list + "\n");
		
		System.out.println("Searching for the index number of an object with indexOf()...");
		System.out.println("\"First pushed object\" is on index number " + list.indexOf("First pushed object") + "\n");
		
		System.out.println("Clearing the list...");
		list.clear();
		System.out.println("List Size: " + list.size() + " items\n\n");
		
		////////////
		
		System.out.println("Using LinkedList<Integer>: \n");

		System.out.println("Creating a new list...");
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		list2.add(new Integer(32));
		list2.add(new Integer(999));
		list2.add(new Integer(2));

		System.out.println(list2 + "\n");
		System.out.println("First Item: " + list2.get(0));
		System.out.println("Last Item: " + list2.getLast());
		System.out.println("List Size: " + list2.size() + " items");
		System.out.println("");
		System.out.println("List Items:");
		
		for (int i = 0; i < list2.size(); i++){
			System.out.println("\t" + (i+1) + ": " + list2.get(i));
		}
		
		
		System.out.println("");
		System.out.println("Clearing the list...");
		list2.clear();
		System.out.println("List Size: " + list2.size() + " items\n");
		
		System.out.println("Creating a new list...");
		list2.add(new Integer(9));
		list2.add(new Integer(242));
		list2.add(new Integer(112323));
		list2.add(new Integer (55));
		
		System.out.println(list2 + "\n");
		System.out.println("Adding an Integer on the third index...");
		
		list2.add(2, new Integer(3));
		System.out.println(list2 + "\n");
		
		System.out.println("Removing the second item...");
		list2.remove(1);
		System.out.println(list2 + "\n");
		
		System.out.println("Removing the last item...");
		list2.removeLast();
		System.out.println(list2 + "\n");
		
		System.out.println("Removing the first item...");
		list2.remove(0);
		System.out.println(list2 + "\n");
		
		System.out.println("Adding an item on the first index..");
		list2.add(0, new Integer(43));
		System.out.println(list2 + "\n");
		
		System.out.println("Adding an item on the last index..");
		list2.add(3, new Integer(1));
		System.out.println(list2 + "\n");
		
		System.out.println("Reversing the list..");
		list2.reverse();
		System.out.println(list2 + "\n");
		
		System.out.println("Using the list's Iterator object to iterate through its items...\n ");
		Iterator iterator2 = list2.getIterator();
		
		System.out.println("Iterating forward...");
		while (iterator2.hasNext()){
			System.out.println("\t" + iterator2.next());
		}
		
		System.out.println("");
		System.out.println("Iterating backwards...");
		while (iterator2.hasPrevious()){
			System.out.println("\t" + iterator2.previous());
		}
		
		System.out.println("");
		System.out.println("Using the LinkedList as a Stack with push() and pop()...\n");
		System.out.println("Pushing three objects...");
		
		list2.push(new Integer(000));
		list2.push(new Integer(30));
		list2.push(new Integer(8555));
		
		System.out.println(list2 + "\n");
		
		System.out.println("Popping two objects...");
		System.out.println(list2.pop());
		System.out.println(list2.pop());
		System.out.println(list2 + "\n");
		
		System.out.println("Replacing the third index with set()...");
		list2.set(2, new Integer(909));
		System.out.println(list2 + "\n");
		
		System.out.println("Removing the \"909\" item with remove(E)...");
		list2.remove(new Integer(909));
		System.out.println(list2 + "\n");
		
		System.out.println("Adding to the list some similar objects to different index numbers..." );
		list2.add(1, new Integer(10));
		list2.add(new Integer(10));
		list2.add(4, new Integer(10));
		System.out.println(list2 + "\n");
		
		System.out.println("Removing the first \"10\" item from the list using removeFirstOcurrence(E)...");
		list2.removeFirstOcurrence(new Integer(10));
		System.out.println(list2 + "\n");
		
		System.out.println("Searching for the index number of an object with indexOf()...");
		System.out.println("112323 is on index number " + list2.indexOf(new Integer(112323)) + "\n");
		
		System.out.println("Removing the subset 0-2 from the list...");
		list2.removeSubSet(0, 2);
		System.out.println(list2 + "\n");
		
		System.out.println("Copying the list to an Integer array...");
		Integer[] intArray = new Integer[3];
		list2.toArray(intArray);
		System.out.println("Displaying the array: ");
		for (Integer numb : intArray){
			if (numb != null) { System.out.println("\t" + numb); }
		}
		
		System.out.println();
		System.out.println("Clearing the list...");
		list2.clear();
		System.out.println("List Size: " + list2.size() + " items\n");
		
		System.out.println("Trying to remove the second item, we get an error...");
		list2.remove(1);
	}

}
