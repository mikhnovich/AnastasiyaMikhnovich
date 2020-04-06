package hw3.fluent.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginComponent extends AbstractComponent {
    @FindBy(id = "name")
    private WebElement firstName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement submit;

    public LoginComponent(WebDriver driver) {
        super(driver);
    }

    public static LoginComponent using(WebDriver driver) {
        return new LoginComponent(driver);
    }

    public LoginComponent enterFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
        return this;
    }

    public LoginComponent enterPassword(String password) {
        this.password.sendKeys(password);
        return this;
    }

    public void submit() {
        this.submit.click();
    }

}
