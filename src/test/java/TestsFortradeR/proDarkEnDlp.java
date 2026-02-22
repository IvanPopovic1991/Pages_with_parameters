package TestsFortradeR;

import Pages.CrmPage;
import Pages.FortradeRPage;
import Pages.YopMail;
import faker.TestData;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class proDarkEnDlp extends BaseTestFortradeR {

    FortradeRPage fortradeRPage;
    CrmPage crmPage;

    @BeforeMethod
    public void setUp() {
        baseSetup("Chrome", "143");
        fortradeRPage = new FortradeRPage(driver);
        crmPage = new CrmPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        baseTearDown();
    }

    @Test(description = "Verify demo account registration")
    public void demoAccountRegistration() throws IOException, AWTException, InterruptedException {
        fortradeRPage.successfullyRegistration("Testq", "Testa", TestData.emailGenerator(),
                "381", TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000",
                "$50,000-$100,000", "Yes, from a relevant role in financial services", "English");
        fortradeRPage.checkRegulation();
        fortradeRPage.takeScreenshot("Successfully demo account registration - FortradeR", fortradeRPage.regulationMsg);
    }

    @Test(description = "Verify the marketing tags in CRM")
    public void checkingTagsInTheCrm() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.fortrader.com/lps/pro-dark/en/?fts=age-annual-saving-knowledge-plang:all&tg=ivanA" +
                "1434&tag1=ivanB@1434&tag2=ivanL1434&tag3=ivanM1434&gid=ivanC@1434&G_GEO=ivanD1434&G_GEOint=ivanE1434&G_" +
                "Device=ivanF1434&G_DeviceModel=ivanG1434&G_AdPos=ivanH1434&g_Track=ivanI1434&Track=ivanj1434&gclid=ivanK1434");
        fortradeRPage.successfullyRegistration("Testq", "Testa", email, "381",
                TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000", "$50,000-$100,000", "All the above", "English");
        fortradeRPage.checkRegulation();
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.takeScreenshot("Account details Fortrader page", crmPage.accFullNameCrm);
        crmPage.checkCrmTags();
        crmPage.takeScreenshot("Marketing tags Fortrader page", crmPage.accFullNameCrm);
    }

    @Test(description = "Verify that the Custom tag in the CRM is empty")
    public void checkingCustomTag() throws InterruptedException, IOException, AWTException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.fortrader.com/lps/pro-dark/en/?fts=age-annual-saving-knowledge-plang:all");
        fortradeRPage.successfullyRegistration("Testq", "Testa", email, "381",
                TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000",
                "$50,000-$100,000", "Yes, from a relevant role in financial services", "English");
        fortradeRPage.checkRegulation();
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.checkCustomTag("");
        crmPage.takeScreenshot("Custom tag field value is empty - FortradeR", crmPage.customTag);
    }

    @Test(description = "Verify the account is registered successfully with NON-valid tag in the URL")
    public void checkingNonValidParameter() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.fortrader.com/lps/pro-dark/en/?fts=testq-testa");
        fortradeRPage.registerAccount1Step("Testq","Testa",email,
                "381",TestData.phoneNumberGenerator());
        fortradeRPage.checkRegulation();
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.checkUtmContent("testq-testa");
        fortradeRPage.takeScreenshot("Demo account registration - non valid tag -utm content- FortradeR");
    }

    @Test(description = "Verify the age value is displayed correctly in the Link ID field in the CRM")
    public void checkingAgeParameter() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.fortrader.com/lps/pro-dark/en/?fts=age");
        fortradeRPage.ageParameter("Testq", "Testa", email, "381", TestData.phoneNumberGenerator(),
                "25-34");
        fortradeRPage.checkRegulation();
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.checkSMSVerification("--");
        crmPage.takeScreenshot("SMS Verification field Age parameter - no value", crmPage.smsVerification);
        crmPage.checkLinkIdValue("PC_windows,25_34_age");
        Thread.sleep(1000);
        crmPage.takeScreenshot("Age parameter value - FortradeR", crmPage.linkId);
    }

    @Test(description = "Verify the annual value is displayed correctly in the Link ID field in the CRM")
    public void checkingAnnualParameter() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.fortrader.com/lps/pro-dark/en/?fts=annual");
        fortradeRPage.annualParameter("Testq", "Testa", email, "381", TestData.phoneNumberGenerator(),
                "$15,000-$50,000");
        fortradeRPage.checkRegulation();
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.checkSMSVerification("--");
        crmPage.takeScreenshot("SMS Verification field Annual parameter - no value", crmPage.smsVerification);
        crmPage.checkLinkIdValue("PC_windows,15000_50000_annual");
        Thread.sleep(1000);
        crmPage.takeScreenshot("Annual parameter value - FortradeR", crmPage.linkId);
    }

    @Test(description = "Verify the saving value is displayed correctly in the Link ID field in the CRM")
    public void checkingSavingParameter() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.fortrader.com/lps/pro-dark/en/?fts=saving");
        fortradeRPage.savingParameter("Testq", "Testa", email, "381", TestData.phoneNumberGenerator(),
                "$50,000-$100,000");
        fortradeRPage.checkRegulation();
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.checkSMSVerification("--");
        crmPage.takeScreenshot("SMS Verification field Saving parameter - no value", crmPage.smsVerification);
        crmPage.checkLinkIdValue("PC_windows,50000_100000_savings");
        Thread.sleep(1000);
        crmPage.takeScreenshot("Saving parameter value - FortradeR", crmPage.linkId);
    }

    @Test(description = "Verify the knowledge of trading value is displayed correctly in the Link ID field in the CRM")
    public void checkingKnowledgeParameter() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.fortrader.com/lps/pro-dark/en/?fts=knowledge");
        fortradeRPage.knowledgeParameter("Testq", "Testa", email, "381", TestData.phoneNumberGenerator(),
                "All the above");
        fortradeRPage.checkRegulation();
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.checkSMSVerification("--");
        crmPage.takeScreenshot("SMS Verification field Knowledge parameter - no value", crmPage.smsVerification);
        crmPage.checkLinkIdValue("PC_windows,knowledge_of_trading_all_the_above");
        Thread.sleep(1000);
        crmPage.takeScreenshot("Knowledge parameter value - FortradeR", crmPage.linkId);
    }

    @Test(description = "Verify that wrong code cannot be submitted")
    public void assertInvalidTokenMsg() throws IOException, AWTException {
        driver.get("https://dlp.fortrader.com/lps/pro-dark/en/?fts=sms-age-annual-saving-knowledge");
        fortradeRPage.unsuccessfullyRegistrationWrongSMS("Testq", "Testa", TestData.emailGenerator(), "381",
                TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000", "$50,000-$100,000", "All the above",
                "1", "1", "1", "1");
        Assert.assertEquals(fortradeRPage.incorrectTokenMsg.getText(), "Incorrect Code. Please check and try again.");
        fortradeRPage.takeScreenshot("Incorrect code - Please check and try again - FortradeR");
    }

    //@Test(description = "Verify token cannot be submitted if the phone number is not correct")

    @Test(description = "Verify that message We sent you the code again is received")
    public void didNotGetToken() throws IOException, AWTException, InterruptedException {
        driver.get("https://dlp.fortrader.com/lps/pro-dark/en/?fts=sms-age-annual-saving-knowledge");
        fortradeRPage.tokenIsNotReceived("Testq", "Testa", TestData.emailGenerator(), "381",
                TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000", "$50,000-$100,000", "All the above");
        Assert.assertEquals(fortradeRPage.codeIsSent.getText(), "We sent you the code again");
        Thread.sleep(2000);
        if (fortradeRPage.codeIsSent.isDisplayed()) {
            fortradeRPage.takeScreenshot("We sent you the code again - FortradeR", fortradeRPage.codeIsSent);
        }
    }

    @Test(description = "Verify if user clicks pencil icon the same is returned to the 1st widget")
    public void userIsReturnedTo1stWidget() throws IOException, AWTException {
        driver.get("https://dlp.fortrader.com/lps/pro-dark/en/?fts=sms-age-annual-saving-knowledge");
        fortradeRPage.enterFirstName("Testq");
        fortradeRPage.enterLastName("Testa");
        fortradeRPage.enterEmail(TestData.emailGenerator());
        fortradeRPage.enterCountryCode("381");
        fortradeRPage.enterPhoneNumber(TestData.phoneNumberGenerator());
        fortradeRPage.clickSubmitButton();
        fortradeRPage.selectAge("75+");
        fortradeRPage.clickEditTokenBtn();
        if (fortradeRPage.loginToFortrade.isDisplayed()) {
            fortradeRPage.takeScreenshot("The user is returned to the 1st form widget - FortradeR", fortradeRPage.loginToFortrade);
        }
    }

    @Test(description = "Verify the demo account is not registered successfully with invalid data")
    public void unsuccessfullyDemoAccountRegistration() throws IOException, AWTException {
        fortradeRPage.unsuccessfullyRegistrationWithWrongData("123", "456", "345342=--=/.,><",
                "123456", "1234567890123456");
        fortradeRPage.assertErrorMessages();
        fortradeRPage.assertColor("red");
        fortradeRPage.takeScreenshot("Unsuccessfully demo account registration - FortradeR", fortradeRPage.submitButton);
    }

    @Test(description = "Verify the demo account is not registered successfully with empty fields")
    public void emptyDemoAccountRegistration() throws IOException, AWTException {
        fortradeRPage.unsuccessfullyRegistrationWithWrongData("", "", "", "", "");
        fortradeRPage.assertErrorMessages();
        fortradeRPage.assertColor("red");
        fortradeRPage.takeScreenshot("Demo account registration - no data - Fortrader", fortradeRPage.submitButton);
    }

    @Test(description = "Verify that the already registered email address cannot be register")
    public void alreadyRegisteredAccountTest() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        //String phoneNumber = TestData.phoneNumberGenerator();
        fortradeRPage.successfullyRegistration("Testq", "Testa", email,
                "381", TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000",
                "$50,000-$100,000", "All the above", "English");
        fortradeRPage.checkRegulation();
        driver.get("https://dlp.fortrader.com/lps/pro-dark/en/?fts=age-annual-saving-knowledge-plang:all");
        fortradeRPage.alreadyRegisteredAccount("Testq", "Testa", email, "381", TestData.phoneNumberGenerator());
        fortradeRPage.assertPopUpForAlreadyRegisteredAccount("Already registered account - FortradeR - pop-up");
    }

    @Test(description = "Verify that the First Name cannot be the same as Last Name")
    public void sameFNameAndLName() throws IOException, AWTException {
        fortradeRPage.enterFirstName("Test");
        fortradeRPage.enterLastName("Test");
        fortradeRPage.clickElement(fortradeRPage.firstName, "on first name field");
        fortradeRPage.clickElement(fortradeRPage.lastName, "on last name field");
        fortradeRPage.assertSameNameErrorMsgs();
        fortradeRPage.takeScreenshot("Error messages for the same first and last name - FortradeR");
    }

    @Test(description = "Verify the logo is not clickable with left click")
    public void checkingForLogoClickability() throws IOException, AWTException {
        fortradeRPage.checkLogoClickability("https://dlp.fortrader.com/lps/pro-dark/en/?fts=age-annual-saving-knowledge");
        fortradeRPage.takeScreenshot("Logo is not clickable - FortradeR");
    }

    @Test(description = "Verify that the invalid data for Country Code field will show valid error message with red border")
    public void checkForCountryCodeErrorMessage() throws IOException, AWTException {
        fortradeRPage.checkCountryCodeErrorMessage("01852833kdkd");
        fortradeRPage.takeScreenshot("Country code error message - FortradeR", fortradeRPage.countryCodeErrorMessage);
    }

    @Test(description = "Verify the email is sent on the new account email")
    public void emailIsReceivedSuccessfully() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        fortradeRPage.successfullyRegistration("Testq", "Testa", email,
                "381", TestData.phoneNumberGenerator(), "25-34", "$50,000-$100,000",
                "$50,000-$100,000", "All the above", "English");
        fortradeRPage.checkRegulation();
        driver.get("https://yopmail.com/en/");
        YopMail yopMail = new YopMail(driver);
        yopMail.findEmail(email);
        yopMail.zoomOutMethod();
        yopMail.takeScreenshot("Email is received successfully - FortradeR", yopMail.emailTitle);
    }

    @Test(description = "Verify the Privacy Policy link works with left/right click")
    public void privacyPolicyTest() throws IOException, AWTException, InterruptedException {
        Thread.sleep(2000);
        fortradeRPage.clickOnSelectedLink(fortradeRPage.privacyPolicyLinkBy, fortradeRPage.privacyPolicyFSC,
                "Privacy policy");
        fortradeRPage.rightClickOnSelectedLink(fortradeRPage.privacyPolicyLinkBy, fortradeRPage.privacyPolicyFSC);
    }

    @Test(description = "Verify the Terms and Conditions link works with left/right click")
    public void termsAndConditionsTest() throws IOException, AWTException, InterruptedException {
        Thread.sleep(2000);
        fortradeRPage.clickOnSelectedLink(fortradeRPage.termsAndConditionsLinkBy, fortradeRPage.termsAndConditionsFSC,
                "Terms and conditions");
        fortradeRPage.rightClickOnSelectedLink(fortradeRPage.termsAndConditionsLinkBy, fortradeRPage.termsAndConditionsFSC);
    }

    @Test(description = "Verify the click here link works with left/right click")
    public void howToUnsubscribeTest() throws IOException, AWTException, InterruptedException {
        Thread.sleep(2000);
        fortradeRPage.clickOnSelectedLink(fortradeRPage.clickHereLinkBy, fortradeRPage.howToUnsubscribeURL,
                "How to unsubscribe");
        fortradeRPage.rightClickOnSelectedLink(fortradeRPage.clickHereLinkBy, fortradeRPage.howToUnsubscribeURL);
    }

    @Test(description = "Verify the Already have an account? link with left click redirects user to the login page")
    public void loginRedirectionTest() throws IOException, AWTException, InterruptedException {
        fortradeRPage.scrollToAnElement(fortradeRPage.alreadyHaveAnAccountLink);
        fortradeRPage.loginRedirection();
        Thread.sleep(2500);
        fortradeRPage.assertURL(fortradeRPage.alrHaveAccount);
        fortradeRPage.takeScreenshot("Login page - the user is successfully redirected - FortradeR");
    }

    @Test(description = "Verify the Privacy policy (in footer) link works with left/right click")
    public void footerPrivacyPolicy() throws IOException, InterruptedException, AWTException {
        fortradeRPage.scrollToAnElement(driver.findElement(By.xpath("//div[@class='fscClass']//a[contains" +
                "(text(), 'Privacy policy')]")));
        fortradeRPage.clickOnSelectedLink(fortradeRPage.footerPrivacyPolicyLinkBy, fortradeRPage.privacyPolicyFSCFooter,
                "Privacy policy footer - FortradeR");
        fortradeRPage.rightClickOnSelectedLink(fortradeRPage.footerPrivacyPolicyLinkBy, fortradeRPage.privacyPolicyFSCFooter);
    }

    @Test(description = "Verify the GB21026472 link works with left/right click")
    public void fscRegulationTest() throws IOException, InterruptedException, AWTException {
        fortradeRPage.scrollToAnElement(driver.findElement(By.xpath("//a[text()=' GB21026472']")));
        fortradeRPage.clickOnSelectedLink(fortradeRPage.fscRegulationLinkBy, fortradeRPage.fscLink,
                "Financial Services Commission page");
        fortradeRPage.scrollToAnElement(driver.findElement(By.xpath("//a[text()=' GB21026472']")));
        fortradeRPage.rightClickOnSelectedLink(fortradeRPage.fscRegulationLinkBy, fortradeRPage.fscLink);
    }

    @Test(description = "Verify the user is redirected to the facebook page")
    public void fbLinkRedirection() throws IOException, InterruptedException, AWTException {
        fortradeRPage.clickOnSelectedLink(fortradeRPage.facebookLinkBy, fortradeRPage.fbURL, "Facebook page");
        fortradeRPage.rightClickOnSelectedLink(fortradeRPage.facebookLinkBy, fortradeRPage.fbURL);
    }

    @Test(description = "Verify the user is redirected to the instagram page")
    public void insLinkRedirection() throws IOException, InterruptedException, AWTException {
        fortradeRPage.clickOnSelectedLink(fortradeRPage.instagramLinkBy, fortradeRPage.insURL, "Instagram page");
        fortradeRPage.rightClickOnSelectedLink(fortradeRPage.instagramLinkBy, fortradeRPage.insURL);
    }

    @Test(description = "Verify the user is redirected to the youtube channel")
    public void ytLinkRedirection() throws IOException, InterruptedException, AWTException {
        fortradeRPage.clickOnSelectedLink(fortradeRPage.youtubeLinkBy, fortradeRPage.ytURL, "Youtube page");
        fortradeRPage.rightClickOnSelectedLink(fortradeRPage.youtubeLinkBy, fortradeRPage.ytURL);
    }

    @Test(description = "Verify the click on Contact us link opens new mail window")
    public void contactUsLink() throws IOException, AWTException, InterruptedException {
        fortradeRPage.clickOnMailLink("contactUs");
        Thread.sleep(1000);
        fortradeRPage.takeScreenshot("FortradeR - contact us redirection");
        fortradeRPage.closeOutlook();
    }

    @Test(description = "Verify the click on info link opens new mail window")
    public void infoLink() throws IOException, AWTException, InterruptedException {
        fortradeRPage.clickOnMailLink("info");
        Thread.sleep(1000);
        fortradeRPage.takeScreenshot("FortradeR - info redirection");
        fortradeRPage.closeOutlook();
    }

    @Test(description = "Verify the click on support@fortrade.com link opens email window")
    public void supportLink() throws IOException, AWTException, InterruptedException {
        fortradeRPage.clickOnMailLink("support");
        Thread.sleep(1000);
        fortradeRPage.takeScreenshot("FortradeR - support redirection");
        fortradeRPage.closeOutlook();
    }

    @Test(description = "Verify the 2nd step - age verification window cannot be submitted if it's not completed")
    public void errorMessageAgeParameter() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        String phoneNumber = TestData.phoneNumberGenerator();
        driver.get("https://dlp.fortrader.com/lps/pro-dark/en/?fts=age");
        fortradeRPage.ageParameter("Testq", "Testa", email, "381", phoneNumber,
                "-- Select --");
        fortradeRPage.secondStepErrorMessage(1);
        fortradeRPage.takeScreenshot("Age parameter error message - FortradeR");
    }

    @Test(description = "Verify the 2nd step - annual income verification window cannot be submitted if it's not completed")
    public void errorMessageAnnualParameter() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        String phoneNumber = TestData.phoneNumberGenerator();
        driver.get("https://dlp.fortrader.com/lps/pro-dark/en/?fts=annual");
        fortradeRPage.annualParameter("Testq", "Testa", email, "381", phoneNumber,
                "-- Select --");
        fortradeRPage.secondStepErrorMessage(1);
        fortradeRPage.takeScreenshot("Annual parameter error message - FortradeR");
    }

    @Test(description = "Verify the 2nd step - value of saving and investments verification window cannot be submitted if it's not completed")
    public void errorMessageSavingParameter() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        String phoneNumber = TestData.phoneNumberGenerator();
        driver.get("https://dlp.fortrader.com/lps/pro-dark/en/?fts=saving");
        fortradeRPage.savingParameter("Testq", "Testa", email, "381", phoneNumber,
                "-- Select --");
        fortradeRPage.secondStepErrorMessage(1);
        fortradeRPage.takeScreenshot("Saving parameter error message - FortradeR");
    }

    @Test(description = "Verify the 2nd step - knowledge of trading verification window cannot be submitted if it's not completed")
    public void errorMessageKnowledgeParameter() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        String phoneNumber = TestData.phoneNumberGenerator();
        driver.get("https://dlp.fortrader.com/lps/pro-dark/en/?fts=knowledge");
        fortradeRPage.knowledgeParameter("Testq", "Testa", email, "381", phoneNumber,
                "-- Select --");
        fortradeRPage.secondStepErrorMessage(1);
        fortradeRPage.takeScreenshot("Knowledge parameter error message - FortradeR");
    }

    @Test(description = "Verify the 2nd step cannot be submitted if all parameter values are not completed ")
    public void errorMessagesAllParameters() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        String phoneNumber = TestData.phoneNumberGenerator();
        fortradeRPage.unsuccessfullyRegistration("Testq", "Testa", email, "381", phoneNumber,
                "25-34", "$15,000-$50,000", "$50,000-$100,000", "All the above",
                "-- Select --", "-- Select --", "-- Select --", "-- Select --");
        fortradeRPage.secondStepErrorMessage(4);
        fortradeRPage.takeScreenshot("All parameters error message - FortradeR");
    }

    @Test(description = "Verify the desired communication language value is displayed correctly in the Link ID field in the CRM")
    public void checkLanguageParameter() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.fortrader.com/lps/pro-dark/en/?fts=plang:srcs,all");
        fortradeRPage.languageParameter("Testq", "Testa", email, "381",
                TestData.phoneNumberGenerator(), "English");
        fortradeRPage.checkRegulation();
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.checkLinkIdValue("PC_windows,lang_EN");
        crmPage.takeScreenshot("Desired communication language - FortradeR", crmPage.linkId);
    }

    @Test(description = "Verify the 2nd step - desired communication language verification window cannot be submitted if it's not completed ")
    public void errorLanguageParameter() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.fortrader.com/lps/pro-dark/en/?fts=plang:srcs,all");
        fortradeRPage.languageParameter("Testq", "Testa", email, "381",
                TestData.phoneNumberGenerator(), "-- Select --");
        fortradeRPage.assertBorderColor(fortradeRPage.languageField);
        fortradeRPage.secondStepErrorMessage(1);
        fortradeRPage.takeScreenshot("Desired communication language - error - FortradeR", fortradeRPage.languageField);
    }

    @Test(description = "Verify that the account cannot be registered with already registered phone number")
    public void anAlreadyRegisteredPhone() throws IOException, AWTException, InterruptedException {
        String phoneNumber = TestData.phoneNumberGenerator();
        fortradeRPage.successfullyRegistration("Testq", "Testa", TestData.emailGenerator(), "381",
                phoneNumber, "25-34", "$15,000-$50,000", "$50,000-$100,000",
                "All the above", "English");
        fortradeRPage.checkRegulation();
        driver.get("https://dlp.fortrader.com/lps/pro-dark/en/?fts=age-annual-saving-knowledge-plang:all");
        fortradeRPage.alreadyRegisteredAccount("Testq", "Testa", TestData.emailGenerator(),
                "381", phoneNumber);
        fortradeRPage.assertPopUpForAlreadyRegisteredAccount("Already registered phone number - pop-up - FortradeR");
    }

    @Test(description = "Verify that the account cannot be registered with already registered email address and phone number")
    public void anAlreadyRegisteredEmailAndPhone() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        String phoneNumber = TestData.phoneNumberGenerator();
        fortradeRPage.successfullyRegistration("Testq", "Testa", email, "381", phoneNumber, "25-34", "$15,000-$50,000", "$50,000-$100,000", "All the above", "English");
        fortradeRPage.checkRegulation();
        driver.get("https://dlp.fortrader.com/lps/pro-dark/en/?fts=age-annual-saving-knowledge-plang:all");
        fortradeRPage.alreadyRegisteredAccount("Testq", "Testa", email,
                "381", phoneNumber);
        fortradeRPage.assertPopUpForAlreadyRegisteredAccount("Already registered email and phone number - pop-up - FortradeR");
    }

    @Test(description = "Verify the CFD text is not displayed on the landing page")
    public void isCFDsTextDisplayedOnTheFortradeRPage() throws IOException, AWTException {
        Assert.assertFalse(fortradeRPage.isTextVisibleAnywhereIgnoreCase("CFDs"), "Text 'CFDs' (case-insensitive) was found, but shouldn't be.");
        fortradeRPage.takeScreenshot("CFD text is not displayed on the page");
    }

    @Test(description = "Verify the custom tag field in the CRM contains Dummy value")
    public void dummyLeadRegistration() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.fortrader.com/lps/pro-dark/en/?fts=annual-saving-knowledge-age-plang:all&" +
                "ftsquery=age-equals(1,3)-or-[saving-equals(1,2,3)-and-knowledge-notequals(5)]");
        fortradeRPage.successfullyRegistration("Testq", "Testa", email, "381",
                TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000", "$50,000-$100,000",
                "All the above", "English");
        fortradeRPage.checkRegulation();
        crmPage.checkCrmData(email, "Testq Testa", "FortradeR");
        crmPage.checkCustomTag("Dummy");
        fortradeRPage.takeScreenshot("Custom Tag - Dummy - FortradeR", crmPage.customTag);
    }

    @Test(description = "Verify the custom tag field in the CRM contains Dummy value")
    public void dummy_Lead_Registration() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.fortrader.com/lps/pro-dark/en/?fts=annual-saving-knowledge-age-plang:all&" +
                "ftsquery=age-equals(1_3)-or-[saving-equals(1_2_3)-and-knowledge-notequals(5)]");
        fortradeRPage.successfullyRegistration("Testq", "Testa", email, "381",
                TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000", "$50,000-$100,000",
                "All the above", "English");
        fortradeRPage.checkRegulation();
        crmPage.checkCrmData(email, "Testq Testa", "FortradeR");
        crmPage.checkCustomTag("Dummy");
        fortradeRPage.takeScreenshot("Custom Tag - Dummy with - mark - FortradeR", crmPage.customTag);
    }

    @Test(description = "Verify the custom tag field in the CRM contains Invalid value")
    public void invalidLeadRegistration() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.fortrader.com/lps/pro-dark/en/?fts=age-annual-saving-knowledge-plang:all&ftsquery=age(1)-" +
                "or-[saving-equals(1,2,3)-and-knowledge-notequals(5)]");
        fortradeRPage.successfullyRegistration("Testq", "Testa", email, "381",
                TestData.phoneNumberGenerator(), "45-54", "$15,000-$50,000", "$100,000-$250,000",
                "None", "English");
        fortradeRPage.checkRegulation();
        crmPage.checkCrmData(email, "Testq Testa", "FortradeR");
        crmPage.checkCustomTag("Invalid");
        fortradeRPage.takeScreenshot("Custom Tag - Invalid - FortradeR", crmPage.customTag);
    }

    @Test(description = "Verify the custom tag field in the CRM contains Invalid value")
    public void invalid_Lead_Registration() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.fortrader.com/lps/pro-dark/en/?fts=age-annual-saving-knowledge-plang:all&ftsquery=age(1)-" +
                "or-[saving-equals(1_2_3)-and-knowledge-notequals(5)]");
        fortradeRPage.successfullyRegistration("Testq", "Testa", email, "381",
                TestData.phoneNumberGenerator(), "45-54", "$15,000-$50,000", "$100,000-$250,000",
                "None", "English");
        fortradeRPage.checkRegulation();
        crmPage.checkCrmData(email, "Testq Testa", "FortradeR");
        crmPage.checkCustomTag("Invalid");
        fortradeRPage.takeScreenshot("Custom Tag - Invalid with-mark - FortradeR", crmPage.customTag);
    }

    @Test(description = "Verify the custom tag field in the CRM is empty")
    public void emptyLeadRegistration() throws InterruptedException, IOException, AWTException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.fortrader.com/lps/pro-dark/en/?fts=age-annual-saving-knowledge-plang:all&ftsquery=age-" +
                "equals(1,3)-or-[saving-equals(1,2,3)-and-knowledge-notequals(5)]");
        fortradeRPage.successfullyRegistration("Testq", "Testa", email, "381",
                TestData.phoneNumberGenerator(), "45-54", "$15,000-$50,000", "$100,000-$250,000",
                "All the above", "English");
        fortradeRPage.checkRegulation();
        crmPage.checkCrmData(email, "Testq Testa", "FortradeR");
        crmPage.checkCustomTag("");
        Thread.sleep(2500);
        fortradeRPage.takeScreenshot("Custom Tag - Empty - FortradeR", crmPage.customTag);
    }

    @Test(description = "Verify the custom tag field in the CRM is empty")
    public void empty_Lead_Registration() throws InterruptedException, IOException, AWTException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.fortrader.com/lps/pro-dark/en/?fts=age-annual-saving-knowledge-plang:all&ftsquery=age-" +
                "equals(1_3)-or-[saving-equals(1_2_3)-and-knowledge-notequals(5)]");
        fortradeRPage.successfullyRegistration("Testq", "Testa", email, "381",
                TestData.phoneNumberGenerator(), "45-54", "$15,000-$50,000", "$100,000-$250,000",
                "All the above", "English");
        fortradeRPage.checkRegulation();
        crmPage.checkCrmData(email, "Testq Testa", "FortradeR");
        crmPage.checkCustomTag("");
        Thread.sleep(2500);
        fortradeRPage.takeScreenshot("Custom Tag - Empty - FortradeR", crmPage.customTag);
    }
}
