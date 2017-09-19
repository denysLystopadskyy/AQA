package src;

import org.junit.Test;
import org.openqa.selenium.By;

public class CartTest extends BaseUITest {

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
