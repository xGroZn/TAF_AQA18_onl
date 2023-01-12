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
        String pathToFile = FileUploadTest.class.getClassLoader().getResource("witcher.jpg").getPath().substring(1);
        fileChooseButton.sendKeys(pathToFile);
        waitsService.waitForVisibilityBy(By.id("file-submit")).click();
        Assert.assertEquals(waitsService.waitForVisibilityBy(By.id("uploaded-files")).getText().trim(), "witcher.jpg");
    }
}
