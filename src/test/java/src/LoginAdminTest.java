package src;

import org.junit.Test;
import org.openqa.selenium.By;

public class LoginAdminTest extends BaseUITest {

    /**
     * # CASE 1: LOG IN AS ADMIN
     * # Ope n site <br/>
     * # Open admin login page <br/>
     * # Enter credentials <br/>
     * # Submit form <br/>
     * # Find element to verify that log in is successful.
     */

    @Test
    public void ValidAdminLoginTest() throws Exception {

        openDemoSite(driver);
        driver.findElement(By.xpath("//li/a[@title=\"Admin area\"]")).click();
        driver.findElement(By.xpath("//input[@name='login']")).sendKeys("Email");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Password");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.findElement(By.xpath("//div/a[@class='link']/span[text()=\"Sign out\"]"));

    }

}
