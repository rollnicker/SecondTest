package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    @FindBy(xpath = "//ul[contains(@class,'kitt-top-menu__list kitt-top-menu__list_icons kitt-top-menu__list_center')]")
    WebElement menuItems;

    @FindBy(xpath = "//DIV[@class='kitt-top-menu__dropdown kitt-top-menu__dropdown_icons']")
    WebElement menuInsurance;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void selectMenuItem(String itemName) {
        menuItems.findElement(By.xpath(".//li[contains(@class,'kitt-top-menu__item kitt-top-menu__item_first')]//A[contains(text(),'" + itemName + "')]")).click();
    }

    public void selectInsuranceItem(String itemName) {
        menuInsurance.findElement(By.xpath("//li[contains(@class,'kitt-top-menu__item')]//A[contains(text(),'" + itemName + "')]")).click();
        // Хотел уточнить, почему точка перед //li в 27 строчке не дает запустить тест. Если ее добавить, то локатор не находится
    }

}
