package pages.mobile;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PickerPageMobile extends BasePageMobile{

    @AndroidFindBy(id = "io.appium.android.apis:id/textView1")
    MobileElement selectedValue;
    public String selectedValueText = selectedValue.getText();

}
