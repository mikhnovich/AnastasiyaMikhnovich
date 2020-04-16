package hw5.fluent.steps;

import hw5.fluent.components.HeaderComponent;
import hw5.fluent.fluentPages.MainPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

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

    @Step("Browser title should be {title}")
    public void pageTitleShouldBe(String title) {
        assertEquals(title, mainPage.getPageTitle());
    }

    @Step("Log in as user: {username}, password: {password}")
    public void logIn(String username, String password) {
        mainPage.clickUserIcon()
                .enterFirstName(username)
                .enterPassword(password)
                .submit();
    }

    @Step("Username should be visible and equal to {username}")
    public void checkUsernameIsVisibleAndEqualsTo(String username) {
        HeaderComponent header = mainPage.getHeader();
        assertTrue(header.isUserNameVisible());
        assertEquals(username, header.getUserName());
    }

    @Step("Open different elements page")
    public void openDifferentElementsPage() {
        mainPage.getHeader()
                .openServiceMenu()
                .clickDifferentElementsLink();
    }

}
