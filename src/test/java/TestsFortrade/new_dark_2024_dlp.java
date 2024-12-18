package TestsFortrade;

import Pages.FortradePage;
import faker.TestData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class new_dark_2024_dlp extends BaseTestFortrade {
    @BeforeMethod
    @Parameters({"tag"})
    public void setUp(String tag) {
        baseSetup("Chrome", "131");
        driver.get("https://www.fortrade.com/minilps/en/new-dark-2024-dlp/?fts=age-annual-saving-knowledge"+tag);
    }

    @AfterMethod
    public void tearDown() {
        baseTearDown();
    }

    @Test
    @Parameters({"countryCode", "regulation"})
    public void demoAccountRegistration(String countryCode, String regulation) throws IOException, AWTException, InterruptedException {
        FortradePage fortradePage = new FortradePage(driver);
        fortradePage.successfullyRegistration("Testq", "Testa", TestData.emailGenerator(), countryCode, TestData.phoneNumberGenerator(),
                "25-34", "$15,000-$50,000", "$50,000 – $100,000", "All the above");
        fortradePage.assertURL("https://ready.fortrade.com/#chartticket");
        fortradePage.clickMenuBtn();
        fortradePage.checkRegulation(regulation);
    }
}
