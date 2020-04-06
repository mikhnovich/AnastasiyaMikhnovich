package hw3.fluent.components;

import hw3.fluent.fluentPages.DifferentElementsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderComponent extends AbstractComponent {

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(css = ".m-l8 .dropdown")
    private WebElement serviceMenu;

    @FindBy(linkText = "DIFFERENT ELEMENTS")
    private WebElement differentElementsLink;

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public WebElement getUserNameElement() {
        return userName;
    }

    public boolean isUserNameVisible() {
        return userName.isDisplayed();
    }

    public String getUserName() {
        return userName.getText();
    }

    public HeaderComponent openServiceMenu() {
        serviceMenu.click();
        return this;
    }

    public DifferentElementsPage clickDifferentElementsLink() {
        differentElementsLink.click();
        return new DifferentElementsPage(getDriver());
    }
}
