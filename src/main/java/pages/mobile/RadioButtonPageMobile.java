package pages.mobile;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class RadioButtonPageMobile extends BasePageMobile{

    @AndroidFindBy(id = "io.appium.android.apis:id/all")
    MobileElement allButton;

    @AndroidFindBy(id = "io.appium.android.apis:id/choice")
    MobileElement selectedResult;

    @AndroidFindBy(id = "io.appium.android.apis:id/clear")
    MobileElement clearAllButton;

    @Step
    public void clickAllButton() {
        allButton.click();
    }

    @Step
    public void clickClearAll() {
        clearAllButton.click();
    }

    @AndroidFindBy(id = "io.appium.android.apis:id/choice")
    MobileElement selectedResultNew;

    public String resultTextBefore = selectedResultNew.getText();

    public String resultTextAfter = selectedResult.getText();

}

