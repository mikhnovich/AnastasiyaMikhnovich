package hw3.fluent.fluentPages;

import hw3.fluent.components.HeaderComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    private WebDriver driver;

    private HeaderComponent headerComponent;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.headerComponent = new HeaderComponent(driver);
        PageFactory.initElements(driver, this);
    }

    public HeaderComponent getHeaderComponent() {
        return headerComponent;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getPageTitle() {
        return getDriver().getTitle();
    }
}
