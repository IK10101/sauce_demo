package saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddSingleItemTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get("https://www.saucedemo.com/");

            // Login
            driver.findElement(By.id("user-name"))
                    .sendKeys("standard_user");

            driver.findElement(By.id("password"))
                    .sendKeys("secret_sauce");

            driver.findElement(By.id("login-button"))
                    .click();

            // Add single item
            driver.findElement(
                    By.id("add-to-cart-sauce-labs-backpack"))
                    .click();

            // Verify cart count
            String count = driver.findElement(
                    By.className("shopping_cart_badge"))
                    .getText();

            if (count.equals("1")) {
                System.out.println("PASS - Single item added to cart");
            } else {
                System.out.println("FAIL - Single item not added");
            }

        } finally {
            driver.quit();
        }
    }
}