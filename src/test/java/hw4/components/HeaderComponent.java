package hw4.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class HeaderComponent extends AbstractComponent {

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(css = ".m-l8 > li")
    private List<WebElement> menuItems;

    @FindBy(id = "name")
    private WebElement firstName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement submit;

    @FindBy(linkText = "Service")
    private WebElement serviceMenuItem;

    @FindBy(linkText = "Table with pages")
    private WebElement tableWithPages;


    public HeaderComponent(WebDriver driver) {
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

    public boolean isUserNameVisible() {
        return userName.isDisplayed();
    }

    public String getUserName() {
        return userName.getText();
    }

    public boolean allMenuItemsAreDisplayed() {
        return menuItems.stream()
                .allMatch(item -> item.isDisplayed());
    }

    public List<String> getMenuItemsText() {
        return menuItems.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void clickServiceMenuItem() {
        serviceMenuItem.click();
    }

    public void openTableWithPages() {
        tableWithPages.click();
    }


}
