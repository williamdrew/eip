/*
 *
 */
package com.adargasystems.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * The Map interface contains 3 general purpose Map implementations 1) HashMap
 * 2) LinkedHashMap and 3) TreeMap
 *
 * @author $Author$
 * @id $Id$
 *
 */
public class MapTutorial {

	private Map<Person, String> personNameMap = new HashMap<Person, String>();

	public MapTutorial() {

		String name = new String("Tammy");
		Person p = new Person(name, 1);

		personNameMap.put(p, p.getName());

		Person getPerson = new Person(name, 1);
		String value = personNameMap.get(getPerson);

		System.out.println("Name = " + value);

		String[] sa = { "plow", "butter", "tire", "umbrella", "zero", "tire",
				"area", "butter", "card", "fox", "otter", "fox" };

		System.out.println("HashMap...");

		showMap(sa, new HashMap<String, Integer>());

		System.out.println("LinkedHashMap...");

		showMap(sa, new LinkedHashMap<String, Integer>());

		System.out.println("TreeMap...");

		showMap(sa, new TreeMap<String, Integer>());

		Map<String, Person> namePersonMap = new LinkedHashMap<String, Person>();

		Person personValue = new Person("Bob", 1);
		namePersonMap.put(personValue.getName(), personValue);
		personValue = new Person("Reggie", 2);
		namePersonMap.put(personValue.getName(), personValue);
		personValue = new Person("Zorro", 3);
		namePersonMap.put(personValue.getName(), personValue);

		System.out.println("keySet()");

		for (String key : namePersonMap.keySet()) {
			System.out.println(namePersonMap.get(key));
		}

		Set<Map.Entry<String, Person>> keyEntry = namePersonMap.entrySet();
		
		for(Map.Entry<String, Person> ke : keyEntry){
			System.out.println("Key = " + ke.getKey() + "  Value = " + ke.getValue());
		}
	}

	/**
	 * 
	 * @param sa
	 * @param map
	 */
	public void showMap(String[] sa, Map<String, Integer> map) {

		for (int idx = 0; idx < sa.length; idx++) {
			String key = sa[idx];
			if (!map.containsKey(key)) {
				map.put(key, 1);
			} else {
				int i = map.get(key).intValue();
				map.put(key, i + 1);
			}
		}

		for (String key : map.keySet()) {
			if (null != key) {
				System.out
						.println("Key = " + key + "; Value = " + map.get(key));
			}
		}
	}

	public static void main(String[] args) {

		new MapTutorial();
	}
}