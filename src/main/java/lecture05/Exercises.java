package lecture05;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Exercises {
    public static void main(String[] args) {}

    public static void printArraySum() {
        double[] numbers = {0, 0.5, 1, 1.5, 2, 2.5};
        double sum = 0;

        for (double num : numbers) {
            sum += num;
        }

        System.out.println("The sum of the array is: " + sum);
    }

    public static void printMatrixElements() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.printf("%d ", matrix[row][col]);
            }
        }

        System.out.println();

        for (int[] row : matrix) {
            for (int col = 0; col < row.length; col++) {
                System.out.printf("%d ", row[col]);
            }
        }
    }

    public static void printDynamicMatrixElements() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the number of rows: ");
        int rows = input.nextInt();

        System.out.println("Please enter the number of columns: ");
        int cols = input.nextInt();

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.printf("matrix[%d,%d] = ", row, col);
                matrix[row][col] = input.nextInt();
            }
        }
        System.out.println("The matrix is created: " + Arrays.deepToString(matrix));
    }

    public static void printBiggestNum() {
        int[] numbers = {10, 30, 20, 50, 40};

        int biggestNum = numbers[0];

        // Traverse array elements from second and compare every element with current biggest number
        for (int i = 1; i < numbers.length; i++)
            if (numbers[i] > biggestNum)
                biggestNum = numbers[i];

        System.out.println("The biggest number is: " + biggestNum);
    }

    public static void reverseLinkedList() {
        LinkedList<String> cars = new LinkedList<>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");

        System.out.println(cars);

        //Algorithm:
        // 1. Create a linked list with n elements
        // 2. Run the loop for n/2 times where ‘n’ is the number of elements in the LinkedList.
        // 3. In the first pass, Swap the first and nth element
        // 4. In the second pass, Swap the second and (n-1)th element and so on till you reach the mid of the linked list.
        // 5. Return the linked list after loop termination.
        for (int i = 0; i < cars.size() / 2; i++) {
            String temp = cars.get(i);
            cars.set(i, cars.get(cars.size() - i - 1));
            cars.set(cars.size() - i - 1, temp);
        }

        System.out.println(cars);
    }

    public static void sumMatrixDiagonal() {
        int[][] matrix = {
                {10, 5, 6, 20},
                {1, 10, 20, 4},
                {11, 20, 10, 14},
                {20, 24, 25, 10}
        };
        int matrixSize = 4;

        int principalDiagonal = 0, secondaryDiagonal = 0;
        for (int row = 0; row < matrixSize; row++) {
            for (int col = 0; col < matrixSize; col++) {
                if (row == col)
                    principalDiagonal += matrix[row][col];
                if ((row + col) == (matrixSize - 1))
                    secondaryDiagonal += matrix[row][col];
            }
        }
        System.out.println(" The sum of principal diagonal is: " + principalDiagonal);
        System.out.println(" The sum of secondary diagonal is: " + secondaryDiagonal);
    }

    public static void isPalindrome() {
        String word = "racecar";

        String reveredWord = "";

        boolean isPalindrome = false;

        for (int i = word.length() - 1; i >= 0; i--) {
            reveredWord = reveredWord + word.charAt(i);
        }

        // Checking if both the strings are equal
        if (word.equals(reveredWord)) {
            isPalindrome = true;
        }

        System.out.println("The String is palindrome: " + isPalindrome);
    }
}
