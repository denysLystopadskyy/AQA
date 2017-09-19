package src.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    @FindBy(id = "login-email")
    private WebElement loginInput;

    @FindBy(id = "login-password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']/span[text()='Sign in']")
    private WebElement signInButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage typeAuthInfo(String email, String password) {
        WebElement signButton = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class= 'header_bar-sign_in']/button")));
        signButton.click();
        //example
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(loginInput));
        loginInput.sendKeys(email);
        passwordInput.sendKeys(password);

        return this;
    }

    public HomePage signInByClick() {
        signInButton.click();
        waitTillUserisLogined();
        return this;
    }

    public WebElement waitTillUserisLogined() {
        return new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'my_account')]/a")));
    }

    public HomePage signInByEnter() {
        signInButton.sendKeys(Keys.ENTER);
        waitTillUserisLogined();
        return this;
    }

    public HomePage singInBySubmit() {
        driver.findElement(By.id("login-email")).submit();
        waitTillUserisLogined();
        return this;
    }
}
