package pages.mobile;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;

public class AppPageMobile extends BasePageMobile {

    @iOSXCUITFindBy(accessibility = "")
    @AndroidFindBy(accessibility = "Alarm")
    private MobileElement alarmElement;

    @iOSXCUITFindBy(accessibility = "")
    @AndroidFindBy(accessibility = "Fragment")
    private MobileElement fragmentElement;

    @AndroidFindBy(accessibility = "Alert Dialogs")
    private MobileElement alertDialogsElement;

    @AndroidFindBy(accessibility = "Menu")
    public MobileElement menulement;

    @Step("Click menu")
    public MenuPageMobile clickMenu(){
        menulement.click();
        return new MenuPageMobile();
    }

    @Step("Click alert dialogs")
    public AlertPageMobile clickAlertElement(){
        alertDialogsElement.click();
        return new AlertPageMobile();
    }

    @Step("Click on 'Alarm'")
    public AlarmPageMobile clickAlarmElement() {
        alarmElement.click();
        return new AlarmPageMobile();
    }

    @Step("Click on 'Fragment'")
    public FragmentPageMobile clickFragmentElement() {
        fragmentElement.click();
        return new FragmentPageMobile();
    }

}
