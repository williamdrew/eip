/*
 *
 */
package com.adargasystems.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;

/**
 *
 * @author $Author$
 * @id $Id$
 *
 */
public class PrintArgsRandomly {

	public static void main(String[] args) {

		String[] strings = { "The", "quick", "brown", "fox", "Jumped", "over",
				"the", "fence", "Fox", "Quick" };

		List<String> shuffledArgs = Arrays.asList(strings);

		Collections.shuffle(shuffledArgs);

		for (String s : shuffledArgs) {
			System.out.println(s);
		}

		LinkedHashSet<String> s = new LinkedHashSet<String>();
		for (String a : strings) {
			s.add(a);
		}

		System.out.println(s.size() + " distinct words: " + s);
		System.out.println("LinkedHashSet ...");
		s.stream().forEach(e -> System.out.println(e));

		Collections.sort(shuffledArgs, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {

				return o1.compareToIgnoreCase(o2);
			}

		});

		System.out.println("Sorted using case-insensitive sort: "
				+ shuffledArgs);

	}
}
