package pages.mobile;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;

import java.util.List;

public class DialogDateWidgetPageMobile extends BasePageMobile{

    @AndroidFindBy(id = "io.appium.android.apis:id/dateDisplay")
    public
    MobileElement displayedDateTime;
    public String displayedDateTimeTextText = displayedDateTime.getText();

    public String dateBeforeChange = displayedDateTimeTextText;

    @AndroidFindBy(id = "io.appium.android.apis:id/pickDate")
    MobileElement changeDateButton;

    @AndroidFindBy(id = "android:id/date_picker_header_year")
    MobileElement yearPickerButton;

    @AndroidFindBy(className = "android.widget.TextView")
    List<MobileElement> textViews;

    @AndroidFindBy(id ="android:id/next")
    MobileElement nextMonthButton;

    @AndroidFindBy(className = "android.view.View")
    List<MobileElement> daysOfMonth;

    @AndroidFindBy(id = "android:id/button1")
    MobileElement okButtonInPicker;

    @AndroidFindBy(id = "io.appium.android.apis:id/dateDisplay")
    MobileElement displayedDateTimeNew;

    @Step
    public void clickChangeButton() {
        changeDateButton.click();
    }

    @Step
    public void clickYearPickerButton() {
        yearPickerButton.click();
    }

    @Step
    public void clickYear() {
        textViews.get(7).click();
    }

    @Step
    public void clickNextMonthButton() {
        nextMonthButton.click();
    }

    @Step
    public void clickDayOfMonth() {
        daysOfMonth.get(15).click();
    }

    @Step
    public void clickOkButtonInPicker() {
        okButtonInPicker.click();
    }

    public String displayedDateTimeTextTextNew = displayedDateTimeNew.getText();
    public String dateAfterChange = displayedDateTimeTextTextNew;

    @AndroidFindBy(id = "io.appium.android.apis:id/dateDisplay")
    MobileElement displayedTimeBefore;

    public String timeBefore = displayedTimeBefore.getText();

    @AndroidFindBy(id = "io.appium.android.apis:id/pickTime")
    MobileElement changeTimeButton;

    @Step
    public void clickChangeTime() {
        changeTimeButton.click();
    }

    @AndroidFindBy(className = "android.widget.RadialTimePickerView$RadialPickerTouchHelper")
    List<MobileElement> radialPicker;

    public void setRadislPicker() {
        radialPicker.get(6).click();
        radialPicker.get(6).click();
        okButtonInPicker.click();
    }

    @AndroidFindBy(id = "io.appium.android.apis:id/dateDisplay")
    MobileElement displayedTimeAfter;

    public String timeAfter = displayedTimeAfter.getText();

    @AndroidFindBy(id = "io.appium.android.apis:id/pickTimeSpinner")
    MobileElement changeTimeButtonSpinner;

    public SpinnerWidgetPageMobile clickSpinnerElement() {
        changeTimeButtonSpinner.click();
        return new SpinnerWidgetPageMobile();
    }

}
