package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps {


    @Step("выбран пункт меню сверху {0} ")
    public void stepSelectMainMenu(String menuItem){ new MainPage() .selectMenuItem(menuItem);
    }

    @Step("выбран вид страхования  {0} ")
    public void stepInsuranceItem(String menuItem){
        new MainPage().selectInsuranceItem(menuItem);
    }
}
