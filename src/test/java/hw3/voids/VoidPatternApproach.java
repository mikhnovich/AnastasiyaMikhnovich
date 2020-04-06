package hw3.voids;

import hw3.voids.voidPages.MainPage;
import org.openqa.selenium.WebDriver;
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
        mainPage.login( "Roman", "Jdi1234");

        //4. Name is displayed and equals to expected result
        mainPage.isUsernameVisible();
        assertEquals(mainPage.getUsername(),"ROMAN IOVLEV");

        //5. Menu buttons are displayed and have proper texts
        assertTrue(mainPage.areAllHeaderMenuItemsDisplayed());
        mainPage.checkHeaderMenuItemsNames();

        //6. Images are displayed
        assertTrue(mainPage.allIconsAreDisplayed());

        //7. Texts are displayed and equal to expected
        mainPage.checkIconsText();

        //8. The iframe exists
        assertTrue(mainPage.iframeIsDisplayed());

        //9. The “Frame Button” exists
        assertTrue(mainPage.iframeButtonIsDisplayed());

        //10. Driver has focus on the original window
        mainPage.focusOnPage();

        //11. Left section menu items are displayed and have proper text
        assertTrue(mainPage.leftSideMenuItemsAreDisplayed());
        mainPage.checkLeftSideMenuItemsNames();
    }


}
