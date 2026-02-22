package TestsPenny;

import Selenium_Core.DriverManager;
import Selenium_Core.DriverManagerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseTestPenny {

    WebDriver driver;
    DriverManager driverManager;

    public void baseSetUp(String browser, String version){
        driverManager = DriverManagerFactory.getDriverManager(browser);
        driver =driverManager.getWebDriver(version);
        driver.get("https://dlp.pennystocks-uk.com/lps/pro-dark/en?fts=age-annual-saving-knowledge-plang:all");
    }

    public void baseTearDown(){
        driverManager.quitDriver();
    }
}
