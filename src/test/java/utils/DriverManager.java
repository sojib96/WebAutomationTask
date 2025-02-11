package utils;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@UtilityClass
public class DriverManager {
    private final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public WebDriver getDriver() {
        if (driver.get() == null) {
            initializeDriver();
        }
        return driver.get();
    }

    private void initializeDriver() {
        String browser = System.getProperty("browser", "chrome").toLowerCase();  // Default to Chrome
        utils.LoggerUtility.info("Initializing WebDriver for browser: " + browser);

        switch (browser) {
            case "chrome":
                driver.set(new ChromeDriver());
                break;
            case "firefox":
                driver.set(new FirefoxDriver());
                break;
            case "edge":
                driver.set(new EdgeDriver());
                break;
            default:
                utils.LoggerUtility.error("Unsupported browser: " + browser);
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.get().manage().window().maximize();
        utils.LoggerUtility.info(browser + " browser launched successfully.");
    }

    public void quitDriver() {
        if (driver.get() != null) {
            utils.LoggerUtility.info("Closing WebDriver...");
            driver.get().quit();
            driver.remove();
            utils.LoggerUtility.info("WebDriver closed and removed from ThreadLocal.");
        }
    }
}
