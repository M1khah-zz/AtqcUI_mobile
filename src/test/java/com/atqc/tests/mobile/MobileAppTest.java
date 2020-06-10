package com.atqc.tests.mobile;

import com.atqc.tests.BaseTest;
import framework.PlatformFactory;
import framework.Utilities;
import io.appium.java_client.*;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.TabsPageMobile;
import pages.mobile.*;

import java.util.Date;
import java.util.stream.IntStream;

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
    PickerPageMobile pickerPage;
    PopUpMenuPageMobile popUpMenuPage;
    RadioButtonPageMobile radioGroupPage;
    RotatingButtonPageMobile rotatingButtonPage;
    TextClockPageMobile textClockPage;
    DateWidgetPageMobile dateWidgetPage;
    DialogDateWidgetPageMobile dialogDateWidgetPage;
    SpinnerWidgetPageMobile spinnerPage;


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
        IntStream.range(0, 3).forEach(i -> Utilities.scrollUp());
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
        viewsPageMobile = new APIDemoPageMobile().clickOnViewsElement();
        IntStream.range(0, 2).forEach(i -> Utilities.scrollUp());
        pickerPage = viewsPageMobile.clickPickerElement();

        Utilities.scrollUp();

        assertThat(pickerPage.selectedValueText, equalTo("Value: kupima"));

    }

    @Test
    public void popUpMenuTest(){

        viewsPageMobile = new APIDemoPageMobile().clickOnViewsElement();
        IntStream.range(0, 2).forEach(i -> Utilities.scrollUp());
        popUpMenuPage = viewsPageMobile.clickPopupMobilePage();

        popUpMenuPage.clickPopUpButton();
        popUpMenuPage.clickWidgetButton();

        assertThat(popUpMenuPage.toastText, containsString("Add"));
    }

    @Test
    public void radioButtonTest(){

        viewsPageMobile = new APIDemoPageMobile().clickOnViewsElement();
        IntStream.range(0, 3).forEach(i -> Utilities.scrollUp());
        radioGroupPage = viewsPageMobile.clickRadioButtonElement();

        radioGroupPage.clickAllButton();
        radioGroupPage.clickClearAll();

        assertThat(radioGroupPage.resultTextBefore, is(not(radioGroupPage.resultTextAfter)));
    }

    @Test
    public void rotatingButtonTest(){

        viewsPageMobile = new APIDemoPageMobile().clickOnViewsElement();
        IntStream.range(0, 3).forEach(i -> Utilities.scrollUp());
        rotatingButtonPage = viewsPageMobile.clickRotatingButtonElement();

        Point locationBefore = rotatingButtonPage.rotatingButton.getLocation();
        Dimension sizeBefore = rotatingButtonPage.rotatingButton.getSize();
        Rectangle rectBefore = rotatingButtonPage.rotatingButton.getRect();
        rotatingButtonPage.translationXBar.sendKeys("200");
        rotatingButtonPage.scaleYBar.sendKeys("200");
        rotatingButtonPage.rotationZBar.sendKeys("200");
        Point locationAfter = rotatingButtonPage.rotatingButton.getLocation();
        Dimension sizeAfter = rotatingButtonPage.rotatingButton.getSize();
        Rectangle rectAfter = rotatingButtonPage.rotatingButton.getRect();

        assertThat(locationAfter, is(not(equalTo(locationBefore))));
        assertThat(sizeAfter, is(not(equalTo(sizeBefore))));
        assertThat(rectAfter, is(not(equalTo(rectBefore))));

    }

  @Test
  public void textClockTest(){

      viewsPageMobile = new APIDemoPageMobile().clickOnViewsElement();
      IntStream.range(0, 4).forEach(i -> Utilities.scrollUp());
      textClockPage = viewsPageMobile.clickTextClockElement();

      assertThat(textClockPage.HHMMFormat, equalTo(textClockPage.HHMM.format(new Date())));
      assertThat(textClockPage.mmDDYYFormat, equalTo(textClockPage.mmDDYY.format(new Date())));
      assertThat(textClockPage.mmDDYYHHMMFormat, equalTo(textClockPage.mmDDYYHHMM.format(new Date())));
      assertThat(textClockPage.hhMMSSFormat,equalTo(textClockPage.hhMMSS.format(new Date())));
  }

  @Test
  public void dateWidgetTest(){
      viewsPageMobile = new APIDemoPageMobile().clickOnViewsElement();
      dateWidgetPage = viewsPageMobile.clickDateWidgetsPage();
      dialogDateWidgetPage = dateWidgetPage.clickDialogButton();

      String displayedDateTimeTextText = dialogDateWidgetPage.displayedDateTime.getText();
      String dateBeforeChange = displayedDateTimeTextText;

      dialogDateWidgetPage.clickChangeButton();
      dialogDateWidgetPage.clickYearPickerButton();
      dialogDateWidgetPage.clickYear();
      dialogDateWidgetPage.clickNextMonthButton();
      dialogDateWidgetPage.clickDayOfMonth();
      dialogDateWidgetPage.clickOkButtonInPicker();
      assertThat(dialogDateWidgetPage.dateAfterChange, is(not(equalTo(dialogDateWidgetPage.dateBeforeChange))));
  }
}





