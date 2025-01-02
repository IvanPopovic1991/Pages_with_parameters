package TestsFortrade;

import Pages.CrmPage;
import Pages.FortradePage;
import Pages.FortradeRPage;
import faker.TestData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class new_dark_2024_dlp extends BaseTestFortrade {
    @BeforeMethod
    @Parameters({"tag"})
    public void setUp(String tag) {
        baseSetup("Chrome", "131");
        driver.get("https://www.fortrade.com/minilps/en/new-dark-2024-dlp/?fts=age-annual-saving-knowledge" + tag);
    }

    @AfterMethod
    public void tearDown() {
        baseTearDown();
    }

    @Test
    @Parameters({"countryCode", "regulation"})
    public void demoAccountRegistration(String countryCode, String regulation) throws IOException, AWTException, InterruptedException {
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.successfullyRegistration("Testq", "Testa", TestData.emailGenerator(), countryCode, TestData.phoneNumberGenerator(),
                "25-34", "$15,000-$50,000", "$50,000 – $100,000", "All the above");
        fortradePage.assertURL("https://ready.fortrade.com/#chartticket");
        fortradePage.clickMenuBtn();
        fortradePage.checkRegulation(regulation);
    }

    @Test
    @Parameters({"tag", "countryCode", "regulation"})
    public void checkingTagsInTheCrm(String tag, String countryCode, String regulation) throws IOException, AWTException {
        String email = TestData.emailGenerator();
        driver.get("https://www.fortrade.com/minilps/en/new-dark-2024-dlp/?fts=age-annual-saving-knowledge&tg=ivanA" +
                "1434&tag1=ivanB@1434&tag2=ivanL1434&tag3=ivanM1434&gid=ivanC@1434&G_GEO=ivanD1434&G_GEOint=ivanE1434&G_" +
                "Device=ivanF1434&G_DeviceModel=ivanG1434&G_AdPos=ivanH1434&g_Track=ivanI1434&Track=ivanj1434&gclid=ivanK1434" + tag);
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.successfullyRegistration("Testq", "Testa", email, countryCode,
                TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000", "$50,000 – $100,000", "All the above");
        CrmPage crmPage = new CrmPage(driver);
        crmPage.checkCrmData(email, "Testq Testa", regulation);
        crmPage.takeScreenshot("Account details Fortrade page " + regulation, crmPage.accFullNameCrm);
        crmPage.takeScreenshot("SMS Verification field - no value" + regulation, crmPage.smsVerification);
        //crmPage.checkSMSVerification("--");
        //crmPage.takeScreenshot("SMS Verification field Age parameter - no value " + regulation, crmPage.smsVerification);
        crmPage.checkCrmTags();
        crmPage.takeScreenshot("Marketing tags Fortrade page " + regulation, crmPage.accFullNameCrm);
    }

    @Test
    @Parameters({"tag", "countryCode", "regulation"})
    public void checkingAgeParameter(String tag, String countryCode, String regulation) throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://www.fortrade.com/minilps/en/new-dark-2024-dlp/?fts=age" + tag);
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.ageParameter("Testq", "Testa", email, countryCode, TestData.phoneNumberGenerator(),
                "25-34");
        CrmPage crmPage = new CrmPage(driver);
        crmPage.checkCrmData(email, "Testq Testa", regulation);
        //crmPage.checkSMSVerification("--");
        //crmPage.takeScreenshot("SMS Verification field Age parameter - no value " + regulation, crmPage.smsVerification);
        crmPage.checkLinkIdValue("25_34_age,PC-windows");
        Thread.sleep(1000);
        crmPage.takeScreenshot( "Age parameter value "+regulation, crmPage.linkId);
    }

    @Test
    @Parameters({"tag", "countryCode", "regulation"})
    public void checkingAnnualParameter(String tag, String countryCode, String regulation) throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://www.fortrade.com/minilps/en/new-dark-2024-dlp/?fts=annual" + tag);
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.annualParameter("Testq", "Testa", email, countryCode, TestData.phoneNumberGenerator(),
                "$15,000-$50,000");
        CrmPage crmPage = new CrmPage(driver);
        crmPage.checkCrmData(email, "Testq Testa", regulation);
        //crmPage.checkSMSVerification("--");
        //crmPage.takeScreenshot("SMS Verification field Annual parameter - no value " + regulation, crmPage.smsVerification);
        crmPage.checkLinkIdValue("15000_50000_annual,PC-windows");
        Thread.sleep(1000);
        crmPage.takeScreenshot( "Annual parameter value "+regulation, crmPage.linkId);
    }

    @Test
    @Parameters({"tag", "countryCode", "regulation"})
    public void checkingSavingParameter(String tag, String countryCode, String regulation) throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://www.fortrade.com/minilps/en/new-dark-2024-dlp/?fts=saving" + tag);
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.savingParameter("Testq", "Testa", email, countryCode, TestData.phoneNumberGenerator(),
                "$50,000 – $100,000");
        CrmPage crmPage = new CrmPage(driver);
        crmPage.checkCrmData(email, "Testq Testa", regulation);
        //crmPage.checkSMSVerification("--");
        //crmPage.takeScreenshot("SMS Verification field Saving parameter - no value " + regulation, crmPage.smsVerification);
        crmPage.checkLinkIdValue("50000_100000_savings,PC-windows");
        Thread.sleep(1000);
        crmPage.takeScreenshot( "Saving parameter value " + regulation, crmPage.linkId);
    }

    @Test
    @Parameters({"tag", "countryCode", "regulation"})
    public void checkingKnowledgeParameter(String tag, String countryCode, String regulation) throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://www.fortrade.com/minilps/en/new-dark-2024-dlp/?fts=knowledge" + tag);
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.knowledgeParameter("Testq", "Testa", email, countryCode, TestData.phoneNumberGenerator(),
                "All the above");
        CrmPage crmPage = new CrmPage(driver);
        crmPage.checkCrmData(email, "Testq Testa", regulation);
        //crmPage.checkSMSVerification("--");
        //crmPage.takeScreenshot("SMS Verification field Knowledge parameter - no value " + regulation, crmPage.smsVerification);
        crmPage.checkLinkIdValue("knowledge_of_trading_all_the_above,PC-windows");
        Thread.sleep(1000);
        crmPage.takeScreenshot( "Knowledge parameter value "+regulation, crmPage.linkId);
    }
}
