package com.cybage.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Vector;

public class Assignment {

	public static void main(String[] args) {

		// PrintEvenNumber(-10,10); //Q1

		// OperationOnList(new ArrayList()); //Q2
		// OperationOnList(new LinkedList());//Q2
		// OperationOnList(new Vector());//Q2

		// pass any list to CountDuplicateInList() method it will give us count
		// List<Object> list = new ArrayList<Object>(Arrays.asList("aa", "bb", "aa",
		// "ac", "ba"));
		// CountDuplicateInList(list);// Q3

		// Different operation on map
		// OperatiOnOnMap();//Q4

		//List ll=new ArrayList(Arrays.asList("a","s","d","f"));
		//SearchingSortingOnCollection(ll);
		
	}

	//this method sort the collections and use binary search
	public static void SearchingSortingOnCollection(List cl) {
		System.out.println(Collections.binarySearch(cl, "f"));
		Collections.sort(cl);
		System.out.println(cl);
		
	}

	// ---------------------Q4 Operation on map-------------------------
	public static void OperatiOnOnMap() {
		// creating map object
		Map<String, Integer> hm = new HashMap<String, Integer>();
		// Adding Object into map
		hm.put("a", new Integer(100));
		hm.put("b", new Integer(200));
		hm.put("c", new Integer(300));
		hm.put("d", new Integer(400));

		// Iterating map
		for (Map.Entry<String, Integer> me : hm.entrySet()) {
			System.out.print("key : " + me.getKey() + " = value : ");
			System.out.println(me.getValue());
		}

		System.out.println("Contain key check : " + hm.containsKey("a"));// checks if key is present
		System.out.println("contains value check : " + hm.containsValue(100));// checks if value present
		System.out.println("Remove element from map using key value pair : " + hm.remove("d", 400));// remove element
																									// from map
		System.out.println("replace element value : " + hm.replace("c", 300, 400));// replace old value with new value,
																					// return true
		System.out.println("retrieve set of keys : " + hm.keySet());// retrieve set of keys
		System.out.println("Put key values if absent in map " + hm.putIfAbsent("d", 300));// put element in map if
																							// absent ion map
		System.out.println("It will return previous value : " + hm.replace("c", 300));// after replacing it will return
																						// previous value

	}

	// ---------------------Q3.Count Duplicate in list----------------
	public static void CountDuplicateInList(List<Object> list) {
		Map<Object, Integer> map = new HashMap<>();
		for (Object r : list) {
			if (map.containsKey(r)) {
				map.put(r, map.get(r) + 1);
			} else {
				map.put(r, 1);
			}
		}
		for (Map.Entry<Object, Integer> entry : map.entrySet()) {
			System.out.printf("%s : %d %n ", entry.getKey(), entry.getValue());
		}
	}

	// -----------------------Q2.operation on list--------------------
	public static void OperationOnList(List<Object> list) {

		// 1.Adding Object into list------------------
		list.add("hello");
		list.add("cybagian");
		list.add("we");
		list.add("will");
		list.add("meet");
		list.add("soon");

		// 2.iterated using foreach loop and iterator---------------
		// iterate using foreach loop
		System.out.println("\nIterate using foreach");
		list.forEach(name -> System.out.println(((String) name).toLowerCase()));
		System.out.println("\nIterator using iterator object ");

		// iterate using Iterator
		ListIterator iterator = list.listIterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println();

		// 3.To remove object from any particular index---------------
		list.remove(list.size() - 1);
		System.out.println("object removed from last index");

		// 4.To get Object from particular index----------------------
		System.out.println("object retrieved from last index = " + list.get(list.size() - 1));
	}

	// ----------------Q1. Method to print even numbers---------------------
	public static void PrintEvenNumber(int num1, int num2) {
		if (num1 <= num2) {
			for (int i = num1; i <= num2; i++) {
				if (i % 2 == 0) {
					System.out.println(i + " is Even number.");
				}
			}
		} else {
			System.err.println("please provide valid parameter eg. param 1 should be less than or equal to param 2");
		}
	}

}
