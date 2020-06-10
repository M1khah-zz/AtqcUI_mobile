package pages.mobile;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import pages.TabsPageMobile;

public class ViewsPageMobile extends BasePageMobile {

    @AndroidFindBy(accessibility = "Chronometer")
    public MobileElement chronometerElement;

    @AndroidFindBy(accessibility = "Controls")
    public MobileElement controlsElement;

    @AndroidFindBy(accessibility = "Layout Animation")
    public MobileElement layoutAnimationElement;

    @AndroidFindBy(accessibility = "Tabs")
    MobileElement tabsElement;

    @AndroidFindBy(accessibility = "3. Content By Intent")
    MobileElement contentByIntent;

    @AndroidFindBy(accessibility = "Picker")
    MobileElement pickerElement;

    @AndroidFindBy(accessibility = "Popup Menu")
    MobileElement popupMenuElement;

    @AndroidFindBy(accessibility = "Radio Group")
    MobileElement radioGroupElement;

    @AndroidFindBy(accessibility = "Rotating Button")
    MobileElement rotatingButtonElement;

    @AndroidFindBy(accessibility = "TextClock")
    MobileElement textClockElement;

    @AndroidFindBy(accessibility = "Date Widgets")
    MobileElement dateWidgetsElement;

    public DateWidgetPageMobile clickDateWidgetsPage() {
        dateWidgetsElement.click();
        return new DateWidgetPageMobile();
    }

    public TextClockPageMobile clickTextClockElement() {
        textClockElement.click();
        return new TextClockPageMobile();
    }

    public RotatingButtonPageMobile clickRotatingButtonElement() {
        rotatingButtonElement.click();
        return new RotatingButtonPageMobile();
    }

    public RadioButtonPageMobile clickRadioButtonElement() {
        radioGroupElement.click();
        return new RadioButtonPageMobile();
    }

    public PopUpMenuPageMobile clickPopupMobilePage() {
        popupMenuElement.click();
        return new PopUpMenuPageMobile();
    }
    public PickerPageMobile clickPickerElement() {
        pickerElement.click();
        return new PickerPageMobile();
    }

    public ContentByIntentPageMobile clickContentByIntent() {
        contentByIntent.click();
        return new ContentByIntentPageMobile();
    }

    public TabsPageMobile clickTabsElement() {
        tabsElement.click();
        return new TabsPageMobile();
    }

    public AnimationMenuPageMobile clickLayoutElement(){
        layoutAnimationElement.click();
        return new AnimationMenuPageMobile();
    }

    public HoloThemePageMobile clickControlsElement() {
        controlsElement.click();
        return new HoloThemePageMobile();
    }

    public ChronometerPageMobile clickChronometerElement(){
        chronometerElement.click();
        return new ChronometerPageMobile();
    }
}
