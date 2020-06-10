package pages.mobile;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class TextClockPageMobile extends BasePageMobile{

    @AndroidFindBy(className = "android.widget.TextView")
    List<MobileElement> timeStrings;

    public String HHMMFormat = timeStrings.get(2).getText();
    public String mmDDYYFormat = timeStrings.get(3).getText();
    public String mmDDYYHHMMFormat = timeStrings.get(4).getText();
    public String hhMMSSFormat = timeStrings.get(5).getText();

    public SimpleDateFormat HHMM = new SimpleDateFormat("h:mm a");
    public SimpleDateFormat mmDDYY = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
    public SimpleDateFormat mmDDYYHHMM = new SimpleDateFormat("MM/dd/yy hmma");
    public SimpleDateFormat hhMMSS = new SimpleDateFormat("hh:mm:ss a");


}
