package lecture06.examples;

public class MathOperations {
    static double addition(double[] numbers) {
        double sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum = sum + numbers[i];
        }
        return sum;
    }

}
