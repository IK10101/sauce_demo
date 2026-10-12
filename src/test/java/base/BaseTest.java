package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

/** Shared setup/teardown. Every test class in every package extends this. */
public class BaseTest {

    protected WebDriver driver;
    protected static final String BASE_URL = "https://www.saucedemo.com/";

    /** Builds a Chrome or Edge driver. Anything other than "edge" gives Chrome. */
    public static WebDriver createDriver(String browser) {
        if ("edge".equalsIgnoreCase(browser)) {
            return new EdgeDriver();
        }
        return new ChromeDriver();
    }

    @BeforeEach
    public void setUp(TestInfo info) {
        // Read @Browser("edge") from the test method; default is chrome
        String browser = info.getTestMethod()
                .map(m -> m.getAnnotation(Browser.class))
                .map(Browser::value)
                .orElse("chrome");

        driver = createDriver(browser);                              // opens the browser
        driver.manage().window().maximize();                         // .window()
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(BASE_URL);                                        // .get()
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();                                           // .quit()
        }
    }

    protected void login(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }
}
