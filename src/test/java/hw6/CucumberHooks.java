package hw6;

import hw4.MyChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CucumberHooks {

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        MyChromeDriver.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown() {
        MyChromeDriver.getDriver().quit();
        MyChromeDriver.invalidateDriver();
    }
}
