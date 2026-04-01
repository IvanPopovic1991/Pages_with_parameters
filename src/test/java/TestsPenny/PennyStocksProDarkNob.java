package TestsPenny;

import Pages.CrmPage;
import Pages.PennyStocks;
import Pages.YopMail;
import faker.TestData;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class PennyStocksProDarkNob extends BaseTestPenny{

    PennyStocks pennyStocks;
    CrmPage crmPage;

    @BeforeMethod
    public void setUp(){
        baseSetUp("Chrome","146");
        pennyStocks = new PennyStocks(driver);
        crmPage = new CrmPage(driver);
    }

    @AfterMethod
    public void tearDown(){
        baseTearDown();
    }

    @Test(description = "Verify demo account registration")
    public void demoAccountRegistration() throws IOException, AWTException, InterruptedException {
        pennyStocks.successfullyRegistration("Testq", "Testa", TestData.emailGenerator(),
                "Serbia", TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000",
                "$50,000-$100,000", "Yes, from a relevant role in financial services", "English");
        pennyStocks.checkRegulation();
        pennyStocks.takeScreenshot("Successfully demo account registration - Penny Stocks",pennyStocks.regulationMsg);
    }

    @Test(description = "Verify the marketing tags in CRM")
    public void checkingTagsInTheCrm() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.pennystocks-uk.com/lps/pro-dark-nob/en?fts=age-annual-saving-knowledge-plang:all&tg=ivanA" +
                "1434&tag1=ivanB@1434&tag2=ivanL1434&tag3=ivanM1434&gid=ivanC@1434&G_GEO=ivanD1434&G_GEOint=ivanE1434&G_" +
                "Device=ivanF1434&G_DeviceModel=ivanG1434&G_AdPos=ivanH1434&g_Track=ivanI1434&Track=ivanj1434&gclid=ivanK1434");
        pennyStocks.successfullyRegistration("Testq", "Testa", email,
                "Serbia", TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000",
                "$50,000-$100,000", "Yes, from a relevant role in financial services", "English");
        pennyStocks.checkRegulation();
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.takeScreenshot("Account details Penny Stocks page", crmPage.accFullNameCrm);
        crmPage.checkCrmTags();
        crmPage.takeScreenshot("Marketing tags Penny Stocks page");
    }

    @Test(description = "Verify that the Custom tag in the CRM is empty")
    public void checkingCustomTag() throws InterruptedException, IOException, AWTException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.pennystocks-uk.com/lps/pro-dark-nob/en?fts=age-annual-saving-knowledge-plang:all");
        pennyStocks.successfullyRegistration("Testq", "Testa", email, "Serbia",
                TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000",
                "$50,000-$100,000", "Yes, from a relevant role in financial services", "English");
        pennyStocks.checkRegulation();
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.checkCustomTag("");
        crmPage.takeScreenshot("Custom tag field value is empty - Penny Stocks", crmPage.customTag);
    }

    @Test(description = "Verify the account is registered successfully with NON-valid tag in the URL")
    public void checkingNonValidParameter() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.pennystocks-uk.com/lps/pro-dark-nob/en?fts=testq-testa");
        pennyStocks.registerAccount1Step("Testq","Testa",email,
                "Serbia",TestData.phoneNumberGenerator());
        pennyStocks.checkRegulation();
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.checkUtmContent("testq-testa");
        pennyStocks.takeScreenshot("Demo account registration - non valid tag - utm content- Penny Stocks");
    }

    @Test(description = "Verify the age value is displayed correctly in the Link ID field in the CRM")
    public void checkingAgeParameter() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.pennystocks-uk.com/lps/pro-dark-nob/en?fts=age");
        pennyStocks.ageParameter("Testq", "Testa", email, "Serbia", TestData.phoneNumberGenerator(),
                "25-34");
        pennyStocks.checkRegulation();
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.checkSMSVerification("--");
        crmPage.takeScreenshot("SMS Verification field Age parameter - no value", crmPage.smsVerification);
        crmPage.checkLinkIdValue("PC_windows,25_34_age");
        Thread.sleep(1000);
        crmPage.takeScreenshot("Age parameter value - Penny Stocks", crmPage.linkId);
    }

    @Test(description = "Verify the annual value is displayed correctly in the Link ID field in the CRM")
    public void checkingAnnualParameter() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.pennystocks-uk.com/lps/pro-dark-nob/en?fts=annual");
        pennyStocks.annualParameter("Testq", "Testa", email, "Serbia", TestData.phoneNumberGenerator(),
                "$15,000-$50,000");
        pennyStocks.checkRegulation();
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.checkSMSVerification("--");
        crmPage.takeScreenshot("SMS Verification field Annual parameter - no value", crmPage.smsVerification);
        crmPage.checkLinkIdValue("PC_windows,15000_50000_annual");
        Thread.sleep(1000);
        crmPage.takeScreenshot("Annual parameter value - Penny Stocks", crmPage.linkId);
    }

    @Test(description = "Verify the saving value is displayed correctly in the Link ID field in the CRM")
    public void checkingSavingParameter() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.pennystocks-uk.com/lps/pro-dark-nob/en?fts=saving");
        pennyStocks.savingParameter("Testq", "Testa", email, "Serbia", TestData.phoneNumberGenerator(),
                "$50,000-$100,000");
        pennyStocks.checkRegulation();
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.checkSMSVerification("--");
        crmPage.takeScreenshot("SMS Verification field Saving parameter - no value", crmPage.smsVerification);
        crmPage.checkLinkIdValue("PC_windows,50000_100000_savings");
        Thread.sleep(1000);
        crmPage.takeScreenshot("Saving parameter value - Penny Stocks", crmPage.linkId);
    }

    @Test(description = "Verify the knowledge of trading value is displayed correctly in the Link ID field in the CRM")
    public void checkingKnowledgeParameter() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.pennystocks-uk.com/lps/pro-dark-nob/en?fts=knowledge");
        pennyStocks.knowledgeParameter("Testq", "Testa", email, "Serbia", TestData.phoneNumberGenerator(),
                "All the above");
        pennyStocks.checkRegulation();
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.checkSMSVerification("--");
        crmPage.takeScreenshot("SMS Verification field Knowledge parameter - no value", crmPage.smsVerification);
        crmPage.checkLinkIdValue("PC_windows,knowledge_of_trading_all_the_above");
        Thread.sleep(1000);
        crmPage.takeScreenshot("Knowledge parameter value - Penny Stocks", crmPage.linkId);
    }

    @Test(description = "Verify the desired communication language value is displayed correctly in the Link ID field in the CRM")
    public void checkLanguageParameter() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.pennystocks-uk.com/lps/pro-dark-nob/en?fts=plang:srcs,all");
        pennyStocks.languageParameter("Testq", "Testa", email, "Serbia",
                TestData.phoneNumberGenerator(), "English");
        pennyStocks.checkRegulation();
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.checkLinkIdValue("PC_windows,lang_EN");
        crmPage.takeScreenshot("Desired communication language - Penny Stocks", crmPage.linkId);
    }

    @Test(description = "Verify that wrong code cannot be submitted")
    public void assertInvalidTokenMsg() throws IOException, AWTException, InterruptedException {
        driver.get("https://dlp.pennystocks-uk.com/lps/pro-dark-nob/en?fts=sms-age-annual-saving-knowledge-plang:all");
        pennyStocks.unsuccessfullyRegistrationWrongSMS("Testq", "Testa", TestData.emailGenerator(), "Serbia",
                TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000", "$50,000-$100,000", "All the above",
                "English","1", "1", "1", "1");
        Thread.sleep(500);
        Assert.assertEquals(pennyStocks.incorrectTokenMsg.getText(), "Incorrect Code. Please check and try again.");
        pennyStocks.takeScreenshot("Incorrect code - Please check and try again - Penny Stocks");
    }

    @Test(description = "Verify that message We sent you the code again is received")
    public void didNotGetToken() throws IOException, AWTException, InterruptedException {
        driver.get("https://dlp.pennystocks-uk.com/lps/pro-dark-nob/en?fts=sms-age-annual-saving-knowledge");
        pennyStocks.tokenIsNotReceived("Testq", "Testa", TestData.emailGenerator(), "Serbia",
                TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000", "$50,000-$100,000", "All the above");
        Assert.assertEquals(pennyStocks.codeIsSent.getText(), "We sent you the code again");
        Thread.sleep(2000);
        if (pennyStocks.codeIsSent.isDisplayed()) {
            pennyStocks.takeScreenshot("We sent you the code again - Penny Stocks", pennyStocks.codeIsSent);
        }
    }

    @Test(description = "Verify if user clicks pencil icon the same is returned to the 1st widget")
    public void userIsReturnedTo1stWidget() throws IOException, AWTException {
        driver.get("https://dlp.pennystocks-uk.com/lps/pro-dark-nob/en?fts=sms-age-annual-saving-knowledge");
        pennyStocks.enterFirstName("Testq");
        pennyStocks.enterLastName("Testa");
        pennyStocks.enterEmail(TestData.emailGenerator());
        pennyStocks.handleCountryCode("Serbia");
        pennyStocks.enterPhoneNumber(TestData.phoneNumberGenerator());
        pennyStocks.clickOnSubmitBtn();
        pennyStocks.selectAge("75+");
        pennyStocks.clickEditTokenBtn();
        if (pennyStocks.phoneNumber.isDisplayed()) {
            pennyStocks.takeScreenshot("The user is returned to the 1st form widget - Penny Stocks", pennyStocks.phoneNumber);
        }
    }

    @Test(description = "Verify the demo account is not registered successfully with invalid data")
    public void unsuccessfullyDemoAccountRegistration() throws IOException, AWTException {
        pennyStocks.unsuccessfullyRegistrationWrongData("123", "456", "345342=--=/.,><",
                "123456", "1234567890123456");
        pennyStocks.assertErrorMessages();
        //pennyStocks.assertColor("red");
        pennyStocks.takeScreenshot("Unsuccessfully demo account registration - Penny Stocks", pennyStocks.submitBtn);
    }

    @Test(description = "Verify the demo account is not registered successfully with empty fields")
    public void emptyDemoAccountRegistration() throws IOException, AWTException {
        pennyStocks.unsuccessfullyRegistrationWrongData("", "", "", "", "");
        pennyStocks.assertErrorMessages();
        //pennyStocks.assertColor("red");
        pennyStocks.takeScreenshot("Demo account registration - no data - Penny Stocks", pennyStocks.submitBtn);
    }

    @Test(description = "Verify that the already registered email address cannot be register")
    public void alreadyRegisteredAccountEmail() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        pennyStocks.successfullyRegistration("Testq", "Testa", email,
                "Serbia", TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000",
                "$50,000-$100,000", "All the above", "English");
        pennyStocks.checkRegulation();
        driver.get("https://dlp.pennystocks-uk.com/lps/pro-dark-nob/en?fts=age-annual-saving-knowledge-plang:all");
        pennyStocks.alreadyRegisteredAccount("Testq", "Testa", email, "Serbia", TestData.phoneNumberGenerator());
        pennyStocks.assertPopUpForAlreadyRegisteredAccount();
        pennyStocks.takeScreenshot("Already registered email address - Penny Stocks",pennyStocks.alrdRegEmailMsg);
    }

    @Test(description = "Verify that the account cannot be registered with already registered phone number")
    public void anAlreadyRegisteredPhone() throws IOException, AWTException, InterruptedException {
        String phoneNumber = TestData.phoneNumberGenerator();
        pennyStocks.successfullyRegistration("Testq", "Testa", TestData.emailGenerator(), "Serbia",
                phoneNumber, "25-34", "$15,000-$50,000", "$50,000-$100,000",
                "All the above", "English");
        pennyStocks.checkRegulation();
        driver.get("https://dlp.pennystocks-uk.com/lps/pro-dark-nob/en?fts=age-annual-saving-knowledge-plang:all");
        pennyStocks.alreadyRegisteredAccount("Testq", "Testa", TestData.emailGenerator(),
                "Serbia", phoneNumber);
        pennyStocks.assertPopUpForAlreadyRegisteredAccount();
        pennyStocks.takeScreenshot("Already registered phone number - Penny Stocks");
    }

    @Test(description = "Verify that the account cannot be registered with already registered email address and phone number")
    public void anAlreadyRegisteredEmailAndPhone() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        String phoneNumber = TestData.phoneNumberGenerator();
        pennyStocks.successfullyRegistration("Testq", "Testa", email, "Serbia", phoneNumber, "25-34", "$15,000-$50,000", "$50,000-$100,000", "All the above", "English");
        pennyStocks.checkRegulation();
        driver.get("https://dlp.pennystocks-uk.com/lps/pro-dark-nob/en?fts=age-annual-saving-knowledge-plang:all");
        pennyStocks.alreadyRegisteredAccount("Testq", "Testa", email,
                "Serbia", phoneNumber);
        pennyStocks.assertPopUpForAlreadyRegisteredAccount();
        pennyStocks.takeScreenshot("Already registered email and phone - Penny Stocks");
    }

    @Test(description = "Verify that the First Name cannot be the same as Last Name")
    public void sameFNameAndLName() throws IOException, AWTException {
        pennyStocks.enterFirstName("Testq");
        pennyStocks.enterLastName("Testq");
        pennyStocks.clickElement(pennyStocks.firstName, "on first name field");
        pennyStocks.clickElement(pennyStocks.lastName, "on last name field");
        pennyStocks.assertSameNameErrorMsgs();
        pennyStocks.takeScreenshot("Error messages for the same first and last name - Penny Stocks");
    }

    @Test(description = "Verify the logo is not clickable with left click")
    public void checkingForLogoClickability() throws IOException, AWTException {
        pennyStocks.checkLogoClickability("https://dlp.pennystocks-uk.com/lps/pro-dark-nob/en?fts=age-annual-saving-knowledge");
        pennyStocks.takeScreenshot("Logo is not clickable - Penny Stocks");
    }

    @Test(description = "Verify that the invalid data for Country Code field will show valid error message with red border")
    public void checkForCountryCodeErrorMessage() throws IOException, AWTException {
        pennyStocks.checkCountryCodeErrorMessage("01852833kdkd");
        pennyStocks.takeScreenshot("Country code error message - Penny Stocks", pennyStocks.firstName);
    }

    @Test(description = "Verify the email is sent on the new account email")
    public void emailIsReceivedSuccessfully() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        pennyStocks.successfullyRegistration("Testq", "Testa", email,
                "Serbia", TestData.phoneNumberGenerator(), "25-34", "$50,000-$100,000",
                "$50,000-$100,000", "All the above", "English");
        pennyStocks.checkRegulation();
        driver.get("https://yopmail.com/en/");
        YopMail yopMail = new YopMail(driver);
        yopMail.findEmail(email);
        yopMail.zoomOutMethod();
        yopMail.takeScreenshot("Email is received successfully - Penny Stocks", yopMail.emailTitle);
    }

    @Test(description = "Verify the Privacy Policy link works with left/right click")
    public void privacyPolicyTest() throws IOException, AWTException, InterruptedException {
        Thread.sleep(2000);
        pennyStocks.clickOnSelectedLink(pennyStocks.privacyPolicyLinkBy, pennyStocks.privacyPolicyUrl,
                "Privacy policy");
        pennyStocks.rightClickOnSelectedLink(pennyStocks.privacyPolicyLinkBy, pennyStocks.privacyPolicyUrl);
    }

    @Test(description = "Verify the Terms and Conditions link works with left/right click")
    public void termsAndConditionsTest() throws IOException, AWTException, InterruptedException {
        Thread.sleep(2000);
        pennyStocks.clickOnSelectedLink(pennyStocks.termsAndConditionsLinkBy, pennyStocks.termsAndConditionsUrl,
                "Terms and conditions");
        pennyStocks.rightClickOnSelectedLink(pennyStocks.termsAndConditionsLinkBy, pennyStocks.termsAndConditionsUrl);
    }

    @Test(description = "Verify the click here link works with left/right click")
    public void howToUnsubscribeTest() throws IOException, AWTException, InterruptedException {
        Thread.sleep(2000);
        pennyStocks.clickOnSelectedLink(pennyStocks.clickHereLink, pennyStocks.howToUnsubscribeURL,
                "How to unsubscribe");
        pennyStocks.rightClickOnSelectedLink(pennyStocks.clickHereLink, pennyStocks.howToUnsubscribeURL);
    }

    @Test(description = "Verify the Already have an account? link with left click redirects user to the login page")
    public void loginRedirectionTest() throws IOException, AWTException, InterruptedException {
        pennyStocks.scrollToAnElement(pennyStocks.alreadyHaveAnAccount);
        pennyStocks.loginRedirection();
        Thread.sleep(2500);
        pennyStocks.assertURL(pennyStocks.alrHaveAccountUrl);
        pennyStocks.takeScreenshot("Login page - the user is successfully redirected - Penny Stocks");
    }

    @Test(description = "Verify the 2nd step - age verification window cannot be submitted if it's not completed")
    public void errorMessageAgeParameter() throws IOException, AWTException, InterruptedException {
        driver.get("https://dlp.pennystocks-uk.com/lps/pro-dark-nob/en?fts=age");
        pennyStocks.ageParameter("Testq", "Testa", TestData.emailGenerator(), "Serbia", TestData.phoneNumberGenerator(),
                "-- Select --");
        pennyStocks.secondStepErrorMessage(1);
        pennyStocks.takeScreenshot("Age parameter error message - Penny Stocks");
    }

    @Test(description = "Verify the 2nd step - annual income verification window cannot be submitted if it's not completed")
    public void errorMessageAnnualParameter() throws IOException, AWTException, InterruptedException {
        driver.get("https://dlp.pennystocks-uk.com/lps/pro-dark-nob/en?fts=annual");
        pennyStocks.annualParameter("Testq", "Testa", TestData.emailGenerator(), "Serbia", TestData.phoneNumberGenerator(),
                "-- Select --");
        pennyStocks.secondStepErrorMessage(1);
        pennyStocks.takeScreenshot("Annual parameter error message - Penny Stocks");
    }

    @Test(description = "Verify the 2nd step - value of saving and investments verification window cannot be submitted if it's not completed")
    public void errorMessageSavingParameter() throws IOException, AWTException, InterruptedException {
        driver.get("https://dlp.pennystocks-uk.com/lps/pro-dark-nob/en?fts=saving");
        pennyStocks.savingParameter("Testq", "Testa", TestData.emailGenerator(), "Serbia", TestData.phoneNumberGenerator(),
                "-- Select --");
        pennyStocks.secondStepErrorMessage(1);
        pennyStocks.takeScreenshot("Saving parameter error message - Penny Stocks");
    }

    @Test(description = "Verify the 2nd step - knowledge of trading verification window cannot be submitted if it's not completed")
    public void errorMessageKnowledgeParameter() throws IOException, AWTException, InterruptedException {
        driver.get("https://dlp.pennystocks-uk.com/lps/pro-dark-nob/en?fts=knowledge");
        pennyStocks.knowledgeParameter("Testq", "Testa", TestData.emailGenerator(), "Serbia", TestData.phoneNumberGenerator(),
                "-- Select --");
        pennyStocks.secondStepErrorMessage(1);
        pennyStocks.takeScreenshot("Knowledge parameter error message - Penny Stocks");
    }

    @Test(description = "Verify the 2nd step - desired communication language verification window cannot be submitted if it's not completed ")
    public void errorLanguageParameter() throws IOException, AWTException, InterruptedException {
        driver.get("https://dlp.pennystocks-uk.com/lps/pro-dark-nob/en?fts=plang:srcs,all");
        pennyStocks.languageParameter("Testq", "Testa", TestData.emailGenerator(), "Serbia",
                TestData.phoneNumberGenerator(), "-- Select --");
        pennyStocks.assertBorderColor(pennyStocks.languageField);
        pennyStocks.secondStepErrorMessage(1);
        pennyStocks.takeScreenshot("Desired communication language - error - Penny Stocks", pennyStocks.languageField);
    }

    @Test(description = "Verify the 2nd step cannot be submitted if all parameter values are not completed ")
    public void errorMessagesAllParameters() throws IOException, AWTException, InterruptedException {
        pennyStocks.unsuccessfullyRegistration("Testq", "Testa", TestData.emailGenerator(), "Serbia", TestData.phoneNumberGenerator(),
                "25-34", "$15,000-$50,000", "$50,000-$100,000", "All the above","English",
                "-- Select --", "-- Select --", "-- Select --", "-- Select --","-- Select --");
        pennyStocks.secondStepErrorMessage(5);
        pennyStocks.takeScreenshot("All parameters error message - Penny Stocks");
    }

    @Test(description = "Verify the custom tag field in the CRM contains Dummy value")
    public void dummyLeadRegistration() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.pennystocks-uk.com/lps/pro-dark-nob/en?fts=annual-saving-knowledge-age-plang:all&" +
                "ftsquery=age-equals(1,3)-or-[saving-equals(1,2,3)-and-knowledge-notequals(5)]");
        pennyStocks.successfullyRegistration("Testq", "Testa", email, "Serbia",
                TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000", "$50,000-$100,000",
                "All the above", "English");
        pennyStocks.checkRegulation();
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.checkCustomTag("Dummy");
        pennyStocks.takeScreenshot("Custom Tag - Dummy - Penny Stocks", crmPage.customTag);
    }

    @Test(description = "Verify the custom tag field in the CRM contains Dummy value")
    public void dummy_Lead_Registration() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.pennystocks-uk.com/lps/pro-dark-nob/en?fts=annual-saving-knowledge-age-plang:all&" +
                "ftsquery=age-equals(1_3)-or-[saving-equals(1_2_3)-and-knowledge-notequals(5)]");
        pennyStocks.successfullyRegistration("Testq", "Testa", email, "Serbia",
                TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000", "$50,000-$100,000",
                "All the above", "English");
        pennyStocks.checkRegulation();
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.checkCustomTag("Dummy");
        pennyStocks.takeScreenshot("Custom Tag - Dummy with - mark - Penny Stocks", crmPage.customTag);
    }

    @Test(description = "Verify the custom tag field in the CRM contains Invalid value")
    public void invalidLeadRegistration() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.pennystocks-uk.com/lps/pro-dark-nob/en?fts=age-annual-saving-knowledge-plang:all&ftsquery=age(1)-" +
                "or-[saving-equals(1,2,3)-and-knowledge-notequals(5)]");
        pennyStocks.successfullyRegistration("Testq", "Testa", email, "Serbia",
                TestData.phoneNumberGenerator(), "45-54", "$15,000-$50,000", "$100,000-$250,000",
                "None", "English");
        pennyStocks.checkRegulation();
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.checkCustomTag("Invalid");
        pennyStocks.takeScreenshot("Custom Tag - Invalid - Penny Stocks", crmPage.customTag);
    }

    @Test(description = "Verify the custom tag field in the CRM contains Invalid value")
    public void invalid_Lead_Registration() throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.pennystocks-uk.com/lps/pro-dark-nob/en?fts=age-annual-saving-knowledge-plang:all&ftsquery=age(1)-" +
                "or-[saving-equals(1_2_3)-and-knowledge-notequals(5)]");
        pennyStocks.successfullyRegistration("Testq", "Testa", email, "Serbia",
                TestData.phoneNumberGenerator(), "45-54", "$15,000-$50,000", "$100,000-$250,000",
                "None", "English");
        pennyStocks.checkRegulation();
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.checkCustomTag("Invalid");
        pennyStocks.takeScreenshot("Custom Tag - Invalid with-mark - Penny Stocks", crmPage.customTag);
    }

    @Test(description = "Verify the custom tag field in the CRM is empty")
    public void emptyLeadRegistration() throws InterruptedException, IOException, AWTException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.pennystocks-uk.com/lps/pro-dark-nob/en?fts=age-annual-saving-knowledge-plang:all&ftsquery=age-" +
                "equals(1,3)-or-[saving-equals(1,2,3)-and-knowledge-notequals(5)]");
        pennyStocks.successfullyRegistration("Testq", "Testa", email, "Serbia",
                TestData.phoneNumberGenerator(), "45-54", "$15,000-$50,000", "$100,000-$250,000",
                "All the above", "English");
        pennyStocks.checkRegulation();
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.checkCustomTag("");
        Thread.sleep(2500);
        pennyStocks.takeScreenshot("Custom Tag - Empty - Penny Stocks", crmPage.customTag);
    }

    @Test(description = "Verify the custom tag field in the CRM is empty")
    public void empty_Lead_Registration() throws InterruptedException, IOException, AWTException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.pennystocks-uk.com/lps/pro-dark-nob/en?fts=age-annual-saving-knowledge-plang:all&ftsquery=age-" +
                "equals(1_3)-or-[saving-equals(1_2_3)-and-knowledge-notequals(5)]");
        pennyStocks.successfullyRegistration("Testq", "Testa", email, "Serbia",
                TestData.phoneNumberGenerator(), "45-54", "$15,000-$50,000", "$100,000-$250,000",
                "All the above", "English");
        pennyStocks.checkRegulation();
        crmPage.checkCrmData(email, "Testq Testa", "FSC");
        crmPage.checkCustomTag("");
        Thread.sleep(2500);
        pennyStocks.takeScreenshot("Custom Tag - Empty with - mark - Penny Stocks", crmPage.customTag);
    }

    @Test(description = "Verify an error message for check box")
    public void checkBoxErrorMessage () throws IOException, AWTException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.pennystocks-uk.com/lps/pro-dark-nob/en");
        pennyStocks.uncheckCheckBox("Testq","Testa",email,
                "Serbia",TestData.phoneNumberGenerator());
        Assert.assertEquals(pennyStocks.getText(pennyStocks.errorMessageCheckBox, "check box error message"), "Please check this box to proceed.");
        pennyStocks.takeScreenshot("Check box - error message - Penny Stocks", pennyStocks.errorMessageCheckBox);
    }

    @Test(description = "Verify that the Language field in the CRM contains expected value")
    public void verifyLanguageField() throws IOException, AWTException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.pennystocks-uk.com/lps/pro-dark-nob/en?fts=age-annual-saving-knowledge-plang:all&userLang=en");
        pennyStocks.successfullyRegistration("Testq","Testa",email,"Serbia",TestData.phoneNumberGenerator(),
                "25-34", "$15,000-$50,000", "$50,000-$100,000", "All the above", "English");
        pennyStocks.assertURL(TestData.fortradeUrl);
        crmPage.checkCrmData(email,"Testq Testa", "FSC");
        crmPage.checkLanguageInCrm("en");
        pennyStocks.takeScreenshot("Language field ",crmPage.language);
    }

    @Test(description = "Verify that the Language field in the CRM contains the default value (the language of the base " +
            "page URL) when we enter the wrong language in the userLang parameter")
    public void verifyLanguage() throws IOException, AWTException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.pennystocks-uk.com/lps/pro-dark-nob/en?fts=age-annual-saving-knowledge-plang:all&userLang=he");
        pennyStocks.successfullyRegistration("Testq","Testa",email, "Serbia",TestData.phoneNumberGenerator(),
                "25-34", "$15,000-$50,000", "$50,000-$100,000", "All the above", "English");
        pennyStocks.assertURL(TestData.fortradeUrl);
        crmPage.checkCrmData(email,"Testq Testa", "FSC");
        crmPage.checkLanguageInCrm("en");
        pennyStocks.takeScreenshot("Language field - default language ",crmPage.language);
    }
}
