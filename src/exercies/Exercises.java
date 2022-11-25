package exercies;

import java.util.Scanner;

public class Exercises {
    public static void main(String[] args) {
        printName();
    }

    public static void printName() {
        String firstName = "Dimitar";
        String middleName = "Nikolaev";
        String lastName = "Tarkalanov";

        String fullName = firstName + " " + middleName + " " + lastName;

        System.out.println(fullName);
    }

    public static void printTrianglePerimeter() {
        int a = 3;
        int b = 4;
        int c = 5;

        int perimeter = a + b + c;

        System.out.println("Triangle Perimeter is: " + perimeter);
    }

    public static void printTriangleArea() {
        int a = 10;
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
}