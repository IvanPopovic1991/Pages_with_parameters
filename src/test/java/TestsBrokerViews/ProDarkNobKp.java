package TestsBrokerViews;

import Pages.CrmPage;
import Pages.BrokerViewsPage;
import Pages.YopMail;
import faker.TestData;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class ProDarkNobKp extends BaseTestBrokerviews {

    BrokerViewsPage brokerViews;
    CrmPage crmPage;

    @BeforeMethod
    public void setUp(){
        baseSetUp("Chrome","146");
        brokerViews = new BrokerViewsPage(driver);
        crmPage = new CrmPage(driver);
    }

    @AfterMethod
    public void tearDown(){
        baseTearDown();
    }

    @Test(description = "Verify demo account registration")
    public void demoAccountRegistration() throws IOException, AWTException, InterruptedException {
        brokerViews.successfullyRegistration("Testq", "Testa", TestData.emailGenerator(),
                "Serbia", TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000",
                "$50,000-$100,000", "Yes, from a relevant role in financial services", "English");
        brokerViews.assertURL(TestData.kapitalRSUrl);
        brokerViews.checkRegulation();
        brokerViews.takeScreenshot("Successfully demo account registration - Broker Views",brokerViews.regulationMsg);
    }

    @Test(description = "Verify the marketing tags in CRM")
    public void checkingTagsInTheCrm() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.brokereviews.com/lps/pro-dark-nob-kp/en?fts=age-annual-saving-knowledge-plang:all&tg=ivanA" +
                "1434&tag1=ivanB@1434&tag2=ivanL1434&tag3=ivanM1434&gid=ivanC@1434&G_GEO=ivanD1434&G_GEOint=ivanE1434&G_" +
                "Device=ivanF1434&G_DeviceModel=ivanG1434&G_AdPos=ivanH1434&g_Track=ivanI1434&Track=ivanj1434&gclid=ivanK1434");
        brokerViews.successfullyRegistration("Testq", "Testa", email,
                "Serbia", TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000",
                "$50,000-$100,000", "Yes, from a relevant role in financial services", "English");
        brokerViews.assertURL(TestData.kapitalRSUrl);
        brokerViews.checkRegulation();
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.takeScreenshot("Account details Broker Views page", crmPage.accFullNameCrm);
        crmPage.checkCrmTags();
        crmPage.takeScreenshot("Marketing tags Broker Views page");
    }

    @Test(description = "Verify that the Custom tag in the CRM is empty")
    public void checkingCustomTag() throws InterruptedException, IOException, AWTException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.brokereviews.com/lps/pro-dark-nob-kp/en?fts=age-annual-saving-knowledge-plang:all");
        brokerViews.successfullyRegistration("Testq", "Testa", email, "Serbia",
                TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000",
                "$50,000-$100,000", "Yes, from a relevant role in financial services", "English");
        brokerViews.assertURL(TestData.kapitalRSUrl);
        brokerViews.checkRegulation();
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.checkCustomTag("");
        crmPage.takeScreenshot("Custom tag field value is empty - Broker Views", crmPage.customTag);
    }

    @Test(description = "Verify the account is registered successfully with NON-valid tag in the URL")
    public void checkingNonValidParameter() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.brokereviews.com/lps/pro-dark-nob-kp/en?fts=testq-testa");
        brokerViews.registerAccount1Step("Testq","Testa",email,
                "Serbia",TestData.phoneNumberGenerator());
        brokerViews.assertURL(TestData.kapitalRSUrl);
        brokerViews.checkRegulation();
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.checkUtmContent("testq-testa");
        brokerViews.takeScreenshot("Demo account registration - non valid tag - utm content- Broker Views");
    }

    @Test(description = "Verify the age value is displayed correctly in the Link ID field in the CRM")
    public void checkingAgeParameter() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.brokereviews.com/lps/pro-dark-nob-kp/en?fts=age");
        brokerViews.ageParameter("Testq", "Testa", email, "Serbia", TestData.phoneNumberGenerator(),
                "25-34");
        brokerViews.assertURL(TestData.kapitalRSUrl);
        brokerViews.checkRegulation();
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.checkSMSVerification("--");
        crmPage.takeScreenshot("SMS Verification field Age parameter - no value", crmPage.smsVerification);
        crmPage.checkLinkIdValue("PC_windows,25_34_age");
        Thread.sleep(1000);
        crmPage.takeScreenshot("Age parameter value - Broker Views", crmPage.linkId);
    }

    @Test(description = "Verify the annual value is displayed correctly in the Link ID field in the CRM")
    public void checkingAnnualParameter() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.brokereviews.com/lps/pro-dark-nob-kp/en?fts=annual");
        brokerViews.annualParameter("Testq", "Testa", email, "Serbia", TestData.phoneNumberGenerator(),
                "$15,000-$50,000");
        brokerViews.assertURL(TestData.kapitalRSUrl);
        brokerViews.checkRegulation();
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.checkSMSVerification("--");
        crmPage.takeScreenshot("SMS Verification field Annual parameter - no value", crmPage.smsVerification);
        crmPage.checkLinkIdValue("PC_windows,15000_50000_annual");
        Thread.sleep(1000);
        crmPage.takeScreenshot("Annual parameter value - Broker Views", crmPage.linkId);
    }

    @Test(description = "Verify the saving value is displayed correctly in the Link ID field in the CRM")
    public void checkingSavingParameter() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.brokereviews.com/lps/pro-dark-nob-kp/en?fts=saving");
        brokerViews.savingParameter("Testq", "Testa", email, "Serbia", TestData.phoneNumberGenerator(),
                "$50,000-$100,000");
        brokerViews.assertURL(TestData.kapitalRSUrl);
        brokerViews.checkRegulation();
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.checkSMSVerification("--");
        crmPage.takeScreenshot("SMS Verification field Saving parameter - no value", crmPage.smsVerification);
        crmPage.checkLinkIdValue("PC_windows,50000_100000_savings");
        Thread.sleep(1000);
        crmPage.takeScreenshot("Saving parameter value - Broker Views", crmPage.linkId);
    }

    @Test(description = "Verify the knowledge of trading value is displayed correctly in the Link ID field in the CRM")
    public void checkingKnowledgeParameter() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.brokereviews.com/lps/pro-dark-nob-kp/en?fts=knowledge");
        brokerViews.knowledgeParameter("Testq", "Testa", email, "Serbia", TestData.phoneNumberGenerator(),
                "All the above");
        brokerViews.assertURL(TestData.kapitalRSUrl);
        brokerViews.checkRegulation();
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.checkSMSVerification("--");
        crmPage.takeScreenshot("SMS Verification field Knowledge parameter - no value", crmPage.smsVerification);
        crmPage.checkLinkIdValue("PC_windows,knowledge_of_trading_all_the_above");
        Thread.sleep(1000);
        crmPage.takeScreenshot("Knowledge parameter value - Broker Views", crmPage.linkId);
    }

    @Test(description = "Verify the desired communication language value is displayed correctly in the Link ID field in the CRM")
    public void checkLanguageParameter() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.brokereviews.com/lps/pro-dark-nob-kp/en?fts=plang:all");
        brokerViews.languageParameter("Testq", "Testa", email, "Serbia",
                TestData.phoneNumberGenerator(), "English");
        brokerViews.assertURL(TestData.kapitalRSUrl);
        brokerViews.checkRegulation();
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.checkLinkIdValue("PC_windows,lang_EN");
        crmPage.takeScreenshot("Desired communication language - Broker Views", crmPage.linkId);
    }

    @Test(description = "Verify that wrong code cannot be submitted")
    public void assertInvalidTokenMsg() throws IOException, AWTException, InterruptedException {
        driver.get("https://dlp.brokereviews.com/lps/pro-dark-nob-kp/en?fts=sms-age-annual-saving-knowledge-plang:all");
        brokerViews.unsuccessfullyRegistrationWrongSMS("Testq", "Testa", TestData.emailGenerator(), "Serbia",
                TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000", "$50,000-$100,000", "All the above",
                "English","1", "1", "1", "1");
        Thread.sleep(500);
        Assert.assertEquals(brokerViews.incorrectTokenMsg.getText(), "Incorrect Code. Please check and try again.");
        brokerViews.takeScreenshot("Incorrect code - Please check and try again - Broker Views");
    }

    @Test(description = "Verify that message We sent you the code again is received")
    public void didNotGetToken() throws IOException, AWTException, InterruptedException {
        driver.get("https://dlp.brokereviews.com/lps/pro-dark-nob-kp/en?fts=sms-age-annual-saving-knowledge");
        brokerViews.tokenIsNotReceived("Testq", "Testa", TestData.emailGenerator(), "Serbia",
                TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000", "$50,000-$100,000", "All the above");
        Assert.assertEquals(brokerViews.codeIsSent.getText(), "We sent you the code again");
        Thread.sleep(2000);
        if (brokerViews.codeIsSent.isDisplayed()) {
            brokerViews.takeScreenshot("We sent you the code again - Broker Views", brokerViews.codeIsSent);
        }
    }

    @Test(description = "Verify if user clicks pencil icon the same is returned to the 1st widget")
    public void userIsReturnedTo1stWidget() throws IOException, AWTException {
        driver.get("https://dlp.brokereviews.com/lps/pro-dark-nob-kp/en?fts=sms-age-annual-saving-knowledge");
        brokerViews.enterFirstName("Testq");
        brokerViews.enterLastName("Testa");
        brokerViews.enterEmail(TestData.emailGenerator());
        brokerViews.handleCountryCode("Serbia");
        brokerViews.enterPhoneNumber(TestData.phoneNumberGenerator());
        brokerViews.clickOnSubmitBtn();
        brokerViews.selectAge("75+");
        brokerViews.clickEditTokenBtn();
        if (brokerViews.phoneNumber.isDisplayed()) {
            brokerViews.takeScreenshot("The user is returned to the 1st form widget - Broker Views", brokerViews.phoneNumber);
        }
    }

    @Test(description = "Verify the demo account is not registered successfully with invalid data")
    public void unsuccessfullyDemoAccountRegistration() throws IOException, AWTException {
        brokerViews.unsuccessfullyRegistrationWrongData("123", "456", "345342=--=/.,><",
                "123456", "1234567890123456");
        brokerViews.assertErrorMessages();
        //brokerViews.assertColor("red");
        brokerViews.takeScreenshot("Unsuccessfully demo account registration - Broker Views", brokerViews.submitBtn);
    }

    @Test(description = "Verify the demo account is not registered successfully with empty fields")
    public void emptyDemoAccountRegistration() throws IOException, AWTException {
        brokerViews.unsuccessfullyRegistrationWrongData("", "", "", "", "");
        brokerViews.assertErrorMessages();
        //brokerViews.assertColor("red");
        brokerViews.takeScreenshot("Demo account registration - no data - Broker Views", brokerViews.submitBtn);
    }

    @Test(description = "Verify that the already registered email address cannot be register")
    public void alreadyRegisteredAccountEmail() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        brokerViews.successfullyRegistration("Testq", "Testa", email,
                "Serbia", TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000",
                "$50,000-$100,000", "All the above", "English");
        brokerViews.assertURL(TestData.kapitalRSUrl);
        brokerViews.checkRegulation();
        driver.get("https://dlp.brokereviews.com/lps/pro-dark-nob-kp/en?fts=age-annual-saving-knowledge-plang:all");
        brokerViews.alreadyRegisteredAccount("Testq", "Testa", email, "Serbia", TestData.phoneNumberGenerator());
        brokerViews.assertPopUpForAlreadyRegisteredAccount();
        brokerViews.takeScreenshot("Already registered email address - Broker Views",brokerViews.alrdRegEmailMsg);
    }

    @Test(description = "Verify that the account cannot be registered with already registered phone number")
    public void anAlreadyRegisteredPhone() throws IOException, AWTException, InterruptedException {
        String phoneNumber = TestData.phoneNumberGenerator();
        brokerViews.successfullyRegistration("Testq", "Testa", TestData.emailGenerator(), "Serbia",
                phoneNumber, "25-34", "$15,000-$50,000", "$50,000-$100,000",
                "All the above", "English");
        brokerViews.assertURL(TestData.kapitalRSUrl);
        brokerViews.checkRegulation();
        driver.get("https://dlp.brokereviews.com/lps/pro-dark-nob-kp/en?fts=age-annual-saving-knowledge-plang:all");
        brokerViews.alreadyRegisteredAccount("Testq", "Testa", TestData.emailGenerator(),
                "Serbia", phoneNumber);
        brokerViews.assertPopUpForAlreadyRegisteredAccount();
        brokerViews.takeScreenshot("Already registered phone number - Broker Views");
    }

    @Test(description = "Verify that the account cannot be registered with already registered email address and phone number")
    public void anAlreadyRegisteredEmailAndPhone() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        String phoneNumber = TestData.phoneNumberGenerator();
        brokerViews.successfullyRegistration("Testq", "Testa", email, "Serbia", phoneNumber, "25-34", "$15,000-$50,000", "$50,000-$100,000", "All the above", "English");
        brokerViews.assertURL(TestData.kapitalRSUrl);
        brokerViews.checkRegulation();
        driver.get("https://dlp.brokereviews.com/lps/pro-dark-nob-kp/en?fts=age-annual-saving-knowledge-plang:all");
        brokerViews.alreadyRegisteredAccount("Testq", "Testa", email,
                "Serbia", phoneNumber);
        brokerViews.assertPopUpForAlreadyRegisteredAccount();
        brokerViews.takeScreenshot("Already registered email and phone - Broker Views");
    }

    @Test(description = "Verify that the First Name cannot be the same as Last Name")
    public void sameFNameAndLName() throws IOException, AWTException {
        brokerViews.enterFirstName("Testq");
        brokerViews.enterLastName("Testq");
        brokerViews.clickElement(brokerViews.firstName, "on first name field");
        brokerViews.clickElement(brokerViews.lastName, "on last name field");
        brokerViews.assertSameNameErrorMsgs();
        brokerViews.takeScreenshot("Error messages for the same first and last name - Broker Views");
    }

    @Test(description = "Verify the logo is not clickable with left click")
    public void checkingForLogoClickability() throws IOException, AWTException {
        brokerViews.checkLogoClickability("https://dlp.brokereviews.com/lps/pro-dark-nob-kp/en?fts=age-annual-saving-knowledge-plang:all");
        brokerViews.takeScreenshot("Logo is not clickable - Broker Views");
    }

    @Test(description = "Verify that the invalid data for Country Code field will show valid error message with red border")
    public void checkForCountryCodeErrorMessage() throws IOException, AWTException {
        brokerViews.checkCountryCodeErrorMessage("01852833kdkd");
        brokerViews.takeScreenshot("Country code error message - Broker Views", brokerViews.submitBtn);
    }

    @Test(description = "Verify the email is sent on the new account email")
    public void emailIsReceivedSuccessfully() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        brokerViews.successfullyRegistration("Testq", "Testa", email,
                "Serbia", TestData.phoneNumberGenerator(), "25-34", "$50,000-$100,000",
                "$50,000-$100,000", "All the above", "English");
        brokerViews.assertURL(TestData.kapitalRSUrl);
        brokerViews.checkRegulation();
        driver.get("https://yopmail.com/en/");
        YopMail yopMail = new YopMail(driver);
        yopMail.findEmail(email);
        yopMail.zoomOutMethod();
        yopMail.takeScreenshot("Email is received successfully - Broker Views", yopMail.emailTitle);
    }

    @Test(description = "Verify the Privacy Policy link works with left/right click")
    public void privacyPolicyTest() throws IOException, AWTException, InterruptedException {
        Thread.sleep(2000);
        brokerViews.clickOnSelectedLink(brokerViews.privacyPolicyLinkBy, brokerViews.privacyPolicyUrl,
                "Privacy policy");
        brokerViews.rightClickOnSelectedLink(brokerViews.privacyPolicyLinkBy, brokerViews.privacyPolicyUrl);
    }

    @Test(description = "Verify the Terms and Conditions link works with left/right click")
    public void termsAndConditionsTest() throws IOException, AWTException, InterruptedException {
        Thread.sleep(2000);
        brokerViews.clickOnSelectedLink(brokerViews.termsAndConditionsLinkBy, brokerViews.termsAndConditionsUrl,
                "Terms and conditions");
        brokerViews.rightClickOnSelectedLink(brokerViews.termsAndConditionsLinkBy, brokerViews.termsAndConditionsUrl);
    }

    @Test(description = "Verify the click here link works with left/right click")
    public void howToUnsubscribeTest() throws IOException, AWTException, InterruptedException {
        Thread.sleep(2000);
        brokerViews.clickOnSelectedLink(brokerViews.clickHereLink, brokerViews.howToUnsubscribeURL,
                "How to unsubscribe");
        brokerViews.rightClickOnSelectedLink(brokerViews.clickHereLink, brokerViews.howToUnsubscribeURL);
    }

    @Test(description = "Verify the Already have an account? link with left click redirects user to the login page")
    public void loginRedirectionTest() throws IOException, AWTException, InterruptedException {
        brokerViews.scrollToAnElement(brokerViews.alreadyHaveAnAccount);
        brokerViews.loginRedirection();
        Thread.sleep(2500);
        brokerViews.assertURL(brokerViews.alrHaveAccountUrl);
        brokerViews.takeScreenshot("Login page - the user is successfully redirected - Broker Views");
    }

    @Test(description = "Verify the 2nd step - age verification window cannot be submitted if it's not completed")
    public void errorMessageAgeParameter() throws IOException, AWTException, InterruptedException {
        driver.get("https://dlp.brokereviews.com/lps/pro-dark-nob-kp/en?fts=age");
        brokerViews.ageParameter("Testq", "Testa", TestData.emailGenerator(), "Serbia", TestData.phoneNumberGenerator(),
                "-- Select --");
        brokerViews.secondStepErrorMessage(1);
        brokerViews.takeScreenshot("Age parameter error message - Broker Views");
    }

    @Test(description = "Verify the 2nd step - annual income verification window cannot be submitted if it's not completed")
    public void errorMessageAnnualParameter() throws IOException, AWTException, InterruptedException {
        driver.get("https://dlp.brokereviews.com/lps/pro-dark-nob-kp/en?fts=annual");
        brokerViews.annualParameter("Testq", "Testa", TestData.emailGenerator(), "Serbia", TestData.phoneNumberGenerator(),
                "-- Select --");
        brokerViews.secondStepErrorMessage(1);
        brokerViews.takeScreenshot("Annual parameter error message - Broker Views");
    }

    @Test(description = "Verify the 2nd step - value of saving and investments verification window cannot be submitted if it's not completed")
    public void errorMessageSavingParameter() throws IOException, AWTException, InterruptedException {
        driver.get("https://dlp.brokereviews.com/lps/pro-dark-nob-kp/en?fts=saving");
        brokerViews.savingParameter("Testq", "Testa", TestData.emailGenerator(), "Serbia", TestData.phoneNumberGenerator(),
                "-- Select --");
        brokerViews.secondStepErrorMessage(1);
        brokerViews.takeScreenshot("Saving parameter error message - Broker Views");
    }

    @Test(description = "Verify the 2nd step - knowledge of trading verification window cannot be submitted if it's not completed")
    public void errorMessageKnowledgeParameter() throws IOException, AWTException, InterruptedException {
        driver.get("https://dlp.brokereviews.com/lps/pro-dark-nob-kp/en?fts=knowledge");
        brokerViews.knowledgeParameter("Testq", "Testa", TestData.emailGenerator(), "Serbia", TestData.phoneNumberGenerator(),
                "-- Select --");
        brokerViews.secondStepErrorMessage(1);
        brokerViews.takeScreenshot("Knowledge parameter error message - Broker Views");
    }

    @Test(description = "Verify the 2nd step - desired communication language verification window cannot be submitted if it's not completed ")
    public void errorLanguageParameter() throws IOException, AWTException, InterruptedException {
        driver.get("https://dlp.brokereviews.com/lps/pro-dark-nob-kp/en?fts=plang:all");
        brokerViews.languageParameter("Testq", "Testa", TestData.emailGenerator(), "Serbia",
                TestData.phoneNumberGenerator(), "-- Select --");
        brokerViews.assertBorderColor(brokerViews.languageField);
        brokerViews.secondStepErrorMessage(1);
        brokerViews.takeScreenshot("Desired communication language - error - Broker Views", brokerViews.languageField);
    }

    @Test(description = "Verify the 2nd step cannot be submitted if all parameter values are not completed ")
    public void errorMessagesAllParameters() throws IOException, AWTException, InterruptedException {
        brokerViews.unsuccessfullyRegistration("Testq", "Testa", TestData.emailGenerator(), "Serbia", TestData.phoneNumberGenerator(),
                "25-34", "$15,000-$50,000", "$50,000-$100,000", "All the above","English",
                "-- Select --", "-- Select --", "-- Select --", "-- Select --","-- Select --");
        brokerViews.secondStepErrorMessage(5);
        brokerViews.takeScreenshot("All parameters error message - Broker Views");
    }

    @Test(description = "Verify the custom tag field in the CRM contains Dummy value")
    public void dummyLeadRegistration() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.brokereviews.com/lps/pro-dark-nob-kp/en?fts=annual-saving-knowledge-age-plang:all&" +
                "ftsquery=age-equals(1,3)-or-[saving-equals(1,2,3)-and-knowledge-notequals(5)]");
        brokerViews.successfullyRegistration("Testq", "Testa", email, "Serbia",
                TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000", "$50,000-$100,000",
                "All the above", "English");
        brokerViews.assertURL(TestData.kapitalRSUrl);
        brokerViews.checkRegulation();
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.checkCustomTag("Dummy");
        brokerViews.takeScreenshot("Custom Tag - Dummy - Broker Views", crmPage.customTag);
    }

    @Test(description = "Verify the custom tag field in the CRM contains Dummy value")
    public void dummy_Lead_Registration() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.brokereviews.com/lps/pro-dark-nob-kp/en?fts=annual-saving-knowledge-age-plang:all&" +
                "ftsquery=age-equals(1_3)-or-[saving-equals(1_2_3)-and-knowledge-notequals(5)]");
        brokerViews.successfullyRegistration("Testq", "Testa", email, "Serbia",
                TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000", "$50,000-$100,000",
                "All the above", "English");
        brokerViews.assertURL(TestData.kapitalRSUrl);
        brokerViews.checkRegulation();
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.checkCustomTag("Dummy");
        brokerViews.takeScreenshot("Custom Tag - Dummy with - mark - Broker Views", crmPage.customTag);
    }

    @Test(description = "Verify the custom tag field in the CRM contains Invalid value")
    public void invalidLeadRegistration() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.brokereviews.com/lps/pro-dark-nob-kp/en?fts=age-annual-saving-knowledge-plang:all&ftsquery=age(1)-" +
                "or-[saving-equals(1,2,3)-and-knowledge-notequals(5)]");
        brokerViews.successfullyRegistration("Testq", "Testa", email, "Serbia",
                TestData.phoneNumberGenerator(), "45-54", "$15,000-$50,000", "$100,000-$250,000",
                "None", "English");
        brokerViews.assertURL(TestData.kapitalRSUrl);
        brokerViews.checkRegulation();
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.checkCustomTag("Invalid");
        brokerViews.takeScreenshot("Custom Tag - Invalid - Broker Views", crmPage.customTag);
    }

    @Test(description = "Verify the custom tag field in the CRM contains Invalid value")
    public void invalid_Lead_Registration() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.brokereviews.com/lps/pro-dark-nob-kp/en?fts=age-annual-saving-knowledge-plang:all&ftsquery=age(1)-" +
                "or-[saving-equals(1_2_3)-and-knowledge-notequals(5)]");
        brokerViews.successfullyRegistration("Testq", "Testa", email, "Serbia",
                TestData.phoneNumberGenerator(), "45-54", "$15,000-$50,000", "$100,000-$250,000",
                "None", "English");
        brokerViews.assertURL(TestData.kapitalRSUrl);
        brokerViews.checkRegulation();
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.checkCustomTag("Invalid");
        brokerViews.takeScreenshot("Custom Tag - Invalid with-mark - Broker Views", crmPage.customTag);
    }

    @Test(description = "Verify the custom tag field in the CRM is empty")
    public void emptyLeadRegistration() throws InterruptedException, IOException, AWTException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.brokereviews.com/lps/pro-dark-nob-kp/en?fts=age-annual-saving-knowledge-plang:all&ftsquery=age-" +
                "equals(1,3)-or-[saving-equals(1,2,3)-and-knowledge-notequals(5)]");
        brokerViews.successfullyRegistration("Testq", "Testa", email, "Serbia",
                TestData.phoneNumberGenerator(), "45-54", "$15,000-$50,000", "$100,000-$250,000",
                "All the above", "English");
        brokerViews.assertURL(TestData.kapitalRSUrl);
        brokerViews.checkRegulation();
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.checkCustomTag("");
        Thread.sleep(2500);
        brokerViews.takeScreenshot("Custom Tag - Empty - Broker Views", crmPage.customTag);
    }

    @Test(description = "Verify the custom tag field in the CRM is empty")
    public void empty_Lead_Registration() throws InterruptedException, IOException, AWTException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.brokereviews.com/lps/pro-dark-nob-kp/en?fts=age-annual-saving-knowledge-plang:all&ftsquery=age-" +
                "equals(1_3)-or-[saving-equals(1_2_3)-and-knowledge-notequals(5)]");
        brokerViews.successfullyRegistration("Testq", "Testa", email, "Serbia",
                TestData.phoneNumberGenerator(), "45-54", "$15,000-$50,000", "$100,000-$250,000",
                "All the above", "English");
        brokerViews.assertURL(TestData.kapitalRSUrl);
        brokerViews.checkRegulation();
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.checkCustomTag("");
        Thread.sleep(2500);
        brokerViews.takeScreenshot("Custom Tag - Empty with - mark - Broker Views", crmPage.customTag);
    }

    @Test(description = "Verify an error message for check box")
    public void checkBoxErrorMessage () throws IOException, AWTException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.brokereviews.com/lps/pro-dark-nob-kp/en");
        brokerViews.uncheckCheckBox("Testq","Testa",email,
                "Serbia",TestData.phoneNumberGenerator());
        Assert.assertEquals(brokerViews.getText(brokerViews.errorMessageCheckBox, "check box error message"), "Please check this box to proceed.");
        brokerViews.takeScreenshot("Check box - error message - Borker Views", brokerViews.errorMessageCheckBox);
    }

    @Test(description = "Verify that the Language field in the CRM contains expected value")
    public void verifyLanguageField() throws IOException, AWTException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.brokereviews.com/lps/pro-dark-nob-kp/en?fts=age-annual-saving-knowledge-plang:all&userLang=en");
        brokerViews.successfullyRegistration("Testq","Testa",email,"Serbia",TestData.phoneNumberGenerator(),
                "25-34", "$15,000-$50,000", "$50,000-$100,000", "All the above", "English");
        brokerViews.assertURL(TestData.kapitalRSUrl);
        crmPage.checkCrmData(email,"Testq Testa", "FSC");
        crmPage.checkLanguageInCrm("en");
        brokerViews.takeScreenshot("Language field ",crmPage.language);
    }

    @Test(description = "Verify that the Language field in the CRM contains the default value (the language of the base " +
            "page URL) when we enter the wrong language in the userLang parameter")
    public void verifyLanguage() throws IOException, AWTException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.brokereviews.com/lps/pro-dark-nob-kp/en?fts=age-annual-saving-knowledge-plang:all&userLang=he");
        brokerViews.successfullyRegistration("Testq","Testa",email, "Serbia",TestData.phoneNumberGenerator(),
                "25-34", "$15,000-$50,000", "$50,000-$100,000", "All the above", "English");
        brokerViews.assertURL(TestData.kapitalRSUrl);
        crmPage.checkCrmData(email,"Testq Testa", "FSC");
        crmPage.checkLanguageInCrm("en");
        brokerViews.takeScreenshot("Language field - default language ",crmPage.language);
    }
}
