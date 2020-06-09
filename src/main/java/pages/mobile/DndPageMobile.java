package pages.mobile;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;

public class DndPageMobile extends BasePageMobile{

    @AndroidFindBy(id = "io.appium.android.apis:id/drag_dot_1")
    public MobileElement dragDot1;

    @AndroidFindBy(id = "io.appium.android.apis:id/drag_dot_2")
    public MobileElement dragDot2;

    @AndroidFindBy(id = "io.appium.android.apis:id/drag_result_text")
    public MobileElement dragResult;
    String dragResultText = dragResult.getText();
}
