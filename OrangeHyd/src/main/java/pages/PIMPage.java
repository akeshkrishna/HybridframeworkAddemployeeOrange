package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PIMPage {

    private WebDriver driver;

    // Left sidebar "PIM" menu item
    private By pimMenu = By.xpath("//span[normalize-space()='PIM']");

    // "Add" button on Employee List page
    private By addButton = By.xpath("//button[normalize-space()='Add']");

    public PIMPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openAddEmployeePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 1. Click PIM in left menu
        WebElement pim = wait.until(
                ExpectedConditions.elementToBeClickable(pimMenu)
        );
        pim.click();

        // 2. Click Add button on Employee List
        WebElement add = wait.until(
                ExpectedConditions.elementToBeClickable(addButton)
        );
        add.click();
    }
}
