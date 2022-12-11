package tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeworkSmokeTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();
    }

    @Test
    public void validateLaminateCalculatorTest() throws InterruptedException{
        driver.get("https://calc.by/building-calculators/laminate.html");
        WebElement selectWebElementLayingMethod = driver.findElement(By.id("laying_method_laminate"));
        Select selectLayingMethodLaminate = new Select(selectWebElementLayingMethod);
        selectLayingMethodLaminate.selectByIndex(1);
        driver.findElement(By.id("ln_room_id")).sendKeys(Keys.CONTROL + "a");
        driver.findElement(By.id("ln_room_id")).sendKeys( "500");
        driver.findElement(By.id("wd_room_id")).sendKeys(Keys.CONTROL + "a");
        driver.findElement(By.id("wd_room_id")).sendKeys("400");
        driver.findElement(By.id("ln_lam_id")).sendKeys(Keys.CONTROL + "a");
        driver.findElement(By.id("ln_lam_id")).sendKeys("2000");
        driver.findElement(By.id("wd_lam_id")).sendKeys(Keys.CONTROL + "a");
        driver.findElement(By.id("wd_lam_id")).sendKeys("200");
        driver.findElement(By.id("direction-laminate-id1")).click();
        driver.findElement(By.linkText("Рассчитать")).click();
        Thread.sleep(4000);
        Assert.assertEquals(driver.findElement(By.cssSelector("[style='padding:5px 0;font-size:22px; color:#C80303; font-weight:bold;']")).getText(), "52");
        Assert.assertEquals(driver.findElement(By.cssSelector("[style='padding:5px 0;font-size:18px; color:#0E8C19; font-weight:bold;']")).getText(), "7");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}