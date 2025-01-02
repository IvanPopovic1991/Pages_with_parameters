package TestsFortradeR;

import Pages.CrmPage;
import Pages.FortradeRPage;
import faker.TestData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class new_dark_2024_dlp extends BaseTestFortradeR {
    @BeforeMethod
    public void setUp() {
        baseSetup("Chrome", "131");
    }

    @AfterMethod
    public void tearDown() {
        baseTearDown();
    }

    @Test
    public void demoAccountRegistration() throws IOException, AWTException {
        FortradeRPage fortradeRPage = new FortradeRPage(driver);
        fortradeRPage.successfullyRegistration("Testq", "Testa", TestData.emailGenerator(),
                "381", TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000",
                "$50,000 – $100,000", "All the above");
        fortradeRPage.checkRegulation();
        fortradeRPage.takeScreenshot("Successfully demo account registration - FortradeR", fortradeRPage.regulationMsg);
    }

    @Test
    public void checkingTagsInTheCrm() throws IOException, AWTException {
        String email = TestData.emailGenerator();
        driver.get("https://www.fortrader.com/minilps/en/new-dark-2024-dlp/?fts=age-annual-saving-knowledge&tg=ivanA" +
                "1434&tag1=ivanB@1434&tag2=ivanL1434&tag3=ivanM1434&gid=ivanC@1434&G_GEO=ivanD1434&G_GEOint=ivanE1434&G_" +
                "Device=ivanF1434&G_DeviceModel=ivanG1434&G_AdPos=ivanH1434&g_Track=ivanI1434&Track=ivanj1434&gclid=ivanK1434");
        FortradeRPage fortradeRPage = new FortradeRPage(driver);
        fortradeRPage.successfullyRegistration("Testq", "Testa", email, "381",
                TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000", "$50,000 – $100,000", "All the above");
        CrmPage crmPage = new CrmPage(driver);
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.takeScreenshot("Account details Fortrader page", crmPage.accFullNameCrm);
        crmPage.checkCrmTags();
        crmPage.takeScreenshot("Marketing tags Fortrader page", crmPage.accFullNameCrm);
    }

    @Test
    public void checkingAgeParameter() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://www.fortrader.com/minilps/en/new-dark-2024-dlp/?fts=age");
        FortradeRPage fortradeRPage = new FortradeRPage(driver);
        fortradeRPage.ageParameter("Testq", "Testa", email, "381", TestData.phoneNumberGenerator(),
                "25-34");
        CrmPage crmPage = new CrmPage(driver);
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        //crmPage.checkSMSVerification("--");
        //crmPage.takeScreenshot("SMS Verification field Age parameter - no value", crmPage.smsVerification);
        crmPage.checkLinkIdValue("25_34_age,PC-Windows");
        Thread.sleep(1000);
        crmPage.takeScreenshot( "Age parameter value - FortradeR", crmPage.linkId);
    }

    @Test
    public void checkingAnnualParameter() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://www.fortrader.com/minilps/en/new-dark-2024-dlp/?fts=annual");
        FortradeRPage fortradeRPage = new FortradeRPage(driver);
        fortradeRPage.annualParameter("Testq", "Testa", email, "381", TestData.phoneNumberGenerator(),
                "$15,000-$50,000");
        CrmPage crmPage = new CrmPage(driver);
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        //crmPage.checkSMSVerification("--");
        //crmPage.takeScreenshot("SMS Verification field Annual parameter - no value", crmPage.smsVerification);
        crmPage.checkLinkIdValue("15000_50000_annual,PC-Windows");
        Thread.sleep(1000);
        crmPage.takeScreenshot( "Annual parameter value - FortradeR", crmPage.linkId);

    }

    @Test
    public void checkingSavingParameter() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://www.fortrader.com/minilps/en/new-dark-2024-dlp/?fts=saving");
        FortradeRPage fortradeRPage = new FortradeRPage(driver);
        fortradeRPage.savingParameter("Testq", "Testa", email, "381", TestData.phoneNumberGenerator(),
                "$50,000 – $100,000");
        CrmPage crmPage = new CrmPage(driver);
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        //crmPage.checkSMSVerification("--");
        crmPage.checkLinkIdValue("50000_100000_savings,PC-Windows");
        Thread.sleep(1000);
        crmPage.takeScreenshot( "Saving parameter value - FortradeR", crmPage.linkId);
    }
    @Test
    public void checkingKnowledgeParameter() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://www.fortrader.com/minilps/en/new-dark-2024-dlp/?fts=knowledge");
        FortradeRPage fortradeRPage = new FortradeRPage(driver);
        fortradeRPage.knowledgeParameter("Testq", "Testa", email, "381", TestData.phoneNumberGenerator(),
                "All the above");
        CrmPage crmPage = new CrmPage(driver);
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        //crmPage.checkSMSVerification("--");
        //crmPage.takeScreenshot("SMS Verification field Knowledge parameter - no value", crmPage.smsVerification);
        crmPage.checkLinkIdValue("knowledge_of_trading_all_the_above,PC-Windows");
        Thread.sleep(1000);
        crmPage.takeScreenshot( "Knowledge parameter value - FortradeR", crmPage.linkId);
    }
}
