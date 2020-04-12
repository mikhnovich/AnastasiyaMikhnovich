package hw4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyChromeDriver {

    private static WebDriver driver = null;

    private MyChromeDriver() {
        driver = new ChromeDriver();
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }
}
