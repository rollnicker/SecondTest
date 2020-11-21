
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class InsurancePage extends BasePage {

    @FindBy(xpath = "//H3[@class='uc-full__header'][text()='Страхование для путешественников']")
    public WebElement title;

    @FindBy(xpath = "//H3[text()='Страхование для путешественников']/../../..//*[text()='Оформить онлайн']")
    public WebElement sendAppBtn;

    public InsurancePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickOformit(String menuItem) {
        sendAppBtn.findElement(By.xpath(".//[text()='" + menuItem + "']/../../..//*[text()='Оформить онлайн']")).click();
    }

    public void waitSendAppClickable() {
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//H3[@class='uc-full__header'][text()='Страхование для путешественников']/../../..//*[text()='Оформить онлайн']"))));
    }

    public void closeCookie() {
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        WebElement cookie = driver.findElement(By.xpath("//button[@class='kitt-cookie-warning__close']"));
        wait.until(ExpectedConditions.visibilityOf(cookie));
        cookie.click();
    }

}

