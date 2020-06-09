package com.atqc.tests.mobile;

import com.atqc.tests.BaseTest;
import framework.PlatformFactory;
import framework.Utilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.TabsPageMobile;
import pages.mobile.*;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class MobileAppTest extends BaseTest {

    AppPageMobile appPageMobile;
    AlarmPageMobile alarmPageMobile;
    AlarmControllerPageMobile alarmControllerPageMobile;
    FragmentPageMobile fragmentPageMobile;
    ContextMenuPageMobile contextMenuPageMobile;
    AlertPageMobile alertPageMobile;
    MenuPageMobile menuPageMobile;
    InflateXMLPageMobile inflateXmlPage;
    HideShowPageMobile hideShowPage;
    ViewsPageMobile viewsPageMobile;
    ChronometerPageMobile chronometerPage;
    HoloThemePageMobile holoThemePage;
    AnimationPageMobile animationPage;
    AnimationMenuPageMobile animationPageMenu;
    TabsPageMobile tabsPage;
    ContentByIntentPageMobile contentByIntentPage;


    @Test
    public void testForAlarmController(){

        appPageMobile = new APIDemoPageMobile().clickOnAppElement();
        alarmPageMobile = appPageMobile.clickAlarmElement();
        alarmControllerPageMobile = alarmPageMobile.clickAlarmControllerElement();
        alarmControllerPageMobile.clickOneShotAlarmButton();

        String toastText = "One-shot alarm will go off in 30 seconds based on the real time clock. Try changing the current time before then!";
        assertThat("Text is equal", Utilities.getToastMessage(), is(toastText));

    }

    @Test
    public void testForFragmentContextMenu(){

        appPageMobile = new APIDemoPageMobile().clickOnAppElement();
        fragmentPageMobile = appPageMobile.clickFragmentElement();
        contextMenuPageMobile = fragmentPageMobile.clickContextMenuElement();
        contextMenuPageMobile.longPressOnLongPressMeButton();

        assertThat("Context elements equals",contextMenuPageMobile.getCountOfMenuElements(),is(2));
        assertThat("Text is equal", contextMenuPageMobile.getTextElementByIndex(0), is("Menu A"));
        assertThat("Text is equal", contextMenuPageMobile.getTextElementByIndex(1), is("Menu B"));

        contextMenuPageMobile.clickOnMenuElementByIndex(0);

        String toastText = "Item 1a was chosen";
        assertThat("Text is equal", Utilities.getToastMessage(), is(toastText));
    }

    @Test
    public void dialogModalTest(){
        appPageMobile = new APIDemoPageMobile().clickOnAppElement();
        alertPageMobile = appPageMobile.clickAlertElement();
        alertPageMobile.clickFirstAlertElement();

        assertThat(alertPageMobile.alertMessageText, containsString(alertPageMobile.correctMessageText));
    }

    @Test
    public void inflateFromXMLTest(){
        appPageMobile = new APIDemoPageMobile().clickOnAppElement();
        menuPageMobile = appPageMobile.clickMenu();
        inflateXmlPage = menuPageMobile.clickInflateElement();

        String textBefore = inflateXmlPage.menuElements.get(1).getText();
        inflateXmlPage.clickSpinnerElement();
        String textAfter = inflateXmlPage.menuElements.get(1).getText();

        assertThat(textAfter, is(textBefore));
    }

    @Test
    public void hideShowTest(){
        appPageMobile = new APIDemoPageMobile().clickOnAppElement();
        fragmentPageMobile = appPageMobile.clickFragmentElement();
        hideShowPage = fragmentPageMobile.clickHideShowElement();

        hideShowPage.hideFrag1();
        boolean frag1isDisplayed = hideShowPage.fragment1.isDisplayed();
        assertThat(frag1isDisplayed, is(false));
        hideShowPage.hideFrag2();
        boolean frag2isDisplayed = hideShowPage.fragment2.isDisplayed();
        assertThat(frag2isDisplayed, is(false));
        hideShowPage.hideFrag1();
        boolean frag1isDisplayedNew = hideShowPage.fragment1.isDisplayed();
        assertThat(frag1isDisplayedNew, is(true));
        hideShowPage.hideFrag2();
        boolean frag2isDisplayedNew = hideShowPage.fragment2.isDisplayed();
        assertThat(frag2isDisplayedNew, is(true));
    }

    @Test
    public void chronometerTest(){
        viewsPageMobile = new APIDemoPageMobile().clickOnViewsElement();
        chronometerPage = viewsPageMobile.clickChronometerElement();

        assertThat(chronometerPage.chronometerTime(), equalTo("Initial format: 00:00"));
        chronometerPage.clickSetFormat();
        chronometerPage.clickStartButton();
        chronometerPage.clickStopButton();
        assertThat(chronometerPage.chronometerTime(), containsString("Formatted time"));
        chronometerPage.clickClearFormatButton();
        chronometerPage.clickStartButton();
        chronometerPage.clickStopButton();
        assertThat(chronometerPage.chronometerTime(), not(containsString("Formatted time")));
        chronometerPage.clickResetFormat();
        assertThat(chronometerPage.chronometerTime(),is("00:00"));
    }

    @Test
    public void holoThemeTest(){

        viewsPageMobile = new APIDemoPageMobile().clickOnViewsElement();
        holoThemePage = viewsPageMobile.clickControlsElement();

        holoThemePage.themesList.get(5).click();
        assertThat(holoThemePage.themeTitle.getText(), containsString("Holo"));

    }

    @Test
    public void animationTest(){

        viewsPageMobile = new APIDemoPageMobile().clickOnViewsElement();
        Utilities.scrollUp();
        animationPageMenu = viewsPageMobile.clickLayoutElement();
        animationPage = animationPageMenu.clickGridElement();

        WebDriverWait wait = new WebDriverWait(PlatformFactory.getDriver(), 10);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MobileBy.className("android.widget.ImageView")));

        assertThat(animationPage.gridElements, is(notNullValue()));

    }

    @Test
    public void contentByIntentTest(){
        viewsPageMobile = new APIDemoPageMobile().clickOnViewsElement();
        Utilities.scrollUp();
        Utilities.scrollUp();
        Utilities.scrollUp();
        tabsPage = viewsPageMobile.clickTabsElement();
        contentByIntentPage = tabsPage.clickContentByIntent();

        contentByIntentPage.screenTabs.get(2).click();
        assertThat(contentByIntentPage.listElements.get(0), is(notNullValue()));
        contentByIntentPage.screenTabs.get(3).click();

        contentByIntentPage.newPhotoButton.click();
        assertThat(contentByIntentPage.addedPhotoElement, is(notNullValue()));
        contentByIntentPage.clearPhotoButton.click();
        assertThat(contentByIntentPage.noPhotosElement, is(notNullValue()));
    }

    @Test
    public void pickerTest(){
        
    }
}





