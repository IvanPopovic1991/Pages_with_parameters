package listeners;

import Pages.BasePage;
import Selenium_Core.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ScreenshotListener implements ITestListener {
    /**
     * onTestFailure metoda prati test koji je pokrenut, i ako padne poziva metodu takeScreenshot koja pravi
     * screenshot celog ekrana.
     *
     * @param result <code>ITestResult</code> containing information about the run test
     */

    /**
     * takeScreenshot metoda pravi screenshot celog ekrana (ako folder ne postoji, objekat directory File
     * klase kreira novi folder (directory.mkdirs();)).
     *
     * takeScreenshot metoda koristi javinu Robot klasu koja uzima dimenzije ekrana i kreira screenshot celog ekrana
     * i smesta ga u screenFullImage objekat klase BufferedImage. Kreira ime fajla (String screenshotName) i kreira
     * folder - (failedScreenshots) ukoliko ne postoji (directory.mkdirs();). Kreira lokaciju fajla gde ce biti smesten i
     * nakon toga upisuje screenshot u PNG formatu na lokaciji koju smo mu odredili (String location).
     * @param result
     */

    @Override
    public void onTestFailure(ITestResult result) {

        String headless = System.getenv("HEADLESS");

        try {
            if ("true".equalsIgnoreCase(headless)) {

                // ===== JENKINS / SERVER =====
                WebDriver driver = DriverManager.getDriver();

                if (driver == null) {
                    System.out.println("⚠️ Driver is NULL - screenshot skipped");
                    return;
                }

                BasePage basePage = new BasePage(driver);
                String screenshotName = "FAILED_" + result.getName() + "_" + System.currentTimeMillis();

                basePage.takeScreenshot(screenshotName);

                System.out.println("📸 Jenkins screenshot saved: " + screenshotName);

            } else {

                // ===== Local =====
                Robot robot = new Robot();
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                Rectangle screenRect = new Rectangle(screenSize);
                BufferedImage screenFullImage = robot.createScreenCapture(screenRect);

                String screenshotName = "Failed - " + result.getName();

                File directory = new File("src/failedScreenshots");
                if (!directory.exists()) {
                    directory.mkdirs();
                }

                String location = "src/failedScreenshots/" + screenshotName + ".png";
                ImageIO.write(screenFullImage, "PNG", new File(location));

                System.out.println("📸 Local screenshot saved: " + screenshotName);
            }

        } catch (Exception e) {
            System.out.println("Screenshot failed: " + e.getMessage());
        }
    }
}