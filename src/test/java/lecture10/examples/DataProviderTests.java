package lecture10.examples;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTests {
    @DataProvider(name = "generateValues")
    public Object[][] generateValues() {
        return new Object[][]{{"First-Value"}, {"Second-Value"}};
    }

    @Test(dataProvider = "generateValues")
    public void testDataProvider(String val) {
        System.out.println("Passed Parameter Is : " + val);
    }

    @DataProvider(name = "generateNumbers")
    public Object[][] generateNumbers() {
        return new Object[][]{{2, 3, 5}, {5, 7, 9}};
    }

    @Test(dataProvider = "generateNumbers")
    public void testDataProviderMultipleParameters(int a, int b, int expectedSum) {
        int sum = a + b;
        Assert.assertEquals(expectedSum, sum);
    }

}
