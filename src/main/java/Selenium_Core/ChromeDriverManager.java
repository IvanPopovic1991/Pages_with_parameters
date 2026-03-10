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
        String driverFileName;

        if (os.contains("win")) {
            driverFileName = "chromedriver" + version + ".exe"; // Windows
        } else {
            driverFileName = "chromedriver" + version;         // Linux / CI runner
        }

        String driverPath = Paths.get("src", "main", "resources", driverFileName)
                .toAbsolutePath().toString();
        System.setProperty("webdriver.chrome.driver", driverPath);

        // ===== OPTIONS =====
        ChromeOptions options = new ChromeOptions();

        // Chrome 115+ fix ChromeExeFilePath=C:\Program Files\Google\Chrome\Application\chrome.exe
        options.addArguments("--remote-allow-origins=*");

        // ===== CHROME BINARY PATH (OPTIONAL) ===== C:\Program Files\chrome-win64\chrome.exe
        String filePath = System.getenv("ChromeExeFilePath");
        System.out.println("Chrome path = " + filePath);

        if (filePath != null && !filePath.isEmpty()) {
            options.setBinary(filePath);
        } else if(System.getProperty("os.name").toLowerCase().contains("linux")) {
            options.setBinary("/usr/bin/google-chrome");
        }

        // ===== HEADLESS CONTROL =====
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

        // ===== WINDOW HANDLING =====
        if (!"true".equalsIgnoreCase(headless)) {
            driver.manage().window().maximize();
            ((JavascriptExecutor) driver).executeScript("window.focus();");
        }

        // ===== TIMEOUTS =====
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
