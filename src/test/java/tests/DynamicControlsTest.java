package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitsService;

import java.time.Duration;

import static io.netty.util.ResourceLeakDetector.isEnabled;

public class DynamicControlsTest extends BaseTest {

    @Test
    public void dynamicControlsTest() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WaitsService waitsService = new WaitsService(driver, Duration.ofSeconds(10));
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        waitsService.waitForElementInvisible(checkbox);
        WebElement input = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(input.isEnabled());
        if (!input.isEnabled()){
                driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();
        }
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(50));
        wait.until(driver -> input.isEnabled());
        Assert.assertTrue(input.isEnabled());
    }
}