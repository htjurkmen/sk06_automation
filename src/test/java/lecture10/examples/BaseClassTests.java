package lecture10.examples;

import org.testng.annotations.*;

public class BaseClassTests {
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Base Before Test method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Base After Test method");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Base Before Class method");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Base After Class method");
    }

    @Test
    public void testName() {
        System.out.println("Test executed in Base Class");
    }
}
