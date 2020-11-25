package steps;

import pages.SendAppPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public class SendAppSteps {

    @Step("Нажать на поле {0}")
    public void clickField(String field) {
        new SendAppPage().clickField(field);
    }


    @Step("Дождаться загрузки экрана")
    public void stepWaitRegisterButton() {
        new SendAppPage().waitRegisterButton();
    }
    @Step("Нажать кнопку оформить")
    public void stepArrangeClick(){
        new SendAppPage().arrange.click();
    }


    @Step("в поле {0} заполняется значением {1}")
    public void stepFillField(String field, String value){
        new SendAppPage().fillField1(field, value);
    }
    @Step("заполняются поля")
    public void stepFillFields(HashMap<String,String>fields){
        fields.forEach(this::stepFillField);}

    @Step("поле {0} заполнено значением {1}")
    public void checkFillField(String field, String value){
        String actual = new SendAppPage().getFillField(field);
        assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value),
                actual.equals(value));}
    @Step("поля заполнены верно")
    public void checkFillFields(HashMap<String,String>fields){
        fields.forEach(this::checkFillField);}

    @Step("Нажать кнопку продолжить")
    public void stepClickConfirm() {
        new SendAppPage().clickField("Продолжить");
    }

    @Step("Проверить, что появилось сообщение - Заполнены не все обязательные поля")
    public void stepCheckErrorMessage(String errorMessage){
        new SendAppPage().checkFieldErrorMessage(errorMessage);
    }
}
