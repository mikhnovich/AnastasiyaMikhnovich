package hw5.fluent.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;

public class LogSidebarComponent extends AbstractComponent {
    @FindBy(className = "info-panel-body-log")
    private WebElement logElement;

    public LogSidebarComponent(WebDriver driver) {
        super(driver);
    }

    public boolean isLogVisible() {
        return logElement.isDisplayed();
    }

    public boolean containsLogEntryIgnoreTime(String logEntry) {
        return Arrays.stream(logElement.getText().split("\n"))
                .filter(entry -> entry.length() > 8)
                .map(entry -> entry.substring(9))
                .anyMatch(entry -> entry.equals(logEntry));
    }
}
