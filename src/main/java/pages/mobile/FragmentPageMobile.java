package pages.mobile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class FragmentPageMobile extends BasePageMobile {

    @AndroidFindBy(accessibility = "Context Menu")
    private MobileElement contextMenuElement;

    @Step("Click on context menu")
    public ContextMenuPageMobile clickContextMenuElement() {
        contextMenuElement.click();
        return new ContextMenuPageMobile();
    }
}
