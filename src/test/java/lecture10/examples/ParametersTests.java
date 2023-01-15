package lecture10.examples;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersTests {
    @Parameters({"full-name"})
    @Test
    public void testSingleParameter(String name) {
        System.out.println("My name is " + name);
    }

    @Parameters({"num1", "num2"})
    @Test
    public void testMultiParameters(int num1, int num2) {
        int result = num1 + num2;
        System.out.println(num1 + "+" + num2 + "=" + result);
    }

    @Parameters({"user-name"})
    @Test
    public void testOptionalParameter(@Optional("guest") String user) {
        System.out.println("Welcome " + user);
    }
}
