package il.ac.telhai.ds.misc;

import java.util.Objects;

public class Person {
	String id;
	String firstName;
	String lastName;

	public Person(String id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || this.getClass() != o.getClass()) return false;
		Person person = (Person) o;
		if (!Objects.equals(id, person.getId())) return false;
		if (!Objects.equals(firstName, person.getFirstName())) return false;
		return Objects.equals(lastName, person.getLastName());
	}

	@Override
	public int hashCode() {
		int result;
		if(id != null) result = id.hashCode();
		else result = 0;
		if(firstName != null ) {
			result = 17 * result + firstName.hashCode();
		}else {
			result = 17 * result;
		}
		if(lastName != null) {
			result = 17 * result + lastName.hashCode();
		}
		else{
			result = 17 * result;
		}

		return result;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}