package hw3.fluent.fluentPages;

import hw3.fluent.components.LogSidebarComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DifferentElementsPage extends AbstractPage {
    LogSidebarComponent logSidebarComponent;
    @FindBy(xpath = "//label[normalize-space() = 'Water']")
    private WebElement waterCheckbox;
    @FindBy(xpath = "//label[normalize-space() = 'Wind']")
    private WebElement windCheckbox;
    @FindBy(xpath = "//label[normalize-space() = 'Selen']")
    private WebElement selenCheckbox;
    @FindBy(css = ".colors select")
    private WebElement colorsSelector;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
        this.logSidebarComponent = new LogSidebarComponent(driver);
    }

    public DifferentElementsPage checkWater() {
        waterCheckbox.click();
        return this;
    }

    public DifferentElementsPage checkWind() {
        windCheckbox.click();
        return this;
    }

    public DifferentElementsPage checkSelen() {
        selenCheckbox.click();
        return this;
    }

    public DifferentElementsPage selectColor(String color) {
        new Select(colorsSelector).selectByVisibleText(color);
        return this;
    }

    public LogSidebarComponent getLogSidebarComponent() {
        return logSidebarComponent;
    }
}
