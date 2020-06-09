package com.atqc.tests.mobile;

import com.atqc.tests.BaseTest;
import framework.Utilities;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.testng.annotations.Test;
import pages.mobile.*;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
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

    }
}





