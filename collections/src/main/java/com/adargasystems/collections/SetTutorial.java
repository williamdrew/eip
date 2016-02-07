/*
 *
 */
package com.adargasystems.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.adargasystems.collections.Shape.Color;

/**
 *
 * @author $Author$
 * @id $Id$
 *
 *     There are 3 concrete Set implementations: HashSet, TreeSet and
 *     LinkedHashSet.
 */
public class SetTutorial {

	public Set<Shape> treeSet = new TreeSet<Shape>();
	public Set<Shape> hashSet = new HashSet<Shape>();
	public Set<Shape> linkedHashSet = new LinkedHashSet<Shape>();

	public SetTutorial() {

		treeSet.add(new Circle(Color.RED, "Circle 1"));
		treeSet.add(new Circle(Color.BLUE, "Circle 2"));
		treeSet.add(new Circle(Color.RED, "Circle 3"));

		// System.out.println("treeSet contents...");
		// treeSet.stream().forEach(e -> System.out.println(e));

		Set<Shape> treeSet2 = new TreeSet<Shape>();

		treeSet2.add(new Circle(Color.RED, "Circle 3"));
		treeSet2.add(new Circle(Color.BLUE, "Circle 4"));
		treeSet2.add(new Circle(Color.RED, "Circle 5"));

		System.out.println("treeSet2 contents...");
		treeSet2.stream().forEach(e -> System.out.println(e));

		// Set<Shape> union = new TreeSet<Shape>(treeSet);
		// union.addAll(treeSet2);
		//
		// System.out.println("Union of treeSet and treeSet2...");
		// union.stream().forEach(e -> System.out.println(e));
		//
		// Set<Shape> intersection = new TreeSet<Shape>(treeSet2);
		// intersection.retainAll(treeSet);
		//
		// System.out.println("Intersection of treeSet and treeSet2");
		// intersection.stream().forEach(e -> System.out.println(e));
		//
		// System.out.println("treeSet contents...");
		// treeSet.stream().forEach(e -> System.out.println(e));
		//
		// Set<Shape> compareSet = new TreeSet<Shape>();
		// compareSet.add(new Circle(Color.GREEN, "Circle 3"));
		// compareSet.add(new Circle(Color.GREEN, "Circle 4"));
		// compareSet.add(new Circle(Color.GREEN, "Circle 5"));

		Set<Shape> symDiff = new TreeSet<Shape>(treeSet);

		System.out.println("symDiff contents after ctor...");
		treeSet.stream().forEach(e -> System.out.println(e));

		symDiff.addAll(treeSet2);

		System.out.println("symDiff contents after addAll(treeSet2)...");
		symDiff.stream().forEach(e -> System.out.println(e));

		Set<Shape> tmp = new TreeSet<Shape>(treeSet);
		System.out.println("tmp contents...");
		tmp.stream().forEach(e -> System.out.println(e));
		System.out.println("treeSet2 contents...");
		treeSet2.stream().forEach(e -> System.out.println(e));

		tmp.retainAll(treeSet2);
		System.out.println("tmp contents after retainAll...");
		tmp.stream().forEach(e -> System.out.println(e));

		symDiff.removeAll(tmp);
		System.out.println("symDiff contents...");
		symDiff.stream().forEach(e -> System.out.println(e));

		treeSet.addAll(treeSet2);

		System.out.println("");
		treeSet.stream().forEach(e -> System.out.println(e));

		treeSet.retainAll(treeSet2);

		System.out.println("");
		treeSet.stream().forEach(e -> System.out.println(e));

		// Set<Shape> symmetricDiff = new HashSet<Shape>(treeSet);
		// symmetricDiff.addAll(treeSet2);
		// Set<Shape> tmp2 = new HashSet<Shape>(treeSet);
		// tmp2.retainAll(treeSet2);
		// symmetricDiff.removeAll(tmp2);
		//
		// System.out.println("symmetricDiff contents...");
		// symmetricDiff.stream().forEach(e -> System.out.println(e));

		System.out.println("LinkedHashSet...");

		Collection<Shape> linkedHashSet = new LinkedHashSet<Shape>(
				Arrays.asList(new Circle(Color.RED, "Circle 94"), new Circle(
						Color.RED, "Circle 95"), new Circle(Color.RED,
						"Circle 96"), new Circle(Color.RED, "Circle 97"),
						new Circle(Color.RED, "Circle 98"), new Circle(
								Color.RED, "Circle 99"), new Rectangle(
								Color.BLUE, "Rectangle 95"), new Rectangle(
								Color.BLUE, "Rectangle 96"), new Rectangle(
								Color.BLUE, "Rectangle 97"), new Rectangle(
								Color.BLUE, "Rectangle 98"), new Rectangle(
								Color.BLUE, "Rectangle 99")));

		for (Shape s : linkedHashSet) {
			System.out.println(s);
		}

		linkedHashSet.clear();

		linkedHashSet = new LinkedHashSet<Shape>(Arrays.asList(new Circle(
				Color.RED, "Circle 95"), new Circle(Color.BLUE, "Circle 98"),
				new Circle(Color.BLUE, "Circle 96"), new Circle(Color.RED,
						"Circle 97"), new Circle(Color.BLUE, "Circle 99"),
				new Rectangle(Color.BLUE, "Rectangle 95"), new Rectangle(
						Color.BLUE, "Rectangle 96"), new Rectangle(Color.BLUE,
						"Rectangle 97"), new Rectangle(Color.RED,
						"Rectangle 98"), new Rectangle(Color.RED,
						"Rectangle 99")));

		System.out.println("LinkedHashSet in different order...");

		for (Shape s : linkedHashSet) {
			System.out.println(s);
		}

		System.out.println("LinkedHashSet with iterator...");

		for (Iterator<Shape> iter = linkedHashSet.iterator(); iter.hasNext();) {
			Shape s = iter.next();
			System.out.println(s);
		}

		System.out.println("Classify Shape objects by name...");

		Map<String, List<Shape>> shapeByColor = linkedHashSet.stream().collect(
				Collectors.groupingBy(Shape::getName));

		for (String key : shapeByColor.keySet()) {
			if (null != key) {
				for (Iterator<Shape> iter = shapeByColor.get(key).iterator(); iter
						.hasNext();) {
					Shape nextShape = iter.next();
					System.out.println("Name = " + nextShape.getName()
							+ "; Color = " + nextShape.getColor());
				}
			}
		}

		System.out.println("Classify Shape objects by color...");

		Map<Color, List<Shape>> shapeByName = linkedHashSet.stream().collect(
				Collectors.groupingBy(Shape::getColor));

		for (Color key : shapeByName.keySet()) {
			if (null != key) {
				for (Iterator<Shape> iter = shapeByName.get(key).iterator(); iter
						.hasNext();) {
					Shape nextShape = iter.next();
					System.out.println("Color = " + nextShape.getColor()
							+ " ;Name = " + nextShape.getName());
				}
			}
		}

	}

	public static void main(String[] args) {

		new SetTutorial();
	}

}
