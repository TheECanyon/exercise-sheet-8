package de.unistuttgart.iste.rss.oo.hamstersimulator.sheet08.homework.immutable;

import java.util.Date;

/**
 * Represents a person with a name and birth date.
 */
public final class Person {
	//@ private instance invariant name != null && name.length() > 0;
	//@ private instance invariant birthDate != null;
	
	public final String name;
	public final Date birthDate;
	
	/*@
	  @ requires name != null && name.length() > 0;
	  @ requires birthDate != null;
	  @ ensures this.name == name;
	  @ ensures this.birthDate == birthDate;
	  @*/
	/**
	 * Creates a new person with the given name.
	 * @param name Name of the person.
	 * @param birthDate Birth date of the person.
	 * @throws IllegalArgumentException If the preconditions are not satisfied.
	 */
	public Person(final String name, final Date birthDate) throws IllegalArgumentException {
		if (name == null || name.length() == 0 || birthDate == null) {
			throw new IllegalArgumentException("A person may not have a null or empty name, and their birth date must not be null.");
		}
		this.name = name;
		this.birthDate = new Date(birthDate.getTime());
	}
	
	/*@
	  @ ensures \result == name;
	  @*/
	/**
	 * @return This person's name.
	 */
	public /*@ pure @*/ String getName() {
		return name;
	}
	
	/*@
	  @ ensures \result == birthDate;
	  @*/
	/**
	 * @return This person's birth date.
	 */
	public /*@ pure @*/ Date getBirthDate() {
		return new Date(birthDate.getTime());
	}
}
