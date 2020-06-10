package pages.mobile;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

import java.util.List;

public class InflateXMLPageMobile extends BasePageMobile {

    @AndroidFindBy(id = "io.appium.android.apis:id/spinner")
    public MobileElement spinnerElement;

    @AndroidFindBy(className = "android.widget.CheckedTextView")
    public List<MobileElement> menuElements;

    @Step("Click spinner element")
    public void clickSpinnerElement(){
        spinnerElement.click();
    }

    public String buttonText = menuElements.get(1).getText();

}
