package lecture07.constructors;

public class Employee {
    private String firstName;
    private String lastName;
    private int birthYear;

    public Employee() {
    }

    public Employee(String firstName, String lastName, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
    }

    public Employee(String firstName, String lastName) {
        this(firstName, lastName, -1);
    }
}
