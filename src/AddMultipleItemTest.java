package saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddMultipleItemTest {

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

            // Add multiple items
            driver.findElement(
                    By.id("add-to-cart-sauce-labs-backpack"))
                    .click();

            driver.findElement(
                    By.id("add-to-cart-sauce-labs-bike-light"))
                    .click();

            driver.findElement(
                    By.id("add-to-cart-sauce-labs-bolt-t-shirt"))
                    .click();

            // Verify cart count
            String count = driver.findElement(
                    By.className("shopping_cart_badge"))
                    .getText();

            if (count.equals("3")) {
                System.out.println("PASS - Multiple items added to cart");
            } else {
                System.out.println("FAIL - Multiple items not added");
            }

        } finally {
            driver.quit();
        }
    }
}