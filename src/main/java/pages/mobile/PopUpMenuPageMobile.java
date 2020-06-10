package pages.mobile;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class PopUpMenuPageMobile extends  BasePageMobile{

    @AndroidFindBy(className = "android.widget.Button")
    MobileElement makePopupButton;

    @AndroidFindBy(className = "android.widget.ListView")
    MobileElement widgetAdd;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.Toast")
    MobileElement toastMessage;

    @Step
    public void clickPopUpButton(){
        makePopupButton.click();
    }

    @Step
    public void clickWidgetButton(){
        widgetAdd.click();
    }

    public String toastText = toastMessage.getText();

}
