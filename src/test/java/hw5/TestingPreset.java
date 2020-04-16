package hw5;

import hw4.MyChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class TestingPreset {

    private static final GetProperty property = new GetProperty();

    private WebDriver driver;
    private WebDriverWait wait;

    public String getProperty(String propName) {
        try {
            return property.getProperty(propName);
        } catch (IOException e) {
            return null;
        }
    }

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = MyChromeDriver.getDriver();
        wait = new WebDriverWait(driver, 7);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        MyChromeDriver.invalidateDriver();
    }

    public WebDriver getDriver() {
        return MyChromeDriver.getDriver();
    }

    public WebDriverWait getWait() {
        return wait;
    }
}
