package Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;

public class YopMail extends BasePage{
    /**
     * PageFactory- koristi se za direktno kreiranje web elemenata. Omogucava nam da sacuvamo veb element bez koricenja
     * driver.findElement(); Locira elemente na prvi poziv elementa za razliku od driver.findElement-a koji bi prijavljivao
     * noSuchElementException gresku.
     * Svaka stranica u svom konstuktoru ce sadrzati page factory.
     *
     * @param driver
     */
    public YopMail(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@class='ycptinput']")
    public WebElement search;

    @FindBy(xpath = "//div[@id='refreshbut']")
    public WebElement goBtn;

    @FindBy(xpath = "//iframe[@id='ifinbox']")
    public WebElement inboxFrame;

    @FindBy(xpath = "//iframe[@id='ifmail']")
    public WebElement mailFrame;

    @FindBy(xpath = "//div[@class='lmfd']/span[contains(text(), 'Fortrade')]")
    public WebElement emailMessage;

    @FindBy(xpath = "//button[@id='refresh']")
    public WebElement refreshEmailBtn;

    @FindBy(xpath = "//span[contains(text(), 'Fortrade <ftadmin@fortrade.com>')]")
    public WebElement fortradeEmail;

    @FindBy(xpath = "//body//header//div[contains(text(),'Your Fortrade Demo Account Is Ready – Let’s GetStarted')]")
    public WebElement emailTitle;

    @FindBy(xpath = "//tr/td/b[contains(text(), 'Testq')]")
    public WebElement fortradeTestqName;

    @FindBy(xpath = "//div[@class='lmfd']/span[contains(text(), 'KapitalRS')]")
    public WebElement emailMessageKRS;

    @FindBy(xpath = "//span[contains(text(), 'KapitalRS <podrska@kapitalrs.com>')]")
    public WebElement kapitalRSEmail;

    @FindBy(xpath = "//div[contains(text(),'Vaš Demo Nalog je Spreman')]")
    public WebElement emailTitleKRS;

    @FindBy(xpath = "//td/p[contains(text(), 'Dobrodošli, Testq!')]")
    public WebElement kapitalRSTestqName;

    public void findEmail(String emailValue){
        typeText(search,emailValue,"search input");
        clickElement(goBtn,"go button");/*
        wait.until(ExpectedConditions.visibilityOf(emailMessage));
        wait.until(ExpectedConditions.elementToBeClickable(emailMessage));*/
        for (int i = 0; i < 10; i++) {
            try {
                driver.switchTo().frame(inboxFrame);
                //WebElement emailMessage = driver.findElement(By.xpath("//div[@class='lmfd']/span[contains(text(), 'Fortrade')]"));
                if (emailMessage.isDisplayed()) {
                    break; // Exit loop when message appears
                }
            } catch (NoSuchElementException e) {
                // Do nothing — element not yet found
                if (i==9){
                    Assert.fail("An email is not found after 9 tries!!!");
                }
            }

            driver.switchTo().defaultContent();
            clickElement(refreshEmailBtn, "refresh email inbox");
        }
        clickElement(emailMessage,"received message in mailbox");
        driver.switchTo().defaultContent();
        driver.switchTo().frame(mailFrame);
        Assert.assertEquals(getText(fortradeEmail, "getting fortrade email"), "Fortrade <ftadmin@fortrade.com>");
        Assert.assertEquals(getText(fortradeTestqName, "getting Testq name"), "Testq");
    }

    /*public void findEmailKRS(String emailValue){
        typeText(search,emailValue,"search input");
        clickElement(goBtn,"go button");
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOf(emailMessageKRS));
        wait.until(ExpectedConditions.elementToBeClickable(emailMessageKRS));
        clickElement(emailMessageKRS,"received message in mailbox");
    }*/

    public void findEmailKRS(String emailValue){
        typeText(search,emailValue,"search input");
        clickElement(goBtn,"go button");/*
        wait.until(ExpectedConditions.visibilityOf(emailMessage));
        wait.until(ExpectedConditions.elementToBeClickable(emailMessage));*/
        for (int i = 0; i < 10; i++) {
            try {
                driver.switchTo().frame(inboxFrame);
                //WebElement emailMessage = driver.findElement(By.xpath("//div[@class='lmfd']/span[contains(text(), 'Fortrade')]"));
                if (emailMessageKRS.isDisplayed()) {
                    break; // Exit loop when message appears
                }
            } catch (NoSuchElementException e) {
                // Do nothing — element not yet found
                if (i==9){
                    Assert.fail("An email is not found after 9 tries!!!");
                }
            }

            driver.switchTo().defaultContent();
            clickElement(refreshEmailBtn, "refresh email inbox");
        }
        clickElement(emailMessageKRS,"received message in mailbox");
        driver.switchTo().defaultContent();
        driver.switchTo().frame(mailFrame);
        Assert.assertEquals(getText(kapitalRSEmail, "getting kapitalRS email"), "KapitalRS <podrska@kapitalrs.com>");
        Assert.assertTrue(getText(kapitalRSTestqName, "getting Testq name").contains("Dobrodošli, Testq!"));
    }

    /**
     * zoomOutMethod() method is used to help the takeScreenshot() method to capture the whole email message (header,
     * body, and footer)
     * @throws AWTException
     */
    public void zoomOutMethod() throws AWTException {
        Robot robot = new Robot();
        for (int i = 0; i < 5; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_MINUS);
            robot.keyRelease(KeyEvent.VK_MINUS);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }
    }

}
