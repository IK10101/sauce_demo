import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductSortingTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");

        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button"))
                .click();

        WebElement sortDropdown =
                driver.findElement(By.className("product_sort_container"));

        Select select = new Select(sortDropdown);

        select.selectByValue("lohi");

        List<WebElement> priceElements =
                driver.findElements(By.className("inventory_item_price"));

        List<Double> actualPrices = new ArrayList<>();

        for (WebElement priceElement : priceElements) {

            String priceText = priceElement.getText();

            double price =
                    Double.parseDouble(priceText.replace("$", ""));

            actualPrices.add(price);
        }
        List<Double> expectedPrices =
                new ArrayList<>(actualPrices);
        Collections.sort(expectedPrices);

        if (actualPrices.equals(expectedPrices)) {
            System.out.println("Product Sorting Test: PASSED");
        } else {
            System.out.println("Product Sorting Test: FAILED");
        }

        driver.quit();
    }
}