package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();

            options.addArguments("--disable-cookies");
            options.addArguments("--disable-notifications");

            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-infobars");

            options.addArguments("--test-type");
            
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
} 