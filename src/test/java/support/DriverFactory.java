package support;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

/**
 * Central place to create/return/quit WebDriver instances.
 * Uses ThreadLocal so scenarios can run in parallel safely.
 */
public class DriverFactory {

    private static final ThreadLocal<WebDriver> TL_DRIVER = new ThreadLocal<>();

    /** Create a driver for the current thread (if not already present). */
    public static WebDriver initDriver() {
        if (TL_DRIVER.get() == null) {
            // You can extend this with browser switching via -Dbrowser=edge, etc.
            String headless = System.getProperty("headless", "false");

            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            if ("true".equalsIgnoreCase(headless)) {
                options.addArguments("--headless=new");
            }
            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");

            ChromeDriver driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
            TL_DRIVER.set(driver);
        }
        return TL_DRIVER.get();
    }

    /** Get driver for current thread (assumes initDriver() was called in a @Before hook). */
    public static WebDriver getDriver() {
        return TL_DRIVER.get();
    }

    /** Quit and clean up driver for current thread. */
    public static void quitDriver() {
        WebDriver driver = TL_DRIVER.get();
        if (driver != null) {
            driver.quit();
            TL_DRIVER.remove();
        }
    }
}
