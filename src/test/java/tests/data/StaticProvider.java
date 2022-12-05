package tests.data;

import org.testng.annotations.DataProvider;

public class StaticProvider {

    @DataProvider (name = "dataForSum")
    public static Object[][] dataForSumTest() {
        return new Object[][] {
                {-2, -3, -5},
                {0, 0, 0},
                {2, 3, 5},
        };
    }
    @DataProvider (name = "dataForDiv")
    public static Object[][] dataForDivTest() {
        return new Object[][] {
                {6, 3, 2},
                {12, 4, 3},
                {15, 5, 3},
        };
    }
}
