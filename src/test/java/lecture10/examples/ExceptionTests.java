package lecture10.examples;

import org.testng.annotations.Test;

import java.io.IOException;

public class ExceptionTests {
    @Test(expectedExceptions = RuntimeException.class)
    public void testExceptions() {
        throw new RuntimeException("Pass");
    }

    @Test(expectedExceptions = {IOException.class, NullPointerException.class})
    public void testExceptions1() {
        throw new NullPointerException("Pass");
    }

    @Test(expectedExceptions = {IOException.class})
    public void testExceptions2() {
        throw new NullPointerException("Fail");
    }

    @Test
    public void testExceptions3() throws Exception {
        throw new IOException("Fail");
    }

}
