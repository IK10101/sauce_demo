import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductPriceTest {

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

        String actualPrice =
                driver.findElement(
                        By.className("inventory_details_price")
                ).getText();

        System.out.println("Actual Product Price: " + actualPrice);
        String expectedPrice = "$29.99";

        if (actualPrice.equals(expectedPrice)) {
            System.out.println("Product Price Test: PASSED");
        } else {
            System.out.println("Product Price Test: FAILED");
            System.out.println("Expected Price: " + expectedPrice);
        }
        driver.quit();
    }
}