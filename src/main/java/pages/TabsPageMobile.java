package pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.mobile.BasePageMobile;
import pages.mobile.ContentByIntentPageMobile;

import java.util.List;

public class TabsPageMobile extends BasePageMobile {

    @AndroidFindBy(accessibility = "3. Content By Intent")
    MobileElement contentByIntent;

    public ContentByIntentPageMobile clickContentByIntent() {
        contentByIntent.click();
        return new ContentByIntentPageMobile();
    }
}
