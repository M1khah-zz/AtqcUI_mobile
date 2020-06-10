package pages.mobile;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;

import java.util.List;

public class DateWidgetPageMobile extends BasePageMobile{

    @AndroidFindBy(accessibility = "1. Dialog")
    MobileElement dialogOption;

    @Step
    public DialogDateWidgetPageMobile clickDialogButton() {
        dialogOption.click();
        return new DialogDateWidgetPageMobile();
    }

}
