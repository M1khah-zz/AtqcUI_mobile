package pages.mobile;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class HideShowPageMobile extends BasePageMobile{

    @AndroidFindBy(id = "io.appium.android.apis:id/fragment1")
    public MobileElement fragment1;

    @AndroidFindBy(id = "io.appium.android.apis:id/fragment2")
    public MobileElement fragment2;

    @AndroidFindBy(id = "io.appium.android.apis:id/frag1hide")
    public MobileElement hideFrag1Button;

    @AndroidFindBy(id = "io.appium.android.apis:id/frag2hide")
    public MobileElement hideFrag2Button;

    @Step("Hide fragment 1")
    public void hideFrag1(){
        hideFrag1Button.click();
    }

    @Step("Hide fragment 2")
    public void hideFrag2(){
        hideFrag2Button.click();
    }
}
