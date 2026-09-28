import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        int products = driver.findElements(By.className("inventory_item")).size();

        System.out.println("Products found: " + products);

        if (products == 6) {
            System.out.println("Product test PASSED");
        } else {
            System.out.println("Product test FAILED");
        }

        driver.quit();
    }
}