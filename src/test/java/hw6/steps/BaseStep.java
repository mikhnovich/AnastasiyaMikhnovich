package hw6.steps;

import hw4.MyChromeDriver;
import hw5.GetProperty;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public abstract class BaseStep {

    private static final GetProperty property = new GetProperty();

    public WebDriver getDriver() {
        return MyChromeDriver.getDriver();
    }

    public String getProperty(String propName) {
        try {
            return property.getProperty(propName);
        } catch (IOException e) {
            return null;
        }
    }
}
