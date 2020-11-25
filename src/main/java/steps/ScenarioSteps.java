package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

public class ScenarioSteps {

    MainSteps mainSteps = new MainSteps();

    InsuranceSteps insuranceSteps = new InsuranceSteps();

    SendAppSteps sendAppSteps = new SendAppSteps();

    @When("^выбран пункт меню \"(.*)\"$")
    public void stepSelectMainMenu(String menuItem){
        mainSteps.stepSelectMainMenu(menuItem);
    }

    @When("^выбран подпункт Страхования - \"(.*)\"$")
    public void stepSelectTypeInsurance(String menuItem) {
        mainSteps.stepInsuranceItem(menuItem);
    }

    @Then("^ждем появления куки сообщения и закрываем$")
    public void stepCloseCookie(){
        insuranceSteps.stepCloseCookie(); }

        @Then("^проверяем наличие на странице заголовка \"(.*)\"$")
        public void steoCheckTitle (String title){
        insuranceSteps.stepCheckTitle2(title);
        }

    @When("^выполнено нажатие на кнопку - Оформить онлайн$")
    public void stepSendAppButton(){
        insuranceSteps.stepSendAppButton();
    }

    @Then("^ждем загрузки страницы$")
    public void stepWaitButton() {
        sendAppSteps.stepWaitRegisterButton();
    }

    @When("^выполнено нажатие на кнопку Оформить$")
    public void stepArrangeButtonClick() {
        sendAppSteps.stepArrangeClick();
    }

    @When("^заполняются поля:$")
    public void stepFillFields(DataTable fields){
        fields.asMap(String.class, String.class).forEach(
                (key, value) -> sendAppSteps.stepFillField(key, value));
    }
    @When("^нажали на кнопку - \"(.*)\"$")
    public void clickGender(String button){
        sendAppSteps.clickField(button);
    }

    @Then("^значения равны:$")
    public void stepCheckFields(DataTable fields){
        fields.asMap(String.class, String.class).forEach((key, value) -> sendAppSteps.checkFillField(key, value));
    }
    @Then("^появилось сообщение об ошибке - \"(.*)\"$")
    public void stepCheckErrorMessage(String message){
        sendAppSteps.stepCheckErrorMessage(message);
    }

}
