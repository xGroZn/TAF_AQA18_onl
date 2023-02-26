package elements;

import org.openqa.selenium.*;
import services.WaitsService;

public class Checkbox {
    private WebDriver driver;

    private UIElement uiElement;

    public Checkbox(WebDriver driver, By by) {
        this.uiElement = new UIElement(driver, by);
    }

    public Checkbox(WebDriver driver, WebElement webElement) {
        this.uiElement = new UIElement(driver, webElement);
    }

    public void click() {
        try {
            uiElement.click();
        } catch (ElementNotInteractableException ex) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", uiElement);
            uiElement.click();
        }
    }

    public boolean isEnabled() {

        return uiElement.isEnabled();
    }

    public boolean isSelected() {

        return uiElement.isSelected();
    }
    public boolean isDisplayed() {

        return uiElement.isDisplayed();
    }
}