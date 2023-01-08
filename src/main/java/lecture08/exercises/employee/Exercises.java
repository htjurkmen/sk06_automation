package lecture08.exercises.employee;

public class Exercises {
    public static void main(String[] args) {
        Employee employee = new Employee(1, "Dimitar", "Tarkalanov", 20);
        String name = employee.getName();
        double annualSalary = employee.getAnnualSalary();
        System.out.println(employee);

        double raisedSalary = employee.raiseSalary(-10);
        annualSalary = employee.getAnnualSalary();
        System.out.println(employee);
    }
}
