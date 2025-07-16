package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FortradePage extends BasePage {

    public FortradePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='logo fcaClass asicClass fscClass']")
    public WebElement logo;

    @FindBy(xpath = "//div[contains(@class,'logo iirocClass')]")
    public WebElement logoIiroc;

    @FindBy(xpath = "//div[contains(@class,'logo cysecClass')]")
    public WebElement logoCysec;

    @FindBy(xpath = "//input[@name='FirstName']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@name='LastName']")
    public WebElement lastName;

    @FindBy(xpath = "(//div[@class='LcWidgetTopWrapper ClField-Email lcFieldWrapper']//input[@name='Email'])[position()=2]")
    public WebElement email;

    @FindBy(xpath = "//input[@name='PhoneCountryCode']")
    public WebElement countryCode;

    @FindBy(xpath = "//input[@name='Phone']")
    public WebElement phoneNumber;

    @FindBy(xpath = "//input[@name='Send']")
    public WebElement submitBtn;

    @FindBy(xpath = "//input[@name='SendTermsAgreementAsic']")
    public WebElement submitBtnAsic;

    @FindBy(xpath = "//button[@id='CybotCookiebotDialogBodyButtonDecline']")
    public WebElement denyBtn;

    @FindBy(xpath = "//div[@data-cmd='menu']")
    public WebElement menuBtn;

    @FindBy(xpath = "//div[@id='platformRegulation']")
    public WebElement regulationMsg;

    @FindBy(xpath = "//div[@class='userExistsLabelInner']")
    public WebElement alrdRegEmailPopUp;

    @FindBy(xpath = "//iframe[@id='myWidgetIframe']")
    public WebElement iFrameIConsent;

    @FindBy(xpath = "//input[@value='I Consent']")
    public WebElement iConsentBtn;

    @FindBy(xpath = "//div[@class='pushcrew-chrome-style-notification pushcrew-chrome-style-notification-safari']")
    public WebElement popUpNotification;

    @FindBy(xpath = "(//div[@class='errorValidationIn'])[last()]")
    public WebElement countryCodeErrorMessage;

    @FindBy(xpath = "//div[@class='alreadyHaveAcc']//a[contains(text(),'Already have an account?')]")
    public WebElement loginToFotrade;

    @FindBy(xpath = "//div[@class='LcWidgetTopWrapper ClField-Age lcFieldWrapper']//select")
    public WebElement age;

    @FindBy(xpath = "//div[@class='LcWidgetTopWrapper ClField-EstimatedAnnualIncome lcFieldWrapper']//select")
    public WebElement annual;

    @FindBy(xpath = "//div[@class='LcWidgetTopWrapper ClField-ValueOfSavingAndInvestments lcFieldWrapper']//select")
    public WebElement saving;

    @FindBy(xpath = "//div[@class='LcWidgetTopWrapper ClField-KnowledgeOfTrading lcFieldWrapper']//select")
    public WebElement knowledge;

    @FindBy(xpath = "//div[@class='LcWidgetTopWrapper ClField-PreferredLanguage lcFieldWrapper']//select")
    public WebElement languageField;

    @FindBy(xpath = "//input[@class='ContinueBtn-Submit']")
    public WebElement continueBtn;

    @FindBy(xpath = "//input[@name='Token0']")
    public WebElement tokenField0;

    @FindBy(xpath = "//input[@name='Token1']")
    public WebElement tokenField1;

    @FindBy(xpath = "//input[@name='Token2']")
    public WebElement tokenField2;

    @FindBy(xpath = "//input[@name='Token3']")
    public WebElement tokenField3;

    @FindBy(xpath = "//div[@class='formErrorMessage']")
    public WebElement incorrectTokenMsg;

    @FindBy(xpath="//input[@class='TokenBack-Button']")
    public WebElement didNotGetToken;

    @FindBy(xpath = "//label[@name='SentAgainLabel']")
    public WebElement codeIsSent;

    @FindBy(xpath="//input[@id='Details-Edit-Btn']")
    public WebElement editTokenBtn;

    @FindBy(xpath = "//span[text()='Fortrade']")
    public WebElement fortradeLogo;

    @FindBy(xpath = "//div[@class='nav-button']")
    public WebElement registerHereBtn;

    @FindBy(xpath = "(//div[@class='fcaClass']/strong[contains(text(), '% of retail investor accounts lose money when trading CFDs with this provider.')])[2]")
    public WebElement dynamicFCAPercentages;

    @FindBy(xpath = "//div[@class='fcaClass']/b[contains(text(), '% of retail investor accounts lose money when trading CFDs with this provider.')]")
    public WebElement staticFCAPercentages;

    @FindBy(xpath = "(//div[@class='cysecClass']/strong[contains(text(), '% of retail investor accounts lose money when trading CFDs with this provider.')])[2]")
    public WebElement dynamicCysecPercentages;

    @FindBy(xpath = "//div[@class='cysecClass']/b[contains(text(), '% of retail investor accounts lose money when trading CFDs with this provider.')]")
    public WebElement staticCysecPercentages;

    @FindBy(xpath = "//div[@class='webSpriteIcon cross']")
    public WebElement closeBtnPyc;

    @FindBy(xpath = "//div[@class='startTradingButton']")
    public WebElement usePasswordBtn;

    @FindBy(xpath = "//button[contains(@class,'pushcrew-btn-close')]")
    public WebElement doNotAllowNtf;

    public By privacyPolicyLinkBy = By.xpath("//*[contains(@class, 'MarketingMaterials')]//a[text()='Privacy Policy']");

    public By termsAndConditionsLinkBy = By.xpath("//*[contains(@class, 'MarketingMaterials')]//a[contains(text(), 'Terms and Conditions')]");

    public By clickHereLink = By.xpath("//*[contains(@class, 'MarketingMaterials')]//a[text()='click here']");

    public By alreadyHaveAnAccountLinkBy = By.xpath("//a[@class='stockLPTag' and @href='https://ready.fortrade.com/?language=en#login']");

    public By contactUsLinkBy = By.xpath("//div[@class='needHelp']/a[contains(text(), 'Contact Us')]");

    public By facebookLinkBy = By.xpath("//img[@alt='facebook']");

    public By instagramLinkBy = By.xpath("//a[@href='https://www.instagram.com/fortrade_online_trading/?hl=en']");

    public By youtubeLinkBy = By.xpath("//a[@href='https://www.youtube.com/channel/UCNCrGhrDTEN1Hx_20-kFxwg']");

    public By supportLinkBy = By.xpath("//a[text()='support@fortrade.com']");

    public By footerRiskWarningLinkBy = By.xpath("//div[@class='footerRiskDisclaimer']//a[contains(text(), 'Risk warning')]");

    public By footerPrivacyPolicyLinkBy = By.xpath("//div[@class='footerRiskDisclaimer']//a[contains(text(), 'Privacy policy')]");

    public By fcaRegulationLinkBy = By.xpath("//a[text()='FRN: 609970']");

    public By ciroRegulationLinkBy = By.xpath("//a[text()='CRN: BC1148613']");

    public By asicRegulationLinkBy = By.xpath("//a[text()='ABN: 33 614 683 831 | AFSL: 493520']");

    public By cysecRegulationLinkBy = By.xpath("//a[text()='CIF license number 385/20']");

    public By fscRegulationLinkBy = By.xpath("//a[text()=' GB21026472']");

    public By fsgDocument = By.xpath("//div[@class='footerRiskDisclaimer']//div[@class='asicClass']//a[contains(text(),'(FSG)')]");

    public By pdsDocument = By.xpath("//div[@class='footerRiskDisclaimer']//div[@class='asicClass']//a[contains(text(),'(PDS)')]");

    public By tmdDocument = By.xpath("//div[@class='footerRiskDisclaimer']//div[@class='asicClass']//a[contains(text(),'(TMD)')]");

    String[] errorMessages = {"Please enter all your given first name(s)",
            "Please enter your last name in alphabetic characters",
            "Invalid email format.",
            "Invalid phone format."};

    String[] sameNamesErrorMessages = {"Your first name must be different from your last name",
            "Your first name must be different from your last name"};

    public String setRegulation(String regulation) {
        String text = "";
        switch (regulation) {
            case "FSC": {
                text = "fortrade-ma-privacy-policy/";
            }
            break;
            case "FCA": {
                text = "wp-content/uploads/legal/Fortrade_Privacy_Policy.pdf";
            }
            break;
            case "iiroc": {
                text = "wp-content/uploads/legal/IIROC/Privacy_Policy.pdf";
            }
            break;
            case "cysec": {
                text = "wp-content/uploads/legal/CySEC/Privacy_Policy.pdf";
            }
            break;
        }
        String privacyPolicy = "https://www.fortrade.com/" + text;
        return privacyPolicy;
    }

    public String termsAndCondition(String regulation) {
        String text = "";
        switch (regulation) {
            case "FSC": {
                text = "fortrade-mauritius-client-agreement/";
            }
            break;
            case "FCA": {
                text = "wp-content/uploads/legal/Fortrade_Terms_and_Conditions.pdf";
            }
            break;
            case "iiroc": {
                text = "wp-content/uploads/legal/IIROC/Client_Agreement.pdf";
            }
            break;
            case "cysec": {
                text = "wp-content/uploads/legal/CySEC/Client_Agreement.pdf";
            }
            break;
        }
        String termsAndConditions = "https://www.fortrade.com/" + text;
        return termsAndConditions;
    }

    public String riskWarning(String regulation) {
        String text = "";
        switch (regulation) {
            case ("FSC"): {
                text = "FSC/Fortrade_MA_Risk_Disclosure.pdf";
            }
            break;
            case ("FCA"): {
                text = "Fortrade_Risk_Disclosure.pdf";
            }
            break;
            case ("iiroc"): {
                text = "IIROC/Risk_Disclosure.pdf";
            }
            break;
            case ("cysec"): {
                text = "CySEC/Risk_Disclosure.pdf";
            }
            break;
            case ("Asic"): {
                text = "ASIC/Fort_Securities_AU_Product_Disclosure_Statement-ASIC.pdf";
            }
            break;
        }
        String riskWarningURL = "https://www.fortrade.com/wp-content/uploads/legal/" + text;
        return riskWarningURL;
    }

    public String footerPrivacyPolicy(String regulation) {
        String text = "";
        switch (regulation) {
            case "FSC": {
                text = "FSC/Fortrade_MA_Privacy_Policy.pdf";
            }
            break;
            case "FCA": {
                text = "Fortrade_Privacy_Policy.pdf";
            }
            break;
            case "Asic": {
                text = "ASIC/Fort_Securities_AU_Privacy_Policy-ASIC.pdf";
            }
            break;
            case "cysec": {
                text = "CySEC/Privacy_Policy.pdf";
            }
            break;
            case "iiroc": {
                text = "IIROC/Privacy_Policy.pdf";
            }
            break;
        }
        String privacyPolicyFooterURL = "https://www.fortrade.com/wp-content/uploads/legal/" + text;
        return privacyPolicyFooterURL;
    }

    public String fbPage(String regulation) {
        String text = "";
        switch (regulation) {
            case ("FSC"): {
                text = "Fortrade.International";
            }
            break;
            case ("FCA"): {
                text = "Fortrade.UK/";
            }
            break;
            case ("Asic"): {
                text = "Fortrade.AU";
            }
            break;
            case ("iiroc"): {
                text = "Fortrade.International";
            }
            break;
            case ("cysec"): {
                text = "Fortrade.EU";
            }
            break;
        }
        String fbURL = "https://www.facebook.com/" + text;
        return fbURL;
    }

    /*How to unsubscribe document link - same for all regulations.
    Iiroc regulation doesn't have the How to unsubscribe document*/
    public String howToUnsubscribeURL = "https://www.fortrade.com/wp-content/uploads/legal/How_to_guides/How_to_unsubscribe.pdf";

    // Already have an account
    public String alrHaveAccount = "https://authfe.fortrade.com/oauth/account/login?appId=41fedbf7-2f03-4aac-8d1d-e11cdbb22bf8";

    // Financial Conduct Authority (FCA) link
    public String fcaLink = "https://register.fca.org.uk/s/firm?id=001b000000NMdUwAAL";

    // Canadian Investment Regulatory Organization (CIRO) link
    public String iirocLink = "https://www.ciro.ca/investors/choosing-investment-advisor/dealers-we-regulate/fortrade-canada-limited";

    // Australian Securities and Investments Commission (ASIC) link
    public String asicLink ="https://connectonline.asic.gov.au/RegistrySearch/faces/landing/panelSearch.jspx?searchText=614683831&searchType=OrgAndBusNm&_adf.ctrl-state=1cbmeylzw8_15";

    // Cyprus Securities and Exchange Commission (CySEC) link
    public String cysecLink = "https://www.cysec.gov.cy/en-GB/entities/investment-firms/cypriot/86639/";

    // Financial Services Commission, Mauritius (FSC) link
    public String fscLink = "https://opr.fscmauritius.org/ords/opr/r/fsc-opr/fsc-online-public-register-opr";

    // Asic regulation - financial service guide document link
    public String fsgDocumentLink = "https://www.fortrade.com/wp-content/uploads/legal/ASIC/Fort_Securities_AU_Financial_Services_Guide-ASIC.pdf";

    // Asic regulation - product disclosure statement document link
    public String pdsDocumentLink = "https://www.fortrade.com/wp-content/uploads/legal/ASIC/Fort_Securities_AU_Product_Disclosure_Statement-ASIC.pdf";

    // Asic regulation - target market determination document link
    public String tmdDeterminationLink = "https://www.fortrade.com/wp-content/uploads/legal/ASIC/Fort_Securities_AU-TMD_Policy.pdf";

    public String ytURL = "https://www.youtube.com/channel/UCNCrGhrDTEN1Hx_20-kFxwg";

    public String insURL = "https://www.instagram.com/fortrade_online_trading/?hl=en";

    public void enterFirstName(String firstNameData) {
        typeText(firstName, firstNameData, "first name");
    }

    public void enterLastName(String lastNameData) {
        typeText(lastName, lastNameData, "last name");
    }

    public void enterEmail(String emailData) {
        typeText(email, emailData, "email name");
    }

    public void enterCountryCode(String countryCodeData) {
        typeText(countryCode, countryCodeData, "country code");
    }

    public void enterPhoneNumber(String phoneNumberData) {
        typeText(phoneNumber, phoneNumberData, "phone number");
    }

    public void clickOnSubmitButton() {
        if (submitBtn.isDisplayed()) {
            clickElement(submitBtn, "Get Started button");
            /*try {
                clickElement(submitBtn, "Get Started button");
            } catch (Exception e){
                System.out.println("Element is not clicked second time!");
            }*/
        } else {
            clickElement(submitBtnAsic, "Get Started button - Asic regulation");
        }
    }

    public void clickDenyBtn() {
        clickElement(denyBtn, "deny cookies button");
    }

    public void selectAge(String ageData) {
        clickElement(age, "Age dropdown menu");
        selectFromDropdown(age, ageData, "age dropdown");
    }

    public void selectAnnual(String annualData) {
        clickElement(annual, "Annual dropdown menu");
        selectFromDropdown(annual, annualData, "annual dropdown");
    }

    public void selectSaving(String savingData) {
        clickElement(saving, "Saving dropdown menu");
        selectFromDropdown(saving, savingData, "saving dropdown");
    }

    public void selectKnowledge(String knowledgeData) {
        clickElement(knowledge, "Knowledge dropdown menu");
        selectFromDropdown(knowledge, knowledgeData, "knowledge dropdown");
    }

    public void clickContinueBtn() {
        clickElement(continueBtn, "continue btn on 2nd widget");
        try {
            clickElement(continueBtn, "continue btn on 2nd widget");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void successfullyRegistration(String firstNameData, String lastNameData, String emailData, String countryCodeData,
                String phoneNumberData, String ageData, String annualData, String savingData, String knowledgeData) {
        enterFirstName(firstNameData);
        enterLastName(lastNameData);
        enterEmail(emailData);
        enterCountryCode(countryCodeData);
        enterPhoneNumber(phoneNumberData);
        /*clickDenyBtn();*/
        clickOnSubmitButton();
        selectAge(ageData);
        selectAnnual(annualData);
        selectSaving(savingData);
        selectKnowledge(knowledgeData);
        clickContinueBtn();
        /*clickDenyBtn();*/
        clickUsePassBtn();
    }
    public void ftsQueryParameter(String url, String firstNameData, String lastNameData, String emailData, String countryCodeData,
                                         String phoneNumberData, String ageData, String annualData, String savingData, String knowledgeData, String languageData) {
        enterFirstName(firstNameData);
        enterLastName(lastNameData);
        enterEmail(emailData);
        enterCountryCode(countryCodeData);
        enterPhoneNumber(phoneNumberData);
        /*clickDenyBtn();*/
        clickOnSubmitButton();
        selectAge(ageData);
        selectAnnual(annualData);
        selectSaving(savingData);
        selectKnowledge(knowledgeData);
        if (url.contains("plang:all")){
            selectLanguage(languageData);
        }
        clickContinueBtn();
//        /*clickDenyBtn();*/
//        clickUsePassBtn();
    }
    public void unsuccessfullyRegistration(String firstNameData, String lastNameData, String emailData, String countryCodeData, String phoneNumberData
            , String ageData, String annualData, String savingData, String knowledgeData, String ageDataSelect, String annualDataSelect, String savingDataSelect, String knowledgeDataSelect) {
        enterFirstName(firstNameData);
        enterLastName(lastNameData);
        enterEmail(emailData);
        enterCountryCode(countryCodeData);
        enterPhoneNumber(phoneNumberData);
        /*clickDenyBtn();*/
        clickOnSubmitButton();
        selectAge(ageData);
        selectAge(ageDataSelect);
        selectAnnual(annualData);
        selectAnnual(annualDataSelect);
        selectSaving(savingData);
        selectSaving(savingDataSelect);
        selectKnowledge(knowledgeData);
        selectKnowledge(knowledgeDataSelect);
        clickContinueBtn();
    }

    public void ageParameter(String firstNameData, String lastNameData, String emailData, String countryCodeData, String phoneNumberData
            , String ageData) {
        enterFirstName(firstNameData);
        enterLastName(lastNameData);
        enterEmail(emailData);
        enterCountryCode(countryCodeData);
        enterPhoneNumber(phoneNumberData);/*
        clickDenyBtn();*/
        clickOnSubmitButton();
        selectAge(ageData);
        clickContinueBtn();
    }

    public void annualParameter(String firstNameData, String lastNameData, String emailData, String countryCodeData, String phoneNumberData
            , String annualData) {
        enterFirstName(firstNameData);
        enterLastName(lastNameData);
        enterEmail(emailData);
        enterCountryCode(countryCodeData);
        enterPhoneNumber(phoneNumberData);/*
        clickDenyBtn();*/
        clickOnSubmitButton();
        selectAnnual(annualData);
        clickContinueBtn();
    }

    public void savingParameter(String firstNameData, String lastNameData, String emailData, String countryCodeData, String phoneNumberData
            , String savingData) {
        enterFirstName(firstNameData);
        enterLastName(lastNameData);
        enterEmail(emailData);
        enterCountryCode(countryCodeData);
        enterPhoneNumber(phoneNumberData);/*
        clickDenyBtn();*/
        clickOnSubmitButton();
        selectSaving(savingData);
        clickContinueBtn();
    }

    public void knowledgeParameter(String firstNameData, String lastNameData, String emailData, String countryCodeData, String phoneNumberData
            , String knowledgeData) {
        enterFirstName(firstNameData);
        enterLastName(lastNameData);
        enterEmail(emailData);
        enterCountryCode(countryCodeData);
        enterPhoneNumber(phoneNumberData);/*
        clickDenyBtn();*/
        clickOnSubmitButton();
        selectKnowledge(knowledgeData);
        clickContinueBtn();
    }

    public void selectLanguage(String languageData){
        clickElement(languageField,"Desired communication language");
        selectFromDropdown(languageField,languageData,"Desired communication language");
    }

    public void languageParameter(String firstNameData, String lastNameData, String emailData, String countryCodeData, String phoneNumberData
            , String languageData){
        enterFirstName(firstNameData);
        enterLastName(lastNameData);
        enterEmail(emailData);
        enterCountryCode(countryCodeData);
        enterPhoneNumber(phoneNumberData);/*
        clickDenyBtn();*/
        clickOnSubmitButton();
        selectLanguage(languageData);
        clickContinueBtn();
    }

    public void unsuccessfullyRegistrationWrongSMS(String firstNameData, String lastNameData, String emailData, String countryCodeData, String phoneNumberData
            , String ageData, String annualData, String savingData, String knowledgeData,String tokenField0Value
            , String tokenField1Value, String tokenField2Value,String tokenField3Value) {
        enterFirstName(firstNameData);
        enterLastName(lastNameData);
        enterEmail(emailData);
        enterCountryCode(countryCodeData);
        enterPhoneNumber(phoneNumberData);
        /*clickDenyBtn();*/
        clickOnSubmitButton();
        selectAge(ageData);
        selectAnnual(annualData);
        selectSaving(savingData);
        selectKnowledge(knowledgeData);
        incorrectToken(tokenField0Value,tokenField1Value,tokenField2Value,tokenField3Value);
        clickContinueBtn();
    }

    public void incorrectToken(String token0, String token1, String token2, String token3) {
        typeText(tokenField0, token0, "first token input field");
        typeText(tokenField1, token1, "second token input field");
        typeText(tokenField2, token2, "third token input field");
        typeText(tokenField3, token3, "fourth token input field");
    }

    public void clickEditTokenBtn(){
        clickElement(editTokenBtn,"edit token button");
    }

    public void assertURL(String url) {
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.urlContains(url));
        Assert.assertTrue(driver.getCurrentUrl().contains(url));
    }

    public void clickMenuBtn() {
        clickElement(menuBtn, "menu button");
    }

    public void checkRegulation(String regulation) throws IOException, AWTException {
        String actualText = getText(regulationMsg, "regulation text");
        ///*clickDenyBtn();*/
        switch (regulation) {
            case "FCA": {
                Assert.assertEquals(actualText, "Broker: Fortrade Ltd. (FCA)");
                new BasePage(driver).takeScreenshot("Broker Fortrade Ltd FCA - successfully registered demo account", regulationMsg);
            }
            break;
            case "cyses": {
                Assert.assertEquals(actualText, "Broker: Fortrade Cyprus Ltd. (CySec)");
                new BasePage(driver).takeScreenshot("Broker Fortrade Cyprus Ltd CySec - successfully registered demo account", regulationMsg);
            }
            break;
            case "Asic": {
                Assert.assertEquals(actualText, "Broker: Fort Securities Australia Pty Ltd. (ASIC)");
                new BasePage(driver).takeScreenshot("Broker Fort Securities Australia Pty Ltd ASIC - successfully registered demo account", regulationMsg);
            }
            break;
            case "iiroc": {
                Assert.assertEquals(actualText, "Broker: Fortrade Canada Limited (CIRO)");
                new BasePage(driver).takeScreenshot("Broker Fortrade Canada Limited CIRO - successfully registered demo account", regulationMsg);
            }
            break;
            case "FSC":
            default: {
                Assert.assertEquals(actualText, "Broker: Fortrade (Mauritius) Ltd (FSC)");
                new BasePage(driver).takeScreenshot("Broker Fortrade Mauritius Ltd FSC - successfully registered demo account", regulationMsg);
            }
            break;
        }
    }

    public void alreadyRegisteredAccount(String firstNameData, String lastNameData, String emailData, String countryCodeData, String phoneNumberData) {
        enterFirstName(firstNameData);
        enterLastName(lastNameData);
        enterEmail(emailData);
        enterCountryCode(countryCodeData);
        enterPhoneNumber(phoneNumberData);
        clickOnSubmitButton();
    }

    private String expTextForPopUp = "Invalid email. Please try another or proceed to log in. If needed, reset your password in case it's forgotten.";

    public void assertPopUpForAlreadyRegisteredAccount(String fileName) throws IOException, AWTException {
        Assert.assertEquals(getTextBy(alrdRegEmailPopUp, "alrdRegEmailPopUp"), expTextForPopUp);
        new BasePage(driver).takeScreenshot(fileName, alrdRegEmailPopUp);
    }

    public void clickConsentBtn() throws InterruptedException {
        driver.switchTo().frame(iFrameIConsent);
        try {
            clickElement(iConsentBtn, "I Consent button");
        } catch (Exception e) {
            System.out.println(e);
        }
        driver.switchTo().defaultContent();
        Thread.sleep(2500);
    }

    public void unsuccessfullyRegistrationWrongData(String firstNameData, String lastNameData, String emailData, String countryCode, String phoneNumberData) {
        enterFirstName(firstNameData);
        enterLastName(lastNameData);
        enterEmail(emailData);
        enterCountryCode(countryCode);
        enterPhoneNumber(phoneNumberData);
        clickOnSubmitButton();
    }

    public void assertErrorMessages() {
        for (int i = 1; i <= 4; i++) {
            Assert.assertEquals(getTextBy(By.xpath("(//div[@class='errorValidationIn'])[position()=number]".replace("number", String.valueOf(i))), "error message " + errorMessages[i - 1]), errorMessages[i - 1]);
        }
    }

    public void tokenIsNotReceived(String firstNameData, String lastNameData, String emailData, String countryCodeData, String phoneNumberData
            , String ageData, String annualData, String savingData, String knowledgeData){
        enterFirstName(firstNameData);
        enterLastName(lastNameData);
        enterEmail(emailData);
        enterCountryCode(countryCodeData);
        enterPhoneNumber(phoneNumberData);
        /*clickDenyBtn();*/
        clickOnSubmitButton();
        selectAge(ageData);
        selectAnnual(annualData);
        selectSaving(savingData);
        selectKnowledge(knowledgeData);
        clickElement(didNotGetToken, "I didn't get the code button");
        driverWait.until(ExpectedConditions.visibilityOf(codeIsSent));
     }

    public void assertSameNameErrorMsgs() {
        for (int i = 1; i <= 2; i++) {
            Assert.assertEquals(getTextBy(By.xpath("(//div[@class='errorValidationIn'])[position()=number]".replace("number", String.valueOf(i))), "Error message : " + sameNamesErrorMessages[i - 1]), sameNamesErrorMessages[i - 1]);
        }
    }

    /**
     * Metod assertColor koristimo za poredjenje boja input polja na formi za registraciju demo naloga
     * Izvlaci rgb vrednost i razbija ga na tri vrednosti (red, green i blue), i na osnovu vrednosti parametra koji mu
     * prosledis poredi ih sa definisanim vrednostima u metodi.
     *
     * @param color
     */
    public void assertColor(String color) {
        WebElement[] fields = {firstName, lastName, email, countryCode, phoneNumber};
        for (int i = 0; i < fields.length; i++) {
            /**
             * Ako prosledis color vrednost kao "rgb(123, 123, 132)" onda ukljuci ovaj kod
             */
            /*System.out.println("This is the border color: " + fields[i].getCssValue("border-color"));
            Assert.assertEquals(fields[i].getCssValue("border-color"), color);*/
            /**
             * U suprotnom ako uneses vrednost kao "blue" onda ukljuci ovaj kod
             */
            String borderColor = fields[i].getCssValue("border-color");
            // Split the RGB value
            String[] rgbValues = borderColor.replace("rgb(", "").replace(")", "").split(",");
            int red = Integer.parseInt(rgbValues[0].trim());
            int green = Integer.parseInt(rgbValues[1].trim());
            int blue = Integer.parseInt(rgbValues[2].trim());
            // Assert if it has a 'red' tone (adjust threshold values as needed)
            if (color.equalsIgnoreCase("red")) {
                System.out.println("This is the border color of " + fields[i].getAttribute("name") + " field: " + borderColor);
                Assert.assertTrue(red > 150 && green < 100 && blue < 100, "Border color is not approximately red.");
            } else if (color.equalsIgnoreCase("blue")) {
                System.out.println("This is the border color of " + fields[i].getAttribute("name") + " field: " + borderColor);
                Assert.assertTrue(blue > 200 && green > 100 && red < 50, "Border color is not approximately blue.");
            } else if (color.equalsIgnoreCase("green")) {
                System.out.println("This is the border color of " + fields[i].getAttribute("name") + "field: " + borderColor);
                Assert.assertTrue(green < 200 && red > 50 && red < 120 && blue > 50 && blue < 100, "Border color is not approximately green.");
            }
        }
    }

    public void assertBorderColor(WebElement element){
        String borderColor = element.getCssValue("border-color");
        System.out.println("The field border color is " + borderColor);
        Assert.assertEquals(borderColor,"rgb(255, 0, 0)");
    }

    public void checkLogoClickability(String regulation, String url) {
        if (regulation.equalsIgnoreCase("fsc") || regulation.equalsIgnoreCase("fca")
                || regulation.equalsIgnoreCase("asic")) {
            WebDriverWait driverWait = new WebDriverWait(driver, 10);
            driverWait.until(ExpectedConditions.visibilityOf(logo));
            try {
                logo.click();
                System.out.println("Logo is not clickable.");
            } catch (Exception e) {
                System.out.println("Logo is not clickable, as expected.");
            }
            assertURL(url);
            List<String> tabs = new ArrayList<>(driver.getWindowHandles());
            Assert.assertEquals(tabs.size(), 1);
        } else if (regulation.equalsIgnoreCase("iiroc")) {
            WebDriverWait driverWait = new WebDriverWait(driver, 10);
            driverWait.until(ExpectedConditions.visibilityOf(logoIiroc));
            try {
                logoIiroc.click();
                System.out.println("Logo is not clickable.");
            } catch (Exception e) {
                System.out.println("Logo is not clickable, as expected.");
            }
            assertURL(url);
            List<String> tabs = new ArrayList<>(driver.getWindowHandles());
            Assert.assertEquals(tabs.size(), 1);
        } else if (regulation.equalsIgnoreCase("cysec")) {
            WebDriverWait driverWait = new WebDriverWait(driver, 10);
            driverWait.until(ExpectedConditions.visibilityOf(logoCysec));
            try {
                logoCysec.click();
                System.out.println("Logo is not clickable.");
            } catch (Exception e) {
                System.out.println("Logo is not clickable, as expected.");
            }
            assertURL(url);
            List<String> tabs = new ArrayList<>(driver.getWindowHandles());
            Assert.assertEquals(tabs.size(), 1);
        }
    }

    public void checkCountryCodeErrorMessage( String wrongCountryCodeDataText,String regulation) {
        if(!regulation.equalsIgnoreCase("iiroc")){
            WebDriverWait driverWait = new WebDriverWait(driver, 10);
            driverWait.until(ExpectedConditions.visibilityOf(popUpNotification));
        }
        else{
            /*clickDenyBtn();*/
        }
        enterCountryCode(wrongCountryCodeDataText);
        clickElement(phoneNumber, "phone number field");
        Assert.assertEquals(getTextBy(countryCodeErrorMessage, "country code error message: " + countryCodeErrorMessage.getText())
                , "Please enter a valid country code");
    }

    public void clickOnSelectedLink(By element, String url, String document, String regulation) throws IOException, AWTException, InterruptedException {
        WebElement displayedElement = returnDisplayedElement(element);
        if (displayedElement != null) {
            clickElement(displayedElement, "link " + displayedElement.getText());
        } else {
            System.out.println("Element is not found!");
        }
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        assertURL(url);
        Thread.sleep(2000);
        takeScreenshot(document + " document - " + regulation + " regulation");
        System.out.println("This is the title of the page: " + driver.getTitle());
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    public void rightClickOnSelectedLink(By element, String url) {
        performRightClick(returnDisplayedElement(element), url, "link " + returnDisplayedElement(element).getText());
    }

    public void loginRedirection(String regulation){
        clickElementBy(alreadyHaveAnAccountLinkBy, "Already have an account?");
        }

    public void clickOnMailLink(String mailLink) {
        if (mailLink.equalsIgnoreCase("contactUs")) {
            clickElement(returnDisplayedElement(contactUsLinkBy), "contact us link");
            clickElement(returnDisplayedElement(contactUsLinkBy), "contact us link");
        } else if (mailLink.equalsIgnoreCase("support")) {
            clickElement(returnDisplayedElement(supportLinkBy), "support link");
            clickElement(returnDisplayedElement(supportLinkBy), "support link");
        }
        try {
            Thread.sleep(10000);
        } catch (Exception e){
            System.out.println(e);
        }
        Assert.assertTrue(isOutlookRunning());
    }

    public void secondStepErrorMessage(int numberOfParameters) throws InterruptedException {
        Thread.sleep(2000);
        for (int i = 1; i <= numberOfParameters; i++) {
            Assert.assertEquals(getTextBy(By.xpath("(//div[@class='errorValidation'])[position()=number]".replace("number", String.valueOf(i))),
                    "error message " + "Please select an option from the dropdown list."), "Please select an option from the dropdown list.");
        }
    }

    public void clickRegisterHere(){
        clickElement(registerHereBtn,"Register Here button");
    }

    public void checkFCAPercentages (String textForPercentages) {
        Assert.assertEquals(getText(dynamicFCAPercentages, "get FCA dynamic percentage"), textForPercentages);
        scrollToAnElement(staticFCAPercentages);
        Assert.assertEquals(getText(staticFCAPercentages, "get FCA static percentage"), textForPercentages);
    }

    public void checkCysecPercentages (String textForPercentages) {
        Assert.assertEquals(getText(dynamicCysecPercentages, "get Cysec dynamic percentage"), textForPercentages);
        scrollToAnElement(staticCysecPercentages);
        Assert.assertEquals(getText(staticCysecPercentages, "get Cysec static percentage"), textForPercentages);
    }

    public void closePersonalizeYourContent(){
        driver.switchTo().frame(iFrameIConsent);
        try {
            clickElement(closeBtnPyc,"- close personalize your content pop-up button");
        } catch (Exception e) {
            System.out.println("Could not switch to frame - " + e);
        }
        driver.switchTo().defaultContent();
    }

    public void clickUsePassBtn() {
        clickElement(usePasswordBtn, "Use Password button");
    }

    public void returnToThe1stWidget(String firstNameData, String lastNameData, String emailData, String countryCodeData
            , String phoneNumberData) {
        enterFirstName(firstNameData);
        enterLastName(lastNameData);
        enterEmail(emailData);
        enterCountryCode(countryCodeData);
        enterPhoneNumber(phoneNumberData);
        clickOnSubmitButton();
        clickEditTokenBtn();
    }

    public void newUrl(String url) {
        driver.get(url);

        if (url.contains("www.fortrade.com")){
            if (url.contains("sms")){
                try {
                    Thread.sleep(3000);
                    System.out.println("Waited 3 seconds.");
                } catch (Exception e){
                    System.out.println(e);
                }
            } else {
                driverWait.until(webDriver -> {
                    String value = webDriver.findElement(By.xpath("//input[@class='lcField FlavorRegistration']")).getAttribute("value");
                    return "quick".equals(value) || "hasStages".equals(value);
                });
                System.out.println("Waited value to contains either quick or hasStages.");
            }
        }
        WebDriverWait shortWait = new WebDriverWait(driver, 2); // fixed syntax

        try {
            WebElement element = shortWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='CybotCookiebotDialogBodyButtonDecline']")));
            element.click();
        } catch (TimeoutException e) {
            System.out.println("Element not visible within 2 seconds: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    public void clickDoNotAllowNtfBtn(){
        List<WebElement> doNotAllowBtn = driver.findElements(By.xpath("//button[contains(@class,'pushcrew-btn-close')]"));
        if(!doNotAllowBtn.isEmpty()){
            doNotAllowBtn.get(0).click();
        }
    }
}
