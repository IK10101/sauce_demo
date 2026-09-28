import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InventoryNavigationTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        System.out.println("Products found: "
                + driver.findElements(By.className("inventory_item")).size());

        driver.findElement(By.linkText("Sauce Labs Backpack")).click();

        System.out.println("On detail page: "
                + driver.getCurrentUrl().contains("inventory-item.html"));

        driver.navigate().back();

        System.out.println("Back on inventory: "
                + driver.getCurrentUrl().contains("inventory.html"));

        driver.quit();
    }
}