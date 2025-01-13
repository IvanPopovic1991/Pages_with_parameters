package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.io.IOException;

public class CrmPage extends BasePage {
    public CrmPage(WebDriver driver) {
        super(driver);
    }

    int waitSeconds = 10;

    @FindBy(xpath = "//input[@id='userNameInput']")
    public WebElement usernameCrm;

    @FindBy(xpath = "//input[@id='passwordInput']")
    public WebElement passwordCrm;

    @FindBy(xpath = "//div[@id='submissionArea']//span[@id='submitButton']")
    public WebElement signInCrm;

    @FindBy(xpath = "//iframe[@id='InlineDialog_Iframe']")
    public WebElement iFrameMicrosoftCrm;

    @FindBy(xpath = "//div[@id='navTourCloseButtonImage']//img[@alt='Close']")
    public WebElement closeMicrosoftCrm;

    @FindBy(xpath = "//iframe[@id='contentIFrame0']")
    public WebElement iFrameSearch;

    @FindBy(xpath = "//input[@id='crmGrid_findCriteria']")
    public WebElement searchInCrm;

    ////div[@style='height:100%']//input[@id='crmGrid_findCriteria']

    @FindBy(xpath = "//a[@id='crmGrid_findCriteriaButton']//img[@id='crmGrid_findCriteriaImg']")
    public WebElement searchBtnCrm;

    @FindBy(xpath = "//div[@id='crmGrid_divDataArea']//tr[@class='ms-crm-List-Row']/td[3]")
    public WebElement accountCrm;

    @FindBy(xpath = "//iframe[@id='contentIFrame1']")
    public WebElement iFrameAccDetails;

    @FindBy(xpath = "//div[@id='FormTitle']//h1[@title='Testq Testa']")
    public WebElement accFullNameCrm;

    @FindBy(xpath = "//div[@class='ms-crm-Inline-Value ms-crm-HeaderTile']")
    public WebElement accDemoField;

    @FindBy(xpath = "//h2[@id='tab_4_header_h2' and contains(text(),'Environment & Marketing Info')]")
    public WebElement marketingSection;

    @FindBy(xpath = "//a[@id='FormSecNavigationControl-Icon']")
    public WebElement menuBtn;

    @FindBy(xpath = "//table[@id='flyoutFormSection_ContentTable']/..//td[@title='Environment & Marketing Info']")
    public WebElement envAndMarSec;

    @FindBy(xpath = "//div[@id='crmFormHeaderTop']")
    public WebElement borderTopColorForRegulation;

    @FindBy(xpath = "//div[@id='lc_sms_verification']/div//span")
    public WebElement smsVerification;

    @FindBy(xpath = "//div[@id='lv_linkid']//div//span")
    public WebElement linkId;

    public void logInCrm(String username, String password) {
        typeText(usernameCrm, username, "username for CRM");
        typeText(passwordCrm, password, "password for CRM");
        clickElement(signInCrm, "sign in to CRM");
    }

    public void loopForTagsCrm() {
        String number = "1434";
        String[] tags = {"lv_tag", "lv_tag1", "lv_googleid", "lv_tlid",
                "lv_tag2", "lv_tag3", "lv_g_track", "lv_gdevice", "lv_g_geo", "lv_g_geoint", "lv_g_device_model", "lv_g_adpos"};
        String[] valueOfTags = {"ivanA" + number, "ivanB@" + number, "ivanC@" + number, "ivanK" + number,
                "ivanL" + number, "ivanM" + number, "ivanI" + number, "ivanF" + number,
                "ivanD" + number, "ivanE" + number, "ivanG" + number, "ivanH" + number};
        for (int i = 0; i < tags.length; i++) {
            tagsInTheCrm(tags[i], valueOfTags[i]);
        }
    }
    public void loopForAccDetailsCrm(String email) {
        String[] tags = {"lv_firstname", "lv_lastname", "emailaddress1"};
        String[] valueOfTags = {"Testq", "Testa", email};
        for (int i = 0; i < tags.length; i++) {
            tagsInTheCrm(tags[i], valueOfTags[i]);
        }
    }

    public void tagsInTheCrm(String tag, String value) {
        String valueOfTag = readAttribute(By.xpath("//div[@id='{Tag}']".replace("{Tag}", tag)), "title", "tag");
        System.out.println("This is the value of the " + tag + ": " + value);
        Assert.assertEquals(valueOfTag, value);
    }

    public void checkCrmData(String email, String fullName, String regulation){
        driver.get(System.getenv("URLForCrm"));
        logInCrm(System.getenv("UsernameForCrm"), System.getenv("PasswordForCrm"));
        driver.switchTo().frame(iFrameMicrosoftCrm);
        try {
            clickElement(closeMicrosoftCrm, "close Microsoft window");
        } catch (Exception e) {
            System.out.println(e);
        }
        driver.switchTo().defaultContent();
        driver.switchTo().frame(iFrameSearch);
        typeText(searchInCrm, email, "search bar for email in CRM");
        clickElement(searchBtnCrm, "search button in CRM");
        doubleClick(accountCrm,"account row");
        driver.switchTo().defaultContent();
        driver.switchTo().frame(iFrameAccDetails);
        assertBorderColorInCRM(regulation);
        Assert.assertEquals(readAttribute(accFullNameCrm, "title", "full name"), fullName);
        Assert.assertEquals(getText(accDemoField, "demo account field"), "Demo Registered");
        loopForAccDetailsCrm(email);
    }
    public void checkCrmTags(){
        clickElement(menuBtn, "menu button");
        clickElement(envAndMarSec, "environment and marketing section button");
        loopForTagsCrm();
    }

    public void checkSMSVerification(String smsVerificationValue) {
        String smsVerificationVal = getText(smsVerification,"SMS Verification field from the CRM");
        Assert.assertEquals(smsVerificationVal,smsVerificationValue);
    }

    public void checkLinkIdValue(String linkIdValue){
        CrmPage crmPage = new CrmPage(driver);
        crmPage.clickElement(menuBtn, "menu button");
        crmPage.clickElement(envAndMarSec, "environment and marketing section button");
        String linkIdVal = getText(linkId,"Link ID field from the CRM");
        System.out.println("Link ID field value from the CRM "+linkIdVal);
        Assert.assertEquals(linkIdVal,linkIdValue);
    }
    public void assertBorderColorInCRM (String regulation){
        String borderColor = "rgb(255, 192, 203)";
        switch (regulation.toLowerCase()){
            case "fca":
                borderColor = "rgb(128, 0, 128)";
                break;
            case "iiroc":
                borderColor = "rgb(165, 42, 42)";
                break;
            case "asic":
                borderColor = "rgb(0, 128, 0)";
                break;
            case "cysec":
                borderColor = "";
                break;
        }
        WebDriverWait driverWait = new WebDriverWait(driver, waitSeconds);
        driverWait.until(cssValueToBe(borderTopColorForRegulation, "border-color", borderColor));
        System.out.println("This is the border color: " + borderTopColorForRegulation.getCssValue("border-color"));
        Assert.assertEquals(borderTopColorForRegulation.getCssValue("border-color"), borderColor);
    }
    public ExpectedCondition<Boolean> cssValueToBe(final WebElement locator, final String cssProperty, final String expectedValue) {
        return new ExpectedCondition<>() {
            @Override
            public Boolean apply(WebDriver driver) {
                String actualValue = locator.getCssValue(cssProperty);
                return actualValue.equals(expectedValue);
            }

            @Override
            public String toString() {
                return String.format("value of CSS property '%s' to be '%s'", cssProperty, expectedValue);
            }
        };
    }
}
