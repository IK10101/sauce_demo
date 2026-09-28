import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductDetailTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");

        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button"))
                .click();

        driver.findElement(
                By.xpath("//div[text()='Sauce Labs Backpack']")
        ).click();

        String productName =
                driver.findElement(
                        By.className("inventory_details_name")
                ).getText();

        String description =
                driver.findElement(
                        By.className("inventory_details_desc")
                ).getText();

        String price =
                driver.findElement(
                        By.className("inventory_details_price")
                ).getText();

        System.out.println("Product Name: " + productName);
        System.out.println("Product Price: " + price);
        System.out.println("Description: " + description);

        if (productName.equals("Sauce Labs Backpack")
                && !description.isEmpty()
                && !price.isEmpty()) {

            System.out.println("Product Detail Test: PASSED");
        } else {
            System.out.println("Product Detail Test: FAILED");
        }
        driver.quit();
    }
}