package saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ViewCartPageTest {

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

            // Click cart
            driver.findElement(
                    By.className("shopping_cart_link"))
                    .click();

            // Verify cart page
            String url = driver.getCurrentUrl();

            if (url.contains("cart.html")) {
                System.out.println("PASS - Cart page opened successfully");
            } else {
                System.out.println("FAIL - Cart page not opened");
            }

        } finally {
            driver.quit();
        }
    }
}