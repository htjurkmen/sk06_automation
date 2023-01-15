package lecture10.examples;

import org.testng.annotations.Test;

public class PriorityTests {
    @Test// No priority equals to (priority = 0)
    public void testPrioritySecond() {
        System.out.println("This is the second priority test");
    }

    @Test(priority = 1)
    public void testPriorityThird() {
        System.out.println("This is the third priority test");
    }

    @Test(priority = -1)
    public void testPriorityFirst() {
        System.out.println("This is the first priority test");
    }
}
