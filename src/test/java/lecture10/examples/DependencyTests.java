package lecture10.examples;

import org.testng.annotations.Test;

public class DependencyTests {
    @Test(dependsOnGroups = "group.dependency")
    public void testDependsOnGroup() {
        System.out.println("This method depends on group.dependency");
    }

    @Test(groups = "group.dependency")
    public void testGroupDependency() {
        System.out.println("This is a test part of group.example");
    }

    @Test(dependsOnMethods = "testMethodDependency")
    public void testDependsOnMethod() {
        System.out.println("This is a depends on testMethodDependency");
    }

    @Test
    public void testMethodDependency() {
        System.out.println("This is test dependency test");
    }
}
