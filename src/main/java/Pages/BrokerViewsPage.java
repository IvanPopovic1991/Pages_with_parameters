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

public class BrokerViewsPage extends BasePage {

    public BrokerViewsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='logo-class']")  /* //div[@class='logo fcaClass belarosClass asicClass fscClass */
    public WebElement logo;

    @FindBy(xpath = "//input[@name='FirstName']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@name='LastName']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@id='EmailAddress']")
    public WebElement email;

    @FindBy(xpath = "//input[@name='Prephone']")
    public WebElement countryCode;

    @FindBy(xpath = "//input[@id='Telephone']")
    public WebElement phoneNumber;

    @FindBy(xpath = "//button[@id='main-submit-btn']")
    public WebElement submitBtn1st;

    @FindBy(xpath = "//button[@id='next-stage-btn']")
    public WebElement submitBtn;

    @FindBy(xpath = "//button[@id='CybotCookiebotDialogBodyButtonDecline']")
    public WebElement denyBtn;

    @FindBy(xpath = "//input[@id='terms']")
    public WebElement checkBox;

    @FindBy(xpath = "//span[@class='errorMessage' and text()='Please check this box to proceed.']")
    public WebElement errorMessageCheckBox;

    @FindBy(xpath = "//div[@data-cmd='menu']")
    public WebElement menuBtn;

    @FindBy(xpath = "//div[@id='platformRegulation']")
    public WebElement regulationMsg;

    @FindBy(xpath = "//span[text()='Email already exists. Please use a different email address.']")
    public WebElement alrdRegEmailMsg;

    @FindBy(xpath = "//span[text()='Must be a valid international phone number']")
    public WebElement countryCodeErrorMessage;

    @FindBy(xpath = "//a[contains(text(),'Already have an account?')]")
    public WebElement alreadyHaveAnAccount;

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

    @FindBy(xpath = "//button[@id='main-submit-btn']")
    public WebElement continueBtn;

    @FindBy(xpath = "//input[@name='Token0']")
    public WebElement tokenField0;

    @FindBy(xpath = "//input[@name='Token1']")
    public WebElement tokenField1;

    @FindBy(xpath = "//input[@name='Token2']")
    public WebElement tokenField2;

    @FindBy(xpath = "//input[@name='Token3']")
    public WebElement tokenField3;

    @FindBy(xpath = "//span[@class='smsErrorMessage']")
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

    @FindBy(xpath = "//div[@class='webSpriteIcon cross']")
    public WebElement closeBtnPyc;

    @FindBy(xpath = "//div[@class='startTradingButton']")
    public WebElement usePasswordBtn;

    @FindBy(xpath = "//button[contains(@class,'pushcrew-btn-close')]")
    public WebElement doNotAllowNtf;

    @FindBy(xpath = "//div[@class='exitButton']")
    public WebElement btnNotSerbianRes;

    public By privacyPolicyLinkBy = By.xpath("//a[text()='Privacy Policy']");

    public By termsAndConditionsLinkBy = By.xpath("//a[text()='Terms and Conditions']");

    public By clickHereLink = By.xpath("//a[text()='click here']");

    public By alreadyHaveAnAccountLinkBy = By.xpath("//a[contains(text(), 'Already have an account?')]");

    public By contactUsLinkBy = By.xpath("//a[contains(text(), 'Contact Us')]");

    public String[] errorMessages = {"Please enter all your given first name(s).",
            "Please enter your last name.",
            "Must be a valid email address.",
            "Must be a valid international phone number"};

    public String[] sameNamesErrorMessages = {"First Name and Last Name cannot be equal.",
            "First Name and Last Name cannot be equal."};

    private String expErrMsgEmail = "Email already exists. Please use a different email address.";

    public String privacyPolicyUrl = "https://www.fortrade.com/wp-content/uploads/legal/FSC/Fortrade_MA_Privacy_Policy.pdf";

    public String termsAndConditionsUrl = "https://www.fortrade.com/fortrade-mauritius-client-agreement/";

    public String howToUnsubscribeURL = "https://www.fortrade.com/wp-content/uploads/legal/How_to_guides/How_to_unsubscribe.pdf";

    public String alrHaveAccountUrl = "https://authfe.fortrade.com/oauth/account/login?appId=41fedbf7-2f03-4aac-8d1d-e11cdbb22bf8";

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

    public void clickOnSubmitBtn(){
        clickElement(submitBtn,"submit button");
    }

    public void clickFirstStepBtn(){
        clickElement(submitBtn1st,"submit button on the first step");
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

    public void selectLanguage(String languageData){
        clickElement(languageField,"Desired communication language");
        selectFromDropdown(languageField,languageData,"Desired communication language");
    }

    public void clickContinueBtn() {
        clickElement(continueBtn, "continue btn on 2nd widget");
    }

    public void clickNotSerbianRes(){
        clickElement(btnNotSerbianRes,"I am not Serbian resident");
    }

    public void clickUsePassBtn() {
        clickElement(usePasswordBtn, "Use Password button");
    }

    public void clickOnCheckBox (){
        clickElement(checkBox, "check box");
    }

    public void registerAccount1Step(String firstNameData, String lastNameData, String emailData, String countryCodeData, String phoneNumberData){
        enterFirstName(firstNameData);
        enterLastName(lastNameData);
        enterEmail(emailData);
        enterCountryCode(countryCodeData);
        enterPhoneNumber(phoneNumberData);
        clickFirstStepBtn();
    }

    public void uncheckCheckBox (String firstNameData, String lastNameData, String emailData, String countryCodeData, String phoneNumberData){
        enterFirstName(firstNameData);
        enterLastName(lastNameData);
        enterEmail(emailData);
        enterCountryCode(countryCodeData);
        enterPhoneNumber(phoneNumberData);
        clickOnCheckBox();
        clickFirstStepBtn();
    }

    public void successfullyRegistration(String firstNameData, String lastNameData, String emailData, String countryCodeData,
                                         String phoneNumberData, String ageData, String annualData, String savingData, String knowledgeData,String lang) {
        enterFirstName(firstNameData);
        enterLastName(lastNameData);
        enterEmail(emailData);
        enterCountryCode(countryCodeData);
        enterPhoneNumber(phoneNumberData);
        clickOnSubmitBtn();
        selectAge(ageData);
        selectAnnual(annualData);
        selectSaving(savingData);
        selectKnowledge(knowledgeData);
        selectLanguage(lang);
        clickContinueBtn();
    }

    public void unsuccessfullyRegistrationWrongData(String firstNameData, String lastNameData, String emailData, String countryCode, String phoneNumberData) {
        enterFirstName(firstNameData);
        enterLastName(lastNameData);
        enterEmail(emailData);
        enterCountryCode(countryCode);
        enterPhoneNumber(phoneNumberData);
        clickOnSubmitBtn();
    }

    public void unsuccessfullyRegistration(String firstNameData, String lastNameData, String emailData, String countryCodeData, String phoneNumberData
            , String ageData, String annualData, String savingData, String knowledgeData,String lang, String ageDataSelect, String annualDataSelect, String savingDataSelect, String knowledgeDataSelect, String langData) {
        enterFirstName(firstNameData);
        enterLastName(lastNameData);
        enterEmail(emailData);
        enterCountryCode(countryCodeData);
        enterPhoneNumber(phoneNumberData);
        clickOnSubmitBtn();
        selectAge(ageData);
        selectAge(ageDataSelect);
        selectAnnual(annualData);
        selectAnnual(annualDataSelect);
        selectSaving(savingData);
        selectSaving(savingDataSelect);
        selectKnowledge(knowledgeData);
        selectKnowledge(knowledgeDataSelect);
        selectLanguage(lang);
        selectLanguage(langData);
        clickContinueBtn();
    }

    public void ftsQueryParameter(String url, String firstNameData, String lastNameData, String emailData, String countryCodeData,
                                  String phoneNumberData, String ageData, String annualData, String savingData, String knowledgeData, String languageData) {
        enterFirstName(firstNameData);
        enterLastName(lastNameData);
        enterEmail(emailData);
        enterCountryCode(countryCodeData);
        enterPhoneNumber(phoneNumberData);
        clickOnSubmitBtn();
        selectAge(ageData);
        selectAnnual(annualData);
        selectSaving(savingData);
        selectKnowledge(knowledgeData);
        if (url.contains("plang:all")){
            selectLanguage(languageData);
        }
        clickContinueBtn();
    }

    public void ageParameter(String firstNameData, String lastNameData, String emailData, String countryCodeData, String phoneNumberData
            , String ageData) {
        enterFirstName(firstNameData);
        enterLastName(lastNameData);
        enterEmail(emailData);
        enterCountryCode(countryCodeData);
        enterPhoneNumber(phoneNumberData);
        clickOnSubmitBtn();
        selectAge(ageData);
        clickContinueBtn();
    }

    public void annualParameter(String firstNameData, String lastNameData, String emailData, String countryCodeData, String phoneNumberData
            , String annualData) {
        enterFirstName(firstNameData);
        enterLastName(lastNameData);
        enterEmail(emailData);
        enterCountryCode(countryCodeData);
        enterPhoneNumber(phoneNumberData);
        clickOnSubmitBtn();
        selectAnnual(annualData);
        clickContinueBtn();
    }

    public void savingParameter(String firstNameData, String lastNameData, String emailData, String countryCodeData, String phoneNumberData
            , String savingData) {
        enterFirstName(firstNameData);
        enterLastName(lastNameData);
        enterEmail(emailData);
        enterCountryCode(countryCodeData);
        enterPhoneNumber(phoneNumberData);
        clickOnSubmitBtn();
        selectSaving(savingData);
        clickContinueBtn();
    }

    public void knowledgeParameter(String firstNameData, String lastNameData, String emailData, String countryCodeData, String phoneNumberData
            , String knowledgeData) {
        enterFirstName(firstNameData);
        enterLastName(lastNameData);
        enterEmail(emailData);
        enterCountryCode(countryCodeData);
        enterPhoneNumber(phoneNumberData);
        clickOnSubmitBtn();
        selectKnowledge(knowledgeData);
        clickContinueBtn();
    }

    public void languageParameter(String firstNameData, String lastNameData, String emailData, String countryCodeData, String phoneNumberData
            , String languageData){
        enterFirstName(firstNameData);
        enterLastName(lastNameData);
        enterEmail(emailData);
        enterCountryCode(countryCodeData);
        enterPhoneNumber(phoneNumberData);
        clickOnSubmitBtn();
        selectLanguage(languageData);
        clickContinueBtn();
    }

    public void incorrectToken(String token0, String token1, String token2, String token3) {
        typeText(tokenField0, token0, "first token input field");
        typeText(tokenField1, token1, "second token input field");
        typeText(tokenField2, token2, "third token input field");
        typeText(tokenField3, token3, "fourth token input field");
    }

    public void unsuccessfullyRegistrationWrongSMS(String firstNameData, String lastNameData, String emailData, String countryCodeData, String phoneNumberData
            , String ageData, String annualData, String savingData, String knowledgeData,String lang, String tokenField0Value
            , String tokenField1Value, String tokenField2Value,String tokenField3Value) {
        enterFirstName(firstNameData);
        enterLastName(lastNameData);
        enterEmail(emailData);
        enterCountryCode(countryCodeData);
        enterPhoneNumber(phoneNumberData);
        clickOnSubmitBtn();
        selectAge(ageData);
        selectAnnual(annualData);
        selectSaving(savingData);
        selectKnowledge(knowledgeData);
        selectLanguage(lang);
        incorrectToken(tokenField0Value,tokenField1Value,tokenField2Value,tokenField3Value);
        clickContinueBtn();
    }

    public void clickEditTokenBtn(){
        clickElement(editTokenBtn,"edit token button");
    }

    public void assertURL(String url) {
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.urlContains(url));
        Assert.assertTrue(driver.getCurrentUrl().contains(url));
    }

    public void checkRegulation() throws IOException, AWTException, InterruptedException {
        clickNotSerbianRes();
        Thread.sleep(2000);
        clickUsePassBtn();
        clickMenuBtn();
        String actualText = getText(regulationMsg, "regulation text");
        Assert.assertEquals(actualText, "Broker: Fortrade (Mauritius) Ltd (FSC)");
    }

    public void clickMenuBtn() {
        clickElement(menuBtn, "menu button");
    }

    public void alreadyRegisteredAccount(String firstNameData, String lastNameData, String emailData, String countryCodeData, String phoneNumberData) {
        enterFirstName(firstNameData);
        enterLastName(lastNameData);
        enterEmail(emailData);
        enterCountryCode(countryCodeData);
        enterPhoneNumber(phoneNumberData);
        clickOnSubmitBtn();
    }

    public void assertPopUpForAlreadyRegisteredAccount() throws IOException, AWTException {
        Assert.assertEquals(getTextBy(alrdRegEmailMsg, "error message for already used email"), expErrMsgEmail);
    }

    public void assertErrorMessages() {
        for (int i = 1; i <= 4; i++) {
            Assert.assertEquals(getTextBy(By.xpath("(//span[@class='errorMessage'])[position()=number]".replace("number", String.valueOf(i))), "error message " + errorMessages[i - 1]), errorMessages[i - 1]);
        }
    }

    public void assertSameNameErrorMsgs() {
        for (int i = 1; i <= 2; i++) {
            Assert.assertEquals(getTextBy(By.xpath("(//span[@class='errorMessage'])[position()=number]".replace("number", String.valueOf(i))), "Error message : " + sameNamesErrorMessages[i - 1]), sameNamesErrorMessages[i - 1]);
        }
    }

    public void tokenIsNotReceived(String firstNameData, String lastNameData, String emailData, String countryCodeData, String phoneNumberData
            , String ageData, String annualData, String savingData, String knowledgeData){
        enterFirstName(firstNameData);
        enterLastName(lastNameData);
        enterEmail(emailData);
        enterCountryCode(countryCodeData);
        enterPhoneNumber(phoneNumberData);
        clickOnSubmitBtn();
        selectAge(ageData);
        selectAnnual(annualData);
        selectSaving(savingData);
        selectKnowledge(knowledgeData);
        clickElement(didNotGetToken, "I didn't get the code button");
        driverWait.until(ExpectedConditions.visibilityOf(codeIsSent));
    }

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

    public void checkCountryCodeErrorMessage(String wrongCountryCodeDataText) {
        enterCountryCode(wrongCountryCodeDataText);
        clickElement(phoneNumber, "phone number field");
        Assert.assertEquals(getTextBy(countryCodeErrorMessage, "country code error message: " + countryCodeErrorMessage.getText())
                , "Must be a valid international phone number");
    }

    public void clickOnSelectedLink(By element, String url, String document) throws IOException, AWTException, InterruptedException {
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
        takeScreenshot(document + " document - Penny Stocks");
        System.out.println("This is the title of the page: " + driver.getTitle());
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    public void rightClickOnSelectedLink(By element, String url) {
        performRightClick(returnDisplayedElement(element), url, "link " + returnDisplayedElement(element).getText());
    }

    public void loginRedirection(){
        clickElementBy(alreadyHaveAnAccountLinkBy, "Already have an account?");
    }

    public void secondStepErrorMessage(int numberOfParameters) throws InterruptedException {
        Thread.sleep(2000);
        for (int i = 1; i <= numberOfParameters; i++) {
            Assert.assertEquals(getTextBy(By.xpath("(//span[@class='selectErrorMessage'])[position()=number]".replace("number", String.valueOf(i))),
                    "error message " + "Please select an option from the dropdown list."), "Please select an option from the dropdown list.");
        }
    }

    public void returnToThe1stWidget(String firstNameData, String lastNameData, String emailData, String countryCodeData
            , String phoneNumberData) {
        enterFirstName(firstNameData);
        enterLastName(lastNameData);
        enterEmail(emailData);
        enterCountryCode(countryCodeData);
        enterPhoneNumber(phoneNumberData);
        clickOnSubmitBtn();
        clickEditTokenBtn();
    }

    public void checkLogoClickability(String url) {
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
    }
}
