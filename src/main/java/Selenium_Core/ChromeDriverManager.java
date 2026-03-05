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
       /* System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver" + version + ".exe");
        String filePath = System.getenv("ChromeExeFilePath");
        ChromeOptions options = new ChromeOptions();
        options.setBinary(filePath);
        System.out.println("Chrome path = " + filePath);
        String headless = System.getenv("HEADLESS");
        if("true".equalsIgnoreCase(headless)) {
            //options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/137.0.0.0 Safari/537.36");
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-extensions");
            options.addArguments("--user-data-dir=C:/jenkins-chrome-profile");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-infobars");
            options.addArguments("--start-maximized");
        }
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        ((JavascriptExecutor) driver).executeScript("window.focus();");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }*/
        String driverPath = Paths.get(
                "src",
                "main",
                "resources",
                "chromedriver" + version + ".exe"
        ).toAbsolutePath().toString();

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

            options.addArguments("--user-data-dir=C:/jenkins-chrome-profile");
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
