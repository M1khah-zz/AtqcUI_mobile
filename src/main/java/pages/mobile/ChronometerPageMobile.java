package pages.mobile;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;

public class ChronometerPageMobile extends BasePageMobile {

    @AndroidFindBy(id = "io.appium.android.apis:id/start")
    public MobileElement startButton;

    @AndroidFindBy(id = "io.appium.android.apis:id/stop")
    public MobileElement stopButton;

    @AndroidFindBy(id = "io.appium.android.apis:id/reset")
    public MobileElement resetButton;

    @AndroidFindBy(id = "io.appium.android.apis:id/set_format")
    public MobileElement setFormatButton;

    @AndroidFindBy(id = "io.appium.android.apis:id/clear_format")
    public MobileElement clearFormatButton;

    @AndroidFindBy(id = "io.appium.android.apis:id/chronometer")
    public MobileElement chronometer;

    @Step
    public void clickStartButton(){
        startButton.click();
    }

    @Step
    public void clickStopButton(){
        stopButton.click();
    }

    @Step
    public void clickResetFormat(){
        resetButton.click();
    }

    @Step
    public void clickSetFormat(){
        setFormatButton.click();
    }

    @Step
    public void clickClearFormatButton(){
        clearFormatButton.click();
    }

    @Step
    public String chronometerTime(){
        return chronometer.getText();
    }
}
