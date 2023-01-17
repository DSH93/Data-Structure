package il.ac.telhai.ds.misc;

public class Person implements Comparable<Person>{
    private String id;
    private String firstName;
    private String lastName;

    public Person(String id, String fn, String ln){
        this.id = id;
        this.firstName = fn;
        this.lastName = ln;
    }

    public String getId() {
        return id;
    }

    public void setId(String newId) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String newFirstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String newLastName) {
        this.lastName = lastName;
    }

    @Override
    public int compareTo(Person o) {
        return 0;
    }
}
