package lecture07.exceptions.exercises;

import java.util.Scanner;

public class Exercises {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide the first number: ");
        double num1 = scanner.nextDouble();
        System.out.println("Please provide the second number: ");
        double num2 = scanner.nextDouble();
        System.out.println("Result after division:" + divideNumbers(num1, num2));
    }

    /**
     * Try the following combinations
     *
     * @param x - -1,1,0,2,10,2,3.5,2
     * @param y - 2,-2,2,0,2,10,2,3.5
     */
    public static double divideNumbers(double x, double y) {
        try {
            return x / y;
        } catch (ArithmeticException e) {
            throw new RuntimeException("Cannot divide by 0!");
        }
    }
}
