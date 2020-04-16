package hw5.voids;

import hw5.ScreenshotListener;
import hw5.TestingPreset;
import hw5.voids.steps.MainPageSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ScreenshotListener.class})
public class FailingTest extends TestingPreset {

    @Feature(value = "Failing test")
    @Story(value = "Just a failing test")
    @Test
    public void stepsBasedApproach() {
        MainPageSteps pageSteps = new MainPageSteps(getDriver());

        pageSteps.openPage();
        pageSteps.pageTitleShouldBe("Wrong title. Fail please for God's sake!");

        pageSteps.logIn(getProperty("userName"), getProperty("password"));
        pageSteps.checkUsernameIsVisibleAndEqualsTo(getProperty("usernameDisplayed"));

        pageSteps.checkHeaderMenuButtonsVisibilityAndText("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");

        pageSteps.checkAllIconsAreDisplayed();
        pageSteps.iconsTextShouldBe(
                "To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project",
                "To be flexible and\n" +
                        "customizable",
                "To be multiplatform",
                "Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more\u2026"
        );

        pageSteps.iframeShouldExist();
        pageSteps.focusOnIFrame();
        pageSteps.iFrameButtonShouldBeDisplayed();

        pageSteps.focusOnPage();

        pageSteps.leftSideMenuItemsShouldBeDisplayed();
        pageSteps.leftSideMenuItemsTextShouldBe(
                "Home",
                "Contact form",
                "Service",
                "Metals & Colors",
                "Elements packs"
        );
    }
}
