package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ReadyFortrade extends BasePage {
    public ReadyFortrade(WebDriver driver) {
        super(driver);
    }

       /*@FindBy(xpath = "//div[@id='platformRegulation']")
       public WebElement txtRegulation;*/

    @FindBy(xpath = "//div[@class='startTradingButton']")
    protected WebElement btnUsePass;

    @FindBy(xpath = "//div[@data-cmd='menu']")
    protected WebElement btnMenu;

    @FindBy(xpath = "//div[@id='supportMenuItem']")
    protected WebElement settingBtn;

    @FindBy(xpath = "//div[@id='languagesMenuItem']")
    protected WebElement languageBtn;

    @FindBy(xpath = "//div[@class='exitButton']")
    protected WebElement iAmNotSerbianRes;

    public void clickNotResBtn() {
        clickElement(iAmNotSerbianRes, "I am not Serbian resident button");
    }

    public void clickUsePassBtn() {
        clickElement(btnUsePass, "use password button");
    }

    public void clickMenuBtn() {
        clickElement(btnMenu, "menu button");
    }

    public void clickSettingsBtn() {
        clickElement(settingBtn, "settings button");
    }

    public void clickLanguageBtn() {
        clickElement(languageBtn, "language button");
    }

    public void assertUrl(String url){
        WebDriverWait webDriverWait = new WebDriverWait(driver,15);
        webDriverWait.until(ExpectedConditions.urlContains(url));
    }

    public void assertDisplayedLanguage(String language) {
        clickMenuBtn();
        clickSettingsBtn();
        clickLanguageBtn();
        WebElement displayedLanguage = driver.findElement
                (By.xpath("//div[@id='settingsLanguage{language}']//*[name()='svg' and contains(@class,'tickSvg')]"
                        .replace("{language}", language)));
        WebDriverWait webDriverWait = new WebDriverWait(driver,10);
        webDriverWait.until(ExpectedConditions.visibilityOf(displayedLanguage));
        Assert.assertTrue(displayedLanguage.isDisplayed());
    }
}
