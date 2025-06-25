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
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FortradeRPage extends BasePage {
    public FortradeRPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "FirstName")
    public WebElement firstName;

    @FindBy(id = "LastName")
    public WebElement lastName;

    @FindBy(xpath = "(//div[@class='LcWidgetTopWrapper ClField-Email lcFieldWrapper']//input[@name='Email'])[position()=2]")
    public WebElement email;

    @FindBy(xpath = "//input[@name='PhoneCountryCode']")
    public WebElement countryCode;

    @FindBy(xpath = "//div[@class='phoneWrapper']//input[@placeholder='Phone']")
    public WebElement phoneNumber;

    //This is only for Door page
    /*@FindBy(xpath = "//div[@name='Send']")
    public WebElement submitButton;*/

    @FindBy(xpath = "//input[contains(@class,'Send-Button') and @name='Send']")
    public WebElement submitButton;

    @FindBy(xpath = "//div[@class='userExistsLabelInner']")
    public WebElement alrdRegEmailPopUp;

    @FindBy(xpath = "(//div[@class='errorValidationIn'])[last()]")
    public WebElement countryCodeErrorMessage;

    @FindBy(xpath = "//div[contains(@class,'logo')]")
    public WebElement fortradeLogo;

    @FindBy(xpath = "//div[@class='alreadyHaveAcc']//a[contains(text(),'Already have an account?')]")
    public WebElement loginToFortrade;

    @FindBy(xpath = "//div[@class='LcWidgetTopWrapper ClField-Age lcFieldWrapper']//select")
    public WebElement age;

    @FindBy(xpath = "//div[@class='LcWidgetTopWrapper ClField-EstimatedAnnualIncome lcFieldWrapper']//select")
    public WebElement annual;

    @FindBy(xpath = "//div[@class='LcWidgetTopWrapper ClField-ValueOfSavingAndInvestments lcFieldWrapper']//select")
    public WebElement saving;

    @FindBy(xpath = "//div[@class='LcWidgetTopWrapper ClField-KnowledgeOfTrading lcFieldWrapper']//select")
    public WebElement knowledge;

    /*@FindBy(xpath = "//div[@name='ContinueBtn']"*//*"//input[@class='ContinueBtn-Submit']"*//*)
    public WebElement continueBtn;*/

    @FindBy(xpath = "//input[@class='ContinueBtn-Submit']")
    public WebElement continueBtn;

    @FindBy(xpath = "//div[@data-cmd='menu']")
    public WebElement menuBtn;

    @FindBy(xpath = "//div[@id='platformRegulation']")
    public WebElement regulationMsg;

    @FindBy(xpath = "//input[@name='Token0']")
    public WebElement tokenField0;

    @FindBy(xpath = "//input[@name='Token1']")
    public WebElement tokenField1;

    @FindBy(xpath = "//input[@name='Token2']")
    public WebElement tokenField2;

    @FindBy(xpath = "//input[@name='Token3']")
    public WebElement tokenField3;

    @FindBy(xpath="//input[@class='TokenBack-Button']")
    public WebElement didNotGetToken;

    @FindBy(xpath = "//label[@name='SentAgainLabel']")
    public WebElement codeIsSent;

    @FindBy(xpath = "//div[@class='formErrorMessage']")
    public WebElement incorrectTokenMsg;

    @FindBy(xpath="//input[@id='Details-Edit-Btn']")
    public WebElement editTokenBtn;

    @FindBy(xpath = "//div[@class='nav-button' and text()='Get Started']")
    public WebElement getStartedBtn;

    /*@FindBy(xpath = "//select[@name='LinkId']")
    public WebElement languageField;*/

    @FindBy(xpath = "//div[@class='LcWidgetTopWrapper ClField-PreferredLanguage lcFieldWrapper']//select")
    public WebElement languageField;

    @FindBy(xpath = "//div[@class='nav-button' and contains(text(),'Register Here')]")
    public WebElement registerHereBtn;

    @FindBy(xpath = "//button[@id='CybotCookiebotDialogBodyButtonDecline']")
    public WebElement denyBtn;

    @FindBy(xpath = "//div[@class='exitButton']")
    public WebElement iAmNotSerbianRes;

    @FindBy(xpath = "//div[@class='startTradingButton']")
    protected WebElement usePasswordBtn;

    /*@FindBy(xpath = "//div[@class='needHelpDiv']/div[@class='alreadyHaveAcc']//a[contains(text(), 'Already have an account?')]")
    public WebElement alreadyHaveAnAccountLink;*/

    @FindBy(xpath = "//div[@class='alreadyHaveAcc']//a[contains(text(), 'Already have an account?')]")
    public WebElement alreadyHaveAnAccountLink;

    public By privacyPolicyLinkBy = By.xpath("//*[contains(@class, 'MarketingMaterials')]//a[contains(text(), 'Privacy Policy')]");

    public By termsAndConditionsLinkBy = By.xpath("//*[contains(@class, 'MarketingMaterials')]//a[contains(text(), 'Terms and Conditions')]");

    public By clickHereLinkBy = By.xpath("//*[contains(@class, 'MarketingMaterials')]//a[text()='click here']");

