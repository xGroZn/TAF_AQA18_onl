package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DropDownMenu {
    private WebDriver driver;

    private UIElement uiElement;

    private List<UIElement> uiElementList;
    private List<String> valueList;
    private List<String> textList;

    public DropDownMenu(WebDriver driver, By by) {
        this.uiElement = new UIElement(driver, by);
    }

    public DropDownMenu(WebDriver driver, WebElement webElement) {
        this.uiElement = new UIElement(driver, webElement);
    }

    public DropDownMenu(WebDriver driver, String xpathValue) {
        uiElementList = new ArrayList<>();
        valueList = new ArrayList<>();
        textList = new ArrayList<>();

        for (WebElement webElement : driver.findElements(By.xpath(xpathValue))) {
            UIElement element = new UIElement(driver, webElement);
            uiElementList.add(element);
            valueList.add(element.getAttribute("value"));
            textList.add(element.findUIElement(By.xpath("parent::*/strong")).getText().trim());
        }
    }

    public boolean isEnabled() {

        return uiElement.isEnabled();
    }

    public boolean isDisplayed() {

        return uiElement.isDisplayed();
    }


}
