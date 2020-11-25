package steps;

import pages.InsurancePage;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertTrue;

public class InsuranceSteps {

    @Step("Закрыли высплывающее сообщение")
    public void stepCloseCookie(){ new InsurancePage().closeCookie();
    }

//    @Step("Проверить что заголовок {0} называется {1}")
//    public void stepCheckTitle() {
//        InsurancePage insurancePage = new InsurancePage(driver);
//        String actualTitle = insurancePage.title.getText();
//        String expectedTitle = "Страхование для путешественников";
//        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
//                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
//    }
    // Старая реализация проверки заголовка

    @Step("Проверить что заголовок Страхование путешественников называется {0}")
    public void stepCheckTitle2(String expectedTitle) {
        String actualTitle = new InsurancePage().title.getText();
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
    }

    @Step("Нажать кнопку Оформить Онлайн")
    public void stepSendAppButton(){
        InsurancePage insurancePage = new InsurancePage();
        insurancePage.waitSendAppClickable();
        insurancePage.sendAppBtn.click();
    }
}
