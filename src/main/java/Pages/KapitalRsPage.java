package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KapitalRsPage extends BasePage {
    public KapitalRsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class,'logo')]")
    public WebElement logo;

    @FindBy(xpath = "//input[@name='FirstName']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@name='LastName']")
    public WebElement lastName;

    @FindBy(xpath = "//div[@class='LcWidgetTopWrapper ClField-Email lcFieldWrapper']//input[@name='Email']")
    public WebElement email;

    @FindBy(xpath = "//input[@name='PhoneCountryCode']")
    public WebElement countryCode;

    @FindBy(xpath = "//input[@name='Phone']")
    public WebElement phoneNumber;

    @FindBy(xpath = "//input[contains(@class,'Send-Button') and @name='Send']")
    public WebElement submitBtn;

    @FindBy(xpath = "//div[@class='alreadyHaveAcc']//a[contains(text(),'Već imate nalog?')]")
    public WebElement login;

    @FindBy(xpath = "//div[@data-cmd='menu']")
    public WebElement menuBtn;

    @FindBy(xpath = "//div[@id='platformRegulation']")
    public WebElement regulationMsg;

    @FindBy(xpath = "//div[@class='userExistsLabelInner']")
    public WebElement alrdRegEmailPopUp;

    @FindBy(xpath = "//iframe[@id='myWidgetIframe']")
    public WebElement iFrameIConsent;

    @FindBy(xpath = "//div[@class='LcWidgetTopWrapper ClField-Age lcFieldWrapper']//select")
    public WebElement age;

    @FindBy(xpath = "//div[@class='LcWidgetTopWrapper ClField-EstimatedAnnualIncome lcFieldWrapper']//select")
    public WebElement annual;

    @FindBy(xpath = "//div[@class='LcWidgetTopWrapper ClField-ValueOfSavingAndInvestments lcFieldWrapper']//select")
    public WebElement saving;

    @FindBy(xpath = "//div[@class='LcWidgetTopWrapper ClField-KnowledgeOfTrading lcFieldWrapper']//select")
    public WebElement knowledge;

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

    @FindBy(xpath = "//input[@class='TokenBack-Button']")
    public WebElement didNotGetToken;

    @FindBy(xpath = "//label[@name='SentAgainLabel']")
    public WebElement codeIsSent;

    @FindBy(xpath = "//input[@id='Details-Edit-Btn']")
    public WebElement editTokenBtn;

    @FindBy(xpath = "//select[@name='LinkId']")
    public WebElement languageField;

    @FindBy(xpath = "(//div[@class='errorValidationIn'])[last()]")
    public WebElement countryCodeErrorMessage;

    public By privacyPolicyLinkBy = By.xpath("//*[contains(@class, 'MarketingMaterials')]//a[text()='Politiku privatnosti']");

    public By termsAndConditionsLinkBy = By.xpath("//*[contains(@class, 'MarketingMaterials')]//a[contains(text(), 'Uslove i odredbe')]");

    public By clickHereLink = By.xpath("//*[contains(@class, 'MarketingMaterials')]//a[text()='kliknite ovde']");

    public By fcaRegulationLinkBy = By.xpath("//a[text()='609970']");

    public By asicRegulationLinkBy = By.xpath("//a[text()='493520']");

    public By fscRegulationLinkBy = By.xpath("//a[text()='GB21026472']");

    public By footerRiskWarningLinkBy = By.xpath("//a[contains(text(), 'Upozorenje o riziku')]");

    public By footerPrivacyPolicyLinkBy = By.xpath("//a[contains(text(), 'Politika o zaštiti privatnosti')]");

    public By alreadyHaveAnAccountLinkBy = By.xpath("//*[@class='alreadyHaveAcc']//a[contains(text(), 'Već imate nalog?')]");

    public By contactUsLinkBy = By.xpath("//*[@class='needHelp']//a[contains(text(), 'Kontakt')]");

    // Privacy Policy document link
    public String privacyPolicyFSC = "https://www.fortrade.com/wp-content/uploads/legal/FSC/Fortrade_MA_Privacy_Policy.pdf";

    // Terms and conditions document link
    public String termsAndConditionsFSC = "https://www.fortrade.com/wp-content/uploads/legal/FSC/Fortrade_Mauritius_Client_Agreement.pdf";

    // Privacy policy document Footer link
    public String privacyPolicyFSCFooter = "https://www.fortrade.com/wp-content/uploads/legal/FSC/Fortrade_MA_Privacy_Policy.pdf";

    // Footer risk warning link
    public String footerRiskWarning= "https://www.fortrade.com/wp-content/uploads/legal/FSC/Fortrade_MA_Risk_Disclosure.pdf";

    String[] errorMessages = {"Ime nije uneto u ispravnom formatu",
            "Prezime nije uneto u ispravnom formatu",
            "Nevažeći format imejla.",
            "Nevažeći format telefona."
    };

    String[] sameNamesErrorMessages = {
            "Vaše ime mora da se razlikuje od vašeg prezimena.",
            "Vaše ime mora da se razlikuje od vašeg prezimena."
    };

    public String howToUnsubscribeURL = "https://www.fortrade.com/wp-content/uploads/legal/How_to_guides/How_to_unsubscribe.pdf";

    // Already have an account
    public String alrHaveAccount = "https://ready.fortrade.com/";

    // Financial Conduct Authority (FCA) link
    public String fcaLink = "https://register.fca.org.uk/s/firm?id=001b000000NMdUwAAL";

    // Australian Securities and Investments Commission (ASIC) link
    public String asicLink = "https://asic.gov.au/online-services/service-availability/";

    // Financial Services Commission, Mauritius (FSC) link
    public String fscLink = "https://www.fscmauritius.org/en/supervision/register-of-licensees/register-of-licensees-details?licence_no=GB21026472&key=&cat=_GB&code=";

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
            clickElement(submitBtn, "Get Started button");
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
    }

    public void successfullyRegistration(String firstNameData, String lastNameData, String emailData, String countryCodeData,
             String phoneNumberData, String ageData, String annualData, String savingData, String knowledgeData) {
        enterFirstName(firstNameData);
        enterLastName(lastNameData);
        enterEmail(emailData);
        enterCountryCode(countryCodeData);
        enterPhoneNumber(phoneNumberData);
        clickOnSubmitButton();
        selectAge(ageData);
        selectAnnual(annualData);
        selectSaving(savingData);
        selectKnowledge(knowledgeData);
        clickContinueBtn();
    }

    public void unsuccessfullyRegistration(String firstNameData, String lastNameData, String emailData, String countryCodeData, String phoneNumberData
            , String ageData, String annualData, String savingData, String knowledgeData, String ageDataSelect, String annualDataSelect, String savingDataSelect, String knowledgeDataSelect) {
        enterFirstName(firstNameData);
        enterLastName(lastNameData);
        enterEmail(emailData);
        enterCountryCode(countryCodeData);
        enterPhoneNumber(phoneNumberData);
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
        enterPhoneNumber(phoneNumberData);
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
        enterPhoneNumber(phoneNumberData);
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
        enterPhoneNumber(phoneNumberData);
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
        enterPhoneNumber(phoneNumberData);
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
        enterPhoneNumber(phoneNumberData);
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

    public void checkRegulation() throws IOException, AWTException {
        clickMenuBtn();
        String actualText = getText(regulationMsg, "regulation text");
        Assert.assertEquals(actualText, "Broker: Fortrade (Mauritius) Ltd (FSC)");
        new BasePage(driver).takeScreenshot("Broker Fortrade Mauritius Ltd FSC - successfully registered demo account", regulationMsg);
    }

    public void alreadyRegisteredAccount(String firstNameData, String lastNameData, String emailData, String countryCodeData, String phoneNumberData) {
        enterFirstName(firstNameData);
        enterLastName(lastNameData);
        enterEmail(emailData);
        enterCountryCode(countryCodeData);
        enterPhoneNumber(phoneNumberData);
        clickOnSubmitButton();
    }

    private String expTextForPopUp = "Nevažeći imejl. Pokušajte sa drugim ili nastavite sa prijavljivanjem. Ako je potrebno, poništite lozinku u slučaju da ste je zaboravili.";

    public void assertPopUpForAlreadyRegisteredAccount(String fileName) throws IOException, AWTException {
        Assert.assertEquals(getTextBy(alrdRegEmailPopUp, "alrdRegEmailPopUp"), expTextForPopUp);
        new BasePage(driver).takeScreenshot(fileName, alrdRegEmailPopUp);
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
            Assert.assertEquals(getTextBy(By.xpath("(//div[@class='errorValidation'])[position()=number]".replace("number", String.valueOf(i))), "error message " + errorMessages[i - 1]), errorMessages[i - 1]);
        }
    }

    public void secondStepErrorMessage(int numberOfParameters) throws InterruptedException {
        Thread.sleep(2000);
        for (int i = 1; i <= numberOfParameters; i++) {
            Assert.assertEquals(getTextBy(By.xpath("(//div[@class='errorValidation'])[position()=number]".replace("number", String.valueOf(i))),
                    "error message " + "Molimo Vas izaberite odgovarajuću opciju iz padajuće liste"), "Molimo Vas izaberite odgovarajuću opciju iz padajuće liste");
        }
    }

    public void tokenIsNotReceived(String firstNameData, String lastNameData, String emailData, String countryCodeData, String phoneNumberData
            , String ageData, String annualData, String savingData, String knowledgeData){
        enterFirstName(firstNameData);
        enterLastName(lastNameData);
        enterEmail(emailData);
        enterCountryCode(countryCodeData);
        enterPhoneNumber(phoneNumberData);
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
            Assert.assertEquals(getTextBy(By.xpath("(//div[@class='errorValidation'])[position()=number]".replace("number", String.valueOf(i))), "Error message : " + sameNamesErrorMessages[i - 1]), sameNamesErrorMessages[i - 1]);
        }
    }

    public void assertColor(String color) {
        WebElement[] fields = {firstName, lastName, email, countryCode, phoneNumber};
        for (int i = 0; i < fields.length; i++) {
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

    public void checkLogoClickability(String url) {
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
    }

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
        takeScreenshot(document + " document - KapitalRs");
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    public void clickOnMailLink(String mailLink) {
        if (mailLink.equalsIgnoreCase("Kontakt")) {
            clickElementBy(contactUsLinkBy, "Kontakt link");
        }
        Assert.assertTrue(isOutlookRunning());
    }

    public void rightClickOnMailLink(String mailLink) {
        if (mailLink.equalsIgnoreCase("Kontakt")) {
            performRightClickForMailLink(driver.findElement(contactUsLinkBy), "Kontakt link");
        }
        Assert.assertTrue(isOutlookRunning());
    }

    public void rightClickOnSelectedLink(By element, String url) {
        performRightClick(returnDisplayedElement(element), url, "link" + returnDisplayedElement(element).getText());
    }

    public void loginRedirection() {
        clickElement(driver.findElement(alreadyHaveAnAccountLinkBy), "An already have account?");
    }

}
