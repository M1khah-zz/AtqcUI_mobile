package pages.mobile;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.PointOption;

public class SpinnerWidgetPageMobile extends BasePageMobile {

    @AndroidFindBy(id = "android:id/button1")
    MobileElement okButtonInSpinner;

    public void clickOkButtonInSpinner() {
        okButtonInSpinner.click();
    }

}
