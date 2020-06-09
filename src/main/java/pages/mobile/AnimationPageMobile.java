package pages.mobile;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class AnimationPageMobile {

    @AndroidFindBy(className = "android.widget.ImageView")
    public
    List<MobileElement> gridElements;

}
