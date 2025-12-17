package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @BeforeClass
    public void start() {
        setUp();   // from BaseTest: opens browser & goes to URL
    }

    @Test
    public void validLoginTest() {
        LoginPage lp = new LoginPage(driver);
        lp.login("Admin", "admin123");

        // Simple verification: after login, URL should contain "dashboard"
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("dashboard"),
                "Login failed OR did not redirect to Dashboard. Current URL: " + currentUrl);
    }

    @AfterClass
    public void end() {
        tearDown();  // close browser
    }
}
