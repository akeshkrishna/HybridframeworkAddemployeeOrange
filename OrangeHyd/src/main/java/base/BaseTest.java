package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ConfigReader;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    public void setUp() {
        String browser = ConfigReader.get("browser");
        String url = ConfigReader.get("url");

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else {
            throw new RuntimeException("Only Chrome is supported.");
        }

        driver.manage().window().maximize();
        // ✅ Add implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(url);
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
