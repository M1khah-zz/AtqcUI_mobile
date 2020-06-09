package pages.mobile;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class ContentByIntentPageMobile extends BasePageMobile{

    @AndroidFindBy(className = "android.widget.LinearLayout")
    public
    List<MobileElement> listElements;

    @AndroidFindBy(className = "android.widget.TextView")
    public
    List<MobileElement> screenTabs;


    @AndroidFindBy(id = "io.appium.android.apis:id/add")
    public
    MobileElement newPhotoButton;

    @AndroidFindBy(id = "io.appium.android.apis:id/clear")
    public
    MobileElement clearPhotoButton;

    @AndroidFindBy(id = "io.appium.android.apis:id/empty")
    public
    MobileElement noPhotosElement;

    @AndroidFindBy(id = "android.widget.ImageView")
    public
    MobileElement addedPhotoElement;
}
