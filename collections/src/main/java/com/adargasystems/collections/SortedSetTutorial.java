/*
 *
 */
package com.adargasystems.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import com.adargasystems.collections.Shape.Color;

/**
 *
 * @author $Author$
 * @id $Id$
 *
 */
public class SortedSetTutorial {

	private class PersonIdComparator implements Comparator<Person> {

		@Override
		public int compare(Person o1, Person o2) {
			System.out.println("Comparing " + o2 + " to " + o1);

			if (o1.getId() != o2.getId()) {
				if (o1.getId() > o2.getId()) {
					System.out.println(o1 + " > " + o2);
					return 1;
				} else {
					System.out.println(o2 + " > " + o1);
					return -1;
				}
			}

			if (!o1.getName().equals(o2.getName())) {
				return o1.getName().compareTo(o2.getName());
			}

			System.out.println(o2 + " = " + o1);
			return 0;
		}
	}

	public SortedSetTutorial() {

		List<Person> pl = Arrays.asList(new Person("Bill", 1), new Person("Mitch", 2), new Person("Amy", 4),
				new Person("Wesley", 3));

		pl.stream().forEach(e -> System.out.println(e));

		Collection<Person> pTreeSet = new TreeSet<Person>(pl);

		System.out.println("TreeSet from list of Persons...");
		pTreeSet.stream().forEach(e -> System.out.println(e));

		List<Shape> shapeList = Arrays.asList(new Circle(Color.BLUE, "Circle 1"),
				new Rectangle(Color.RED, "Rectangle 1"), new Rectangle(Color.GREEN, "Rectangle 2"),
				new Circle(Color.BLUE, "Circle 2"));

		Collection<Shape> shapeTreeSet = new TreeSet<Shape>(shapeList);

		System.out.println("TreeSet from list of Shapes...");
		shapeTreeSet.stream().forEach(e -> System.out.println(e));

		Set<Person> ssPersons = new TreeSet<Person>(new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				System.out.println("Comparing " + o2 + " to " + o1);
				if (!o1.getName().equals(o2.getName())) {
					return o1.getName().compareTo(o2.getName());
				}

				if (o1.getId() != o2.getId()) {
					if (o1.getId() > o2.getId()) {
						System.out.println(o1 + " > " + o2);
						return 1;
					} else {
						System.out.println(o2 + " > " + o1);
						return -1;
					}
				}

				System.out.println(o2 + " = " + o1);
				return 0;
			}
		});

		ssPersons.addAll(pl);

		System.out.println("TreeSet of Persons with Comparator<Person> ...");
		ssPersons.stream().forEach(e -> System.out.println(e));

		SortedSet<Person> idPersons = new TreeSet<Person>(new PersonIdComparator());

		idPersons.addAll(pl);

		System.out.println("TreeSet of Persons with PersonIdComparator<Person> ...");
		idPersons.stream().forEach(e -> System.out.println(e));

		Comparator<? super Person> comp = idPersons.comparator();

		SortedMap<Person, Integer> sortedMap = new TreeMap<Person, Integer>(comp);

		// SortedMap<Person, Integer> sortedMap = new TreeMap<Person,
		// Integer>();

		sortedMap.put(new Person("Bill", 1), 1);
		sortedMap.put(new Person("Wesley", 4), 4);
		sortedMap.put(new Person("Amy", 2), 2);

		System.out.println("TreeMap of Persons with PersonIdComparator<Person> ...");
		sortedMap.entrySet().forEach(e -> System.out.println(e));

	}

	public static void main(String[] args) {
		new SortedSetTutorial();
	}

}
