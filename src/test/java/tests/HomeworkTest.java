package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.data.StaticProvider;
import utils.Retry;

public class HomeworkTest{
    Calculator calculator = new Calculator();
    int attempt = 4;

    //Tests with int

    @Test (groups = "smokeHomework")
    public void testDiv() {
        Assert.assertEquals(calculator.divisionInt(6,3), 2, "Неверный результат");
    }

    @Test (groups = "smokeHomework", expectedExceptions = ArithmeticException.class, dependsOnMethods = "testDiv")
    public void exceptionTest() {
        calculator.divisionInt(3, 0);
    }

    @Test(groups = "smokeHomework", timeOut = 500, dependsOnMethods = "exceptionTest", alwaysRun = true)
    public void testDiv3() throws InterruptedException {
        Thread.sleep(450);
        Assert.assertEquals(calculator.divisionInt(8,2), 4, "Неверный результат");
    }

    @Test(groups = "smokeHomework", dataProvider = "dataForDiv", dataProviderClass = StaticProvider.class, threadPoolSize = 4)
    public void testSum(int a, int b, int expected) {
        Assert.assertEquals(calculator.divisionInt(a, b), expected, "Неверный результат");
    }

    //Tests with double

    @Test(groups = "regressionHomework", description = "Проверка метода деления с использованием переменных типа double")
    public void testDiv1() {
        Assert.assertEquals(calculator.divisionDouble(4, 2), 2, "Неверный результат");
    }

    @Test(groups = "regressionHomework", testName = "Просто тест", dependsOnMethods = "testDiv1", alwaysRun = true)
    public void testDiv2() {
        Assert.assertEquals(calculator.divisionDouble(2, 1), 2, "Неверный результат");
    }

    @Test(groups = "regressionHomework", invocationCount = 6, invocationTimeOut = 300, threadPoolSize = 3)
    public void testSum5() throws InterruptedException {
        Thread.sleep(100);
        Assert.assertEquals(calculator.divisionDouble(8,2), 4, "Неверный результат");
    }
}
