package src;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class BaseUITest {


    private static final String chromeDriverPath = "D:\\Training\\AQA\\src\\test\\resources\\chromedriver.exe";

    protected WebDriver driver;

    @BeforeClass
    public static void beforeClassSetUp() throws Exception {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, chromeDriverPath);
    }

    @Before
    public void setUp() throws Exception {
        driver = getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1L, TimeUnit.MINUTES);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    public WebDriver getDriver() {
        return new ChromeDriver();
    }


}
