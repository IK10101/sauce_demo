import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LockOutUserTest {
	
	public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name"))
              .sendKeys("locked_out_user");

        driver.findElement(By.id("password"))
              .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button"))
              .click();

        String error = driver.findElement(
                By.cssSelector("[data-test='error']")
        ).getText();

        System.out.println("Locked Out error: " + error);

        driver.quit();
    }
	
      
}
