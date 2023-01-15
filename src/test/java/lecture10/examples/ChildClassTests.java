package lecture10.examples;

import org.testng.annotations.*;

public class ChildClassTests extends BaseClassTests {
    @BeforeMethod
    public void beforeMethodChild() {
        System.out.println("Child Before Test method");
    }

    @AfterMethod
    public void afterMethodChild() {
        System.out.println("Child After Test method");
    }

    @BeforeClass
    public void beforeClassChild() {
        System.out.println("Child Before Class method");
    }

    @AfterClass
    public void afterClassChild() {
        System.out.println("Child After Class method");
    }

    @Test
    public void testName() {
        System.out.println("Test executed in Child Class");
    }
}
