/*
 *
 */
package com.adargasystems.collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.adargasystems.collections.Shape.Color;

/**
 *
 * @author $Author$
 * @id $Id$
 *
 */
public class CollectionInterfaceTutorial {

	public CollectionInterfaceTutorial() {

	}

	public static void main(String[] args) {

		Collection<String> al = new ArrayList<String>();

		al.add("First string");
		al.add("Second string");
		al.add("Third string");

		System.out.println(al);

		Collection<String> ad = new ArrayDeque<String>(al);

		System.out.println(ad);

		Collection<String> containsAll = new ArrayDeque<String>();

		if (!containsAll.containsAll(ad)) {
			containsAll.addAll(ad);
			if (containsAll.containsAll(ad)) {
				System.out.println("addAll() adds one container to another");
			}
		}

		Collection<Integer> intList1 = new ArrayList<Integer>();

		intList1.add(1);
		intList1.add(2);
		intList1.add(3);
		intList1.add(4);

		Collection<Integer> intList2 = new ArrayList<Integer>();

		intList2.add(1);
		intList2.add(2);
		intList2.add(2);
		intList2.add(6);

		System.out.println(intList2);
		intList2.addAll(intList1);

		System.out.println(intList2);

		intList2.retainAll(intList1);
		System.out.println(intList2);

		Collection<Shape> myShapesCollection = new ArrayList<Shape>();

		myShapesCollection.add(new Circle(Color.RED, "Circle 1"));
		myShapesCollection.add(new Rectangle(Color.BLUE, "Rectangle 1"));
		myShapesCollection.add(new Circle(Color.RED, "Circle 2"));
		myShapesCollection.add(new Rectangle(Color.RED, "Rectangle 2"));
		myShapesCollection.add(new Circle(Color.BLUE, "Circle 3"));
		// myShapesCollection.add(null);

		myShapesCollection.stream().filter(e -> e.getColor() == Color.BLUE).forEach(e -> System.out.println(e));

		myShapesCollection.stream().forEach(e -> System.out.println(e));

		System.out.println("");

		prune(myShapesCollection);

		System.out.println("");

		myShapesCollection.stream().forEach(e -> System.out.println(e));

		System.out.println("");

		// myShapesCollection.removeAll(Collections.singleton(new Rectangle(
		// Color.BLUE, "Rectangle 1")));

		// myShapesCollection.stream().forEach(e -> System.out.println(e));

		Shape[] sa = myShapesCollection.toArray(new Shape[myShapesCollection.size()]);

		System.out.println("After toArray()");

		for (Shape s : sa) {
			System.out.println(s);
		}

	}

	static void prune(Collection<Shape> c) {

		for (Iterator<? extends Shape> it = c.iterator(); it.hasNext();) {

			// for (Iterator<Shape> it = c.iterator(); it.hasNext();){
			Shape p = it.next();
			if (!cond(p)) {
				System.out.println("Removing [" + p + "]");
				it.remove();
			}
		}
	}

	/**
	 * @param
	 * @param next
	 * @return
	 */
	private static <T extends Shape> boolean cond(T next) {
		return next.getColor() == Color.BLUE;
	}

}
