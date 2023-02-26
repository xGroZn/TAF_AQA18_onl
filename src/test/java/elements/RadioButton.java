package elements;

import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;

public class RadioButton {
    private WebDriver driver;
    private List<UIElement> uiElementList;
    private List<String> valueList;
    private List<String> textList;

    public RadioButton(WebDriver driver, String xpathValue) {
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
    public void selectByIndex(int index) {
        try {
            uiElementList.get(index).click();
        } catch (ElementNotInteractableException ex) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", uiElementList);
            uiElementList.get(index).click();
        }
    }

    public void selectByValue(String value) {
        try {
            uiElementList.get(valueList.indexOf(value)).click();
        } catch (ElementNotInteractableException ex) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", uiElementList);
            uiElementList.get(valueList.indexOf(value)).click();
        }
    }

    public void selectByText(String text) {
        try {
            uiElementList.get(textList.indexOf(text)).click();
        } catch (ElementNotInteractableException ex) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", uiElementList);
            uiElementList.get(textList.indexOf(text)).click();
        }
    }
}