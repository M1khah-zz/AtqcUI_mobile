package pages.mobile;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class AlertPageMobile extends BasePageMobile {

    @AndroidFindBy(id = "io.appium.android.apis:id/two_buttons")
    private MobileElement firstAlertElement;

    @Step("CLick first alert element")
    public void clickFirstAlertElement() {
        firstAlertElement.click();
    }

    @AndroidFindBy(id = "android:id/alertTitle")
    private MobileElement alertMessageElement;

   public String alertMessageText = alertMessageElement.getText();
   public String correctMessageText = "Lorem ipsum dolor sit aie consectetur adipiscing";

}
