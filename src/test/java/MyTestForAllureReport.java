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

//        testData.put("Застрахованные Фамилия","Иванов");
//        testData.put("Застрахованные имя","Иван");
//        testData.put("Застрахованные дата рождения","10011999");
//
//        testData.put("Фамилия","Петров");
//        testData.put("Имя","Пётр");
//        testData.put("Отчество","Петрович");
//        testData.put("Дата рождения","10011989");
//
        testData.put("Серия паспорта","1234");
        testData.put("Номер паспорта","123456");
        testData.put("Дата выдачи","10012015");
        testData.put("Кем выдан","Отдоелом");
//
//        testData.put("Телефон","");
//        testData.put("Эл. почта","");
//        testData.put("Повтор почты","");

        mainSteps.stepSelectMainMenu("Страхование");
        mainSteps.stepInsuranceItem("Перейти в каталог");

        insuranceSteps.stepCloseCookie();
        insuranceSteps.stepCheckTitle2("Страхование для путешественников");
        insuranceSteps.stepSendAppButton();


        sendAppSteps.stepArrangeClick();
        sendAppSteps.clickField("Серия паспорта");
        sendAppSteps.stepFillFields(testData);
//        sendAppSteps.stepClickConfirm();
//        sendAppSteps.stepCheckErrorMessage("При заполнении данных произошла ошибка");
    }
}
