import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class InvalidLoginTest {
	public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name"))
              .sendKeys("standard_user");

        driver.findElement(By.id("password"))
              .sendKeys("wrong_pass");

        driver.findElement(By.id("login-button"))
              .click();

        String error = driver.findElement(
                By.cssSelector("[data-test='error']")
        ).getText();

        System.out.println("Invalid password error: " + error);

        driver.quit();
    }
}
