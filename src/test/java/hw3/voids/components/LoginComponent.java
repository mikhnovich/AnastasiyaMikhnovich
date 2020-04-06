package hw3.voids.components;

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

    public void enterFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    public void enterPassword(String password) {
        this.password.sendKeys(password);
    }

    public void submit() {
        this.submit.click();
    }

}
