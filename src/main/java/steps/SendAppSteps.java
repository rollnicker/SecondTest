package steps;

import pages.SendAppPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class SendAppSteps extends BaseSteps {

    @Step("Нажать на поле {0}")
    public void clickField(String field) {
        new SendAppPage(driver).clickField(field);
    }

    @Step("Дождаться загрузки экрана")
    public void stepWaitRegisterButton() {
        new SendAppPage(driver).waitRegisterButton();
    }
    @Step("Нажать кнопку оформить")
    public void stepArrangeClick(){
        new SendAppPage(driver).arrange.click();
    }

    @Step("в поле {0} заполняется значением {1}")
    public void stepFillField(String field, String value){
        new SendAppPage(driver).fillField(field, value);
    }

    @Step("Заполяется поле {0} значением {1}")
    public void stepFillFields(HashMap<String,String>fields){
        fields.forEach((key,value)->
                stepFillField(key,value));}

    @Step("поле {0} заполнено значением {1}")
    public void checkFillField(String field, String value){
        String actual = new SendAppPage(driver).getFillField(field);
        assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value),
                actual.equals(value));
    }
    @Step("поля заполнены верно")
    public void checkFillFields(HashMap<String,String>fields){
        fields.forEach((key,value)->
                checkFillField(key,value));}

    @Step("Нажать кнопку продолжить")
    public void stepClickConfirm() {
        new SendAppPage(driver).clickField("Продолжить");
    }

    @Step("Проверить, что появилось сообщение - Заполнены не все обязательные поля")
    public void stepCheckErrorMessage(String errorMessage){
        new SendAppPage(driver).checkFieldErrorMessage(errorMessage);
    }
}
