/*
 *
 */
package com.adargasystems.aggregateops;

import java.time.LocalDate;

/**
 *
 * @author $Author$
 * @id $Id$
 *
 */
public class Person {

	public enum Sex {
		MALE, FEMALE
	}

	private final String name;
	private final LocalDate birthday;

	private Sex gender;
	private String emailAddress;

	/**
	 * 
	 * @param name
	 * @param gender
	 * @param birthday
	 */
	private Person(final String name, final Sex gender, final LocalDate birthday) {
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
	}

	/**
	 * 
	 * @param name
	 * @param gender
	 * @param birthday
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static Person of(final String name, final Sex gender,
			final LocalDate birthday) throws IllegalArgumentException {
		if (null == name) {
			throw new IllegalArgumentException("Name parameter was null");
		}
		if (null == gender) {
			throw new IllegalArgumentException("Name parameter was null");
		}
		if (null == birthday) {
			throw new IllegalArgumentException("Birthday parameter was null");
		}

		return new Person(name, gender, birthday);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the birthday
	 */
	public LocalDate getBirthday() {
		return birthday;
	}

	public int getAgeInYears() {
		return birthday.until(LocalDate.now()).getYears();
	}

	/**
	 * @return the gender
	 */
	public synchronized Sex getGender() {
		return gender;
	}

	/**
	 * @return the emailAddress
	 */
	public synchronized String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * 
	 * @param gender
	 * @return
	 */
	public Person setGender(final Sex gender) {
		if (null != gender) {
			synchronized (this) {
				this.gender = gender;
			}
		}
		return this;
	}

	/**
	 * 
	 * @param newValue
	 */
	public synchronized Person setEmailAddress(final String newValue) {
		if (null != newValue) {
			emailAddress = newValue;
		}
		return this;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Name = " + name + "\t");
		sb.append("Gender = " + gender + "\t");
		sb.append("Birthday = " + birthday + "\t");
		sb.append("Email = " + emailAddress);
		return sb.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Person other = (Person) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (gender != other.gender) {
			return false;
		}
		return true;
	}

}
