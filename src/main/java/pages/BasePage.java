package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class BasePage {
    WebDriver driver;

    public BasePage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void fillField(WebElement element, String value) {
        element.click();
        element.clear();
        element.sendKeys(value);
    }
}