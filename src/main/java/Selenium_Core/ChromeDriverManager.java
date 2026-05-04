package Selenium_Core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;


/**
 * ChromeDriverManager - ukazuje na to kako ce se kreirati driver - implementira apstratknu metodu createWebDriver().
 */
public class ChromeDriverManager extends DriverManager {

    @Override
    public void createWebDriver(String version) {

        String os = System.getProperty("os.name").toLowerCase();
        String driverPath;

        // ===== DRIVER PATH =====
        if (os.contains("win")) {
            // Lokalno (Windows)
            String driverFileName = "chromedriver" + version + ".exe";
            driverPath = Paths.get("src", "main", "resources", driverFileName)
                    .toAbsolutePath().toString();
        } else {
            // Server (Linux / Jenkins)
            driverPath = "/usr/local/bin/chromedriver";
        }

        System.out.println("Driver path = " + driverPath);
        System.setProperty("webdriver.chrome.driver", driverPath);

        // ===== OPTIONS =====
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--remote-allow-origins=*");

        // ===== CHROME PATH =====
        String chromePath = System.getenv("ChromeExeFilePath");
        System.out.println("Chrome path = " + chromePath);

        if (chromePath != null && !chromePath.isEmpty()) {
            options.setBinary(chromePath);
        } else if (os.contains("linux")) {
            options.setBinary("/usr/bin/google-chrome");
        }

        // ===== HEADLESS =====
        String headless = System.getenv("HEADLESS");
        System.out.println("HEADLESS = " + headless);

        if ("true".equalsIgnoreCase(headless)) {

            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");

            options.addArguments("--window-size=1920,1080");

            options.addArguments("--disable-extensions");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-infobars");

            if (os.contains("win")) {
                options.addArguments("--user-data-dir=C:/jenkins-chrome-profile");
            }
        }

        // ===== DRIVER CREATION =====
        driver = new ChromeDriver(options);
        setDriver(driver);

        // ===== WINDOW =====
        if (!"true".equalsIgnoreCase(headless)) {
            driver.manage().window().maximize();
            ((JavascriptExecutor) driver).executeScript("window.focus();");
        }

        // ===== TIMEOUT =====
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}