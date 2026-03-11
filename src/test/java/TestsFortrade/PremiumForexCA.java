package TestsFortrade;

import Pages.BasePage;
import Pages.CrmPage;
import Pages.FortradePage;
import Pages.YopMail;
import faker.TestData;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class PremiumForexCA extends BaseTestFortrade {

    FortradePage fortradePage;
    CrmPage crmPage;

    @BeforeMethod
    public void setUp() {
        baseSetup("Chrome", "146");
        fortradePage = new FortradePage(driver);
        crmPage = new CrmPage(driver);
        driver.get("https://dlp.fortrade.com/lps/premium-forex-landing-ephone-ca/en?fts=age-annual-saving-knowledge");
     }

    @AfterMethod
    public void tearDown() {
        baseTearDown();
    }

    @Test(description = "Verify demo account registration")
    @Description("User should successfully register demo account")
    @Parameters({"countryCode","regulation"})
    public void demoAccountRegistration(String countryCode,String regulation) throws IOException, AWTException, InterruptedException {
        fortradePage.successfullyRegistration("Testq", "Testa", TestData.emailGenerator(),countryCode,
                TestData.canadaPhoneNumber(),"25-34", "$15,000-$50,000", "$50,000-$100,000", "All the above");
        if (regulation.equalsIgnoreCase("Iiroc")) {
            fortradePage.assertURL("https://ready.fortrade.com/");
        }
        fortradePage.clickUsePassBtn();
        fortradePage.clickMenuBtn();
        fortradePage.checkRegulation(regulation);
    }

    @Test(description = "Verify the marketing tags in CRM")
    @Parameters({"countryCode","regulation"})
    public void checkingTagsInTheCrm(String countryCode, String regulation) throws IOException, AWTException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.fortrade.com/lps/premium-forex-landing-ephone-ca/en?fts=age-annual-saving-knowledge&tg=ivanA" +
                "1434&tag1=ivanB@1434&tag2=ivanL1434&tag3=ivanM1434&gid=ivanC@1434&G_GEO=ivanD1434&G_GEOint=ivanE1434&G_" +
                "Device=ivanF1434&G_DeviceModel=ivanG1434&G_AdPos=ivanH1434&g_Track=ivanI1434&Track=ivanj1434&gclid=ivanK1434");
        fortradePage.successfullyRegistration("Testq", "Testa", email,countryCode,TestData.canadaPhoneNumber(),
                "25-34", "$15,000-$50,000", "$50,000-$100,000", "All the above");
        fortradePage.assertURL("https://ready.fortrade.com/");
        fortradePage.clickUsePassBtn();
        fortradePage.clickMenuBtn();
        fortradePage.checkRegulation(regulation);
        crmPage.checkCrmData(email, "Testq Testa", regulation);
        crmPage.takeScreenshot("Account details Fortrade page " + regulation, crmPage.accFullNameCrm);
        crmPage.takeScreenshot("SMS Verification field - no value " + regulation, crmPage.smsVerification);
        crmPage.checkSMSVerification("--");
        crmPage.takeScreenshot("SMS Verification field without sms parameter - no value " + regulation, crmPage.smsVerification);
        crmPage.checkCrmTags();
        crmPage.takeScreenshot("Marketing tags Fortrade page " + regulation, crmPage.accFullNameCrm);
    }

    @Test(description = "Verify the age value is displayed correctly in the Link ID field in the CRM")
    @Parameters({"tag", "countryCode", "regulation"})
    public void checkingAgeParameter(String tag, String countryCode, String regulation) throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.fortrade.com/lps/premium-forex-landing-ephone-ca/en?fts=age" + tag);
        fortradePage.ageParameter("Testq", "Testa", email, countryCode, TestData.canadaPhoneNumber(),
                "25-34");
        fortradePage.assertURL("https://ready.fortrade.com/");
        crmPage.checkCrmData(email, "Testq Testa", regulation);
        crmPage.checkSMSVerification("--");
        crmPage.takeScreenshot("SMS Verification field Age parameter - no value " + regulation, crmPage.smsVerification);
        crmPage.checkLinkIdValue("PC_windows,25_34_age");
        Thread.sleep(1000);
        crmPage.takeScreenshot("Age parameter value " + regulation, crmPage.linkId);
    }

    @Test(description = "Verify the annual value is displayed correctly in the Link ID field in the CRM")
    @Parameters({"tag", "countryCode", "regulation"})
    public void checkingAnnualParameter(String tag, String countryCode, String regulation) throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.fortrade.com/lps/premium-forex-landing-ephone-ca/en?fts=annual" + tag);
        fortradePage.annualParameter("Testq", "Testa", email, countryCode, TestData.canadaPhoneNumber(),
                "$15,000-$50,000");
        fortradePage.assertURL("https://ready.fortrade.com/");
        crmPage.checkCrmData(email, "Testq Testa", regulation);
        crmPage.checkSMSVerification("--");
        crmPage.takeScreenshot("SMS Verification field Annual parameter - no value " + regulation, crmPage.smsVerification);
        crmPage.checkLinkIdValue("PC_windows,15000_50000_annual");
        Thread.sleep(1000);
        crmPage.takeScreenshot("Annual parameter value " + regulation, crmPage.linkId);
    }

    @Test(description = "Verify the saving value is displayed correctly in the Link ID field in the CRM")
    @Parameters({"tag", "countryCode", "regulation"})
    public void checkingSavingParameter(String tag, String countryCode, String regulation) throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.fortrade.com/lps/premium-forex-landing-ephone-ca/en?fts=saving" + tag);
        fortradePage.savingParameter("Testq", "Testa", email, countryCode, TestData.canadaPhoneNumber(),
                "$50,000-$100,000");
 /*       if (regulation.equalsIgnoreCase("Asic")) {
            fortradePage.assertURL("https://ready.fortrade.com/#asicupdateacceptcalls");
            fortradePage.clickConsentBtn();
        } else if (regulation.equalsIgnoreCase("Iiroc")) {
            fortradePage.assertURL("https://ready.fortrade.com/#enhancedcustomerconsent");
        } else {
            fortradePage.assertURL("https://ready.fortrade.com/#chartticket");
        }*/
        fortradePage.assertURL("https://ready.fortrade.com/");
        crmPage.checkCrmData(email, "Testq Testa", regulation);
        crmPage.checkSMSVerification("--");
        crmPage.takeScreenshot("SMS Verification field Saving parameter - no value " + regulation, crmPage.smsVerification);
        crmPage.checkLinkIdValue("PC_windows,50000_100000_savings");
        Thread.sleep(1000);
        crmPage.takeScreenshot("Saving parameter value " + regulation, crmPage.linkId);
    }

    @Test(description = "Verify the knowledge of trading value is displayed correctly in the Link ID field in the CRM")
    @Parameters({"tag", "countryCode", "regulation"})
    public void checkingKnowledgeParameter(String tag, String countryCode, String regulation) throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.fortrade.com/lps/premium-forex-landing-ephone-ca/en?fts=knowledge" + tag);
        fortradePage.knowledgeParameter("Testq", "Testa", email, countryCode, TestData.canadaPhoneNumber(),
                "All the above");
        /*if (regulation.equalsIgnoreCase("Asic")) {
            fortradePage.assertURL("https://ready.fortrade.com/#asicupdateacceptcalls");
            fortradePage.clickConsentBtn();
        } else if (regulation.equalsIgnoreCase("Iiroc")) {
            fortradePage.assertURL("https://ready.fortrade.com/#enhancedcustomerconsent");
        } else {
            fortradePage.assertURL("https://ready.fortrade.com/#chartticket");
        }*/
        fortradePage.assertURL("https://ready.fortrade.com/");
        crmPage.checkCrmData(email, "Testq Testa", regulation);
        crmPage.checkSMSVerification("--");
        crmPage.takeScreenshot("SMS Verification field Knowledge parameter - no value " + regulation, crmPage.smsVerification);
        crmPage.checkLinkIdValue("PC_windows,knowledge_of_trading_all_the_above");
        Thread.sleep(1000);
        crmPage.takeScreenshot("Knowledge parameter value " + regulation, crmPage.linkId);
    }

    @Test(description = "Verify the demo account is not registered successfully with invalid data")
    @Parameters({"countryCode","regulation"})
    public void unsuccessfullyDemoAccountRegistration(String countryCode,String regulation) throws IOException, AWTException {
        fortradePage.unsuccessfullyRegistrationWrongData("123", "574", "abcd134324", countryCode, "fjldjoijwe");
        fortradePage.assertErrorMessages();
        //fortradePage.assertColor("red");
        fortradePage.takeScreenshot("Unsuccessfully demo account registration " + regulation + " regulation", fortradePage.firstName);
    }

    @Test(description = "Verify that wrong code cannot be submitted")
    @Parameters({"tag", "countryCode", "regulation"})
    public void assertInvalidTokenMsg(String tag, String countryCode, String regulation) throws IOException, AWTException, InterruptedException {
        driver.get("https://dlp.fortrade.com/lps/premium-forex-landing-ephone-ca/en?fts=sms-age-annual-saving-knowledge" + tag);
        fortradePage.unsuccessfullyRegistrationWrongSMS("Testq", "Testa", TestData.emailGenerator(), countryCode,
                TestData.canadaPhoneNumber(), "25-34", "$15,000-$50,000", "$50,000-$100,000", "All the above",
                "1", "1", "1", "1");
        Thread.sleep(500);
        Assert.assertEquals(fortradePage.incorrectTokenMsg.getText(), "Incorrect Code. Please check and try again.");
        fortradePage.takeScreenshot("Incorrect code - Please check and try again - " + regulation);
    }

    @Test(description = "Verify that message We sent you the code again is received")
    @Parameters({"tag", "countryCode", "regulation"})
    public void didNotGetToken(String tag, String countryCode, String regulation) throws IOException, AWTException, InterruptedException {
        driver.get("https://dlp.fortrade.com/lps/premium-forex-landing-ephone-ca/en?fts=sms-age-annual-saving-knowledge" + tag);
        fortradePage.tokenIsNotReceived("Testq", "Testa", TestData.emailGenerator(), countryCode,
                TestData.canadaPhoneNumber(), "25-34", "$15,000-$50,000", "$50,000-$100,000", "All the above");
        Assert.assertEquals(fortradePage.codeIsSent.getText(), "We sent you the code again");
        Thread.sleep(1500);
        if (fortradePage.codeIsSent.isDisplayed()) {
            fortradePage.takeScreenshot("We sent you the code again " + regulation, fortradePage.codeIsSent);
        }
    }

    @Test(description = "Verify if user clicks pencil icon the same is returned to the 1st widget")
    @Parameters({"tag", "countryCode", "regulation"})
    public void userIsReturnedTo1stWidget(String tag, String countryCode, String regulation) throws IOException, AWTException {
        driver.get("https://dlp.fortrade.com/lps/premium-forex-landing-ephone-ca/en?fts=sms-age-annual-saving-knowledge" + tag);
        fortradePage.unsuccessfullyRegistrationWrongData("Testq","Testa",TestData.emailGenerator(),
                countryCode,TestData.canadaPhoneNumber());
        fortradePage.clickEditTokenBtn();
        if (fortradePage.phoneNumber.isDisplayed()) {
            fortradePage.enterPhoneNumber(TestData.canadaPhoneNumber());
            fortradePage.takeScreenshot("The user is returned to the 1st form widget " + regulation);
        }
    }

    @Test(description = "Verify the demo account is not registered successfully with empty fields")
    @Parameters({"regulation"})
    public void emptyDemoAccountRegistration(String regulation) throws IOException, AWTException {
        fortradePage.unsuccessfullyRegistrationWrongData("", "", "", "", "");
        fortradePage.assertErrorMessages();
       //fortradePage.assertColor("red");
        if (regulation.equalsIgnoreCase("Asic")) {
            fortradePage.takeScreenshot("Demo account registration - no data " + regulation + " regulation", fortradePage.submitBtnAsic);
        } else {
            fortradePage.takeScreenshot("Demo account registration - no data " + regulation + " regulation", fortradePage.submitBtn);
        }
    }

    @Test(description = "Verify that the already registered email address cannot be register")
    @Parameters({"countryCode", "regulation", "tag"})
    public void alreadyRegisteredAccountTest(String countryCode, String regulation, String tag) throws IOException, AWTException {
        String email = TestData.emailGenerator();
        fortradePage.successfullyRegistration("Testq", "Testa", email, countryCode,
                TestData.canadaPhoneNumber(), "25-34", "$15,000-$50,000", "$50,000-$100,000",
                "All the above");
        fortradePage.assertURL("https://ready.fortrade.com/");
        driver.get("https://dlp.fortrade.com/lps/premium-forex-landing-ephone-ca/en?fts=age-annual-saving-knowledge" + tag);
        fortradePage.alreadyRegisteredAccount("Testq", "Testa", email, countryCode, TestData.canadaPhoneNumber());
        fortradePage.assertErrMsgForAlreadyRegisteredAccount("Already registered account - error message " + regulation);
    }

    @Test(description = "Verify that the First Name cannot be the same as Last Name")
    @Parameters({"regulation"})
    public void sameFNameAndLName(String regulation) throws IOException, AWTException {
        fortradePage.enterFirstName("Test");
        fortradePage.enterLastName("Test");
        fortradePage.clickElement(fortradePage.firstName, "on the first name field");
        fortradePage.clickElement(fortradePage.lastName, "on the last name field");
        fortradePage.assertSameNameErrorMsgs();
        fortradePage.takeScreenshot("Error messages for the same first and last name - " + regulation + " regulation");
    }

    @Test(description = "Verify the logo is not clickable with left click")
    @Parameters({"regulation", "tag"})
    public void checkingLogoClickability(String regulation, String tag) throws IOException, AWTException {
        fortradePage.checkLogoClickability(regulation, "https://dlp.fortrade.com/lps/premium-forex-landing-ephone-ca/en?fts=age-annual-saving-knowledge" + tag);
        fortradePage.takeScreenshot("Logo is not clickable - " + regulation + " regulation");
    }

    @Test
    @Parameters({"regulation"})
    public void checkForCountryCodeErrorMessage(String regulation) throws IOException, AWTException {
        fortradePage.checkCountryCodeErrorMessage("01852833kdkd", regulation);
        fortradePage.takeScreenshot("Country code error message - " + regulation + " regulation");
    }

    @Test(description = "Verify the email is sent on the new account email")
    @Parameters({"regulation", "countryCode"})
    public void emailIsReceivedSuccessfully(String regulation, String countryCode) throws IOException, AWTException {
        String email = TestData.emailGenerator();
        fortradePage.successfullyRegistration("Testq", "Testa", email, countryCode, TestData.canadaPhoneNumber(),
                "25-34", "$15,000-$50,000", "$50,000-$100,000", "All the above");
        fortradePage.assertURL("https://ready.fortrade.com/");
        driver.get("https://yopmail.com/en/");
        YopMail yopMail = new YopMail(driver);
        yopMail.findEmail(email);
        yopMail.zoomOutMethod();
        yopMail.takeScreenshot("Email is received successfully - " + regulation + " regulation", yopMail.emailTitle);
    }

    @Test(description = "Verify the Privacy Policy link works with left/right click")
    @Parameters({"regulation"})
    public void privacyPolicyTest(String regulation) throws IOException, AWTException, InterruptedException {
        Thread.sleep(2000);
        fortradePage.scrollToAnElementBy(fortradePage.privacyPolicyLinkBy);
        fortradePage.clickOnSelectedLink(fortradePage.privacyPolicyLinkBy, fortradePage.setRegulation(regulation),
                "Privacy policy", regulation);
        fortradePage.scrollToAnElementBy(fortradePage.privacyPolicyLinkBy);
        fortradePage.rightClickOnSelectedLink(fortradePage.privacyPolicyLinkBy, fortradePage.setRegulation(regulation));
    }

    @Test(description = "Verify the Terms and Conditions link works with left/right click")
    @Parameters({"regulation"})
    public void termsAndConditionsTest(String regulation) throws IOException, AWTException, InterruptedException {
        Thread.sleep(2000);
        fortradePage.scrollToAnElementBy(fortradePage.termsAndConditionsLinkBy);
        fortradePage.clickOnSelectedLink(fortradePage.termsAndConditionsLinkBy, fortradePage.termsAndCondition(regulation),
                "Terms and conditions", regulation);
        fortradePage.scrollToAnElementBy(fortradePage.termsAndConditionsLinkBy);
        fortradePage.rightClickOnSelectedLink(fortradePage.termsAndConditionsLinkBy, fortradePage.termsAndCondition(regulation));
    }

    @Test(description = "Verify the click here link works with left/right click")
    @Parameters({"regulation"})
    public void howToUnsubscribeTest(String regulation) throws IOException, InterruptedException, AWTException {
        Thread.sleep(2000);
        fortradePage.scrollToAnElementBy(fortradePage.clickHereLink);
        fortradePage.clickOnSelectedLink(fortradePage.clickHereLink, fortradePage.howToUnsubscribeURL, "How to unsubscribe", regulation);
        fortradePage.scrollToAnElementBy(fortradePage.clickHereLink);
        fortradePage.rightClickOnSelectedLink(fortradePage.clickHereLink, fortradePage.howToUnsubscribeURL);
    }

    @Test(description = "Verify the Already have an account? link with left click redirects user to the login page")
    @Parameters({"regulation"})
    public void loginRedirectionTest(String regulation) throws IOException, AWTException, InterruptedException {
        fortradePage.scrollToAnElementBy(fortradePage.alreadyHaveAnAccountLinkBy);
        fortradePage.loginRedirection(regulation);
        fortradePage.assertURL(fortradePage.alrHaveAccount);
        fortradePage.takeScreenshot("Login page - the user is successfully redirected " + regulation +
                " regulation");
    }

    @Test(description = "Verify the Risk warning link works with left/right click")
    @Parameters({"regulation"})
    public void riskWarningTest(String regulation) throws IOException, InterruptedException, AWTException {
        fortradePage.scrollToAnElementBy(fortradePage.footerRiskWarningLinkBy);
        fortradePage.clickOnSelectedLink(fortradePage.footerRiskWarningLinkBy, fortradePage.riskWarning(regulation),
                "Risk warning", regulation);
        fortradePage.rightClickOnSelectedLink(fortradePage.footerRiskWarningLinkBy, fortradePage.riskWarning(regulation));
    }

    @Test(description = "Verify the Privacy policy (in footer) link works with left/right click")
    @Parameters({"regulation"})
    public void footerPrivacyPolicy(String regulation) throws IOException, InterruptedException, AWTException {
        fortradePage.scrollToAnElementBy(fortradePage.footerPrivacyPolicyLinkBy);
        fortradePage.clickOnSelectedLink(fortradePage.footerPrivacyPolicyLinkBy, fortradePage.footerPrivacyPolicy(regulation),
                "Privacy policy - footer", regulation);
        fortradePage.rightClickOnSelectedLink(fortradePage.footerPrivacyPolicyLinkBy, fortradePage.footerPrivacyPolicy(regulation));
    }

    @Test(description = "Verify the FRN: 609970 link works with left/right click")
    @Parameters({"regulation"})
    public void fcaRegulationTest(String regulation) throws IOException, InterruptedException, AWTException {
        fortradePage.scrollToAnElementBy(fortradePage.fcaRegulationLinkBy);
        fortradePage.clickOnSelectedLink(fortradePage.fcaRegulationLinkBy, fortradePage.fcaLink,
                "Financial conduct authority page", regulation);
        fortradePage.scrollToAnElement(driver.findElement(By.xpath("//a[text()='FRN: 609970']")));
        fortradePage.rightClickOnSelectedLink(fortradePage.fcaRegulationLinkBy, fortradePage.fcaLink);
    }

    @Test(description = "Verify the CRN: BC1148613 link works with left/right click")
    @Parameters({"regulation"})
    public void iirocRegulationTest(String regulation) throws IOException, InterruptedException, AWTException {
        fortradePage.scrollToAnElementBy(fortradePage.ciroRegulationLinkBy);
        fortradePage.clickOnSelectedLink(fortradePage.ciroRegulationLinkBy, fortradePage.iirocLink,
                "Canadian Investment Regulatory Organization page", regulation);
        //fortradePage.scrollToAnElement(driver.findElement(By.xpath("//a[text()='CRN: BC1148613']")));
        fortradePage.rightClickOnSelectedLink(fortradePage.ciroRegulationLinkBy, fortradePage.iirocLink);
    }

    @Test(description = "Verify the ABN: 33 614 683 831 | AFSL: 493520 link works with left/right click")
    @Parameters({"regulation"})
    public void asicRegulationTest(String regulation) throws IOException, InterruptedException, AWTException {
        fortradePage.scrollToAnElementBy(fortradePage.asicRegulationLinkBy);
        fortradePage.clickOnSelectedLink(fortradePage.asicRegulationLinkBy, fortradePage.asicLink,
                "Australian Securities and Investments Commission page", regulation);
        fortradePage.assertURL("https://connectonline.asic.gov.au/");
        //fortradePage.scrollToAnElement(driver.findElement(By.xpath("//a[text()='ABN: 33 614 683 831 | AFSL: 493520']")));
        fortradePage.rightClickOnSelectedLink(fortradePage.asicRegulationLinkBy, fortradePage.asicLink);
    }

    @Test(description = "Verify the CIF license number 385/20 link works with left/right click")
    @Parameters({"regulation"})
    public void cysecRegulationTest(String regulation) throws IOException, InterruptedException, AWTException {
        fortradePage.scrollToAnElementBy(fortradePage.cysecRegulationLinkBy);
        fortradePage.clickOnSelectedLink(fortradePage.cysecRegulationLinkBy, fortradePage.cysecLink,
                "Cyprus Securities and Exchange Commission page", regulation);
        fortradePage.scrollToAnElementBy(fortradePage.cysecRegulationLinkBy);
        fortradePage.rightClickOnSelectedLink(fortradePage.cysecRegulationLinkBy, fortradePage.cysecLink);
    }

    @Test(description = "Verify the GB21026472 link works with left/right click")
    @Parameters({"regulation"})
    public void fscRegulationTest(String regulation) throws IOException, InterruptedException, AWTException {
        fortradePage.scrollToAnElementBy(fortradePage.fscRegulationLinkBy);
        fortradePage.clickOnSelectedLink(fortradePage.fscRegulationLinkBy, fortradePage.fscLink,
                "Financial Services Commission page", regulation);
        fortradePage.scrollToAnElementBy(fortradePage.fscRegulationLinkBy);
        fortradePage.rightClickOnSelectedLink(fortradePage.fscRegulationLinkBy, fortradePage.fscLink);
    }

    @Test
    @Parameters({"regulation"})
    public void fsgDocumentTest(String regulation) throws IOException, InterruptedException, AWTException {
        fortradePage.scrollToAnElementBy(fortradePage.fsgDocument);
        fortradePage.clickOnSelectedLink(fortradePage.fsgDocument, fortradePage.fsgDocumentLink,
                "Financial Service Guide ", regulation);
        fortradePage.scrollToAnElementBy(fortradePage.fsgDocument);
        fortradePage.rightClickOnSelectedLink(fortradePage.fsgDocument, fortradePage.fsgDocumentLink);
    }

    @Test
    @Parameters({"regulation"})
    public void pdsDocumentTest(String regulation) throws IOException, InterruptedException, AWTException {
        fortradePage.scrollToAnElementBy(fortradePage.pdsDocument);
        fortradePage.clickOnSelectedLink(fortradePage.pdsDocument, fortradePage.pdsDocumentLink,
                "Product Disclosure Statement document", regulation);
        fortradePage.scrollToAnElementBy(fortradePage.pdsDocument);
        fortradePage.rightClickOnSelectedLink(fortradePage.pdsDocument, fortradePage.pdsDocumentLink);
    }

    @Test
    @Parameters({"regulation"})
    public void tmdDocumentTest(String regulation) throws IOException, InterruptedException, AWTException {
        fortradePage.scrollToAnElementBy(fortradePage.tmdDocument);
        fortradePage.clickOnSelectedLink(fortradePage.tmdDocument, fortradePage.tmdDeterminationLink,
                "Target Market Determination ", regulation);
        fortradePage.scrollToAnElementBy(fortradePage.tmdDocument);
        fortradePage.rightClickOnSelectedLink(fortradePage.tmdDocument, fortradePage.tmdDeterminationLink);
    }

    @Test
    @Parameters({"regulation"})
    public void contactUsLink(String regulation) throws IOException, AWTException, InterruptedException {
        fortradePage.clickOnMailLink("contactUs");
        Thread.sleep(1500);
        fortradePage.takeScreenshot("Fortrade " + regulation + " - contact us redirection");
        fortradePage.closeOutlook();
    }

    @Test(description = "Verify the click on support@fortrade.com link opens email window")
    @Parameters({"regulation"})
    public void supportLink(String regulation) throws IOException, AWTException, InterruptedException {
        if (!regulation.equalsIgnoreCase("cysec")) {
            fortradePage.clickOnMailLink("support");
        } else {
            System.out.println("Cysec regulation does not contain support.fortrade.com address");
        }
        Thread.sleep(2000);
        fortradePage.takeScreenshot("Fortrade " + regulation + " - support redirection");
        fortradePage.closeOutlook();
    }

    @Test(description = "Verify the 2nd step - age verification window cannot be submitted if it's not completed")
    @Parameters({"tag", "countryCode", "regulation"})
    public void errorMessageAgeParameter(String tag, String countryCode, String regulation) throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        String phoneNumber = TestData.canadaPhoneNumber();
        driver.get("https://dlp.fortrade.com/lps/premium-forex-landing-ephone-ca/en?fts=age" + tag);
        fortradePage.ageParameter("Testq", "Testa", email, countryCode, phoneNumber,
                "-- Select --");
        fortradePage.secondStepErrorMessage(1);
        fortradePage.takeScreenshot("Age parameter error message - Fortrade - " + regulation + " regulation");
    }

    @Test(description = "Verify the 2nd step - annual income verification window cannot be submitted if it's not completed")
    @Parameters({"tag", "countryCode", "regulation"})
    public void errorMessageAnnualParameter(String tag, String countryCode, String regulation) throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        String phoneNumber = TestData.canadaPhoneNumber();
        driver.get("https://dlp.fortrade.com/lps/premium-forex-landing-ephone-ca/en?fts=annual" + tag);
        fortradePage.annualParameter("Testq", "Testa", email, countryCode, phoneNumber,
                "-- Select --");
        fortradePage.secondStepErrorMessage(1);
        fortradePage.takeScreenshot("Annual parameter error message - Fortrade - " + regulation + " regulation");
    }

    @Test(description = "Verify the 2nd step - value of saving and investments verification window cannot be submitted if it's not completed")
    @Parameters({"tag", "countryCode", "regulation"})
    public void errorMessageSavingParameter(String tag, String countryCode, String regulation) throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        String phoneNumber = TestData.canadaPhoneNumber();
        driver.get("https://dlp.fortrade.com/lps/premium-forex-landing-ephone-ca/en?fts=saving" + tag);
        fortradePage.savingParameter("Testq", "Testa", email, countryCode, phoneNumber,
                "-- Select --");
        fortradePage.secondStepErrorMessage(1);
        fortradePage.takeScreenshot("Saving parameter error message - Fortrade - " + regulation + " regulation");
    }

    @Test(description = "Verify the 2nd step - knowledge of trading verification window cannot be submitted if it's not completed")
    @Parameters({"tag", "countryCode", "regulation"})
    public void errorMessageKnowledgeParameter(String tag, String countryCode, String regulation) throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        String phoneNumber = TestData.canadaPhoneNumber();
        driver.get("https://dlp.fortrade.com/lps/premium-forex-landing-ephone-ca/en?fts=knowledge" + tag);
        fortradePage.knowledgeParameter("Testq", "Testa", email, countryCode, phoneNumber,
                "-- Select --");
        fortradePage.secondStepErrorMessage(1);
        fortradePage.takeScreenshot("Knowledge parameter error message - Fortrade - " + regulation + " regulation");
    }

    @Test
    @Parameters({"countryCode", "regulation"})
    public void errorMessagesAllParameters(String countryCode, String regulation) throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        String phoneNumber = TestData.canadaPhoneNumber();
        fortradePage.unsuccessfullyRegistration("Testq", "Testa", email, countryCode, phoneNumber,
                "25-34", "$15,000-$50,000", "$50,000-$100,000", "All the above",
                "-- Select --", "-- Select --", "-- Select --", "-- Select --");
        fortradePage.secondStepErrorMessage(4);
        fortradePage.takeScreenshot("All parameters error message - Fortrade - " + regulation + " regulation");
    }

    @Test(description = "Verify the desired communication language value is displayed correctly in the Link ID field in the CRM")
    @Parameters({"tag", "countryCode", "regulation"})
    public void checkLanguageParameter(String tag, String countryCode, String regulation) throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.fortrade.com/lps/premium-forex-landing-ephone-ca/en?fts=plang:srcs,all" + tag);
        fortradePage.languageParameter("Testq", "Testa", email, countryCode,
                TestData.canadaPhoneNumber(), "English");
       /* if (regulation.equalsIgnoreCase("Asic")) {
            fortradePage.assertURL("https://ready.fortrade.com/#asicupdateacceptcalls");
            fortradePage.clickConsentBtn();
        } else if (regulation.equalsIgnoreCase("Iiroc")) {
            fortradePage.assertURL("https://ready.fortrade.com/#enhancedcustomerconsent");
        } else {
            fortradePage.assertURL("https://ready.fortrade.com/#chartticket");
        }*/
        fortradePage.assertURL("https://ready.fortrade.com/");
        crmPage.checkCrmData(email, "Testq Testa", regulation);
        crmPage.checkLinkIdValue("PC_windows,lang_EN");
        Thread.sleep(1000);
        crmPage.takeScreenshot("Desired communication language - " + regulation + " regulation", crmPage.linkId);
    }

    @Test(description = "Verify the 2nd step - desired communication language verification window cannot be submitted if it's not completed")
    @Parameters({"tag", "countryCode", "regulation"})
    public void errorLanguageParameter(String tag, String countryCode, String regulation) throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.fortrade.com/lps/premium-forex-landing-ephone-ca/en?fts=plang:srcs,all" + tag);
        fortradePage.languageParameter("Testq", "Testa", email, countryCode,
                TestData.canadaPhoneNumber(), "-- Select --");
        //fortradePage.assertBorderColor(fortradePage.languageField);
        fortradePage.secondStepErrorMessage(1);
        fortradePage.takeScreenshot("Desired communication language - error " + regulation + " regulation", fortradePage.languageField);
    }

    @Test
    @Parameters({"tag", "regulation"})
    public void checkFCAPercentages(String tag, String regulation) throws IOException, AWTException {
        driver.get("https://dlp.fortrade.com/lps/premium-forex-landing-ephone-ca/en?fts=plang:srcs,all" + tag);
        fortradePage.checkFCAPercentages("69% of retail investor accounts lose money when trading CFDs with this provider.");
        //fortradePage.clickDenyBtn();
        fortradePage.takeScreenshot("Percentages - " + regulation + " regulation");
    }

    @Test
    @Parameters({"tag", "regulation"})
    public void checkCysecPercentages(String tag, String regulation) throws IOException, AWTException {
        driver.get("https://dlp.fortrade.com/lps/premium-forex-landing-ephone-ca/en?fts=plang:srcs,all" + tag);
        fortradePage.checkCysecPercentages("70.88% % of retail investor accounts lose money when trading CFDs with this provider.");
        fortradePage.takeScreenshot("Percentages - " + regulation + " regulation");
    }

    @Test(description = "Verify the custom tag field in the CRM contains Dummy value ")
    @Parameters({"countryCode", "regulation", "tag"})
    public void dummyLeadRegistration(String countryCode, String regulation, String tag) throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.fortrade.com/lps/premium-forex-landing-ephone-ca/en?fts=annual-saving-knowledge-age&" +
                "ftsquery=age-equals(1,3)-or-[saving-equals(1,2,3)-and-knowledge-notequals(5)]" + tag);
        fortradePage.successfullyRegistration("Testq", "Testa", email, countryCode,
                TestData.canadaPhoneNumber(), "25-34", "$50,000-$100,000", "$50,000-$100,000",
                "All the above");
        fortradePage.assertURL("https://ready.fortrade.com/");
        crmPage.checkCrmData(email, "Testq Testa", regulation);
        crmPage.checkCustomTag("Dummy");
        fortradePage.takeScreenshot("Custom Tag - Dummy " + regulation + " regulation", crmPage.customTag);
    }

    @Test(description = "Verify the cutom tag field in the CRM contains Dummy value ")
    @Parameters({"countryCode", "regulation", "tag"})
    public void dummy_Lead_Registration(String countryCode, String regulation, String tag) throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.fortrade.com/lps/premium-forex-landing-ephone-ca/en?fts=annual-saving-knowledge-age&" +
                "ftsquery=age-equals(1_3)-or-[saving-equals(1_2_3)-and-knowledge-notequals(5)]" + tag);
        fortradePage.successfullyRegistration("Testq", "Testa", email, countryCode,
                TestData.canadaPhoneNumber(), "25-34", "$15,000-$50,000", "$50,000-$100,000",
                "All the above");
        fortradePage.assertURL("https://ready.fortrade.com/");
        crmPage.checkCrmData(email, "Testq Testa", regulation);
        crmPage.checkCustomTag("Dummy");
        fortradePage.takeScreenshot("Custom Tag - Dummy " + regulation + " regulation", crmPage.customTag);
    }

    @Test(description = "Verify the custom tag field in the CRM is Invalid")
    @Parameters({"countryCode", "regulation", "tag"})
    public void invalidLeadRegistration(String countryCode, String regulation, String tag) throws InterruptedException, IOException, AWTException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.fortrade.com/lps/premium-forex-landing-ephone-ca/en?fts=annual-saving-knowledge-age&" +
                "ftsquery=age(1)-or-[saving-equals(1,2,3)-and-knowledge-notequals(5)]" + tag);
        fortradePage.successfullyRegistration("Testq", "Testa", email, countryCode,
                TestData.canadaPhoneNumber(), "45-54", "$15,000-$50,000", "$100,000-$250,000",
                "None");
        fortradePage.assertURL("https://ready.fortrade.com/");
        crmPage.checkCrmData(email, "Testq Testa", regulation);
        crmPage.checkCustomTag("Invalid");
        fortradePage.takeScreenshot("Custom Tag - Invalid " + regulation + " regulation", crmPage.customTag);
    }

    @Test(description = "Verify the custom tag field in the CRM is Invalid")
    @Parameters({"countryCode", "regulation", "tag"})
    public void invalid_Lead_Registration(String countryCode, String regulation, String tag) throws InterruptedException, IOException, AWTException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.fortrade.com/lps/premium-forex-landing-ephone-ca/en?fts=annual-saving-knowledge-age&" +
                "ftsquery=age(1)-or-[saving-equals(1_2_3)-and-knowledge-notequals(5)]" + tag);
        fortradePage.successfullyRegistration("Testq", "Testa", email, countryCode,
                TestData.canadaPhoneNumber(), "45-54", "$15,000-$50,000", "$100,000-$250,000",
                "None");
        fortradePage.assertURL("https://ready.fortrade.com/");
        crmPage.checkCrmData(email, "Testq Testa", regulation);
        crmPage.checkCustomTag("Invalid");
        fortradePage.takeScreenshot("Custom Tag - Invalid " + regulation + " regulation", crmPage.customTag);
    }

    @Test(description = "Verify the custom tag field in the CRM is empty")
    @Parameters({"countryCode", "regulation", "tag"})
    public void emptyLeadRegistration(String countryCode, String regulation, String tag) throws InterruptedException, IOException, AWTException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.fortrade.com/lps/premium-forex-landing-ephone-ca/en?fts=annual-saving-knowledge-age&" +
                "ftsquery=age-equals(1,3)-or-[saving-equals(1,2,3)-and-knowledge-notequals(5)]" + tag);
        fortradePage.successfullyRegistration("Testq", "Testa", email, countryCode,
                TestData.canadaPhoneNumber(), "45-54", "$15,000-$50,000", "$100,000-$250,000",
                "All the above");
        fortradePage.assertURL("https://ready.fortrade.com/");
        crmPage.checkCrmData(email, "Testq Testa", regulation);
        crmPage.checkCustomTag("");
        fortradePage.takeScreenshot("Custom Tag - Empty " + regulation + " regulation", crmPage.customTag);
    }

    @Test(description = "Verify the custom tag field in the CRM is empty")
    @Parameters({"countryCode", "regulation", "tag"})
    public void empty_Lead_Registration(String countryCode, String regulation, String tag) throws InterruptedException, IOException, AWTException {
        String email = TestData.emailGenerator();
        driver.get("https://dlp.fortrade.com/lps/premium-forex-landing-ephone-ca/en?fts=annual-saving-knowledge-age&" +
                "ftsquery=age-equals(1_3)-or-[saving-equals(1_2_3)-and-knowledge-notequals(5)]" + tag);
        fortradePage.successfullyRegistration("Testq", "Testa", email, countryCode,
                TestData.canadaPhoneNumber(), "45-54", "$15,000-$50,000", "$100,000-$250,000",
                "All the above");
        fortradePage.assertURL("https://ready.fortrade.com/");
        crmPage.checkCrmData(email, "Testq Testa", regulation);
        crmPage.checkCustomTag("");
        fortradePage.takeScreenshot("Custom Tag - Empty " + regulation + " regulation", crmPage.customTag);
    }

    @Test(description = "Verify that the already registered phone number cannot be register")
    @Parameters({"countryCode", "tag", "regulation"})
    public void anAlreadyRegisteredPhone(String countryCode, String tag, String regulation) throws IOException, AWTException {
        String phoneNumber = TestData.canadaPhoneNumber();
        fortradePage.successfullyRegistration("Testq", "Testa", TestData.emailGenerator(), countryCode,
                phoneNumber, "25-34", "$15,000-$50,000", "$50,000-$100,000",
                "All the above");
        fortradePage.assertURL("https://ready.fortrade.com/");
        driver.get("https://dlp.fortrade.com/lps/premium-forex-landing-ephone-ca/en?fts=age-annual-saving-knowledge" + tag);
        fortradePage.alreadyRegisteredAccount("Testq", "Testa", TestData.emailGenerator(),
                countryCode, phoneNumber);
        fortradePage.assertErrMsgForAlreadyRegisteredAccount("Already registered phone number - error message " + regulation);
    }

    @Test
    @Parameters({"countryCode", "tag", "regulation"})
    public void anAlreadyRegisteredEmailAndPhone(String countryCode, String tag, String regulation) throws IOException, AWTException {
        String email = TestData.emailGenerator();
        String phoneNumber = TestData.canadaPhoneNumber();
        fortradePage.successfullyRegistration("Testq", "Testa", email, countryCode,
                phoneNumber, "25-34", "$15,000-$50,000", "$50,000-$100,000",
                "All the above");
        fortradePage.assertURL("https://ready.fortrade.com/");
        driver.get("https://dlp.fortrade.com/lps/premium-forex-landing-ephone-ca/en?fts=age-annual-saving-knowledge" + tag);
        fortradePage.alreadyRegisteredAccount("Testq", "Testa", email,
                countryCode, phoneNumber);
        fortradePage.assertErrMsgForAlreadyRegisteredAccount("Already registered email and phone number - error message " + regulation);
    }

    @Test(description = "Verify that the text By proceeding, I agree to the Privacy Policy and the Terms and Conditions" +
            " By providing my contact details to Fortrade Canada, I agree to receive telephone calls from Customer " +
            "Service Representatives regarding Fortrade Canada, its products, services, promotions, and offers. " +
            "I can opt out of phone contact anytime by informing a Customer Service Representative or unsubscribing via " +
            "notification settings. is  displayed under the deo account registration widget for IIroc regulation")
    @Parameters({"tag", "regulation"})
    public void verifyIirocDisclaimerText(String tag, String regulation) throws IOException, AWTException {
        driver.get("https://dlp.fortrade.com/lps/premium-forex-landing-ephone-ca/en?fts=age-annual-saving-knowledge" + tag);
        String actualText = fortradePage.iirocDisclaimer.getText();
        Assert.assertEquals(actualText, fortradePage.iirocDisclaimerText);
        fortradePage.takeScreenshot("Iiroc disclaimer text - " + regulation);
    }

    @Test(description = "Verify that the text By providing your details to Fortrade Australia you are consenting to be" +
            " contacted by telephone about offers and invites to trade Contracts for Difference (CFDs)." +
            " is  displayed under the demo account registration widget for Asic regulation")
    @Parameters({"tag", "regulation"})
    public void verifyAsicDisclaimerText(String tag, String regulation) throws IOException, AWTException {
        driver.get("https://dlp.fortrade.com/lps/trusted-broker-dr/en?fts=age-annual-saving-knowledge" + tag);
        String actualText = fortradePage.asicDisclaimer.getText();
        Assert.assertEquals(actualText, fortradePage.asicDisclaimerText);
        fortradePage.takeScreenshot("Asic disclaimer text - " + regulation, fortradePage.asicDisclaimer);
    }
}
