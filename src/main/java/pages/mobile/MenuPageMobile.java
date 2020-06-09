package pages.mobile;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class MenuPageMobile extends BasePageMobile{

    @AndroidFindBy(id = "android:id/text1")
    public MobileElement inflateElement;

    @Step("Click inflate element")
    public InflateXMLPageMobile clickInflateElement() {
        inflateElement.click();
        return new InflateXMLPageMobile();
    }
}
