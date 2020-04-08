package hw3.fluent.fluentPages;

import hw3.fluent.components.HeaderComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPage extends AbstractPage {

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public static MainPage using(WebDriver driver) {
        return new MainPage(driver);
    }

    public MainPage launch() {
        getDriver().get("https://jdi-testing.github.io/jdi-light/index.html");
        return this;
    }

    public HeaderComponent clickUserIcon() {
        this.userIcon.click();
        return getHeaderComponent();
    }

}
