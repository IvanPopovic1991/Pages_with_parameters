package TestsFortradeR;

import Selenium_Core.DriverManager;
import Selenium_Core.DriverManagerFactory;
import org.openqa.selenium.WebDriver;

public class BaseTestFortradeR {
    WebDriver driver;
    DriverManager driverManager;

    public void baseSetup(String browser, String version) {
        driverManager = DriverManagerFactory.getDriverManager(browser);
        driver = driverManager.getWebDriver(version);
        driver.get("https://www.fortrader.com/minilps/en/pro-dark-2024-dlp/?fts=age-annual-saving-knowledge");
    }

    public void baseTearDown(){
        driverManager.quitDriver();
    }
}
