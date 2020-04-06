package hw3.fluent.fluentPages;

import hw3.fluent.components.LoginComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPage extends AbstractPage {

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    private LoginComponent loginComponent;

    public MainPage(WebDriver driver) {
        super(driver);
        this.loginComponent = new LoginComponent(driver);
    }

    public static MainPage using(WebDriver driver) {
        return new MainPage(driver);
    }

    public MainPage launch() {
        getDriver().get("https://jdi-testing.github.io/jdi-light/index.html");
        return this;
    }

    public LoginComponent clickUserIcon() {
        this.userIcon.click();
        return loginComponent;
    }

}
