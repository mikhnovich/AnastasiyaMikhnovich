package hw5.fluent;

import hw5.ScreenshotListener;
import hw5.TestingPreset;
import hw5.fluent.steps.DifferentElementsPageSteps;
import hw5.fluent.steps.MainPageSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ScreenshotListener.class})
public class DifferentElementsPageTest extends TestingPreset {

    @Feature(value = "Different elements page clickable checkboxes")
    @Story(value = "Checkbox interactions should be logged on sidebar")
    @Test
    public void stepsBasedApproach() {

        MainPageSteps mainPage = new MainPageSteps(getDriver());

        mainPage.openPage();
        mainPage.pageTitleShouldBe("Home Page");

        mainPage.logIn(getProperty("userName"), getProperty("password"));
        mainPage.checkUsernameIsVisibleAndEqualsTo(getProperty("usernameDisplayed"));

        mainPage.openDifferentElementsPage();

        DifferentElementsPageSteps differentElementsPage = new DifferentElementsPageSteps(getDriver());

        differentElementsPage.checkWaterCheckbox();
        differentElementsPage.checkWindCheckbox();
        differentElementsPage.checkSelenCheckbox();
        differentElementsPage.selectColor("Yellow");

        differentElementsPage.checkLogsAreVisible();
        differentElementsPage.logsShouldContain("Wind: condition changed to true");
        differentElementsPage.logsShouldContain("Water: condition changed to true");
        differentElementsPage.logsShouldContain("Colors: value changed to Yellow");
    }
}
