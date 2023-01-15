package lecture07.exceptions.exercises;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CodeFixExercise {
    private static FileWriter getFileWriter(String filePath) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath, true);
        return fileWriter;
    }

    protected static void closeFileWriter(FileWriter fileWriter) throws IOException {
        fileWriter.close();
    }

    public static void printToFile(FileWriter fileWriter, String text, int repeat) throws IOException {
        for (int i = 0; i < repeat; i++) {
            fileWriter.write(text + "\n");
        }
    }

    /**
     * filePath - "src/lecture07/exceptions/testFile.txt" (existing file)
     * filePath - "src/lecture07/exceptions/testFile.txt" (file in use by another program example: notepad)
     * filePath - "test" (not existing file)
     * filePath - "" (no file path specified)
     * howManyTimesToPrintTheTextToFile - "-1"
     * howManyTimesToPrintTheTextToFile - "0"
     * howManyTimesToPrintTheTextToFile - "1"
     * howManyTimesToPrintTheTextToFile - "2" (any number bigger than 1)
     * howManyTimesToPrintTheTextToFile - "" (empty)
     * textToAdd - "a" (1 char)
     * textToAdd - "test" (single word)
     * textToAdd - "test add text" (multiple words)
     * textToAdd - "test1$" (alphabetic, numeric, and special symbols)
     * textToAdd - "" (empty)
     */
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = null;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the file path: ");
            String filePath = scanner.nextLine();
            System.out.println("Please enter how many times to add the text in the file: ");
            int howManyTimesToPrintTheTextToFile = Integer.parseInt(scanner.nextLine());
            System.out.println("Please provide the text: ");
            String textToAdd = scanner.nextLine();
            fileWriter = getFileWriter(filePath);
            printToFile(fileWriter, textToAdd, howManyTimesToPrintTheTextToFile);
        } catch (IOException e) {
            System.out.println("Unable to print the text to the file! Please provide valid file path and try again!");
        } catch (NumberFormatException e) {
            System.out.println("Please provide valid number for how many times to add the text!");
        } finally {
            if (fileWriter != null) {
                closeFileWriter(fileWriter);
            }
        }
    }

}
