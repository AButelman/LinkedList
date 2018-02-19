package tests;

import resources.LinkedList;

public class UsesLinkedList {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		Integer aNumber = new Integer(642);
		String aString = "A String";
		Double aDouble = new Double(17.245);
		
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
		
		System.out.println("Clearing the list...");
		list.clear();
		System.out.println("List Size: " + list.size() + " items\n");
		
		System.out.println("Trying to remove the second item, we get an error...");
		list.remove(1);
		
	}

}
