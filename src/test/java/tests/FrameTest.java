package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest {
    @Test
    public void frameTest() {
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.findElement(By.xpath("//img")).isDisplayed();
        WebElement iFrame = driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(iFrame);
        driver.findElement(By.xpath("//p")).isDisplayed();
        }
}