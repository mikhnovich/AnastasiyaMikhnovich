package hw3.voids.voidPages;

import hw3.voids.components.IconsComponent;
import hw3.voids.components.IframeComponent;
import hw3.voids.components.LeftSectionMenuComponent;
import hw3.voids.components.LoginComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;


public class MainPage extends AbstractPage {

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    private LoginComponent loginComponent;

    private IconsComponent iconsComponent;

    private IframeComponent iframeComponent;

    private LeftSectionMenuComponent leftSectionMenuComponent;

    List<String> expectedMenuItemsText = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");

    List<String> expectedIconTexts = Arrays.asList(
            "To include good practices\n" +
                    "and ideas from successful\n" +
                    "EPAM project",
            "To be flexible and\n" +
                    "customizable",
            "To be multiplatform",
            "Already have good base\n" +
                    "(about 20 internal and\n" +
                    "some external projects),\n" +
                    "wish to get more…"
    );

    List<String> expectedLeftSideMenuNames = Arrays.asList(
            "Home",
            "Contact form",
            "Service",
            "Metals & Colors",
            "Elements packs"
    );


    public MainPage(WebDriver driver) {
        super(driver);
        this.loginComponent = new LoginComponent(driver);
        this.iconsComponent = new IconsComponent(driver);
        this.iframeComponent = new IframeComponent(driver);
        this.leftSectionMenuComponent = new LeftSectionMenuComponent(driver);
    }

    public static void using(WebDriver driver) {
    }

    public void launch() {
        getDriver().get("https://jdi-testing.github.io/jdi-light/index.html");
    }

    public boolean isUsernameVisible() {
        return getHeaderComponent().isUserNameVisible();
    }

    public String getUsername() {
        return getHeaderComponent().getUserName();
    }

    public void login(String username, String password) {
        userIcon.click();
        loginComponent.enterFirstName(username);
        loginComponent.enterPassword(password);
        loginComponent.submit();
    }

    public boolean areAllHeaderMenuItemsDisplayed() {
        return getHeaderComponent().allMenuItemsAreDisplayed();
    }


    public void checkHeaderMenuItemsNames() {
        assertEquals(getHeaderComponent().getMenuItemsText(), expectedMenuItemsText);
    }

    public boolean allIconsAreDisplayed(){
        return iconsComponent.allIconsAreDisplayed();
    }

    public List<String> getMenuItemsText(){
        return iconsComponent.getMenuItemsText();
    }

    public void checkIconsText(){
        assertEquals(this.getMenuItemsText(),expectedIconTexts);
    }

    public boolean iframeIsDisplayed(){
    return iframeComponent.iframeIsDisplayed();
    }

    public boolean iframeButtonIsDisplayed(){
        return iframeComponent.iframeButtonIsDisplayed();
    }

    public void focusOnPage(){
        getDriver().switchTo().defaultContent();
    }

    public boolean leftSideMenuItemsAreDisplayed(){
        return leftSectionMenuComponent.leftSideMenuItemsAreDisplayed();
    }

    public void checkLeftSideMenuItemsNames() {
        assertEquals(leftSectionMenuComponent.getLeftSideMenuItemsText(), expectedLeftSideMenuNames);
    }



}
