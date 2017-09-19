package src;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseUITest {

    private String loginEmail = "testEmail@gmail.com";

    /**
     * # CASE 3: LOG IN AS USER
     * # Open site <br/>
     * # Open login popup
     * # Enter user credentials <br/>
     * # Submit form <br/>
     * # <b>Expected Result:</b> User logged into account
     */

    @Test
    public void ValidLoginTest() throws Exception {
        openDemoSite(driver).typeAuthInfo(loginEmail, "Temp1234%").signInByClick();
    }

    @Test
    public void ValidLoginByEnter() throws Exception {
        openDemoSite(driver).typeAuthInfo(loginEmail, "Temp1234%").signInByEnter();
    }

    @Test
    public void ValidLoginFormSubmit() throws Exception {
        openDemoSite(driver).typeAuthInfo(loginEmail, "Temp1234%").singInBySubmit();
    }

    /**
     * # CASE 2: CREATE A NEW USER
     * # Open site <br/>
     * # Open admin login page <br/>
     * # Enter admin credentials <br/>
     * # Submit form <br/>
     * # <b>Expected Result:</b> Admin logged into account
     * # Click on 'Users list' link <br/>
     * # Click on 'Add user' button <br/>
     * # Enter new user credentials <br/>
     * # Click on 'Create account' button <br/>
     * * # <b>Expected Result:</b> User should be created
     */

    @Test
    public void UserCreation() throws Exception {
        openDemoSite(driver);
        driver.findElement(By.xpath("//li/a[@title=\"Admin area\"]")).click();
        driver.findElement(By.xpath("//input[@name='login']")).sendKeys("Email");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Password");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assert.assertTrue("Admin should be logged in", false);
        driver.findElement(By.xpath("//a[@title=\"Users list\"]")).click();
        driver.findElement(By.xpath("//button[@class='btn  regular-button']")).click();
        driver.findElement(By.xpath("//input[@id='login']")).sendKeys("Email");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password");
        driver.findElement(By.xpath("//input[@id='password-conf']")).sendKeys("Confirm password");
        driver.findElement(By.xpath("//div/button[@type='submit']/span[text()='Create account']")).click();

    }
}
