package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendAppPage extends BasePage {

    @FindBy(xpath = "//BUTTON[text()='Оформить']")
    public WebElement arrange;
    // Кнопка оформить

    @FindBy(id = "surname_vzr_ins_0")
    WebElement insuredLastName;
    @FindBy(id = "name_vzr_ins_0")
    WebElement InsuredFirstName;
    @FindBy(id = "birthDate_vzr_ins_0")
    WebElement InsuredBirthDate;
    // Фамилия, имя и др страхованных
    @FindBy(id = "person_lastName")
    WebElement lastName;
    @FindBy(id = "person_firstName")
    WebElement firstName;
    @FindBy(id = "person_middleName")
    WebElement middleName;
    @FindBy(id = "person_birthDate")
    WebElement birthDate;
    // ФиО и дата рождения страховщика
    @FindBy(xpath = "//label[text()='Женский']")
    public WebElement gender;
    @FindBy(id = "passportSeries")
    WebElement passportSeries;
    @FindBy(id = "passportNumber")
    WebElement passportNumber;
    @FindBy(id = "documentIssue")
    WebElement documentIssue;
    @FindBy(id = "documentDate")
    WebElement documentDate;
    // Паспортные данные
    @FindBy(id = "phone")
    WebElement phone;
    @FindBy(id = "email")
    WebElement email;
    @FindBy(id = "repeatEmail")
    WebElement repeatEmail;
    // Контакты
    @FindBy(xpath = "//DIV[@class='col-xl-3 col-md-4 col-12']//*[contains(text(),'Продолжить')]")
    WebElement sendButton;

    // Кнопка отправить
    @FindBy(xpath = "//BUTTON[@class='btn btn-util page__btn']")
    public WebElement backButton;


    public SendAppPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(arrange));
        this.driver = driver;
    }

    public void fillField(String fieldName, String value){
        switch (fieldName){
            case  "Застрахованные Фамилия":
                fillField(insuredLastName, value);
                break;
            case  "Застрахованные имя":
                fillField(InsuredFirstName, value);
                break;
            case  "Застрахованные дата рождения":
                fillField(InsuredBirthDate, value);
                break;
            case  "Фамилия":
                fillField(lastName, value);
                break;
            case  "Имя":
                fillField(firstName, value);
                break;
            case  "Отчество":
                fillField(middleName, value);
                break;
            case  "Дата рождения":
                fillField(birthDate, value);
                break;
            case  "Серия паспорта":
                fillField(passportSeries, value);
                break;
            case  "Номер паспорта":
                fillField(passportNumber, value);
                break;
            case  "Дата выдачи":
                fillField(documentDate, value);
                break;
            case  "Кем выдан":
                fillField(documentIssue, value);
                break;
            case  "Телефон":
                fillField(phone, value);
                break;
            case  "Эл. почта":
                fillField(email, value);
                break;
            case  "Повтор почты":
                fillField(repeatEmail, value);
                break;

            default:  throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }

    public String getFillField(String fieldName){
        switch (fieldName){
            case  "Застрахованные Фамилия":
                return insuredLastName.getAttribute("value");
            case  "Застрахованные имя":
                return InsuredFirstName.getAttribute("value");
            case  "Застрахованные дата рождения":
                return InsuredBirthDate.getAttribute("value");
            case  "Фамилия":
                return lastName.getAttribute("value");
            case  "Имя":
                return firstName.getAttribute("value");
            case  "Отчество":
                return middleName.getAttribute("value");
            case  "Дата рождения":
                return birthDate.getAttribute("value");
            case  "Серия паспорта":
                return passportSeries.getAttribute("value");
            case  "Номер паспорта":
                return passportNumber.getAttribute("value");
            case  "Дата выдачи":
                return documentDate.getAttribute("value");
            case  "Кем выдан":
                return documentIssue.getAttribute("value");
            case  "Телефон":
                return phone.getAttribute("value");
            case  "Эл. почта":
                return email.getAttribute("value");
            case  "Повтор почты":
                return repeatEmail.getAttribute("value");
        }
        throw new AssertionError("Поле не объявлено на странице");
    }

    public void checkFieldErrorMessage(String errorMessage){
        String xpath = "//div[@class='alert-form alert-form-error']";
        String actualValue = driver.findElement(By.xpath(xpath)).getText();
        org.junit.Assert.assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", actualValue, errorMessage),
                actualValue.contains(errorMessage));
    }
    public void waitRegisterButton(){
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//BUTTON[text()='Оформить']"))));
    }
    public void clickField(String fieldName) {
        switch (fieldName) {
            case "Фамилия":
                lastName.click();
                break;
            case "Серия паспорта":
                passportSeries.click();
                break;
            case "Кем выдан":
                documentIssue.click();
                break;
            case "Продолжить":
                sendButton.click();
                break;
        }
    }
}