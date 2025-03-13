package TestsFortrade;

import Pages.CrmPage;
import Pages.FortradePage;
import Pages.Mailinator;
import faker.TestData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class dayTradingRegularBright extends BaseTestFortrade{
    @BeforeMethod
    @Parameters({"tag"})
    public void setUp(String tag) {
        baseSetup("Chrome", "133");
        driver.get("https://www.fortrade.com/minilps/en/day-trading-regular-bright/?fts=age-annual-saving-knowledge" + tag);
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.driverWait.until(webDriver -> {
            String value = webDriver.findElement(By.xpath("//input[@class='lcField FlavorRegistration']")).getAttribute("value");
            return "quick".equals(value) || "hasStages".equals(value);
        });
        fortradePage.clickRegisterHere();
    }

    @AfterMethod
    public void tearDown() {
        baseTearDown();
    }

    @Test
    @Parameters({"countryCode", "regulation"})
    public void demoAccountRegistration(String countryCode, String regulation) throws IOException, AWTException {
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
        driver.get("https://www.fortrade.com/minilps/en/day-trading-regular-bright/?fts=age-annual-saving-knowledge&tg=ivanA" +
                "1434&tag1=ivanB@1434&tag2=ivanL1434&tag3=ivanM1434&gid=ivanC@1434&G_GEO=ivanD1434&G_GEOint=ivanE1434&G_" +
                "Device=ivanF1434&G_DeviceModel=ivanG1434&G_AdPos=ivanH1434&g_Track=ivanI1434&Track=ivanj1434&gclid=ivanK1434" + tag);
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.successfullyRegistration("Testq", "Testa", email, countryCode,
                TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000", "$50,000 – $100,000", "All the above");
        CrmPage crmPage = new CrmPage(driver);
        crmPage.checkCrmData(email, "Testq Testa", regulation);
        crmPage.takeScreenshot("Account details Fortrade page " + regulation, crmPage.accFullNameCrm);
        crmPage.takeScreenshot("SMS Verification field - no value" + regulation, crmPage.smsVerification);
        crmPage.checkSMSVerification("--");
        crmPage.takeScreenshot("SMS Verification field without sms parameter - no value " + regulation, crmPage.smsVerification);
        crmPage.checkCrmTags();
        crmPage.takeScreenshot("Marketing tags Fortrade page " + regulation, crmPage.accFullNameCrm);
    }

    @Test
    @Parameters({"tag", "countryCode", "regulation"})
    public void checkingAgeParameter(String tag, String countryCode, String regulation) throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://www.fortrade.com/minilps/en/day-trading-regular-bright/?fts=age" + tag);
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.ageParameter("Testq", "Testa", email, countryCode, TestData.phoneNumberGenerator(),
                "25-34");
        CrmPage crmPage = new CrmPage(driver);
        crmPage.checkCrmData(email, "Testq Testa", regulation);
        crmPage.checkSMSVerification("--");
        crmPage.takeScreenshot("SMS Verification field Age parameter - no value " + regulation, crmPage.smsVerification);
        crmPage.checkLinkIdValue("25_34_age,PC-windows");
        Thread.sleep(1000);
        crmPage.takeScreenshot( "Age parameter value "+regulation, crmPage.linkId);
    }

    @Test
    @Parameters({"tag", "countryCode", "regulation"})
    public void checkingAnnualParameter(String tag, String countryCode, String regulation) throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://www.fortrade.com/minilps/en/day-trading-regular-bright/?fts=annual" + tag);
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.annualParameter("Testq", "Testa", email, countryCode, TestData.phoneNumberGenerator(),
                "$15,000-$50,000");
        CrmPage crmPage = new CrmPage(driver);
        crmPage.checkCrmData(email, "Testq Testa", regulation);
        crmPage.checkSMSVerification("--");
        crmPage.takeScreenshot("SMS Verification field Annual parameter - no value " + regulation, crmPage.smsVerification);
        crmPage.checkLinkIdValue("15000_50000_annual,PC-windows");
        Thread.sleep(1000);
        crmPage.takeScreenshot( "Annual parameter value "+regulation, crmPage.linkId);
    }

    @Test
    @Parameters({"tag", "countryCode", "regulation"})
    public void checkingSavingParameter(String tag, String countryCode, String regulation) throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://www.fortrade.com/minilps/en/day-trading-regular-bright/?fts=saving" + tag);
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.savingParameter("Testq", "Testa", email, countryCode, TestData.phoneNumberGenerator(),
                "$50,000 – $100,000");
        CrmPage crmPage = new CrmPage(driver);
        crmPage.checkCrmData(email, "Testq Testa", regulation);
        crmPage.checkSMSVerification("--");
        crmPage.takeScreenshot("SMS Verification field Saving parameter - no value " + regulation, crmPage.smsVerification);
        crmPage.checkLinkIdValue("50000_100000_savings,PC-windows");
        Thread.sleep(1000);
        crmPage.takeScreenshot( "Saving parameter value " + regulation, crmPage.linkId);
    }

    @Test
    @Parameters({"tag", "countryCode", "regulation"})
    public void checkingKnowledgeParameter(String tag, String countryCode, String regulation) throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://www.fortrade.com/minilps/en/day-trading-regular-bright/?fts=knowledge" + tag);
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.knowledgeParameter("Testq", "Testa", email, countryCode, TestData.phoneNumberGenerator(),
                "All the above");
        CrmPage crmPage = new CrmPage(driver);
        crmPage.checkCrmData(email, "Testq Testa", regulation);
        crmPage.checkSMSVerification("--");
        crmPage.takeScreenshot("SMS Verification field Knowledge parameter - no value " + regulation, crmPage.smsVerification);
        crmPage.checkLinkIdValue("knowledge_of_trading_all_the_above,PC-windows");
        Thread.sleep(1000);
        crmPage.takeScreenshot( "Knowledge parameter value "+regulation, crmPage.linkId);
    }

    @Test
    @Parameters({"regulation"})
    public void unsuccessfullyDemoAccountRegistration(String regulation) throws IOException, AWTException {
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.unsuccessfullyRegistrationWrongData("12/*", "+-*5", "test#123", "123456", "/*-+");
        fortradePage.assertErrorMessages();
        fortradePage.assertColor("red");
        fortradePage.takeScreenshot("Unsuccessfully demo account registration " + regulation + " regulation", fortradePage.firstName);
    }

    @Test
    @Parameters({"tag","countryCode","regulation"})
    public void assertInvalidTokenMsg(String tag, String countryCode, String regulation) throws IOException, AWTException {
        driver.get("https://www.fortrade.com/minilps/en/day-trading-regular-bright/?fts=sms-age-annual-saving-knowledge"+tag);
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.unsuccessfullyRegistrationWrongSMS("Testq", "Testa", TestData.emailGenerator(), countryCode,
                TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000", "$50,000 – $100,000", "All the above",
                "1","1","1","1");
        Assert.assertEquals(fortradePage.incorrectTokenMsg.getText(),"Incorrect Code. Please check and try again.");
        fortradePage.takeScreenshot("Incorrect code - Please check and try again - "+regulation);
    }

    @Test
    @Parameters({"tag","countryCode","regulation"})
    public void didNotGetToken(String tag,String countryCode, String regulation) throws IOException, AWTException, InterruptedException {
        driver.get("https://www.fortrade.com/minilps/en/day-trading-regular-bright/?fts=sms-age-annual-saving-knowledge"+tag);
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.tokenIsNotReceived("Testq", "Testa", TestData.emailGenerator(), countryCode,
                TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000", "$50,000 – $100,000", "All the above");
        Assert.assertEquals(fortradePage.codeIsSent.getText(),"We sent you the code again");
        Thread.sleep(1500);
        if (fortradePage.codeIsSent.isDisplayed()){
            fortradePage.takeScreenshot("We sent you the code again "+regulation,fortradePage.codeIsSent);
        }
    }

    @Test
    @Parameters({"tag","countryCode","regulation"})
    public void userIsReturnedTo1stWidget(String tag,String countryCode, String regulation) throws IOException, AWTException {
        driver.get("https://www.fortrade.com/minilps/en/day-trading-regular-bright/?fts=sms-age-annual-saving-knowledge"+tag);
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.enterFirstName("Testq");
        fortradePage.enterLastName("Testa");
        fortradePage.enterEmail(TestData.emailGenerator());
        fortradePage.enterCountryCode(countryCode);
        fortradePage.enterPhoneNumber(TestData.phoneNumberGenerator());
        fortradePage.clickDenyBtn();
        fortradePage.clickOnSubmitButton();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        fortradePage.clickEditTokenBtn();
        if(fortradePage.loginToFotrade.isDisplayed()){
            fortradePage.takeScreenshot("The user is returned to the 1st form widget " + regulation,fortradePage.loginToFotrade);
        }
    }

    @Test
    @Parameters({"regulation"})
    public void emptyDemoAccountRegistration(String regulation) throws IOException, AWTException {
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.unsuccessfullyRegistrationWrongData("", "", "", "", "");
        fortradePage.assertErrorMessages();
        fortradePage.assertColor("red");
        if(regulation.equalsIgnoreCase("Asic")){
            fortradePage.takeScreenshot("Demo account registration - no data " + regulation + " regulation", fortradePage.submitBtnAsic);
        }else{
            fortradePage.takeScreenshot("Demo account registration - no data " + regulation + " regulation", fortradePage.submitBtn);
        }
    }

    @Test
    @Parameters({"countryCode", "regulation","tag"})
    public void alreadyRegisteredAccountTest(String countryCode, String regulation,String tag) throws IOException, AWTException {
        String email = TestData.emailGenerator();
        String phoneNumber = TestData.phoneNumberGenerator();
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.successfullyRegistration("Testq", "Testa", email, countryCode,
                TestData.phoneNumberGenerator(), "25-34", "$15,000-$50,000", "$50,000 – $100,000",
                "All the above");
        driver.get("https://www.fortrade.com/minilps/en/day-trading-regular-bright/?fts=age-annual-saving-knowledge"+tag);
        fortradePage.alreadyRegisteredAccount("Testq", "Testa", email, countryCode, phoneNumber);
        fortradePage.assertPopUpForAlreadyRegisteredAccount("Already registered account - pop-up " + regulation);
    }

    @Test
    @Parameters({"regulation"})
    public void sameFNameAndLName(String regulation) throws IOException, AWTException {
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.enterFirstName("Test");
        fortradePage.enterLastName("Test");
        fortradePage.clickElement(fortradePage.firstName, "on the first name field");
        fortradePage.clickElement(fortradePage.lastName, "on the last name field");
        fortradePage.assertSameNameErrorMsgs();
        fortradePage.takeScreenshot("Error messages for the same first and last name - " + regulation + " regulation");
    }

    @Test
    @Parameters({"regulation", "tag"})
    public void checkingLogoClickability(String regulation, String tag) throws IOException, AWTException {
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.checkLogoClickability(regulation, "https://www.fortrade.com/minilps/en/day-trading-regular-bright/?fts=age-annual-saving-knowledge" + tag);
        fortradePage.takeScreenshot("Logo is not clickable - " + regulation + " regulation");
    }

    @Test
    @Parameters({"regulation"})
    public void checkForCountryCodeErrorMessage(String regulation) throws IOException, AWTException {
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.checkCountryCodeErrorMessage("01852833kdkd",regulation);
        fortradePage.takeScreenshot("Country code error message - " + regulation + " regulation");
    }

    @Test
    @Parameters({"regulation", "countryCode"})
    public void emailIsReceivedSuccessfully(String regulation, String countryCode) throws IOException, AWTException {
        String email = TestData.emailGenerator();
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.successfullyRegistration("Testq", "Testa", email, countryCode, TestData.phoneNumberGenerator(),
                "25-34", "$15,000-$50,000", "$50,000 – $100,000", "All the above");
        driver.get("https://www.mailinator.com/");
        Mailinator mailinator = new Mailinator(driver);
        mailinator.findEmail(email);
        mailinator.zoomOutMethod();
        mailinator.takeScreenshot("Email is received successfully - " + regulation + " regulation", mailinator.emailTitle);
    }

    @Test
    @Parameters({"regulation"})
    public void privacyPolicyTest(String regulation) throws IOException, AWTException, InterruptedException {
        Thread.sleep(2000);
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.clickDenyBtn();
        //fortradePage.scrollToAnElementBy(fortradePage.privacyPolicyLinkBy);
        Thread.sleep(2000);
        fortradePage.clickOnSelectedLink(fortradePage.privacyPolicyLinkBy, fortradePage.setRegulation(regulation),
                "Privacy policy", regulation);
        fortradePage.scrollToAnElementBy(fortradePage.privacyPolicyLinkBy);
        fortradePage.rightClickOnSelectedLink(fortradePage.privacyPolicyLinkBy, fortradePage.setRegulation(regulation));
    }

    @Test
    @Parameters({"regulation"})
    public void termsAndConditionsTest(String regulation) throws IOException, AWTException, InterruptedException {
        Thread.sleep(2000);
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.clickDenyBtn();
        //fortradePage.scrollToAnElementBy(fortradePage.termsAndConditionsLinkBy);
        Thread.sleep(2000);
        fortradePage.clickOnSelectedLink(fortradePage.termsAndConditionsLinkBy, fortradePage.termsAndCondition(regulation),
                "Terms and conditions", regulation);
        fortradePage.scrollToAnElementBy(fortradePage.termsAndConditionsLinkBy);
        fortradePage.rightClickOnSelectedLink(fortradePage.termsAndConditionsLinkBy, fortradePage.termsAndCondition(regulation));
    }

    @Test
    @Parameters({"regulation"})
    public void howToUnsubscribeTest(String regulation) throws IOException, InterruptedException, AWTException {
        Thread.sleep(2000);
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.clickDenyBtn();
        fortradePage.scrollToAnElementBy(fortradePage.clickHereLink);
        fortradePage.clickOnSelectedLink(fortradePage.clickHereLink, fortradePage.howToUnsubscribeURL, "How to unsubscribe", regulation);
        fortradePage.scrollToAnElementBy(fortradePage.clickHereLink);
        fortradePage.rightClickOnSelectedLink(fortradePage.clickHereLink, fortradePage.howToUnsubscribeURL);
    }

    @Test
    @Parameters({"regulation"})
    public void loginRedirectionTest(String regulation) throws IOException, AWTException, InterruptedException {
        Thread.sleep(2000);
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.clickDenyBtn();
        fortradePage.scrollToAnElementBy(fortradePage.alreadyHaveAnAccountLinkBy);
        fortradePage.loginRedirection(regulation);
        if (driver.getCurrentUrl().contains(fortradePage.alrHaveAccount) && fortradePage.fortradeLogo.isDisplayed()) {
            fortradePage.takeScreenshot("Login page - the user is successfully redirected " + regulation +
                    " regulation", fortradePage.fortradeLogo);
        } else {
            System.out.println("Wrong link redirection");
        }
    }

    @Test
    @Parameters({"regulation"})
    public void riskWarningTest(String regulation) throws IOException, InterruptedException, AWTException {
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.clickDenyBtn();
        fortradePage.scrollToAnElementBy(fortradePage.footerRiskWarningLinkBy);
        fortradePage.clickOnSelectedLink(fortradePage.footerRiskWarningLinkBy, fortradePage.riskWarning(regulation),
                "Risk warning", regulation);
        fortradePage.rightClickOnSelectedLink(fortradePage.footerRiskWarningLinkBy, fortradePage.riskWarning(regulation));
    }

    @Test
    @Parameters({"regulation"})
    public void footerPrivacyPolicy(String regulation) throws IOException, InterruptedException, AWTException {
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.clickDenyBtn();
        fortradePage.scrollToAnElementBy(fortradePage.footerPrivacyPolicyLinkBy);
        fortradePage.clickOnSelectedLink(fortradePage.footerPrivacyPolicyLinkBy, fortradePage.footerPrivacyPolicy(regulation),
                "Privacy policy - footer", regulation);
        fortradePage.rightClickOnSelectedLink(fortradePage.footerPrivacyPolicyLinkBy, fortradePage.footerPrivacyPolicy(regulation));
    }

    @Test
    @Parameters({"regulation"})
    public void fcaRegulationTest(String regulation) throws IOException, InterruptedException, AWTException {
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.clickDenyBtn();
        fortradePage.scrollToAnElementBy(fortradePage.fcaRegulationLinkBy);
        fortradePage.clickOnSelectedLink(fortradePage.fcaRegulationLinkBy, fortradePage.fcaLink,
                "Financial conduct authority page", regulation);
        fortradePage.scrollToAnElement(driver.findElement(By.xpath("//a[text()='FRN: 609970']")));
        fortradePage.rightClickOnSelectedLink(fortradePage.fcaRegulationLinkBy, fortradePage.fcaLink);
    }

    @Test
    @Parameters({"regulation"})
    public void iirocRegulationTest(String regulation) throws IOException, InterruptedException, AWTException {
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.clickDenyBtn();
        fortradePage.scrollToAnElementBy(fortradePage.ciroRegulationLinkBy);
        fortradePage.clickOnSelectedLink(fortradePage.ciroRegulationLinkBy, fortradePage.iirocLink,
                "Canadian Investment Regulatory Organization page", regulation);
        //fortradePage.scrollToAnElement(driver.findElement(By.xpath("//a[text()='CRN: BC1148613']")));
        fortradePage.rightClickOnSelectedLink(fortradePage.ciroRegulationLinkBy, fortradePage.iirocLink);
    }

    @Test
    @Parameters({"regulation"})
    public void asicRegulationTest(String regulation) throws IOException, InterruptedException, AWTException {
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.clickDenyBtn();
        fortradePage.scrollToAnElementBy(fortradePage.asicRegulationLinkBy);
        fortradePage.clickOnSelectedLink(fortradePage.asicRegulationLinkBy, fortradePage.asicLink,
                "Australian Securities and Investments Commission page", regulation);
        //fortradePage.scrollToAnElement(driver.findElement(By.xpath("//a[text()='ABN: 33 614 683 831 | AFSL: 493520']")));
        fortradePage.rightClickOnSelectedLink(fortradePage.asicRegulationLinkBy, fortradePage.asicLink);
    }

    @Test
    @Parameters({"regulation"})
    public void cysecRegulationTest(String regulation) throws IOException, InterruptedException, AWTException {
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.clickDenyBtn();
        fortradePage.scrollToAnElementBy(fortradePage.cysecRegulationLinkBy);
        fortradePage.clickOnSelectedLink(fortradePage.cysecRegulationLinkBy, fortradePage.cysecLink,
                "Cyprus Securities and Exchange Commission page", regulation);
        fortradePage.scrollToAnElementBy(fortradePage.cysecRegulationLinkBy);
        fortradePage.rightClickOnSelectedLink(fortradePage.cysecRegulationLinkBy, fortradePage.cysecLink);
    }

    @Test
    @Parameters({"regulation"})
    public void fscRegulationTest(String regulation) throws IOException, InterruptedException, AWTException {
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.clickDenyBtn();
        fortradePage.scrollToAnElementBy(fortradePage.fscRegulationLinkBy);
        fortradePage.clickOnSelectedLink(fortradePage.fscRegulationLinkBy, fortradePage.fscLink,
                "Financial Services Commission page", regulation);
        fortradePage.scrollToAnElementBy(fortradePage.fscRegulationLinkBy);
        fortradePage.rightClickOnSelectedLink(fortradePage.fscRegulationLinkBy, fortradePage.fscLink);
    }

    @Test
    @Parameters({"regulation"})
    public void fsgDocumentTest(String regulation) throws IOException, InterruptedException, AWTException {
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.clickDenyBtn();
        fortradePage.scrollToAnElementBy(fortradePage.fsgDocument);
        fortradePage.clickOnSelectedLink(fortradePage.fsgDocument, fortradePage.fsgDocumentLink,
                "Financial Service Guide ", regulation);
        fortradePage.scrollToAnElementBy(fortradePage.fsgDocument);
        fortradePage.rightClickOnSelectedLink(fortradePage.fsgDocument, fortradePage.fsgDocumentLink);
    }

    @Test
    @Parameters({"regulation"})
    public void pdsDocumentTest(String regulation) throws IOException, InterruptedException, AWTException {
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.clickDenyBtn();
        fortradePage.scrollToAnElementBy(fortradePage.pdsDocument);
        fortradePage.clickOnSelectedLink(fortradePage.pdsDocument, fortradePage.pdsDocumentLink,
                "Product Disclosure Statement document", regulation);
        fortradePage.scrollToAnElementBy(fortradePage.pdsDocument);
        fortradePage.rightClickOnSelectedLink(fortradePage.pdsDocument, fortradePage.pdsDocumentLink);
    }

    @Test
    @Parameters({"regulation"})
    public void tmdDocumentTest(String regulation) throws IOException, InterruptedException, AWTException {
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.clickDenyBtn();
        fortradePage.scrollToAnElementBy(fortradePage.tmdDocument);
        fortradePage.clickOnSelectedLink(fortradePage.tmdDocument, fortradePage.tmdDeterminationLink,
                "Target Market Determination ", regulation);
        fortradePage.scrollToAnElementBy(fortradePage.tmdDocument);
        fortradePage.rightClickOnSelectedLink(fortradePage.tmdDocument, fortradePage.tmdDeterminationLink);
    }

/*    @Test
    @Parameters({"regulation"})
    public void fbLinkRedirection(String regulation) throws IOException, InterruptedException, AWTException {
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.clickDenyBtn();
        fortradePage.scrollToAnElementBy(fortradePage.facebookLinkBy);
        fortradePage.clickOnSelectedLink(fortradePage.facebookLinkBy, fortradePage.fbPage(regulation), "Facebook page", regulation);
        fortradePage.scrollToAnElementBy(fortradePage.facebookLinkBy);
        fortradePage.rightClickOnSelectedLink(fortradePage.facebookLinkBy, fortradePage.fbPage(regulation));
    }

    @Test
    @Parameters({"regulation"})
    public void insLinkRedirection(String regulation) throws IOException, InterruptedException, AWTException {
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.clickDenyBtn();
        fortradePage.scrollToAnElementBy(fortradePage.instagramLinkBy);
        fortradePage.clickOnSelectedLink(fortradePage.instagramLinkBy, fortradePage.insURL, "Instagram page", regulation);
        fortradePage.scrollToAnElementBy(fortradePage.instagramLinkBy);
        fortradePage.rightClickOnSelectedLink(fortradePage.instagramLinkBy, fortradePage.insURL);
    }

    @Test
    @Parameters({"regulation"})
    public void ytLinkRedirection(String regulation) throws IOException, InterruptedException, AWTException {
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.clickDenyBtn();
        fortradePage.scrollToAnElementBy(fortradePage.youtubeLinkBy);
        fortradePage.clickOnSelectedLink(fortradePage.youtubeLinkBy, fortradePage.ytURL, "Youtube page", regulation);
        fortradePage.scrollToAnElementBy(fortradePage.youtubeLinkBy);
        fortradePage.rightClickOnSelectedLink(fortradePage.youtubeLinkBy, fortradePage.ytURL);
    }*/

    @Test
    @Parameters({"regulation"})
    public void contactUsLink(String regulation) throws IOException, AWTException, InterruptedException {
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.clickDenyBtn();
        fortradePage.clickOnMailLink("contactUs");
        Thread.sleep(1500);
        fortradePage.takeScreenshot("Fortrade " + regulation + " - contact us redirection");
        fortradePage.closeOutlook();
    }

    @Test
    @Parameters({"regulation"})
    public void supportLink(String regulation) throws IOException, AWTException, InterruptedException {
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.clickDenyBtn();
        if (!regulation.equalsIgnoreCase("cysec")) {
            fortradePage.clickOnMailLink("support");
        } else {
            System.out.println("Cysec regulation does not contain support.fortrade.com address");
        }
        Thread.sleep(2000);
        fortradePage.takeScreenshot("Fortrade " + regulation + " - support redirection");
        fortradePage.closeOutlook();
    }

    @Test
    @Parameters({"tag","countryCode","regulation"})
    public void errorMessageAgeParameter(String tag,String countryCode ,String regulation) throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        String phoneNumber = TestData.phoneNumberGenerator();
        driver.get("https://www.fortrade.com/minilps/en/day-trading-regular-bright/?fts=age"+tag);
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.ageParameter("Testq", "Testa", email, countryCode, phoneNumber,
                "-- Select --");
        fortradePage.secondStepErrorMessage(1);
        fortradePage.takeScreenshot("Age parameter error message - Fortrade - " + regulation + " regulation");
    }

    @Test
    @Parameters({"tag","countryCode","regulation"})
    public void errorMessageAnnualParameter(String tag,String countryCode ,String regulation) throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        String phoneNumber = TestData.phoneNumberGenerator();
        driver.get("https://www.fortrade.com/minilps/en/day-trading-regular-bright/?fts=annual"+tag);
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.annualParameter("Testq", "Testa", email, countryCode, phoneNumber,
                "-- Select --");
        fortradePage.secondStepErrorMessage(1);
        fortradePage.takeScreenshot("Annual parameter error message - Fortrade - " + regulation + " regulation");
    }

    @Test
    @Parameters({"tag","countryCode","regulation"})
    public void errorMessageSavingParameter(String tag,String countryCode ,String regulation) throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        String phoneNumber = TestData.phoneNumberGenerator();
        driver.get("https://www.fortrade.com/minilps/en/day-trading-regular-bright/?fts=saving"+tag);
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.savingParameter("Testq", "Testa", email, countryCode, phoneNumber,
                "-- Select --");
        fortradePage.secondStepErrorMessage(1);
        fortradePage.takeScreenshot("Saving parameter error message - Fortrade - " + regulation + " regulation");
    }

    @Test
    @Parameters({"tag","countryCode","regulation"})
    public void errorMessageKnowledgeParameter(String tag,String countryCode ,String regulation) throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        String phoneNumber = TestData.phoneNumberGenerator();
        driver.get("https://www.fortrade.com/minilps/en/day-trading-regular-bright/?fts=knowledge"+tag);
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.knowledgeParameter("Testq", "Testa", email, countryCode, phoneNumber,
                "-- Select --");
        fortradePage.secondStepErrorMessage(1);
        fortradePage.takeScreenshot("Knowledge parameter error message - Fortrade - " + regulation + " regulation");
    }

    @Test
    @Parameters({"countryCode","regulation"})
    public void errorMessagesAllParameters(String countryCode ,String regulation) throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        String phoneNumber = TestData.phoneNumberGenerator();
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.unsuccessfullyRegistration("Testq", "Testa", email, countryCode, phoneNumber,
                "25-34", "$15,000-$50,000", "$50,000 – $100,000", "All the above",
                "-- Select --", "-- Select --", "-- Select --", "-- Select --");
        fortradePage.secondStepErrorMessage(4);
        fortradePage.takeScreenshot("All parameters error message - Fortrade - " + regulation + " regulation");
    }

    @Test
    @Parameters({"tag","countryCode","regulation"})
    public void checkLanguageParameter(String tag, String countryCode ,String regulation) throws IOException, AWTException, InterruptedException {
        String email = TestData.emailGenerator();
        driver.get("https://www.fortrade.com/minilps/en/day-trading-regular-bright/?fts=plang:srcs,all"+tag);
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.languageParameter("Testq", "Testa", email, countryCode,
                TestData.phoneNumberGenerator(),"English");
        CrmPage crmPage = new CrmPage(driver);
        crmPage.checkCrmData(email, "Testq Testa", regulation);
        crmPage.checkLinkIdValue("lang_EN,PC-windows");
        Thread.sleep(1000);
        crmPage.takeScreenshot("Desired communication language - " + regulation + " regulation",crmPage.linkId);
    }

    @Test
    @Parameters({"tag","countryCode","regulation"})
    public void errorLanguageParameter(String tag, String countryCode,String regulation) throws IOException, AWTException {
        String email = TestData.emailGenerator();
        driver.get("https://www.fortrade.com/minilps/en/day-trading-regular-bright/?fts=plang:srcs,all"+tag);
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.languageParameter("Testq", "Testa", email, countryCode,
                TestData.phoneNumberGenerator(),"-- Select --");
        fortradePage.assertBorderColor(fortradePage.languageField);
        fortradePage.takeScreenshot("Desired communication language - error " + regulation + " regulation", fortradePage.languageField);
    }

    @Test
    @Parameters({"tag", "regulation"})
    public void checkFCAPercentages(String tag, String regulation) throws IOException, AWTException {
        driver.get("https://www.fortrade.com/minilps/en/day-trading-regular-bright/?fts=plang:srcs,all"+tag);
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.checkFCAPercentages("66% of retail investor accounts lose money when trading CFDs with this provider.");
        fortradePage.clickDenyBtn();
        fortradePage.takeScreenshot("Percentages - " + regulation + " regulation");
    }

    @Test
    @Parameters({"tag", "regulation"})
    public void checkCysecPercentages(String tag, String regulation) throws IOException, AWTException {
        driver.get("https://www.fortrade.com/minilps/en/day-trading-regular-bright/?fts=plang:srcs,all"+tag);
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.checkCysecPercentages("73.43% of retail investor accounts lose money when trading CFDs with this provider.");
        fortradePage.clickDenyBtn();
        fortradePage.takeScreenshot("Percentages - " + regulation + " regulation");
    }
}
