package src;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest extends BaseUITest {

    private String loginEmail = "testEmail@gmail.com";

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

    public void openDemoSite(WebDriver driver) {
        driver.get("https://demostore.x-cart.com/");
    }

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
        openDemoSite(driver);
        typeAuthInfo(loginEmail, "Temp1234%");
        driver.findElement(By.xpath("//td/button[@type='submit']/span[text()='Sign in']")).click();

    }

    @Test
    public void ValidLoginByEnter() throws Exception {
        openDemoSite(driver);
        typeAuthInfo(loginEmail, "Temp1234%");
        driver.findElement(By.xpath("//td/button[@class='btn  regular-button  submit']")).sendKeys(Keys.ENTER);
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'my_account')]/a")));
    }

    @Test
    public void ValidLoginFormSubmit() throws Exception {
        openDemoSite(driver);
        typeAuthInfo(loginEmail, "Temp1234%");
        driver.findElement(By.id("login-email")).submit();
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'my_account')]/a")));
    }

    public void typeAuthInfo(String email, String password) {
        WebElement signButton = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class= 'header_bar-sign_in']/button")));
        signButton.click();
        WebElement emailLogin = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#login-email")));
        emailLogin.sendKeys(email);
        driver.findElement(By.cssSelector("#login-password")).sendKeys(password);
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

    /**
     * # CASE 4: ADD TO CART
     * # Open site <br/>
     * # Click on 'Toys' link <br/>
     * # Click on 'Geek toys' link <br/>
     * # Hover mouse over a product and click on 'Add to Cart' button <br/>
     * # Find element to be sure that product is added
     */

    @Test
    public void AddToCart() throws Exception {


        openDemoSite(driver);
        driver.findElement(By.xpath("//li[@class='leaf has-sub']/ul/li/a/span[contains(text(),'Toys')]")).click();
        driver.findElement(By.xpath("//span[@class='subcategory-name'][text()='Geek toys']")).click();
        driver.findElement(By.xpath(".//div[@class='list-container']/div[@class=\"block block-block\"]/div/div/div/ul/li[@class='product-cell box-product'][1]/div/div/div[@class=\"add-to-cart-button\"]/button")).click();
        driver.findElement(By.xpath(".//div[@title=\"Your cart\"]/div/h4[@class='title']/a[text()='1 item in cart']"));

        driver.findElement(By.xpath("//div[@title='Your cart']/div[text()='1']"));


    }
}
