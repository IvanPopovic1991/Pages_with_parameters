package TestsFortradeR;

import Pages.CrmPage;
import Pages.FortradeRPage;
import Pages.Mailinator;
import faker.TestData;
import org.openqa.selenium.By;
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

    @Test
    public void unsuccessfullyDemoAccountRegistration() throws IOException, AWTException {
        FortradeRPage fortradeRPage = new FortradeRPage(driver);
        fortradeRPage.unsuccessfullyRegistrationWithWrongData("123", "456", "345342=--=/.,><",
                "123456", "1234567890123456");
        fortradeRPage.assertErrorMessages();
        fortradeRPage.assertColor("red");
        fortradeRPage.takeScreenshot("Unsuccessfully demo account registration - FortradeR", fortradeRPage.submitButton);
    }

    @Test
    public void emptyDemoAccountRegistration() throws IOException, AWTException {
        FortradeRPage fortradeRPage = new FortradeRPage(driver);
        fortradeRPage.unsuccessfullyRegistrationWithWrongData("", "", "", "", "");
        fortradeRPage.assertErrorMessages();
        fortradeRPage.assertColor("red");
        fortradeRPage.takeScreenshot("Demo account registration - no data - Fortrader", fortradeRPage.submitButton);
    }

    @Test
    public void alreadyRegisteredAccountTest() throws IOException, AWTException {
        String email = TestData.emailGenerator();
        String phoneNumber = TestData.phoneNumberGenerator();
        FortradeRPage fortradeRPage = new FortradeRPage(driver);
        fortradeRPage.successfullyRegistration("Testq", "Testa", email,
                "381", TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000",
                "$50,000 – $100,000", "All the above");
        driver.get("https://www.fortrader.com/minilps/en/new-dark-2024-dlp/?fts=age-annual-saving-knowledge");
        fortradeRPage.alreadyRegisteredAccount("Testq", "Testa", email, "381", phoneNumber);
        fortradeRPage.assertPopUpForAlreadyRegisteredAccount("Already registered account - FortradeR - pop-up");
    }

    @Test
    public void sameFNameAndLName() throws IOException, AWTException {
        FortradeRPage fortradeRPage = new FortradeRPage(driver);
        fortradeRPage.enterFirstName("Test");
        fortradeRPage.enterLastName("Test");
        fortradeRPage.clickElement(fortradeRPage.firstName, "on first name field");
        fortradeRPage.clickElement(fortradeRPage.lastName, "on last name field");
        fortradeRPage.assertSameNameErrorMsgs();
        fortradeRPage.takeScreenshot("Error messages for the same first and last name - FortradeR");
    }

    @Test
    public void checkingForLogoClickability() throws IOException, AWTException {
        FortradeRPage fortradeRPage = new FortradeRPage(driver);
        fortradeRPage.checkLogoClickability("https://www.fortrader.com/minilps/en/new-dark-2024-dlp/?fts=age-annual-saving-knowledge");
        fortradeRPage.takeScreenshot("Logo is not clickable - FortradeR");
    }

    @Test
    public void checkForCountryCodeErrorMessage() throws IOException, AWTException {
        FortradeRPage fortradeRPage = new FortradeRPage(driver);
        fortradeRPage.checkCountryCodeErrorMessage("01852833kdkd");
        fortradeRPage.takeScreenshot("Country code error message - FortradeR");
    }

    @Test
    public void emailIsReceivedSuccessfully() throws IOException, AWTException {
        String email = TestData.emailGenerator();
        FortradeRPage fortradeRPage = new FortradeRPage(driver);
        fortradeRPage.successfullyRegistration("Testq", "Testa", email,
                "381", TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000",
                "$50,000 – $100,000", "All the above");
        driver.get("https://www.mailinator.com/");
        Mailinator mailinator = new Mailinator(driver);
        mailinator.findEmail(email);
        mailinator.zoomOutMethod();
        mailinator.takeScreenshot("Email is received successfully - FortradeR", mailinator.emailTitle);
    }

    @Test
    public void privacyPolicyTest() throws IOException, AWTException, InterruptedException {
        FortradeRPage fortradeRPage = new FortradeRPage(driver);
        fortradeRPage.clickOnSelectedLink(fortradeRPage.privacyPolicyLinkBy, fortradeRPage.privacyPolicyFSC,
                "Privacy policy");
        fortradeRPage.rightClickOnSelectedLink(fortradeRPage.privacyPolicyLinkBy, fortradeRPage.privacyPolicyFSC);
    }

    @Test
    public void termsAndConditionsTest() throws IOException, AWTException, InterruptedException {
        FortradeRPage fortradeRPage = new FortradeRPage(driver);
        fortradeRPage.clickOnSelectedLink(fortradeRPage.termsAndConditionsLinkBy, fortradeRPage.termsAndConditionsFSC,
                "Terms and conditions");
        fortradeRPage.rightClickOnSelectedLink(fortradeRPage.termsAndConditionsLinkBy, fortradeRPage.termsAndConditionsFSC);
    }

    @Test
    public void howToUnsubscribeTest() throws IOException, AWTException, InterruptedException {
        FortradeRPage fortradeRPage = new FortradeRPage(driver);
        fortradeRPage.clickOnSelectedLink(fortradeRPage.clickHereLinkBy, fortradeRPage.howToUnsubscribeURL,
                "How to unsubscribe");
        fortradeRPage.rightClickOnSelectedLink(fortradeRPage.clickHereLinkBy, fortradeRPage.howToUnsubscribeURL);
    }

    @Test
    public void loginRedirectionTest() throws IOException, AWTException {
        FortradeRPage fortradeRPage = new FortradeRPage(driver);
        fortradeRPage.loginRedirection();
        if (driver.getCurrentUrl().contains(fortradeRPage.alrHaveAccount)) {
            fortradeRPage.takeScreenshot("Login page - the user is successfully redirected", fortradeRPage.loginToFortrade);
        } else {
            System.out.println("Wrong link redirection");
        }
    }

    @Test
    public void footerPrivacyPolicy() throws IOException, InterruptedException, AWTException {
        FortradeRPage fortradeRPage = new FortradeRPage(driver);
        fortradeRPage.scrollToAnElement(driver.findElement(By.xpath("//div[@class='fscClass']//a[contains" +
                "(text(), 'Privacy policy')]")));
        fortradeRPage.clickOnSelectedLink(fortradeRPage.footerPrivacyPolicyLinkBy, fortradeRPage.privacyPolicyFSCFooter,
                "Privacy policy footer - FortradeR");
        fortradeRPage.rightClickOnSelectedLink(fortradeRPage.footerPrivacyPolicyLinkBy, fortradeRPage.privacyPolicyFSCFooter);
    }

    @Test
    public void fscRegulationTest() throws IOException, InterruptedException, AWTException {
        FortradeRPage fortradeRPage = new FortradeRPage(driver);
        fortradeRPage.scrollToAnElement(driver.findElement(By.xpath("//a[text()=' GB21026472']")));
        fortradeRPage.clickOnSelectedLink(fortradeRPage.fscRegulationLinkBy, fortradeRPage.fscLink,
                "Financial Services Commission page");
        fortradeRPage.scrollToAnElement(driver.findElement(By.xpath("//a[text()=' GB21026472']")));
        fortradeRPage.rightClickOnSelectedLink(fortradeRPage.fscRegulationLinkBy, fortradeRPage.fscLink);
    }

    @Test
    public void fbLinkRedirection() throws IOException, InterruptedException, AWTException {
        FortradeRPage fortradeRPage = new FortradeRPage(driver);
        fortradeRPage.clickOnSelectedLink(fortradeRPage.facebookLinkBy, fortradeRPage.fbURL, "Facebook page");
        fortradeRPage.rightClickOnSelectedLink(fortradeRPage.facebookLinkBy, fortradeRPage.fbURL);
    }

    @Test
    public void insLinkRedirection() throws IOException, InterruptedException, AWTException {
        FortradeRPage fortradeRPage = new FortradeRPage(driver);
        fortradeRPage.clickOnSelectedLink(fortradeRPage.instagramLinkBy, fortradeRPage.insURL, "Instagram page");
        fortradeRPage.rightClickOnSelectedLink(fortradeRPage.instagramLinkBy, fortradeRPage.insURL);
    }

    @Test
    public void ytLinkRedirection() throws IOException, InterruptedException, AWTException {
        FortradeRPage fortradeRPage = new FortradeRPage(driver);
        fortradeRPage.clickOnSelectedLink(fortradeRPage.youtubeLinkBy, fortradeRPage.ytURL, "Youtube page");
        fortradeRPage.rightClickOnSelectedLink(fortradeRPage.youtubeLinkBy, fortradeRPage.ytURL);
    }

    @Test
    public void contactUsLink() throws IOException, AWTException, InterruptedException {
        FortradeRPage fortradeRPage = new FortradeRPage(driver);
        fortradeRPage.clickOnMailLink("contactUs");
        Thread.sleep(1000);
        fortradeRPage.takeScreenshot("FortradeR - contact us redirection");
        fortradeRPage.closeOutlook();
    }

    @Test
    public void infoLink() throws IOException, AWTException, InterruptedException {
        FortradeRPage fortradeRPage = new FortradeRPage(driver);
        fortradeRPage.clickOnMailLink("info");
        Thread.sleep(1000);
        fortradeRPage.takeScreenshot("FortradeR - info redirection");
        fortradeRPage.closeOutlook();
    }

    @Test
    public void supportLink() throws IOException, AWTException, InterruptedException {
        FortradeRPage fortradeRPage = new FortradeRPage(driver);
        fortradeRPage.clickOnMailLink("support");
        Thread.sleep(1000);
        fortradeRPage.takeScreenshot("FortradeR - support redirection");
        fortradeRPage.closeOutlook();
    }
}
