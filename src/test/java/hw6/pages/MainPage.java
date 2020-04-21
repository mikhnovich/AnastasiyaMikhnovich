package hw6.pages;

import hw6.components.HeaderComponent;
import hw6.components.IconsComponent;
import hw6.components.IframeComponent;
import hw6.components.LeftSectionMenuComponent;
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

    public static MainPage using(WebDriver driver) {
        return new MainPage(driver);
    }

    public boolean isUsernameVisible() {
        return getHeader().isUserNameVisible();
    }

    public String getUsernameDisplayed() {
        return getHeader().getUserName();
    }

    public void login(String username, String password) {
        userIcon.click();
        getHeader().enterFirstName(username);
        getHeader().enterPassword(password);
        getHeader().submit();
    }

    public boolean areAllHeaderMenuItemsDisplayed() {
        return getHeader().allMenuItemsAreDisplayed();
    }

    public List<String> getHeaderMenuItemsNames() {
        return getHeader().getMenuItemsText();
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

    public MainPage launch() {
        getDriver().get("https://jdi-testing.github.io/jdi-light/index.html");
        return this;
    }

    public HeaderComponent clickUserIcon() {
        this.userIcon.click();
        return getHeader();
    }

}
