package lecture02;

import java.util.Scanner;

public class Exercises {
    public static void main(String[] args) {
        printQuadraticEquation();
    }

    public static void printName() {
        String firstName = "Dimitar";
        String middleName = "Nikolaev";
        String lastName = "Tarkalanov";

        String fullName = firstName + " " + middleName + " " + lastName;

        System.out.println(fullName);
    }

    public static void printTrianglePerimeter() {
        int a = 1;
        int b = 4;
        int c = 5;

        int perimeter = a + b + c;

        System.out.println("Triangle Perimeter is: " + perimeter);
    }

    public static void printTriangleArea() {
        int a = 20;
        int b = 5;

        int area = (a * b) / 2;

        System.out.println("The area of the triangle is: " + area);
    }

    public static void printPineTree() {
        System.out.println("  *");
        System.out.println(" ***");
        System.out.println("*****");
    }

    public static void printTrianglePerimeterInput() {
        Scanner myObj = new Scanner(System.in);

        System.out.println("Enter side a size");
        int a = myObj.nextInt();

        System.out.println("Enter side b size");
        int b = myObj.nextInt();

        System.out.println("Enter side c size");
        int c = myObj.nextInt();

        int perimeter = a + b + c;

        System.out.println("Triangle Perimeter is: " + perimeter);
    }

    public static void printTriangleAreaInput() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter side a size");
        int a = myObj.nextInt();

        System.out.println("Enter side b size");
        int b = myObj.nextInt();

        int area = (a * b) / 2;

        System.out.println("The area of the triangle is: " + area);
    }

    public static void printQuadraticEquation() {
        // value of the constants a, b, c
        double a = 7.2;
        double b = 5;
        double c = 9;

        // declared the two roots
        double root1;
        double root2;

        // determinant (b^2 - 4ac)
        double determinant = b * b - 4 * a * c;

        System.out.println("Determinant = " + determinant);

        //determinant > 0
        root1 = (-b + Math.sqrt(determinant)) / (2 * a);
        root2 = (-b - Math.sqrt(determinant)) / (2 * a);
        System.out.println("\nDeterminant > 0");
        System.out.println("root1 = " + root1);
        System.out.println("root2 = " + root2);


        //determinant == 0
        root1 = root2 = -b / (2 * a);
        System.out.println("\nDeterminant == 0");
        System.out.println("root1 = root2 = " + root1);

        //determinant < 0
        double real = -b / (2 * a);
        double imaginary = Math.sqrt(-determinant) / (2 * a);
        System.out.println("\nDeterminant < 0");
        System.out.format("root1 = %.2f+%.2fi", real, imaginary);
        System.out.format("\nroot2 = %.2f-%.2fi", real, imaginary);
    }
}