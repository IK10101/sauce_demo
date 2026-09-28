import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductListingTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");

        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button"))
                .click();

        int productCount =
                driver.findElements(By.className("inventory_item")).size();
        System.out.println("Number of products displayed: " + productCount);
     
        if (productCount > 0) {
            System.out.println("Product Listing Test: PASSED");
        } else {
            System.out.println("Product Listing Test: FAILED");
        }
        driver.quit();
    }
}