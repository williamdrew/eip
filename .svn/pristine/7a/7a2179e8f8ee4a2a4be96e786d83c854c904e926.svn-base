package com.adargasystems.collections;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetClassesTest {

	public SetClassesTest() {

		Set<Dog> hashSet = new HashSet<Dog>();

		hashSet.add(new Dog("Mastiff", 12));
		hashSet.add(new Dog("Toy Poodle", 1));
		hashSet.add(new Dog("Shepard", 4));
		hashSet.add(new Dog("Collied", 4));

		hashSet.stream().forEach(e -> System.out.println(e));

		System.out.println("Sorted via DogComparator");

		TreeSet<Dog> treeSet = new TreeSet<Dog>(new DogComparator());

		treeSet.add(new Dog("Toy Poodle", 1));
		treeSet.add(new Dog("Collie", 4));
		treeSet.add(new Dog("Shepard", 8));
		treeSet.add(new Dog("Mastif", 12));

		treeSet.stream().forEach(e -> System.out.println(e));

		System.out.println("Sorted with Comparator");
		
		List<Dog> ll = new LinkedList<Dog>(treeSet);

		ll.sort(new Comparator<Dog>() {

			public int compare(Dog dog1, Dog dog2) {

				if (dog1 == dog2) {
					return 0;
				}

				if (dog1.equals(dog2)) {
					return 0;
				}

				return (dog1.getSize() < dog2.getSize() ? 1 : -1);
			}
			
		});

		ll.stream().forEach(e -> System.out.println(e));
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new SetClassesTest();
	}

	/**
	 * 
	 * 
	 * @author <a href=mailto:support@aeronomos.org>aeronomos</a>
	 *
	 *         $Id: $
	 *
	 */
	private class Dog {
		private final String name;
		private final int size;

		public Dog(final String name, final int size) {
			this.name = name;
			this.size = size;
		}

		public int getSize() {
			return size;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + size;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;

			Dog other = (Dog) obj;

			if (!getOuterType().equals(other.getOuterType()))
				return false;

			if (size != other.size)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return name + " = " + size;
		}

		private SetClassesTest getOuterType() {
			return SetClassesTest.this;
		}
	}

	private class DogComparator implements Comparator<Dog> {

		@Override
		public int compare(Dog o1, Dog o2) {

			if (null == o1 ^ null == o2) {
				return (null == o1) ? -1 : 1;
			}

			if (o1.size < o2.size) {
				return -1;
			}
			if (o1.size > o2.size) {
				return 1;
			}
			return 0;
		}
	}
}
