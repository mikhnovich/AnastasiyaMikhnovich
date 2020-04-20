package hw5.voids.voidPages;

import hw5.voids.components.IconsComponent;
import hw5.voids.components.IframeComponent;
import hw5.voids.components.LeftSectionMenuComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class MainPage extends AbstractPage {

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    private IconsComponent iconsComponent;

    private IframeComponent iframeComponent;

    private LeftSectionMenuComponent leftSectionMenuComponent;

    public MainPage(WebDriver driver) {
        super(driver);
        this.iconsComponent = new IconsComponent(driver);
        this.iframeComponent = new IframeComponent(driver);
        this.leftSectionMenuComponent = new LeftSectionMenuComponent(driver);
    }

    public void launch() {
        getDriver().get("https://jdi-testing.github.io/jdi-light/index.html");
    }

    public boolean isUsernameVisible() {
        return getHeaderComponent().isUserNameVisible();
    }

    public String getUsernameDisplayed() {
        return getHeaderComponent().getUserName();
    }

    public void login(String username, String password) {
        userIcon.click();
        getHeaderComponent().enterFirstName(username);
        getHeaderComponent().enterPassword(password);
        getHeaderComponent().submit();
    }

    public boolean areAllHeaderMenuItemsDisplayed() {
        return getHeaderComponent().allMenuItemsAreDisplayed();
    }

    public List<String> getHeaderMenuItemsNames() {
        return getHeaderComponent().getMenuItemsText();
    }

    public boolean allIconsAreDisplayed() {
        return iconsComponent.allIconsAreDisplayed();
    }

    public List<String> getMenuItemsText() {
        return iconsComponent.getMenuItemsText();
    }

    public boolean iframeIsDisplayed() {
        return iframeComponent.iframeIsDisplayed();
    }

    public boolean iframeButtonIsDisplayed() {
        return iframeComponent.iframeButtonIsDisplayed();
    }

    public void focusOnPage() {
        getDriver().switchTo().defaultContent();
    }

    public boolean leftSideMenuItemsAreDisplayed() {
        return leftSectionMenuComponent.leftSideMenuItemsAreDisplayed();
    }

    public List<String> getLeftSideMenuItemsNames() {
        return leftSectionMenuComponent.getLeftSideMenuItemsText();
    }

    public void focusOnFrame() {
        iframeComponent.focus();
    }
}
