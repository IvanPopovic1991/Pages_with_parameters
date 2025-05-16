package TestsKapitalRS;

import Pages.CrmPage;
import Pages.KapitalRsPage;
import Pages.Mailinator;
import Pages.YopMail;
import faker.TestData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class proDark2024dlp extends BaseTestKapitalRS{

    KapitalRsPage kapitalRsPage;

    @BeforeMethod
    public void setUp() {
        baseSetup("Chrome", "135");
    }

    @AfterMethod
    public void tearDown() {
        baseTearDown();
    }

    @Test
    public void demoAccountRegistration() throws IOException, AWTException {
        kapitalRsPage = new KapitalRsPage(driver);

        kapitalRsPage.successfullyRegistration("Testq", "Testa", TestData.emailGenerator(),
                "381", TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000",
                "$50,000 – $100,000", "Sve navedeno");
        kapitalRsPage.checkRegulation();
        kapitalRsPage.assertURL("https://pro.kapitalrs.com/#chartticket");
        kapitalRsPage.takeScreenshot("Successfully demo account registration - KapitalRS", kapitalRsPage.regulationMsg);
    }

    @Test
    public void checkingTagsInTheCrm() throws IOException, AWTException {
        String email = TestData.emailGenerator();
        driver.get("https://www.kapitalrs.com/minilps/rs/pro-dark-2024-dlp/?fts=age-annual-saving-knowledge&tg=ivanA" +
                "1434&tag1=ivanB@1434&tag2=ivanL1434&tag3=ivanM1434&gid=ivanC@1434&G_GEO=ivanD1434&G_GEOint=ivanE1434&G_" +
                "Device=ivanF1434&G_DeviceModel=ivanG1434&G_AdPos=ivanH1434&g_Track=ivanI1434&Track=ivanj1434&gclid=ivanK1434");
        kapitalRsPage = new KapitalRsPage(driver);
        kapitalRsPage.successfullyRegistration("Testq", "Testa", email, "381",
                TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000", "$50,000 – $100,000", "Sve navedeno");
        CrmPage crmPage = new CrmPage(driver);
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.takeScreenshot("Account details KapitalRS page", crmPage.accFullNameCrm);
        crmPage.checkCrmTags();
        crmPage.takeScreenshot("Marketing tags KapitalRS page", crmPage.accFullNameCrm);
    }

    @Test
    public void checkingAgeParameter() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://www.kapitalrs.com/minilps/rs/pro-dark-2024-dlp/?fts=age");
        kapitalRsPage = new KapitalRsPage(driver);
        kapitalRsPage.ageParameter("Testq", "Testa", email, "381", TestData.phoneNumberGenerator(),
                "25-34");
        CrmPage crmPage = new CrmPage(driver);
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.checkSMSVerification("--");
        crmPage.takeScreenshot("SMS Verification field Age parameter - no value - KapitalRs", crmPage.smsVerification);
        crmPage.checkLinkIdValue("25_34_age,PC-windows");
        Thread.sleep(1000);
        crmPage.takeScreenshot( "Age parameter value - KapitalRs", crmPage.linkId);
    }

    @Test
    public void checkingAnnualParameter() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://www.kapitalrs.com/minilps/rs/pro-dark-2024-dlp/?fts=annual");
        kapitalRsPage = new KapitalRsPage(driver);
        kapitalRsPage.annualParameter("Testq", "Testa", email, "381", TestData.phoneNumberGenerator(),
                "$15,000-$50,000");
        CrmPage crmPage = new CrmPage(driver);
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.checkSMSVerification("--");
        crmPage.takeScreenshot("SMS Verification field Annual parameter - no value - KapitalRs", crmPage.smsVerification);
        crmPage.checkLinkIdValue("15000_50000_annual,PC-windows");
        Thread.sleep(1000);
        crmPage.takeScreenshot( "Annual parameter value - KapitalRs", crmPage.linkId);

    }

    @Test
    public void checkingSavingParameter() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://www.kapitalrs.com/minilps/rs/pro-dark-2024-dlp/?fts=saving");
        kapitalRsPage = new KapitalRsPage(driver);
        kapitalRsPage.savingParameter("Testq", "Testa", email, "381", TestData.phoneNumberGenerator(),
                "$50,000 – $100,000");
        CrmPage crmPage = new CrmPage(driver);
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.checkSMSVerification("--");
        crmPage.takeScreenshot("SMS Verification field Saving parameter - no value - KapitalRs",crmPage.smsVerification);
        crmPage.checkLinkIdValue("50000_100000_savings,PC-windows");
        Thread.sleep(1000);
        crmPage.takeScreenshot( "Saving parameter value - KapitalRs", crmPage.linkId);
    }

    @Test
    public void checkingKnowledgeParameter() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://www.kapitalrs.com/minilps/rs/pro-dark-2024-dlp/?fts=knowledge");
        kapitalRsPage = new KapitalRsPage(driver);
        kapitalRsPage.knowledgeParameter("Testq", "Testa", email, "381", TestData.phoneNumberGenerator(),
                "Sve navedeno");
        CrmPage crmPage = new CrmPage(driver);
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.checkSMSVerification("--");
        crmPage.takeScreenshot("SMS Verification field Knowledge parameter - no value - KapitalRs", crmPage.smsVerification);
        crmPage.checkLinkIdValue("knowledge_of_trading_all_the_above,PC-windows");
        Thread.sleep(1000);
        crmPage.takeScreenshot( "Knowledge parameter value - KapitalRs", crmPage.linkId);
    }

    @Test
    public void assertInvalidTokenMsg() throws IOException, AWTException {
        driver.get("https://www.kapitalrs.com/minilps/rs/pro-dark-2024-dlp/?fts=sms-age-annual-saving-knowledge");
        kapitalRsPage = new KapitalRsPage(driver);
        kapitalRsPage.unsuccessfullyRegistrationWrongSMS("Testq", "Testa", TestData.emailGenerator(), "381",
                TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000", "$50,000 – $100,000", "Sve navedeno",
                "1","1","1","1");
        Assert.assertEquals(kapitalRsPage.incorrectTokenMsg.getText(),"ups... taj kod je pogresan . Molimo vas pokusajte ponovo");
        kapitalRsPage.takeScreenshot("Incorrect code - Please check and try again - KapitalRs");
    }

    @Test
    public void didNotGetToken() throws IOException, AWTException, InterruptedException {
        driver.get("https://www.kapitalrs.com/minilps/rs/pro-dark-2024-dlp/?fts=sms-age-annual-saving-knowledge");
        kapitalRsPage = new KapitalRsPage(driver);
        kapitalRsPage.tokenIsNotReceived("Testq", "Testa", TestData.emailGenerator(), "381",
                TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000", "$50,000 – $100,000", "Sve navedeno");
        Assert.assertEquals(kapitalRsPage.codeIsSent.getText(),"Ponovo smo vam poslali kod");
        Thread.sleep(2000);
        if(kapitalRsPage.codeIsSent.isDisplayed()){
            kapitalRsPage.takeScreenshot("We sent you the code again - KapitalRs",kapitalRsPage.codeIsSent);
        }
    }

    @Test
    public void userIsReturnedTo1stWidget() throws IOException, AWTException {
        driver.get("https://www.kapitalrs.com/minilps/rs/pro-dark-2024-dlp/?fts=sms-age-annual-saving-knowledge");
        kapitalRsPage = new KapitalRsPage(driver);
        kapitalRsPage.enterFirstName("Testq");
        kapitalRsPage.enterLastName("Testa");
        kapitalRsPage.enterEmail(TestData.emailGenerator());
        kapitalRsPage.enterCountryCode("381");
        kapitalRsPage.enterPhoneNumber(TestData.phoneNumberGenerator());
        kapitalRsPage.clickOnSubmitButton();
        kapitalRsPage.selectAge("75+");
        kapitalRsPage.clickEditTokenBtn();
        if(kapitalRsPage.login.isDisplayed()){
            kapitalRsPage.takeScreenshot("The user is returned to the 1st form widget - KapitalRs",kapitalRsPage.login);
        }
    }

    @Test
    public void unsuccessfullyDemoAccountRegistration() throws IOException, AWTException {
        kapitalRsPage = new KapitalRsPage(driver);
        kapitalRsPage.unsuccessfullyRegistrationWrongData("123", "456", "345342=--=/.,><",
                "123456", "1234567890123456");
        kapitalRsPage.assertErrorMessages();
        kapitalRsPage.assertColor("red");
        kapitalRsPage.takeScreenshot("Unsuccessfully demo account registration - KapitalRs", kapitalRsPage.submitBtn);
    }

    @Test
    public void emptyDemoAccountRegistration() throws IOException, AWTException {
        kapitalRsPage = new KapitalRsPage(driver);
        kapitalRsPage.unsuccessfullyRegistrationWrongData("", "", "", "", "");
        kapitalRsPage.assertErrorMessages();
        kapitalRsPage.assertColor("red");
        kapitalRsPage.takeScreenshot("Demo account registration - no data - KapitalRs", kapitalRsPage.submitBtn);
    }

    @Test
    public void alreadyRegisteredAccountTest() throws IOException, AWTException {
        String email = TestData.emailGenerator();
        String phoneNumber = TestData.phoneNumberGenerator();
        kapitalRsPage = new KapitalRsPage(driver);
        kapitalRsPage.successfullyRegistration("Testq", "Testa", email,
                "381", TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000",
                "$50,000 – $100,000", "Sve navedeno");
        driver.get("https://www.kapitalrs.com/minilps/rs/pro-dark-2024-dlp/?fts=age-annual-saving-knowledge");
        kapitalRsPage.alreadyRegisteredAccount("Testq", "Testa", email, "381", phoneNumber);
        kapitalRsPage.assertPopUpForAlreadyRegisteredAccount("Already registered account - KapitalRs - pop-up");
    }

    @Test
    public void sameFNameAndLName() throws IOException, AWTException {
        kapitalRsPage = new KapitalRsPage(driver);
        kapitalRsPage.enterFirstName("Test");
        kapitalRsPage.enterLastName("Test");
        kapitalRsPage.clickElement(kapitalRsPage.firstName, "on first name field");
        kapitalRsPage.clickElement(kapitalRsPage.lastName, "on last name field");
        kapitalRsPage.assertSameNameErrorMsgs();
        kapitalRsPage.takeScreenshot("Error messages for the same first and last name - KapitalRs");
    }

    @Test
    public void checkingForLogoClickability() throws IOException, AWTException {
        kapitalRsPage = new KapitalRsPage(driver);
        kapitalRsPage.checkLogoClickability("https://www.kapitalrs.com/minilps/rs/pro-dark-2024-dlp/?fts=age-annual-saving-knowledge");
        kapitalRsPage.takeScreenshot("Logo is not clickable - KapitalRs");
    }

    @Test
    public void checkForCountryCodeErrorMessage() throws IOException, AWTException {
        kapitalRsPage = new KapitalRsPage(driver);
        kapitalRsPage.checkCountryCodeErrorMessage("01852833kdkd");
        kapitalRsPage.takeScreenshot("Country code error message - KapitlaRs");
    }

    //Mailinator is not working (we will use YopMail)
    /*@Test
    public void emailIsReceivedSuccessfully() throws IOException, AWTException {
        String email = TestData.emailGenerator();
        kapitalRsPage = new KapitalRsPage(driver);
        kapitalRsPage.successfullyRegistration("Testq", "Testa", email,
                "381", TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000",
                "$50,000 – $100,000", "Sve navedeno");
        driver.get("https://www.mailinator.com/");
        Mailinator mailinator = new Mailinator(driver);
        mailinator.findEmailKRS(email);
        mailinator.zoomOutMethod();
        mailinator.takeScreenshot("Email is received successfully - KapitalRs", mailinator.emailTitleKRS);
    }*/

    @Test
    public void emailIsReceivedSuccessfully() throws IOException, AWTException {
        String email = TestData.emailGenerator();
        kapitalRsPage = new KapitalRsPage(driver);
        kapitalRsPage.successfullyRegistration("Testq", "Testa", email,
                "381", TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000",
                "$50,000 – $100,000", "Sve navedeno");
        driver.get("https://yopmail.com/en/");
        YopMail yopMail = new YopMail(driver);
        yopMail.findEmailKRS(email);
        yopMail.zoomOutMethod();
        yopMail.takeScreenshot("Email is received successfully - KapitalRs", yopMail.emailTitleKRS);
    }

    @Test
    public void privacyPolicyTest() throws IOException, AWTException, InterruptedException {
        kapitalRsPage = new KapitalRsPage(driver);
        kapitalRsPage.clickOnSelectedLink(kapitalRsPage.privacyPolicyLinkBy, kapitalRsPage.privacyPolicyFSC,
                "Privacy policy");
        kapitalRsPage.rightClickOnSelectedLink(kapitalRsPage.privacyPolicyLinkBy, kapitalRsPage.privacyPolicyFSC);
    }

    @Test
    public void termsAndConditionsTest() throws IOException, AWTException, InterruptedException {
        kapitalRsPage = new KapitalRsPage(driver);
        kapitalRsPage.clickOnSelectedLink(kapitalRsPage.termsAndConditionsLinkBy, kapitalRsPage.termsAndConditionsFSC,
                "Terms and conditions");
        kapitalRsPage.rightClickOnSelectedLink(kapitalRsPage.termsAndConditionsLinkBy, kapitalRsPage.termsAndConditionsFSC);
    }

    @Test
    public void howToUnsubscribeTest() throws IOException, AWTException, InterruptedException {
        kapitalRsPage = new KapitalRsPage(driver);
        kapitalRsPage.clickOnSelectedLink(kapitalRsPage.clickHereLink, kapitalRsPage.howToUnsubscribeURL,
                "How to unsubscribe");
        kapitalRsPage.rightClickOnSelectedLink(kapitalRsPage.clickHereLink, kapitalRsPage.howToUnsubscribeURL);
    }

    @Test
    public void loginRedirectionTest() throws IOException, AWTException {
        kapitalRsPage = new KapitalRsPage(driver);
        kapitalRsPage.loginRedirection();
        if (driver.getCurrentUrl().contains(kapitalRsPage.alrHaveAccount)) {
            kapitalRsPage.takeScreenshot("Login page - the user is successfully redirected - KapitalRs");
        } else {
            System.out.println("Wrong link redirection");
        }
    }

    @Test
    public void footerPrivacyPolicy() throws IOException, InterruptedException, AWTException {
        kapitalRsPage = new KapitalRsPage(driver);
        kapitalRsPage.scrollToAnElement(driver.findElement(By.xpath("//a[contains" +
                "(text(), 'Politika o zaštiti privatnosti')]")));
        kapitalRsPage.clickOnSelectedLink(kapitalRsPage.footerPrivacyPolicyLinkBy, kapitalRsPage.privacyPolicyFSCFooter,
                "Privacy policy footer");
        kapitalRsPage.rightClickOnSelectedLink(kapitalRsPage.footerPrivacyPolicyLinkBy, kapitalRsPage.privacyPolicyFSCFooter);
    }

    @Test
    public void riskWarningTest() throws IOException, InterruptedException, AWTException {
        kapitalRsPage = new KapitalRsPage(driver);
        kapitalRsPage.scrollToAnElementBy(kapitalRsPage.footerRiskWarningLinkBy);
        kapitalRsPage.clickOnSelectedLink(kapitalRsPage.footerRiskWarningLinkBy, kapitalRsPage.footerRiskWarning,
                "Risk warning");
        kapitalRsPage.rightClickOnSelectedLink(kapitalRsPage.footerRiskWarningLinkBy, kapitalRsPage.footerRiskWarning);
    }

    @Test
    public void fscRegulationTest() throws IOException, InterruptedException, AWTException {
        kapitalRsPage = new KapitalRsPage(driver);
        kapitalRsPage.scrollToAnElement(driver.findElement(By.xpath("//a[text()='GB21026472']")));
        kapitalRsPage.clickOnSelectedLink(kapitalRsPage.fscRegulationLinkBy, kapitalRsPage.fscLink,
                "Financial Services Commission page");
        kapitalRsPage.scrollToAnElement(driver.findElement(By.xpath("//a[text()='GB21026472']")));
        kapitalRsPage.rightClickOnSelectedLink(kapitalRsPage.fscRegulationLinkBy, kapitalRsPage.fscLink);
    }

    @Test
    public void asicRegulationTest() throws IOException, InterruptedException, AWTException {
        kapitalRsPage = new KapitalRsPage(driver);
        kapitalRsPage.scrollToAnElementBy(kapitalRsPage.asicRegulationLinkBy);
        kapitalRsPage.clickOnSelectedLink(kapitalRsPage.asicRegulationLinkBy, kapitalRsPage.asicLink,
                "Australian Securities and Investments Commission page");
        kapitalRsPage.rightClickOnSelectedLink(kapitalRsPage.asicRegulationLinkBy, kapitalRsPage.asicLink);
    }

    @Test
    public void fcaRegulationTest() throws IOException, InterruptedException, AWTException {
        kapitalRsPage = new KapitalRsPage(driver);
        kapitalRsPage.scrollToAnElementBy(kapitalRsPage.fcaRegulationLinkBy);
        kapitalRsPage.clickOnSelectedLink(kapitalRsPage.fcaRegulationLinkBy, kapitalRsPage.fcaLink,
                "Financial conduct authority page");
        kapitalRsPage.scrollToAnElement(driver.findElement(By.xpath("//a[text()='609970']")));
        kapitalRsPage.rightClickOnSelectedLink(kapitalRsPage.fcaRegulationLinkBy, kapitalRsPage.fcaLink);
    }

/*    @Test
    public void fbLinkRedirection() throws IOException, InterruptedException, AWTException {
        kapitalRsPage = new KapitalRsPage(driver);
        kapitalRsPage.clickOnSelectedLink(kapitalRsPage.facebookLinkBy, fortradeRPage.fbURL, "Facebook page");
        kapitalRsPage.rightClickOnSelectedLink(kapitalRsPage.facebookLinkBy, fortradeRPage.fbURL);
    }

    @Test
    public void insLinkRedirection() throws IOException, InterruptedException, AWTException {
        kapitalRsPage = new KapitalRsPage(driver);
        kapitalRsPage.clickOnSelectedLink(kapitalRsPage.instagramLinkBy, fortradeRPage.insURL, "Instagram page");
        kapitalRsPage.rightClickOnSelectedLink(kapitalRsPage.instagramLinkBy, fortradeRPage.insURL);
    }

    @Test
    public void ytLinkRedirection() throws IOException, InterruptedException, AWTException {
        kapitalRsPage = new KapitalRsPage(driver);
        kapitalRsPage.clickOnSelectedLink(kapitalRsPage.youtubeLinkBy, fortradeRPage.ytURL, "Youtube page");
        kapitalRsPage.rightClickOnSelectedLink(kapitalRsPage.youtubeLinkBy, fortradeRPage.ytURL);
    }*/

    @Test
    public void contactUsLink() throws IOException, AWTException, InterruptedException {
        kapitalRsPage = new KapitalRsPage(driver);
        kapitalRsPage.clickOnMailLink("Kontakt");
        Thread.sleep(1000);
        kapitalRsPage.takeScreenshot("KapitalRs - contact us redirection");
        kapitalRsPage.closeOutlook();
    }

/*    @Test
    public void infoLink() throws IOException, AWTException, InterruptedException {
        kapitalRsPage = new KapitalRsPage(driver);
        kapitalRsPage.clickOnMailLink("info");
        Thread.sleep(1000);
        kapitalRsPage.takeScreenshot("FortradeR - info redirection");
        kapitalRsPage.closeOutlook();
    }

    @Test
    public void supportLink() throws IOException, AWTException, InterruptedException {
        kapitalRsPage = new KapitalRsPage(driver);
        kapitalRsPage.clickOnMailLink("support");
        Thread.sleep(1000);
        kapitalRsPage.takeScreenshot("FortradeR - support redirection");
        kapitalRsPage.closeOutlook();
    }*/

    @Test
    public void errorMessageAgeParameter() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        String phoneNumber = TestData.phoneNumberGenerator();
        driver.get("https://www.kapitalrs.com/minilps/rs/pro-dark-2024-dlp/?fts=age");
        kapitalRsPage = new KapitalRsPage(driver);
        kapitalRsPage.ageParameter("Testq", "Testa", email, "381", phoneNumber,
                "-- Izaberite --");
        kapitalRsPage.secondStepErrorMessage(1);
        kapitalRsPage.takeScreenshot("Age parameter error message - KapitalRs");
    }

    @Test
    public void errorMessageAnnualParameter() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        String phoneNumber = TestData.phoneNumberGenerator();
        driver.get("https://www.kapitalrs.com/minilps/rs/pro-dark-2024-dlp/?fts=annual");
        kapitalRsPage = new KapitalRsPage(driver);
        kapitalRsPage.annualParameter("Testq", "Testa", email, "381", phoneNumber,
                "-- Izaberite --");
        kapitalRsPage.secondStepErrorMessage(1);
        kapitalRsPage.takeScreenshot("Annual parameter error message - KapitalRs");
    }

    @Test
    public void errorMessageSavingParameter() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        String phoneNumber = TestData.phoneNumberGenerator();
        driver.get("https://www.kapitalrs.com/minilps/rs/pro-dark-2024-dlp/?fts=saving");
        kapitalRsPage = new KapitalRsPage(driver);
        kapitalRsPage.savingParameter("Testq", "Testa", email, "381", phoneNumber,
                "-- Izaberite --");
        kapitalRsPage.secondStepErrorMessage(1);
        kapitalRsPage.takeScreenshot("Saving parameter error message - KapitalRs");
    }

    @Test
    public void errorMessageKnowledgeParameter() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        String phoneNumber = TestData.phoneNumberGenerator();
        driver.get("https://www.kapitalrs.com/minilps/rs/pro-dark-2024-dlp/?fts=knowledge");
        kapitalRsPage = new KapitalRsPage(driver);
        kapitalRsPage.knowledgeParameter("Testq", "Testa", email, "381", phoneNumber,
                "-- Izaberite --");
        kapitalRsPage.secondStepErrorMessage(1);
        kapitalRsPage.takeScreenshot("Knowledge parameter error message - KapitalRs");
    }

    @Test
    public void errorMessagesAllParameters() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        String phoneNumber = TestData.phoneNumberGenerator();
        kapitalRsPage = new KapitalRsPage(driver);
        kapitalRsPage.unsuccessfullyRegistration("Testq", "Testa", email, "381", phoneNumber,
                "25-34", "$15,000-$50,000", "$50,000 – $100,000", "Sve navedeno",
                "-- Izaberite --", "-- Izaberite --", "-- Izaberite --", "-- Izaberite --");
        kapitalRsPage.secondStepErrorMessage(4);
        kapitalRsPage.takeScreenshot("All parameters error message - KapitalRs");
    }

    @Test
    public void checkLanguageParameter() throws IOException, AWTException {
        String email = TestData.emailGenerator();
        driver.get("https://www.kapitalrs.com/minilps/rs/pro-dark-2024-dlp/?fts=plang:srcs,all");
        kapitalRsPage = new KapitalRsPage(driver);
        kapitalRsPage.languageParameter("Testq", "Testa", email, "381",
                TestData.phoneNumberGenerator(),"Engleski");
        CrmPage crmPage = new CrmPage(driver);
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.checkLinkIdValue("lang_EN,PC-windows");
        crmPage.takeScreenshot("Desired communication language - KapitalRs",crmPage.linkId);
    }

    @Test
    public void errorLanguageParameter() throws IOException, AWTException {
        String email = TestData.emailGenerator();
        driver.get("https://www.kapitalrs.com/minilps/rs/pro-dark-2024-dlp/?fts=plang:srcs,all");
        kapitalRsPage = new KapitalRsPage(driver);
        kapitalRsPage.languageParameter("Testq", "Testa", email, "381",
                TestData.phoneNumberGenerator(),"-- Izaberite --");
        kapitalRsPage.assertBorderColor(kapitalRsPage.languageField);
        kapitalRsPage.takeScreenshot("Desired communication language - error - KapitalRs",kapitalRsPage.languageField);
    }
}
