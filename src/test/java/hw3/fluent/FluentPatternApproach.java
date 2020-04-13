package hw3.fluent;

import hw3.GetProperty;
import hw3.fluent.components.HeaderComponent;
import hw3.fluent.components.LogSidebarComponent;
import hw3.fluent.fluentPages.DifferentElementsPage;
import hw3.fluent.fluentPages.MainPage;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class FluentPatternApproach extends TestingPreset {

    private static GetProperty property = new GetProperty();

    @Test
    public void fluentApproachTest() throws IOException {
        //1. Test site is opened
        MainPage mainPage = MainPage.using(getDriver())
                .launch();

        //2. Browser title equals "Home Page"
        assertEquals(mainPage.getPageTitle(), "Home Page");

        //3. User is logged
        mainPage.clickUserIcon()
                .enterFirstName(property.getProperty("userName"))
                .enterPassword(property.getProperty("password"))
                .submit();

        //4. Name is displayed and equals to expected result
        HeaderComponent header = mainPage.getHeaderComponent();
        assertTrue(header.isUserNameVisible());
        assertEquals(header.getUserName(), "ROMAN IOVLEV");

        //5. Page is opened
        DifferentElementsPage differentElementsPage = header
                .openServiceMenu()
                .clickDifferentElementsLink();

        //6, 7, 8. Elements are checked
        differentElementsPage
                .checkWater()
                .checkWind()
                .checkSelen()
                .selectColor("Yellow");

        //9. Log rows are displayed and:
        // checkbox name and its status are corresponding to selected
        // radio button name and it status is corresponding to selected
        // dropdown name and selected value is corresponding to selected
        LogSidebarComponent logSidebarComponent = differentElementsPage.getLogSidebarComponent();
        assertTrue(logSidebarComponent.isLogVisible());
        assertTrue(logSidebarComponent.containsLogEntryIgnoreTime("Wind: condition changed to true"));
        assertTrue(logSidebarComponent.containsLogEntryIgnoreTime("Water: condition changed to true"));
        assertTrue(logSidebarComponent.containsLogEntryIgnoreTime("Colors: value changed to Yellow"));
    }
}
