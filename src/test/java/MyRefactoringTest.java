import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.InsurancePage;
import pages.MainPage;
import pages.SendAppPage;
import steps.BaseSteps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyRefactoringTest extends BaseSteps {

    @Test
@Ignore
    public void testInsurance() throws Exception {
        driver.get(baseUrl + "/");
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMenuItem("Страхование");
        mainPage.selectInsuranceItem("Перейти ");
        // Переходим в каталог страховки

        InsurancePage insurancePage = new InsurancePage(driver);
        insurancePage.closeCookie();

        insurancePage.waitSendAppClickable();
        String actualTitle = insurancePage.title.getText();
        String expectedTitle = "Страхование для путешественников";
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
        insurancePage.sendAppBtn.click();
        // На экране выбора страховки сравниваем название заголовка и нажимаем ОФормить

        SendAppPage sendAppPage = new SendAppPage(driver);
        sendAppPage.waitRegisterButton();
        sendAppPage.arrange.click();

        sendAppPage.gender.click();
        sendAppPage.fillField("Застрахованные Фамилия", "Иванов");
        sendAppPage.fillField("Застрахованные имя", "Иван");
        sendAppPage.fillField("Застрахованные дата рождения", "10011999");

        sendAppPage.clickField("Фамилия");
        sendAppPage.fillField("Фамилия", "Петров");
        sendAppPage.fillField("Имя", "Пётр");
        sendAppPage.fillField("Отчество", "Петрович");
        sendAppPage.fillField("Дата рождения", "10011989");

        sendAppPage.clickField("Серия паспорта");
        sendAppPage.fillField("Серия паспорта", "1234");
        sendAppPage.fillField("Номер паспорта", "123456");
        sendAppPage.fillField("Дата выдачи", "10012015");
        sendAppPage.clickField("Кем выдан");
        sendAppPage.fillField("Кем выдан", "Отдоелом");

        sendAppPage.fillField("Телефон", "");
        sendAppPage.fillField("Эл. почта", "");
        sendAppPage.fillField("Повтор почты", "");

        sendAppPage.clickField("Продолжить");
        sendAppPage.checkFieldErrorMessage("При заполнении данных произошла ошибка");

        // Проверяем поля
        checkFillField("Иванов", By.id("surname_vzr_ins_0"));
        checkFillField("Иван", By.id("name_vzr_ins_0"));
        checkFillField("10.01.1999", By.id("birthDate_vzr_ins_0"));

        checkFillField("Петров", By.id("person_lastName"));
        checkFillField("Пётр", By.id("person_firstName"));
        checkFillField("Петрович", By.id("person_middleName"));
        checkFillField("10.01.1989", By.id("person_birthDate"));

        checkFillField("1234", By.id("passportSeries"));
        checkFillField("123456", By.id("passportNumber"));
        checkFillField("Отдоелом", By.id("documentIssue"));
        checkFillField("10.01.2015", By.id("documentDate"));

        checkFillField("", By.id("phone"));
        checkFillField("", By.id("email"));
        checkFillField("", By.id("repeatEmail"));
    }
}