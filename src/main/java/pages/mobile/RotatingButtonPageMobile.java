package pages.mobile;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;

public class RotatingButtonPageMobile extends BasePageMobile{

    @AndroidFindBy(id = "io.appium.android.apis:id/rotatingButton")
    public
    MobileElement rotatingButton;

    @AndroidFindBy(id = "io.appium.android.apis:id/translationX")
    public
    MobileElement translationXBar;

    @AndroidFindBy(id = "io.appium.android.apis:id/scaleY")
    public
    MobileElement scaleYBar;

    @AndroidFindBy(id = "io.appium.android.apis:id/rotationZ")
    public
    MobileElement rotationZBar;

}
