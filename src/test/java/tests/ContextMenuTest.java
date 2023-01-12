package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitsService;

import javax.swing.*;
import java.time.Duration;

public class ContextMenuTest extends BaseTest {

    @Test
    public void contextMenuTest() {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WaitsService waitsService = new WaitsService(driver, Duration.ofSeconds(5));
        WebElement frame = waitsService.waitForVisibilityBy(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions
                .moveToElement(frame)
                .contextClick()
                .build()
                .perform();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "You selected a context menu");
        alert.accept();
    }
}