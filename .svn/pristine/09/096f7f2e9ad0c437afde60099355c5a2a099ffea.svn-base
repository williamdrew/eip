/*
 *
 */
package com.adargasystems.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import com.adargasystems.collections.Shape.Color;

/**
 *
 * @author $Author$
 * @id $Id$
 *
 *     There are 2 concrete implementations for the List interface. ArrayList()
 *     and LinkedList().
 *
 */
public class ListTutorial {

	private List<Shape> arrayList = new ArrayList<Shape>();
	private List<Shape> linkedList = new LinkedList<Shape>();

	public ListTutorial() {

		arrayList.add(new Circle(Color.RED, "Circle 1"));
		arrayList.add(new Rectangle(Color.BLUE, "Rectangle 1"));
		arrayList.add(new Circle(Color.GREEN, "Circle 2"));

		System.out.println("");
		arrayList.stream().forEach(e -> System.out.println(e));

		List<Shape> arrayList2Append = new ArrayList<Shape>();

		arrayList2Append.add(new Circle(Color.RED, "Circle 3"));
		arrayList2Append.add(new Circle(Color.GREEN, "Circle 4"));
		arrayList2Append.add(new Rectangle(Color.BLUE, "Rectangle 2"));
		Shape s = new Circle(Color.GREEN, "Circle 4");
		arrayList2Append.add(s);

		arrayList2Append.set((arrayList2Append.size() - 1), new Circle(
				Color.GREEN, "Circle 5"));
		System.out.println("Bottom of arrayList2Append = "
				+ arrayList2Append.get(arrayList2Append.size() - 1));
		System.out.println("Top of arrayList2Append = "
				+ arrayList2Append.get(0));

		System.out.println("First green circle is at ["
				+ arrayList2Append.indexOf(s) + "] in a list of ["
				+ arrayList2Append.size() + "] shapes.");
		System.out.println("Last green circle is at ["
				+ arrayList2Append.lastIndexOf(s) + "] in a list of ["
				+ arrayList2Append.size() + "] shapes.");

		System.out.println("arrayList2Append");
		arrayList2Append.stream().forEach(e -> System.out.println(e));

		Collections.shuffle(arrayList2Append);
		System.out.println("arrayList2Append after shuffle");
		arrayList2Append.stream().forEach(e -> System.out.println(e));

		ListIterator<Shape> liShapes = arrayList2Append.listIterator();

		while (liShapes.hasNext()) {
			System.out.println("Next index = " + liShapes.nextIndex());
			//System.out.println("Previous index = " + liShapes.previousIndex());
//			if (liShapes.previousIndex() >= 0) {
//				System.out.println(liShapes.previous());
//			}
			System.out.println(liShapes.next());
		}

		String name = new String("William Drew");
		
		String firstName = name.substring(0, name.indexOf(' '));
		
		System.out.println(firstName);
		
		// arrayList.addAll(arrayList2Append);
		//
		// System.out.println("");
		// arrayList.stream().forEach(e -> System.out.println(e));

		// utilizes ArrayList's standard conversion ctor
		List<Shape> a3 = new ArrayList<Shape>(arrayList2Append);
		a3.addAll(arrayList);

		System.out.println("");
		a3.stream().forEach(e -> System.out.println(e));

	}

	public static void main(String[] args) {
		new ListTutorial();
	}
}
