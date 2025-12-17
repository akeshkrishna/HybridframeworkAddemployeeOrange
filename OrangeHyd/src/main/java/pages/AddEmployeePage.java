package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddEmployeePage {

    private WebDriver driver;

    private By firstNameField  = By.name("firstName");
    private By middleNameField = By.name("middleName");
    private By lastNameField   = By.name("lastName");
    private By employeeIdField = By.xpath("//label[text()='Employee Id']/../following-sibling::div//input");
    private By saveButton      = By.xpath("//button[@type='submit']");
    private By profileHeader   = By.xpath("//h6[contains(@class,'orangehrm-main-title')]");

    public AddEmployeePage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillEmployeeForm(String first, String middle, String last, String empId) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for first name field to be visible on Add Employee page
        WebElement firstNameElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(firstNameField)
        );

        firstNameElement.sendKeys(first);
        driver.findElement(middleNameField).sendKeys(middle);
        driver.findElement(lastNameField).sendKeys(last);

        WebElement empIdInput = driver.findElement(employeeIdField);
        empIdInput.clear();
        empIdInput.sendKeys(empId);
    }

    public void clickSave() {
        driver.findElement(saveButton).click();
    }

    public String getProfileHeaderName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement header = wait.until(
                ExpectedConditions.visibilityOfElementLocated(profileHeader)
        );
        return header.getText();
    }
}
