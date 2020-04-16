package hw5.fluent.fluentPages;

import hw5.fluent.components.HeaderComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    private final WebDriver driver;

    private final HeaderComponent headerComponent;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.headerComponent = new HeaderComponent(driver);
        PageFactory.initElements(driver, this);
    }

    public HeaderComponent getHeader() {
        return headerComponent;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getPageTitle() {
        return getDriver().getTitle();
    }
}
