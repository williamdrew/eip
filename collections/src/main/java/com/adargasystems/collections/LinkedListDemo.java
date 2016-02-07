package com.adargasystems.collections;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDemo {

	public static void main(String[] args) {

		// create a LinkedList
		LinkedList<Person> list = new LinkedList<Person>();

		// add some elements
		list.add(new Person("Dave", 3));
		list.add(new Person("Steve", 11));
		list.add(new Person("Bob", 1));
		list.add(new Person("Jasper", 5));

		list.sort(new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				if (p1 == p2) {
					return 0;
				}

				if (p1.equals(p2)) {
					return 0;
				}

				return ((p1.getId() > p2.getId()) ? 1 : -1);
			}

		});

		// print the list
		System.out.println("LinkedList : " + list);

		// set Iterator as descending
		Iterator<Person> x = list.descendingIterator();

		// print list with descending order
		while (x.hasNext()) {
			System.out.println(x.next());
		}
	}
}