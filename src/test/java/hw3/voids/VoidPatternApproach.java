package hw3.voids;

import hw3.voids.voidPages.MainPage;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class VoidPatternApproach extends TestingPreset {
    @Test
    public void voidPatternApproachTest() {
        //1. Test site is opened
        MainPage mainPage = new MainPage(getDriver());
        mainPage.launch();
        //2. Browser title equals "Home Page"
        assertEquals(mainPage.getPageTitle(), "Home Page");

        //3. User is logged
        mainPage.login("Roman", "Jdi1234");

        //4. Name is displayed and equals to expected result
        assertTrue(mainPage.isUsernameVisible());
        assertEquals(mainPage.getUsername(), "ROMAN IOVLEV");

        //5. Menu buttons are displayed and have proper texts
        assertTrue(mainPage.areAllHeaderMenuItemsDisplayed());

        List<String> expectedMenuItemsText = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        assertEquals(expectedMenuItemsText, mainPage.getHeaderMenuItemsNames());

        //6. Images are displayed
        assertTrue(mainPage.allIconsAreDisplayed());

        //7. Texts are displayed and equal to expected
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
        assertEquals(expectedIconTexts, mainPage.getMenuItemsText());

        //8. The iframe exists
        assertTrue(mainPage.iframeIsDisplayed());

        //9. The “Frame Button” exists
        mainPage.focusOnFrame();
        assertTrue(mainPage.iframeButtonIsDisplayed());

        //10. Driver has focus on the original window
        mainPage.focusOnPage();

        //11. Left section menu items are displayed and have proper text
        assertTrue(mainPage.leftSideMenuItemsAreDisplayed());
        List<String> expectedLeftSideMenuNames = Arrays.asList(
                "Home",
                "Contact form",
                "Service",
                "Metals & Colors",
                "Elements packs"
        );
        assertEquals(expectedLeftSideMenuNames, mainPage.getLeftSideMenuItemsNames());
    }
}
