package tests;

import factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeworkLocatorsTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = new BrowserFactory().getDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        driver.findElement(By.cssSelector(".shopping_cart_link")).click();
        Thread.sleep(200);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void saucedemoLocatorsTest() throws InterruptedException {
        Assert.assertEquals(driver.findElement(By.className("inventory_item_name")).getText(), "Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(driver.findElement(By.className("inventory_item_price")).getText(), "$15.99");
        //Поиск элементов с помощью базовых локаторов
        Assert.assertTrue(driver.findElement(By.id("react-burger-menu-btn")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.name("remove-sauce-labs-bolt-t-shirt")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("bm-burger-button")).isDisplayed());
        Assert.assertEquals(driver.findElements(By.tagName("link")).size(), 4);
        Assert.assertTrue(driver.findElement(By.linkText("Sauce Labs Bolt T-Shirt")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.partialLinkText("Bolt T-Shirt")).isDisplayed());
        //Поиск элементов с помощью css
        Assert.assertTrue(driver.findElement(By.cssSelector(".cart_footer")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(".cart_footer")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(".btn.btn_secondary.back")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(".social .social_twitter")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("#remove-sauce-labs-bolt-t-shirt")).isDisplayed());
        Assert.assertEquals(driver.findElements(By.cssSelector("link")).size(), 4);
        Assert.assertTrue(driver.findElement(By.cssSelector("div.cart_quantity")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("[alt='Swag Bot Footer']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("[alt~='Footer']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("[name|='continue']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("[alt^='Swag']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("[alt$='Footer']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("[alt*='Bot']")).isDisplayed());
        //Поиск элементов с помощью XPath
        Assert.assertTrue(driver.findElement(By.xpath("//div//button[@id='react-burger-menu-btn']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//button[text()='Open Menu']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@id,'menu')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(),'Open')]")).isDisplayed());
        Assert.assertEquals(driver.findElements(By.xpath("//button[text()='Open Menu']//ancestor::div")).size(), 9);
        Assert.assertEquals(driver.findElements(By.xpath("//div//descendant::button")).size(), 5);
        Assert.assertTrue(driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']/parent::div")).isDisplayed());
        Assert.assertEquals(driver.findElements(By.xpath("//button[@id='react-burger-menu-btn']/preceding::head")).size(), 1);
        Assert.assertEquals(driver.findElements(By.xpath("//div[@style='height: 100%; box-sizing: border-box; overflow: auto;' and @class='bm-menu']")).size(), 1);
    }
}