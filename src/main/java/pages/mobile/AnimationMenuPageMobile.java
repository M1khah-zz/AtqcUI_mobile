package pages.mobile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AnimationMenuPageMobile extends BasePageMobile {

    @AndroidFindBy(accessibility = "1. Grid Fade")
    MobileElement gridFade;

    public AnimationPageMobile clickGridElement(){
        gridFade.click();
        return new AnimationPageMobile();
    }
}
