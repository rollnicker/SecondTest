import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;
import steps.BaseSteps;
import steps.InsuranceSteps;
import steps.MainSteps;
import steps.SendAppSteps;

import java.util.HashMap;

public class MyTestForAllureReport extends BaseSteps {

    MainSteps mainSteps = new MainSteps();
    InsuranceSteps insuranceSteps = new InsuranceSteps();
    SendAppSteps sendAppSteps = new SendAppSteps();

    HashMap<String, String> testData = new HashMap<>();


    @Title("Страхование")
    @Test


    public  void testImsurance(){

        testData.put("Застрахованные Фамилия","Иванов");
        testData.put("Застрахованные имя","Иван");
        testData.put("Застрахованные дата рождения","10.01.1999");

        testData.put("Фамилия","Петров");
        testData.put("Имя","Пётр");
        testData.put("Отчество","Петрович");
        testData.put("Дата рождения","10.01.1989");

        testData.put("Серия паспорта","1234");
        testData.put("Номер паспорта","123456");
        testData.put("Дата выдачи","10.01.2015");
        testData.put("Кем выдан","Отделом");

        testData.put("Телефон","");
        testData.put("Эл. почта","");
        testData.put("Повтор почты","");

        mainSteps.stepSelectMainMenu("Страхование");
        mainSteps.stepInsuranceItem("Перейти в каталог");

        insuranceSteps.stepCloseCookie();
        insuranceSteps.stepCheckTitle2("Страхование для путешественников");
        insuranceSteps.stepSendAppButton();

        sendAppSteps.stepWaitRegisterButton();
        sendAppSteps.stepArrangeClick();
        sendAppSteps.stepFillFields(testData);
        sendAppSteps.stepFillField("Кем выдан", "Отделом");
        sendAppSteps.clickField("Пол");
        sendAppSteps.checkFillFields(testData);
        sendAppSteps.stepClickConfirm();
        sendAppSteps.stepCheckErrorMessage("При заполнении данных произошла ошибка");
    }
}
