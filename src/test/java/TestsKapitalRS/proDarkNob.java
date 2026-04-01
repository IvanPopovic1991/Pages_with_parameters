package TestsKapitalRS;

import Pages.CrmPage;
import Pages.KapitalRsEnPage;
import Pages.YopMail;
import faker.TestData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class proDarkNob extends BaseTestKapitalRS{

    KapitalRsEnPage kapitalRsEnPage;
    CrmPage crmPage;

    @BeforeMethod
    public void setUp() {
        baseSetup("Chrome", "146");
    }

    @AfterMethod
    public void tearDown() {
        baseTearDown();
    }

    @Test(description = "Verify demo account registration")
    public void demoAccountRegistration() throws IOException, AWTException {
        kapitalRsEnPage = new KapitalRsEnPage(driver);
        kapitalRsEnPage.successfullyRegistration("Testq", "Testa", TestData.emailGenerator(),
                "Serbia", TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000",
                "$50,000-$100,000", "All the above");
        kapitalRsEnPage.checkRegulation();
        kapitalRsEnPage.assertURL("https://pro.kapitalrs.com/#chartticket");
        kapitalRsEnPage.takeScreenshot("Successfully demo account registration - KapitalRS", kapitalRsEnPage.regulationMsg);
    }

    @Test(description = "Verify the marketing tags in CRM")
    public void checkingTagsInTheCrm() throws IOException, AWTException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.kapitalrs.com/lps/pro-dark-nob/en?fts=age-annual-saving-knowledge&tg=ivanA" +
                "1434&tag1=ivanB@1434&tag2=ivanL1434&tag3=ivanM1434&gid=ivanC@1434&G_GEO=ivanD1434&G_GEOint=ivanE1434&G_" +
                "Device=ivanF1434&G_DeviceModel=ivanG1434&G_AdPos=ivanH1434&g_Track=ivanI1434&Track=ivanj1434&gclid=ivanK1434");
        kapitalRsEnPage = new KapitalRsEnPage(driver);
        kapitalRsEnPage.successfullyRegistration("Testq", "Testa", email, "Serbia",
                TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000", "$50,000-$100,000", "All the above");
        kapitalRsEnPage.checkRegulation();
        CrmPage crmPage = new CrmPage(driver);
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.takeScreenshot("Account details KapitalRS page", crmPage.accFullNameCrm);
        crmPage.checkCrmTags();
        crmPage.takeScreenshot("Marketing tags KapitalRS page", crmPage.accFullNameCrm);
    }

    @Test(description = "Verify the age value is displayed correctly in the Link ID field in the CRM")
    public void checkingAgeParameter() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.kapitalrs.com/lps/pro-dark-nob/en?fts=age");
        kapitalRsEnPage = new KapitalRsEnPage(driver);
        kapitalRsEnPage.ageParameter("Testq", "Testa", email, "Serbia", TestData.phoneNumberGenerator(),
                "25-34");
        kapitalRsEnPage.checkRegulation();
        CrmPage crmPage = new CrmPage(driver);
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.checkSMSVerification("--");
        crmPage.takeScreenshot("SMS Verification field Age parameter - no value - KapitalRs", crmPage.smsVerification);
        crmPage.checkLinkIdValue("PC_windows,25_34_age");
        Thread.sleep(1000);
        crmPage.takeScreenshot( "Age parameter value - KapitalRs", crmPage.linkId);
    }

    @Test(description = "Verify the annual value is displayed correctly in the Link ID field in the CRM")
    public void checkingAnnualParameter() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.kapitalrs.com/lps/pro-dark-nob/en?fts=annual");
        kapitalRsEnPage = new KapitalRsEnPage(driver);
        kapitalRsEnPage.annualParameter("Testq", "Testa", email, "Serbia", TestData.phoneNumberGenerator(),
                "$15,000-$50,000");
        kapitalRsEnPage.checkRegulation();
        CrmPage crmPage = new CrmPage(driver);
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.checkSMSVerification("--");
        crmPage.takeScreenshot("SMS Verification field Annual parameter - no value - KapitalRs", crmPage.smsVerification);
        crmPage.checkLinkIdValue("PC_windows,15000_50000_annual");
        Thread.sleep(1000);
        crmPage.takeScreenshot( "Annual parameter value - KapitalRs", crmPage.linkId);

    }

    @Test(description = "Verify the saving value is displayed correctly in the Link ID field in the CRM")
    public void checkingSavingParameter() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.kapitalrs.com/lps/pro-dark-nob/en?fts=saving");
        kapitalRsEnPage = new KapitalRsEnPage(driver);
        kapitalRsEnPage.savingParameter("Testq", "Testa", email, "Serbia", TestData.phoneNumberGenerator(),
                "$50,000-$100,000");
        kapitalRsEnPage.checkRegulation();
        CrmPage crmPage = new CrmPage(driver);
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.checkSMSVerification("--");
        crmPage.takeScreenshot("SMS Verification field Saving parameter - no value - KapitalRs",crmPage.smsVerification);
        crmPage.checkLinkIdValue("PC_windows,50000_100000_savings");
        Thread.sleep(1000);
        crmPage.takeScreenshot( "Saving parameter value - KapitalRs", crmPage.linkId);
    }

    @Test(description = "Verify the knowledge of trading value is displayed correctly in the Link ID field in the CRM")
    public void checkingKnowledgeParameter() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.kapitalrs.com/lps/pro-dark-nob/en?fts=knowledge");
        kapitalRsEnPage = new KapitalRsEnPage(driver);
        kapitalRsEnPage.knowledgeParameter("Testq", "Testa", email, "Serbia", TestData.phoneNumberGenerator(),
                "All the above");
        kapitalRsEnPage.checkRegulation();
        CrmPage crmPage = new CrmPage(driver);
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.checkSMSVerification("--");
        crmPage.takeScreenshot("SMS Verification field Knowledge parameter - no value - KapitalRs", crmPage.smsVerification);
        crmPage.checkLinkIdValue("PC_windows,knowledge_of_trading_all_the_above");
        Thread.sleep(1000);
        crmPage.takeScreenshot( "Knowledge parameter value - KapitalRs", crmPage.linkId);
    }

    @Test(description = "Verify that wrong code cannot be submitted")
    public void assertInvalidTokenMsg() throws IOException, AWTException {
        driver.get("https://dlp.kapitalrs.com/lps/pro-dark-nob/en?fts=sms-age-annual-saving-knowledge");
        kapitalRsEnPage = new KapitalRsEnPage(driver);
        kapitalRsEnPage.unsuccessfullyRegistrationWrongSMS("Testq", "Testa", TestData.emailGenerator(), "Serbia",
                TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000", "$50,000-$100,000", "All the above",
                "1","1","1","1");
        Assert.assertEquals(kapitalRsEnPage.getTextBy(kapitalRsEnPage.incorrectTokenMsg, "incorrect token msg"),"Incorrect Code. Please check and try again.");
        kapitalRsEnPage.takeScreenshot("Incorrect code - Please check and try again - KapitalRs");
    }

    @Test(description = "Verify that message We sent you the code again is received")
    public void didNotGetToken() throws IOException, AWTException, InterruptedException {
        driver.get("https://dlp.kapitalrs.com/lps/pro-dark-nob/en?fts=sms-age-annual-saving-knowledge");
        kapitalRsEnPage = new KapitalRsEnPage(driver);
        kapitalRsEnPage.tokenIsNotReceived("Testq", "Testa", TestData.emailGenerator(), "Serbia",
                TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000", "$50,000-$100,000", "All the above");
        Assert.assertEquals(kapitalRsEnPage.getTextBy(kapitalRsEnPage.codeIsSent, "code is sent error message"),"We sent you the code again");
        Thread.sleep(2000);
        if(kapitalRsEnPage.codeIsSent.isDisplayed()){
            kapitalRsEnPage.takeScreenshot("We sent you the code again - KapitalRs", kapitalRsEnPage.codeIsSent);
        }
    }

    @Test(description = "Verify if user clicks pencil icon the same is returned to the 1st widget")
    public void userIsReturnedTo1stWidget() throws IOException, AWTException {
        driver.get("https://dlp.kapitalrs.com/lps/pro-dark-nob/en?fts=sms-age-annual-saving-knowledge");
        kapitalRsEnPage = new KapitalRsEnPage(driver);
        kapitalRsEnPage.enterFirstName("Testq");
        kapitalRsEnPage.enterLastName("Testa");
        kapitalRsEnPage.enterEmail(TestData.emailGenerator());
        kapitalRsEnPage.handleCountryCode("Serbia");
        kapitalRsEnPage.enterPhoneNumber(TestData.phoneNumberGenerator());
        kapitalRsEnPage.clickOnSubmitButton();
        kapitalRsEnPage.selectAge("75+");
        kapitalRsEnPage.clickEditTokenBtn();
        if(kapitalRsEnPage.login.isDisplayed()){
            kapitalRsEnPage.takeScreenshot("The user is returned to the 1st form widget - KapitalRs", kapitalRsEnPage.login);
        }
    }

    @Test(description = "Verify the demo account is not registered successfully with invalid data")
    public void unsuccessfullyDemoAccountRegistration() throws IOException, AWTException {
        kapitalRsEnPage = new KapitalRsEnPage(driver);
        kapitalRsEnPage.unsuccessfullyRegistrationWrongData("123", "456", "345342=--=/.,><",
                "1234567890123456");
        kapitalRsEnPage.assertErrorMessages();
        //KapitalRsEnPage.assertColor("red");
        kapitalRsEnPage.takeScreenshot("Unsuccessfully demo account registration - KapitalRs", kapitalRsEnPage.submitBtn);
    }

    @Test(description = "Verify the demo account is not registered successfully with empty fields")
    public void emptyDemoAccountRegistration() throws IOException, AWTException {
        kapitalRsEnPage = new KapitalRsEnPage(driver);
        kapitalRsEnPage.unsuccessfullyRegistrationWrongData("", "", "", "");
        kapitalRsEnPage.assertErrorMessages();
        //KapitalRsEnPage.assertColor("red");
        kapitalRsEnPage.takeScreenshot("Demo account registration - no data - KapitalRs", kapitalRsEnPage.submitBtn);
    }

    @Test(description = "Verify that the account cannot be registered with already registered email address")
    public void alreadyRegisteredAccountTest() throws IOException, AWTException {
        String email = TestData.emailGenerator();
        String phoneNumber = TestData.phoneNumberGenerator();
        kapitalRsEnPage = new KapitalRsEnPage(driver);
        kapitalRsEnPage.successfullyRegistration("Testq", "Testa", email,
                "Serbia", TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000",
                "$50,000-$100,000", "All the above");
        kapitalRsEnPage.checkRegulation();
        driver.get("https://dlp.kapitalrs.com/lps/pro-dark-nob/en?fts=age-annual-saving-knowledge");
        kapitalRsEnPage.alreadyRegisteredAccount("Testq", "Testa", email, "Serbia", phoneNumber);
        kapitalRsEnPage.assertPopUpForAlreadyRegisteredAccount("Already registered account - KapitalRs - pop-up");
    }

    @Test(description = "Verify that the First Name cannot be the same as Last Name")
    public void sameFNameAndLName() throws IOException, AWTException {
        kapitalRsEnPage = new KapitalRsEnPage(driver);
        kapitalRsEnPage.enterFirstName("Test");
        kapitalRsEnPage.enterLastName("Test");
        kapitalRsEnPage.clickElement(kapitalRsEnPage.firstName, "on first name field");
        kapitalRsEnPage.clickElement(kapitalRsEnPage.lastName, "on last name field");
        kapitalRsEnPage.assertSameNameErrorMsgs();
        kapitalRsEnPage.takeScreenshot("Error messages for the same first and last name - KapitalRs");
    }

    @Test(description = "Verify the logo is not clickable with left click")
    public void checkingForLogoClickability() throws IOException, AWTException {
        kapitalRsEnPage = new KapitalRsEnPage(driver);
        kapitalRsEnPage.checkLogoClickability("https://dlp.kapitalrs.com/lps/pro-dark-nob/en?fts=age-annual-saving-knowledge");
        kapitalRsEnPage.takeScreenshot("Logo is not clickable - KapitalRs");
    }

/*    @Test
    public void checkForCountryCodeErrorMessage() throws IOException, AWTException {
        kapitalRsEnPage = new KapitalRsEnPage(driver);
        kapitalRsEnPage.checkCountryCodeErrorMessage("01852833kdkd");
        kapitalRsEnPage.takeScreenshot("Country code error message - KapitlaRs");
    }*/

    @Test(description = "Verify the email is sent on the new account email")
    public void emailIsReceivedSuccessfully() throws IOException, AWTException {
        String email = TestData.emailGenerator();
        kapitalRsEnPage = new KapitalRsEnPage(driver);
        kapitalRsEnPage.successfullyRegistration("Testq", "Testa", email,
                "Serbia", TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000",
                "$50,000-$100,000", "All the above");
        kapitalRsEnPage.checkRegulation();
        driver.get("https://yopmail.com/en/");
        YopMail yopMail = new YopMail(driver);
        yopMail.findEmailKRS(email);
        yopMail.zoomOutMethod();
        yopMail.takeScreenshot("Email is received successfully - KapitalRs", yopMail.emailTitleKRS);
    }

    @Test(description = "Verify the Privacy Policy link works with left/right click")
    public void privacyPolicyTest() throws IOException, AWTException, InterruptedException {
        kapitalRsEnPage = new KapitalRsEnPage(driver);
        kapitalRsEnPage.clickOnSelectedLink(kapitalRsEnPage.privacyPolicyLinkBy, kapitalRsEnPage.privacyPolicyFSC,
                "Privacy policy");
        kapitalRsEnPage.rightClickOnSelectedLink(kapitalRsEnPage.privacyPolicyLinkBy, kapitalRsEnPage.privacyPolicyFSC);
    }

    @Test(description = "Verify the Terms and Conditions link works with left/right click")
    public void termsAndConditionsTest() throws IOException, AWTException, InterruptedException {
        kapitalRsEnPage = new KapitalRsEnPage(driver);
        kapitalRsEnPage.clickOnSelectedLink(kapitalRsEnPage.termsAndConditionsLinkBy, kapitalRsEnPage.termsAndConditionsFSC,
                "Terms and conditions");
        kapitalRsEnPage.rightClickOnSelectedLink(kapitalRsEnPage.termsAndConditionsLinkBy, kapitalRsEnPage.termsAndConditionsFSC);
    }

    @Test(description = "Verify the click here link works with left/right click")
    public void howToUnsubscribeTest() throws IOException, AWTException, InterruptedException {
        kapitalRsEnPage = new KapitalRsEnPage(driver);
        kapitalRsEnPage.clickOnSelectedLink(kapitalRsEnPage.clickHereLink, kapitalRsEnPage.howToUnsubscribeURL,
                "How to unsubscribe");
        kapitalRsEnPage.rightClickOnSelectedLink(kapitalRsEnPage.clickHereLink, kapitalRsEnPage.howToUnsubscribeURL);
    }

    @Test(description = "Verify the Already have an account? link with left click redirects user to the login page")
    public void loginRedirectionTest() throws IOException, AWTException {
        kapitalRsEnPage = new KapitalRsEnPage(driver);
        kapitalRsEnPage.loginRedirection();
        if (driver.getCurrentUrl().contains(kapitalRsEnPage.alrHaveAccount)) {
            kapitalRsEnPage.takeScreenshot("Login page - the user is successfully redirected - KapitalRs");
        } else {
            System.out.println("Wrong link redirection");
        }
    }

    @Test(description = "Verify the Privacy policy (in footer) link works with left/right click")
    public void footerPrivacyPolicy() throws IOException, InterruptedException, AWTException {
        kapitalRsEnPage = new KapitalRsEnPage(driver);
        kapitalRsEnPage.scrollToAnElement(driver.findElement(By.xpath("//a[contains" +
                "(text(), 'Privacy policy.')]")));
        kapitalRsEnPage.clickOnSelectedLink(kapitalRsEnPage.footerPrivacyPolicyLinkBy, kapitalRsEnPage.privacyPolicyFSCFooter,
                "Privacy policy footer");
        kapitalRsEnPage.rightClickOnSelectedLink(kapitalRsEnPage.footerPrivacyPolicyLinkBy, kapitalRsEnPage.privacyPolicyFSCFooter);
    }

    @Test(description = "Verify the Risk warning link works with left/right click")
    public void riskWarningTest() throws IOException, InterruptedException, AWTException {
        kapitalRsEnPage = new KapitalRsEnPage(driver);
        kapitalRsEnPage.scrollToAnElementBy(kapitalRsEnPage.footerRiskWarningLinkBy);
        kapitalRsEnPage.clickOnSelectedLink(kapitalRsEnPage.footerRiskWarningLinkBy, kapitalRsEnPage.footerRiskWarning,
                "Risk warning");
        kapitalRsEnPage.rightClickOnSelectedLink(kapitalRsEnPage.footerRiskWarningLinkBy, kapitalRsEnPage.footerRiskWarning);
    }

    @Test(description = "Verify the FRN: 609970 link works with left/right click")
    public void fscRegulationTest() throws IOException, InterruptedException, AWTException {
        kapitalRsEnPage = new KapitalRsEnPage(driver);
        kapitalRsEnPage.scrollToAnElement(driver.findElement(By.xpath("//a[text()=' GB21026472']")));
        kapitalRsEnPage.clickOnSelectedLink(kapitalRsEnPage.fscRegulationLinkBy, kapitalRsEnPage.fscLink,
                "Financial Services Commission page");
        kapitalRsEnPage.scrollToAnElement(driver.findElement(By.xpath("//a[text()=' GB21026472']")));
        kapitalRsEnPage.rightClickOnSelectedLink(kapitalRsEnPage.fscRegulationLinkBy, kapitalRsEnPage.fscLink);
    }

/*    @Test
    public void asicRegulationTest() throws IOException, InterruptedException, AWTException {
        kapitalRsEnPage = new KapitalRsEnPage(driver);
        kapitalRsEnPage.scrollToAnElementBy(kapitalRsEnPage.asicRegulationLinkBy);
        kapitalRsEnPage.clickOnSelectedLink(kapitalRsEnPage.asicRegulationLinkBy, kapitalRsEnPage.asicLink,
                "Australian Securities and Investments Commission page");
        kapitalRsEnPage.rightClickOnSelectedLink(kapitalRsEnPage.asicRegulationLinkBy, kapitalRsEnPage.asicLink);
    }*/

/*    @Test(description = "Verify the GB21026472 link works with left/right click")
    public void fcaRegulationTest() throws IOException, InterruptedException, AWTException {
        kapitalRsEnPage = new KapitalRsEnPage(driver);
        kapitalRsEnPage.scrollToAnElementBy(kapitalRsEnPage.fcaRegulationLinkBy);
        kapitalRsEnPage.clickOnSelectedLink(kapitalRsEnPage.fcaRegulationLinkBy, kapitalRsEnPage.fcaLink,
                "Financial conduct authority page");
        kapitalRsEnPage.scrollToAnElement(driver.findElement(By.xpath("//a[text()='609970']")));
        kapitalRsEnPage.rightClickOnSelectedLink(kapitalRsEnPage.fcaRegulationLinkBy, kapitalRsEnPage.fcaLink);
    }*/

/*    @Test
    public void fbLinkRedirection() throws IOException, InterruptedException, AWTException {
        KapitalRsEnPage = new KapitalRsEnPage(driver);
        KapitalRsEnPage.clickOnSelectedLink(KapitalRsEnPage.facebookLinkBy, fortradeRPage.fbURL, "Facebook page");
        KapitalRsEnPage.rightClickOnSelectedLink(KapitalRsEnPage.facebookLinkBy, fortradeRPage.fbURL);
    }

    @Test
    public void insLinkRedirection() throws IOException, InterruptedException, AWTException {
        KapitalRsEnPage = new KapitalRsEnPage(driver);
        KapitalRsEnPage.clickOnSelectedLink(KapitalRsEnPage.instagramLinkBy, fortradeRPage.insURL, "Instagram page");
        KapitalRsEnPage.rightClickOnSelectedLink(KapitalRsEnPage.instagramLinkBy, fortradeRPage.insURL);
    }

    @Test
    public void ytLinkRedirection() throws IOException, InterruptedException, AWTException {
        KapitalRsEnPage = new KapitalRsEnPage(driver);
        KapitalRsEnPage.clickOnSelectedLink(KapitalRsEnPage.youtubeLinkBy, fortradeRPage.ytURL, "Youtube page");
        KapitalRsEnPage.rightClickOnSelectedLink(KapitalRsEnPage.youtubeLinkBy, fortradeRPage.ytURL);
    }*/

    @Test
    public void contactUsLink() throws IOException, AWTException, InterruptedException {
        kapitalRsEnPage = new KapitalRsEnPage(driver);
        kapitalRsEnPage.clickOnMailLink("Kontakt");
        Thread.sleep(1000);
        kapitalRsEnPage.takeScreenshot("KapitalRs - contact us redirection");
        kapitalRsEnPage.closeOutlook();
    }

   @Test
    public void infoLink() throws IOException, AWTException, InterruptedException {
        kapitalRsEnPage.clickOnMailLink("info");
        Thread.sleep(1000);
        kapitalRsEnPage.takeScreenshot("FortradeR - info redirection");
        kapitalRsEnPage.closeOutlook();
    }

   /*  @Test
    public void supportLink() throws IOException, AWTException, InterruptedException {
        KapitalRsEnPage = new KapitalRsEnPage(driver);
        KapitalRsEnPage.clickOnMailLink("support");
        Thread.sleep(1000);
        KapitalRsEnPage.takeScreenshot("FortradeR - support redirection");
        KapitalRsEnPage.closeOutlook();
    }*/

    @Test(description = "Verify the 2nd step - age verification window cannot be submitted if it's not completed")
    public void errorMessageAgeParameter() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        String phoneNumber = TestData.phoneNumberGenerator();
        driver.get("https://dlp.kapitalrs.com/lps/pro-dark-nob/en?fts=age");
        kapitalRsEnPage = new KapitalRsEnPage(driver);
        kapitalRsEnPage.ageParameter("Testq", "Testa", email, "Serbia", phoneNumber,
                "-- Select --");
        kapitalRsEnPage.secondStepErrorMessage(1);
        kapitalRsEnPage.takeScreenshot("Age parameter error message - KapitalRs");
    }

    @Test(description = "Verify the 2nd step - annual income verification window cannot be submitted if it's not completed")
    public void errorMessageAnnualParameter() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        String phoneNumber = TestData.phoneNumberGenerator();
        driver.get("https://dlp.kapitalrs.com/lps/pro-dark-nob/en?fts=annual");
        kapitalRsEnPage = new KapitalRsEnPage(driver);
        kapitalRsEnPage.annualParameter("Testq", "Testa", email, "Serbia", phoneNumber,
                "-- Select --");
        kapitalRsEnPage.secondStepErrorMessage(1);
        kapitalRsEnPage.takeScreenshot("Annual parameter error message - KapitalRs");
    }

    @Test(description = "Verify the 2nd step - value of saving and investments verification window cannot be submitted if it's not completed")
    public void errorMessageSavingParameter() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        String phoneNumber = TestData.phoneNumberGenerator();
        driver.get("https://dlp.kapitalrs.com/lps/pro-dark-nob/en?fts=saving");
        kapitalRsEnPage = new KapitalRsEnPage(driver);
        kapitalRsEnPage.savingParameter("Testq", "Testa", email, "Serbia", phoneNumber,
                "-- Select --");
        kapitalRsEnPage.secondStepErrorMessage(1);
        kapitalRsEnPage.takeScreenshot("Saving parameter error message - KapitalRs");
    }

    @Test(description = "Verify the 2nd step - knowledge of trading verification window cannot be submitted if it's not completed")
    public void errorMessageKnowledgeParameter() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        String phoneNumber = TestData.phoneNumberGenerator();
        driver.get("https://dlp.kapitalrs.com/lps/pro-dark-nob/en?fts=knowledge");
        kapitalRsEnPage = new KapitalRsEnPage(driver);
        kapitalRsEnPage.knowledgeParameter("Testq", "Testa", email, "Serbia", phoneNumber,
                "-- Select --");
        kapitalRsEnPage.secondStepErrorMessage(1);
        kapitalRsEnPage.takeScreenshot("Knowledge parameter error message - KapitalRs");
    }

    @Test(description = "Verify the 2nd step cannot be submitted if all parameter values are not completed ")
    public void errorMessagesAllParameters() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        String phoneNumber = TestData.phoneNumberGenerator();
        kapitalRsEnPage = new KapitalRsEnPage(driver);
        kapitalRsEnPage.unsuccessfullyRegistration("Testq", "Testa", email, "Serbia", phoneNumber,
                "25-34", "$15,000-$50,000", "$50,000-$100,000", "All the above",
                "-- Select --", "-- Select --", "-- Select --", "-- Select --");
        kapitalRsEnPage.secondStepErrorMessage(4);
        kapitalRsEnPage.takeScreenshot("All parameters error message - KapitalRs");
    }

    @Test(description = "Verify the desired communication language value is displayed correctly in the Link ID field in the CRM")
    public void checkLanguageParameter() throws IOException, AWTException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.kapitalrs.com/lps/pro-dark-nob/en?fts=plang:srcs,all");
        kapitalRsEnPage = new KapitalRsEnPage(driver);
        kapitalRsEnPage.languageParameter("Testq", "Testa", email, "Serbia",
                TestData.phoneNumberGenerator(),"English");
        kapitalRsEnPage.checkRegulation();
        CrmPage crmPage = new CrmPage(driver);
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.checkLinkIdValue("PC_windows,lang_EN");
        crmPage.takeScreenshot("Desired communication language - KapitalRs",crmPage.linkId);
    }

    @Test(description = "Verify the 2nd step - desired communication language verification window cannot be submitted if it's not completed")
    public void errorLanguageParameter() throws IOException, AWTException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.kapitalrs.com/lps/pro-dark-nob/en?fts=plang:srcs,all");
        kapitalRsEnPage = new KapitalRsEnPage(driver);
        kapitalRsEnPage.languageParameter("Testq", "Testa", email, "Serbia",
                TestData.phoneNumberGenerator(),"-- Select --");
        kapitalRsEnPage.assertBorderColor(kapitalRsEnPage.languageField);
        kapitalRsEnPage.takeScreenshot("Desired communication language - error - KapitalRs", kapitalRsEnPage.languageField);
    }

    @Test(description = "Verify that the Language field in the CRM contains expected value")
    public void verifyLanguageField() throws IOException, AWTException {
        kapitalRsEnPage = new KapitalRsEnPage(driver);
        crmPage = new CrmPage(driver);
        String email = TestData.emailGenerator();
        driver.get("https://dlp.kapitalrs.com/lps/pro-dark-nob/en?fts=age-annual-saving-knowledge&userLang=en");
        kapitalRsEnPage.successfullyRegistration("Testq","Testa",email,"Serbia",TestData.phoneNumberGenerator(),
                "25-34", "$15,000-$50,000", "$50,000-$100,000", "All the above");
        kapitalRsEnPage.assertURL("https://pro.kapitalrs.com");
        crmPage.checkCrmData(email,"Testq Testa","FSC");
        crmPage.checkLanguageInCrm("en");
        kapitalRsEnPage.takeScreenshot("Language field ",crmPage.language);
    }

    @Test(description = "Verify that the Language field in the CRM contains the default value (the language of the base " +
            "page URL) when we enter the wrong language in the userLang parameter")
    public void verifyLanguage() throws IOException, AWTException {
        kapitalRsEnPage = new KapitalRsEnPage(driver);
        crmPage = new CrmPage(driver);
        String email = TestData.emailGenerator();
        driver.get("https://dlp.kapitalrs.com/lps/pro-dark-nob/en?fts=age-annual-saving-knowledge&userLang=he");
        kapitalRsEnPage.successfullyRegistration("Testq","Testa",email,"Serbia",TestData.phoneNumberGenerator(),
                "25-34", "$15,000-$50,000", "$50,000-$100,000", "All the above");
        kapitalRsEnPage.assertURL("https://pro.kapitalrs.com/");
        crmPage.checkCrmData(email,"Testq Testa","FSC");
        crmPage.checkLanguageInCrm("en");
        kapitalRsEnPage.takeScreenshot("Language field - default language ",crmPage.language);
    }
}
