package hw6.components;

import hw6.pages.DifferentElementsPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class HeaderComponent extends AbstractComponent {

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(css = ".m-l8 .dropdown")
    private WebElement serviceMenu;

    @FindBy(linkText = "DIFFERENT ELEMENTS")
    private WebElement differentElementsLink;

    @FindBy(id = "name")
    private WebElement firstName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement submit;

    @FindBy(css = ".m-l8 > li")
    private List<WebElement> menuItems;

    @FindBy(css = ".dropdown-menu > li")
    private List<WebElement> dropdownMenu;

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public HeaderComponent enterFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
        return this;
    }

    public HeaderComponent enterPassword(String password) {
        this.password.sendKeys(password);
        return this;
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

    public HeaderComponent clickDropdownMenuItem(String name) {
        WebElement element = dropdownMenu.stream()
                .filter(item -> item.getText().equals(name))
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("Unable to locate Dropdown menu item " + name));
        element.click();
        return this;
    }

    public DifferentElementsPage clickServiceButton() {
        serviceMenu.click();
        return new DifferentElementsPage(getDriver());
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
}
