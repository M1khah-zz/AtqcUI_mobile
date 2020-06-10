package pages.mobile;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class HoloThemePageMobile extends BasePageMobile {

    @AndroidFindBy(className = "android.widget.TextView")
    public List<MobileElement> themesList;

    @AndroidFindBy(id = "android:id/action_bar_title")
    public MobileElement themeTitle;

}
