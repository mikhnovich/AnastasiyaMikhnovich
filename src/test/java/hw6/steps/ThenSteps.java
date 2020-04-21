package hw6.steps;

import hw6.components.LogSidebarComponent;
import hw6.domain.SiteUser;
import hw6.pages.DifferentElementsPage;
import hw6.pages.MainPage;
import hw6.pages.UsersTablePage;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class ThenSteps extends BaseStep {

    @Then("Log row should be for each selected value on the log panel")
    public void logRowShouldBeForEachSelectedValueOnTheLogPanel() {
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(getDriver());
        LogSidebarComponent logSidebarComponent = differentElementsPage.getLogSidebarComponent();
        assertTrue(logSidebarComponent.isLogVisible());
        assertTrue(logSidebarComponent.containsLogEntryIgnoreTime("Wind: condition changed to true"));
        assertTrue(logSidebarComponent.containsLogEntryIgnoreTime("Water: condition changed to true"));
        assertTrue(logSidebarComponent.containsLogEntryIgnoreTime("Colors: value changed to Yellow"));

    }

    @Then("I can see my name {string} on the top left side of the screen")
    public void iCanSeeMyNameOnTheTopLeftSideOfTheScreen(String expected) {
        MainPage mainPage = new MainPage(getDriver());
        assertTrue(mainPage.isUsernameVisible());
        assertEquals(expected, mainPage.getUsernameDisplayed());
    }

    @Then("Page title is equal to {string}")
    public void pageTitleIsEqualTo(String string) {
        MainPage mainPage = new MainPage(getDriver());
        assertEquals(string, mainPage.getPageTitle());
    }

    @Then("Logs should contain {string}")
    public void logsShouldContainEntry(String entry) {
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(getDriver());
        LogSidebarComponent logSidebarComponent = differentElementsPage.getLogSidebarComponent();
        assertTrue(logSidebarComponent.isLogVisible());
        assertTrue(logSidebarComponent.containsLogEntryIgnoreTime(entry));
    }

    @Then("{int} log row has {string} text in log section")
    public void logRowHasTextInLogSection(int arg0, String entry) {
        assertTrue(new UsersTablePage(getDriver()).checkLogsContainEntry(entry));
    }

    @Then("{string} page should be opened")
    public void userTablePageShouldBeOpened(String pagename) {
        assertEquals(pagename, getDriver().getTitle());

    }

    @And("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void numberTypeDropdownsShouldBeDisplayedOnUsersTableOnUserTablePage(int size) {
        assertEquals(size, new UsersTablePage(getDriver()).getUsersSelectors().size());
    }

    @And("{int} Usernames should be displayed on Users Table on User Table Page")
    public void usernamesShouldBeDisplayedOnUsersTableOnUserTablePage(int size) {
        UsersTablePage usersTablePage = new UsersTablePage(getDriver());
        List<WebElement> usersNameElements = usersTablePage.getUsersNameElements();
        assertEquals(size, usersNameElements.size());
        assertTrue(checkAllElementsAreVisible(usersNameElements));
    }

    @And("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void descriptionTextsUnderImagesShouldBeDisplayedOnUsersTableOnUserTablePage(int size) {
        UsersTablePage usersTablePage = new UsersTablePage(getDriver());
        List<WebElement> imageDescriptions = usersTablePage.getImageDescriptions();
        assertEquals(size, imageDescriptions.size());
        assertTrue(checkAllElementsAreVisible(imageDescriptions));
    }

    @And("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkboxesShouldBeDisplayedOnUsersTableOnUserTablePage(int size) {
        UsersTablePage usersTablePage = new UsersTablePage(getDriver());
        List<WebElement> usersCheckboxes = usersTablePage.getUsersCheckboxes();
        assertEquals(size, usersCheckboxes.size());
        assertTrue(checkAllElementsAreVisible(usersCheckboxes));
    }

    @DataTableType
    public SiteUser siteUser(Map<String, String> entries) {
        return new SiteUser(
                entries.get("Number"),
                entries.get("User"),
                entries.get("Description"));
    }

    @And("User table should contain following values:")
    public void userTableShouldContainFollowingValues(List<SiteUser> users) {
        UsersTablePage usersTablePage = new UsersTablePage(getDriver());
        assertEquals(users, usersTablePage.getUsersData());
    }

    @And("droplist should contain values in column Type for user Roman")
    public void droplistShouldContainValuesInColumnTypeForUserRoman(List<String> dropdownValues) {
        UsersTablePage usersTablePage = new UsersTablePage(getDriver());
        List<String> actual = usersTablePage.getUserRoles("Roman");
        List<String> expected = dropdownValues.subList(1, dropdownValues.size());
        assertEquals(expected, actual);
    }

    private boolean checkAllElementsAreVisible(List<WebElement> webElements) {
        return webElements.stream()
                .allMatch(WebElement::isDisplayed);
    }
}
