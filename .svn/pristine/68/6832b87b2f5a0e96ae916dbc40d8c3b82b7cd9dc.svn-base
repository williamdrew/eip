package com.adargasystems.aggregateops;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import com.adargasystems.aggregateops.Person.Sex;

/**
 *
 */
public class AggregrateOperationsDemo {

	public AggregrateOperationsDemo() {

		Collection<Person> l = Collections
				.synchronizedList(new LinkedList<Person>());

		l.add(Person.of("Bill", Person.Sex.MALE,
				LocalDate.of(1959, Month.APRIL, 12)));
		l.add(Person.of("Amy", Person.Sex.FEMALE,
				LocalDate.of(1965, Month.JUNE, 1)));
		l.add(Person.of("Seglinde", Person.Sex.FEMALE,
				LocalDate.of(1962, Month.NOVEMBER, 12)));
		l.add(Person.of("Raymond", Person.Sex.MALE,
				LocalDate.of(1964, Month.OCTOBER, 12)));
		l.add((Person.of("Wesley", Person.Sex.MALE,
				LocalDate.of(1984, Month.SEPTEMBER, 5))
				.setEmailAddress("wes.drew@gmail.com")));
		l.add((Person.of("Mitchell", Person.Sex.MALE,
				LocalDate.of(1990, Month.SEPTEMBER, 17))
				.setEmailAddress("mitch.drew@gmail.com")));

		Person person = Person.of("Pat", Person.Sex.MALE,
				LocalDate.of(1965, Month.JULY, 17));
		
		l.add(person);
				
		for (Person p : l) {
			System.out.println(p);
		}

		person.setEmailAddress("pat@gmail.com").setGender(Sex.FEMALE);

		l.stream().forEach(e -> System.out.println(e));

		double avgAge = l.stream().mapToInt(Person::getAgeInYears).average()
				.getAsDouble();

		System.out.println("Average age = "
				+ Integer.valueOf(Double.valueOf(avgAge).intValue()));

	}

	public static void main(String[] args) {
		new AggregrateOperationsDemo();
	}
}