/*
    public By contactUsLinkBy = By.xpath("//div[@class='needHelpDiv']/div/a[contains(text(), 'Contact Us')]");
*/

    public By contactUsLinkBy = By.xpath("//div[@class='needHelp']/a[contains(text(), 'Contact Us')]");

    public By facebookLinkBy = By.xpath("//a[@href='https://www.facebook.com/Fortrade.International']");

    public By instagramLinkBy = By.xpath("//a[@href='https://www.instagram.com/fortrade_online_trading/?hl=en']");

    public By youtubeLinkBy = By.xpath("//a[@href='https://www.youtube.com/channel/UCNCrGhrDTEN1Hx_20-kFxwg']");

    public By infoLinkBy = By.xpath("//div[@class='col-md-12 text-center']//a[text()='info@fortrade.com']");

    public By supportLinkBy = By.xpath("//a[text()='support@fortrade.com']");

    public By footerPrivacyPolicyLinkBy = By.xpath("//div[@class='fscClass']//a[contains(text(),'Privacy policy')]");

    public By fscRegulationLinkBy = By.xpath("//a[text()=' GB21026472']");


    String[] errorMessages = {"Please enter all your given first name(s)",
            "Please enter your last name in alphabetic characters",
            "Invalid email format.",
            "Invalid phone format."};

    String[] sameNamesErrorMessages = {"Your first name must be different from your last name",
            "Your first name must be different from your last name"};

    // Privacy Policy document link
    public String privacyPolicyFSC = "https://www.fortrade.com/fortrade-ma-privacy-policy/";

    // Terms and conditions document link
    public String termsAndConditionsFSC = "https://www.fortrade.com/fortrade-mauritius-client-agreement/";

    //How to unsubscribe document link
    public String howToUnsubscribeURL = "https://www.fortrade.com/wp-content/uploads/legal/How_to_guides/How_to_unsubscribe.pdf";

    // Already have an account link
    public String alrHaveAccount = "https://pro.fortrade.com/";

    // Privacy policy document Footer link
    public String privacyPolicyFSCFooter = "https://www.fortrade.com/wp-content/uploads/legal/FSC/Fortrade_MA_Privacy_Policy.pdf";

    // Financial Services Commission, Mauritius (FSC) link
    public String fscLink = "https://opr.fscmauritius.org/ords/opr/r/fsc-opr/fsc-online-public-register-opr";

    public String fbURL = "https://www.facebook.com/Fortrade.International";

    public String insURL = "https://www.instagram.com/fortrade_online_trading/?hl=en";

    public String ytURL = "https://www.youtube.com/channel/UCNCrGhrDTEN1Hx_20-kFxwg";

    public void enterFirstName(String firstNameData) {
        typeText(firstName, firstNameData, "first name");
    }

    public void enterLastName(String lastNameData) {
        typeText(lastName, lastNameData, "last name");
    }

    public void enterEmail(String emailData) {
        typeText(email, emailData, "email");
    }

    public void enterCountryCode(String countryCodeData) {
        typeText(countryCode, countryCodeData, "country code");
    }

    public void enterPhoneNumber(String phoneNumberData) {
        typeText(phoneNumber, phoneNumberData, "phone number");
    }

    public void clickSubmitButton() {
        clickElement(submitButton, "get started button");
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
        clickElement(continueBtn, "continue button");
    }

    public void clickMenuBtn() {
        clickElement(menuBtn, "menu button");
    }

    public void successfullyRegistration(String firstNameData, String lastNameData, String emailData, String countryCodeData, String phoneNumberData
            , String ageData, String annualData, String savingData, String knowledgeData) {
        enterFirstName(firstNameData);
        enterLastName(lastNameData);
        enterEmail(emailData);
        enterCountryCode(countryCodeData);
        enterPhoneNumber(phoneNumberData);
        clickSubmitButton();
        selectAge(ageData);
        selectAnnual(annualData);
        selectSaving(savingData);
        selectKnowledge(knowledgeData);
        clickContinueBtn();
        /*clickDenyBtn();*/
        clickNotSerbResBtn();
        clickUsePassBtn();
        clickMenuBtn();
    }

    public void ftsQueryParameter(String url, String firstNameData, String lastNameData, String emailData, String countryCodeData,
                                  String phoneNumberData, String ageData, String annualData, String savingData, String knowledgeData, String languageData) {
        enterFirstName(firstNameData);
        enterLastName(lastNameData);
        enterEmail(emailData);
        enterCountryCode(countryCodeData);
        enterPhoneNumber(phoneNumberData);
        /*clickDenyBtn();*/
        clickSubmitButton();
        selectAge(ageData);
        selectAnnual(annualData);
        selectSaving(savingData);
        selectKnowledge(knowledgeData);
        if (url.contains("plang:all")){
            selectLanguage(languageData);
        }
        clickContinueBtn();
        /*clickDenyBtn();*/
        clickNotSerbResBtn();
        clickUsePassBtn();
        clickMenuBtn();
    }

    public void unsuccessfullyRegistration(String firstNameData, String lastNameData, String emailData, String countryCodeData, String phoneNumberData
            , String ageData, String annualData, String savingData, String knowledgeData, String ageDataSelect, String annualDataSelect, String savingDataSelect, String knowledgeDataSelect) {
        enterFirstName(firstNameData);
        enterLastName(lastNameData);
        enterEmail(emailData);
        enterCountryCode(countryCodeData);
        enterPhoneNumber(phoneNumberData);
        clickSubmitButton();
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
        enterPhoneNumber(phoneNumberData);
        clickSubmitButton();
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
        clickSubmitButton();
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
        clickSubmitButton();
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
        clickSubmitButton();
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
        enterPhoneNumber(phoneNumberData);
        clickSubmitButton();
        selectLanguage(languageData);
        clickContinueBtn();
    }

    public void unsuccessfullyRegistrationWithWrongData(String firstNameData, String lastNameData, String emailData, String countryCode, String phoneNumberData) {
        enterFirstName(firstNameData);
        enterLastName(lastNameData);
        enterEmail(emailData);
        enterCountryCode(countryCode);
        enterPhoneNumber(phoneNumberData);
        clickSubmitButton();
    }

    public void unsuccessfullyRegistrationWrongSMS(String firstNameData, String lastNameData, String emailData, String countryCodeData, String phoneNumberData
            , String ageData, String annualData, String savingData, String knowledgeData,String tokenField0Value
            , String tokenField1Value, String tokenField2Value,String tokenField3Value) {
        enterFirstName(firstNameData);
        enterLastName(lastNameData);
        enterEmail(emailData);
        enterCountryCode(countryCodeData);
        enterPhoneNumber(phoneNumberData);
        clickSubmitButton();
        selectAge(ageData);
        selectAnnual(annualData);
        selectSaving(savingData);
        selectKnowledge(knowledgeData);
        incorrectToken(tokenField0Value,tokenField1Value,tokenField2Value,tokenField3Value);
        clickContinueBtn();
    }

    public void tokenIsNotReceived(String firstNameData, String lastNameData, String emailData, String countryCodeData, String phoneNumberData
            , String ageData, String annualData, String savingData, String knowledgeData){
        enterFirstName(firstNameData);
        enterLastName(lastNameData);
        enterEmail(emailData);
        enterCountryCode(countryCodeData);
        enterPhoneNumber(phoneNumberData);
        clickSubmitButton();
        selectAge(ageData);
        selectAnnual(annualData);
        selectSaving(savingData);
        selectKnowledge(knowledgeData);
        clickElement(didNotGetToken, "I didn't get the code button");
        driverWait.until(ExpectedConditions.visibilityOf(codeIsSent));
    }

    public void clickEditTokenBtn(){
        clickElement(editTokenBtn,"Edit token button");
    }
    /**
     * Izvlaci tekst iz DOM-a i poredi ih sa ocekivanim porukama definisanih u nizu errorMessages
     */
    public void assertErrorMessages() {
        for (int i = 1; i <= 4; i++) {
            Assert.assertEquals(getTextBy(By.xpath("(//div[@class='errorValidationIn'])[position()=number]".replace("number", String.valueOf(i))),
                    "error message " + errorMessages[i - 1]), errorMessages[i - 1]);
        }
    }

    public void assertSameNameErrorMsgs() {
        for (int i = 1; i <= 2; i++) {
            Assert.assertEquals(getTextBy(By.xpath("(//div[@class='errorValidationIn'])[position()=number]".replace("number", String.valueOf(i))),
                    "error message " + sameNamesErrorMessages[i - 1]), sameNamesErrorMessages[i - 1]);
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
                System.out.println("This is the border color of " + fields[i].getAttribute("name") + " field: " + borderColor);
                Assert.assertTrue(green < 200 && red > 50 && red < 120 && blue > 50 && blue < 100, "Border color is not approximately green.");
            }
        }
    }

    public void assertBorderColor(WebElement element){
        String borderColor = element.getCssValue("border-color");
        System.out.println("The field border color is " + borderColor);
        Assert.assertEquals(borderColor,"rgb(255, 0, 0)");
    }

    public void assertURL(String url) {
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.urlContains(url));
        Assert.assertTrue(driver.getCurrentUrl().contains(url));
    }

    public void checkRegulation() throws IOException, AWTException {
        String actualText = getText(regulationMsg, "regulation text");
        Assert.assertEquals(actualText, "Broker: Fortrade (Mauritius) Ltd (FSC)");
        new BasePage(driver).takeScreenshot("Broker Fortrade Mauritius Ltd FSC - successfully registered demo account - FortradeR", regulationMsg);
    }

    public void alreadyRegisteredAccount(String firstNameData, String lastNameData, String emailData, String countryCodeData, String phoneNumberData) {
        enterFirstName(firstNameData);
        enterLastName(lastNameData);
        enterEmail(emailData);
        enterCountryCode(countryCodeData);
        enterPhoneNumber(phoneNumberData);
        clickSubmitButton();
    }

    private String expTextForPopUp = "Invalid email. Please try another or proceed to log in. If needed, reset your " +
            "password in case it's forgotten.";

    public void assertPopUpForAlreadyRegisteredAccount(String fileName) throws IOException, AWTException {
        Assert.assertEquals(getTextBy(alrdRegEmailPopUp, "alrdRegEmailPopUp"), expTextForPopUp);
        new BasePage(driver).takeScreenshot(fileName, alrdRegEmailPopUp);
    }

    public void checkLogoClickability(String url) {
        driverWait.until(ExpectedConditions.visibilityOf(fortradeLogo));
        try {
            fortradeLogo.click();
            System.out.println("Logo is not clickable.");
        } catch (Exception e) {
            System.out.println("Logo is not clickable, as expected.");
        }
        assertURL(url);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        Assert.assertEquals(tabs.size(), 1);
    }

    /*
    This method accept instance of Robot class and text. It breaks String to a character, call the method for convert
     a character into a number (keyCode) and type one by one character into the field (for example click on field and call
      this typeString method)
     */
    public void typeString(Robot robot, String text) {
        for (char c : text.toCharArray()) {
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
            if (KeyEvent.CHAR_UNDEFINED != keyCode) {
                robot.keyPress(keyCode);
                robot.keyRelease(keyCode);
            }
        }
    }

    public void checkCountryCodeErrorMessage(String wrongCountryCodeDataText) {
        clickElement(countryCode, "country code field");
        try {
            Robot robot = new Robot();
            typeString(robot, wrongCountryCodeDataText);
            clickElement(phoneNumber, "phone number field");
            Assert.assertEquals(getTextBy(countryCodeErrorMessage, "country code error message: " + countryCodeErrorMessage.getText())
                    , "Please enter a valid country code");
        } catch (Exception e) {
            System.out.println(e);
        }
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
        takeScreenshot(document + " document - FortradeR");
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    public void clickOnMailLink(String mailLink) {
        if (mailLink.equalsIgnoreCase("contactUs")) {
            clickElementBy(contactUsLinkBy, "contact us link");
        } else if (mailLink.equalsIgnoreCase("info")) {
            clickElementBy(infoLinkBy, "info link");
        } else if (mailLink.equalsIgnoreCase("support")) {
            clickElementBy(supportLinkBy, "support link");
        }
        Assert.assertTrue(isOutlookRunning());
    }

    public void rightClickOnMailLink(String mailLink) {
        if (mailLink.equalsIgnoreCase("contactUs")) {
            performRightClickForMailLink(driver.findElement(contactUsLinkBy), "contact us link");
        } else if (mailLink.equalsIgnoreCase("info")) {
            performRightClickForMailLink(driver.findElement(infoLinkBy), "info link");
        } else if (mailLink.equalsIgnoreCase("support")) {
            performRightClickForMailLink(driver.findElement(supportLinkBy), "support link");
        }
        Assert.assertTrue(isOutlookRunning());
    }

    public void rightClickOnSelectedLink(By element, String url) {
        performRightClick(returnDisplayedElement(element), url, "link" + returnDisplayedElement(element).getText());
    }

    public void loginRedirection() {
        clickElement(alreadyHaveAnAccountLink, "An already have account?");
    }

    public void incorrectToken(String token0, String token1, String token2, String token3) {
        typeText(tokenField0, token0, "first token input field");
        typeText(tokenField1, token1, "second token input field");
        typeText(tokenField2, token2, "third token input field");
        typeText(tokenField3, token3, "fourth token input field");
    }

    public void clickGetStartedBtn(){
        clickElement(getStartedBtn,"Get started button");
    }

    public void secondStepErrorMessage(int numberOfParameters) throws InterruptedException {
        Thread.sleep(2000);
        for (int i = 1; i <= numberOfParameters; i++) {
            Assert.assertEquals(getTextBy(By.xpath("(//div[@class='errorValidationIn'])[position()=number]".replace("number", String.valueOf(i))),
                    "error message " + "Please select an option from the dropdown list."), "Please select an option from the dropdown list.");
        }
    }

    public void clickRegisterHere(){
        clickElement(registerHereBtn,"Register Here button");
    }

    public void clickDenyBtn() {
        clickElement(denyBtn, "deny cookies button");
    }

    public void clickNotSerbResBtn(){
        clickElement(iAmNotSerbianRes,"I am not Serbian resident button");
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
        clickSubmitButton();
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
}
