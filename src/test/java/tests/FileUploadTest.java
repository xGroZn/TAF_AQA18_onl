package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTest extends BaseTest {

    @Test
    public void fileUploadTest() {
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement fileChooseButton = waitsService.waitForExists(By.id("file-upload"));
        String pathToFile = "D:\\Programms\\TAF_AQA18_onl\\TAF_AQA18_onl\\src\\test\\resources\\witcher.jpg";
        fileChooseButton.sendKeys(pathToFile);
        waitsService.waitForVisibilityBy(By.id("file-submit")).click();
        Assert.assertEquals(waitsService.waitForVisibilityBy(By.id("uploaded-files")).getText().trim(), "witcher.jpg");
    }
}