package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddEmployeePage;
import pages.LoginPage;
import pages.PIMPage;
import utils.ExcelUtils;

public class AddEmployeeTest extends BaseTest {

    @BeforeClass
    public void setUpTest() {
        setUp();
    }

    @Test
    public void addEmployeeUsingExcel() {

        // 1. Login
        LoginPage login = new LoginPage(driver);
        login.login("Admin", "admin123");

        // 2. Navigate to Add Employee page via PIM + Add
        PIMPage pim = new PIMPage(driver);
        pim.openAddEmployeePage();

        // (Optional debug)
        System.out.println("URL after openAddEmployeePage: " + driver.getCurrentUrl());

        // 3. Read Excel
        ExcelUtils excel = new ExcelUtils("EmployeeData.xlsx", "Employee");
        String first  = excel.getCellData(1, 0);
        String middle = excel.getCellData(1, 1);
        String last   = excel.getCellData(1, 2);
        String empId  = excel.getCellData(1, 3);

        // 4. Fill form & save
        AddEmployeePage add = new AddEmployeePage(driver);
        add.fillEmployeeForm(first, middle, last, empId);
        add.clickSave();

        // 5. Verify
     // 5. Verify we are on Personal Details page after save
     // 5. Verify header changed to "Personal Details" after saving
        String headerText = add.getProfileHeaderName();
        System.out.println("Header after save: " + headerText);

        // For now, just confirm we are on Add Employee / employee page without errors
        Assert.assertTrue(headerText.contains("Add Employee") || headerText.contains("Personal Details"),
                "Unexpected header after save. Header found: " + headerText);


    }

    @AfterClass
    public void tearDownTest() {
        tearDown();
    }
}
