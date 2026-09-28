package saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RemoveItemTest {

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

            // Add item
            driver.findElement(
                    By.id("add-to-cart-sauce-labs-backpack"))
                    .click();

            // Open cart
            driver.findElement(
                    By.className("shopping_cart_link"))
                    .click();

            // Remove item
            driver.findElement(
                    By.id("remove-sauce-labs-backpack"))
                    .click();

            // Verify item is removed
            boolean removed = driver.findElements(
                    By.className("inventory_item_name"))
                    .isEmpty();

            if (removed) {
                System.out.println("PASS - Item removed from cart");
            } else {
                System.out.println("FAIL - Item was not removed");
            }

        } finally {
            driver.quit();
        }
    }
}