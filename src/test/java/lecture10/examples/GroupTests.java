package lecture10.examples;

import org.testng.annotations.Test;

public class GroupTests {
    @Test(groups = "smoke")
    public void testSmokeGroup1() {
        System.out.println("First test from smoke group");
    }

    @Test(groups = "smoke")
    public void testSmokeGroup2() {
        System.out.println("Second test from smoke group");
    }

    @Test
    public void testNoGroup() {
        System.out.println("This test doesn't belong to any group");
    }

    @Test(groups = "regression")
    public void testRegressionGroup1() {
        System.out.println("First test from regression group");
    }

    @Test(groups = "regression")
    public void testRegressionGroup2() {
        System.out.println("Second test from regression group");
    }
}
