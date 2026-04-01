package TestsBrokerViews;

import Selenium_Core.DriverManager;
import Selenium_Core.DriverManagerFactory;
import org.openqa.selenium.WebDriver;

public class BaseTestBrokerviews {


    WebDriver driver;
    DriverManager driverManager;

    public void baseSetUp(String browser, String version){
        driverManager = DriverManagerFactory.getDriverManager(browser);
        driver =driverManager.getWebDriver(version);
        driver.get("https://dlp.brokereviews.com/lps/pro-dark-nob-kp/en?fts=age-annual-saving-knowledge-plang:all");
    }

    public void baseTearDown(){
        driverManager.quitDriver();
    }
}
