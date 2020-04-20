package hw5.voids.steps;

import hw5.voids.voidPages.MainPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static java.util.Arrays.asList;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class MainPageSteps {

    private final MainPage mainPage;

    public MainPageSteps(WebDriver driver) {
        this.mainPage = new MainPage(driver);
    }

    @Step("Opening main page")
    public void openPage() {
        mainPage.launch();
    }

    @Step("Page title should be {title}")
    public void pageTitleShouldBe(String title) {
        assertEquals(title, mainPage.getPageTitle());
    }

    @Step("Log in as user: {username}, password: {password}")
    public void logIn(String username, String password) {
        mainPage.login(username, password);
    }

    @Step("Username should be visible and equal to {username}")
    public void checkUsernameIsVisibleAndEqualsTo(String username) {
        assertTrue(mainPage.isUsernameVisible());
        assertEquals(username, mainPage.getUsernameDisplayed());
    }

    @Step("Menu buttons are displayed and names are: {}")
    public void checkHeaderMenuButtonsVisibilityAndText(String... names) {
        assertTrue(mainPage.areAllHeaderMenuItemsDisplayed());
        assertEquals(asList(names), mainPage.getHeaderMenuItemsNames());
    }

    @Step("All icons are displayed")
    public void checkAllIconsAreDisplayed() {
        assertTrue(mainPage.allIconsAreDisplayed());
    }

    @Step("Icons text should be {text}")
    public void iconsTextShouldBe(String... text) {
        assertEquals(asList(text), mainPage.getMenuItemsText());
    }

    @Step("Iframe should exist")
    public void iframeShouldExist() {
        assertTrue(mainPage.iframeIsDisplayed());
    }

    @Step("Focus on IFrame component")
    public void focusOnIFrame() {
        mainPage.focusOnFrame();
    }

    @Step("IFrame button should be displayed")
    public void iFrameButtonShouldBeDisplayed() {
        assertTrue(mainPage.iframeButtonIsDisplayed());
    }

    @Step("Focus on page")
    public void focusOnPage() {
        mainPage.focusOnPage();
    }

    @Step("Left side menu items should be displayed")
    public void leftSideMenuItemsShouldBeDisplayed() {
        assertTrue(mainPage.leftSideMenuItemsAreDisplayed());
    }

    @Step("Left side menu items text should be {}")
    public void leftSideMenuItemsTextShouldBe(String... text) {
        assertEquals(asList(text), mainPage.getLeftSideMenuItemsNames());
    }
}
