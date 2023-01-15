package lecture08.exercises.employee;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private double salary;

    public Employee(int id, String firstName, String lastName, double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public double getAnnualSalary() {
        return 12 * salary;
    }

    public double raiseSalary(double percentage) {
        salary = salary + (salary * (percentage / 100));
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
