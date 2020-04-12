package hw4;

import hw4.pages.MainPage;
import hw4.pages.TableWithPagesPage;
import hw4.pages.TestingPreset;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class FirstExercise extends TestingPreset {

    private static GetProperty property = new GetProperty();

    @Test
    public void firstExerciseTest() throws IOException {
        //1. Test site is opened
        MainPage mainPage = new MainPage(getDriver());
        mainPage.launch();
        //2. Browser title equals "Home Page"
        assertEquals(mainPage.getPageTitle(), "Home Page");

        //3. User is logged
        mainPage.login(property.getProperty("userName"), property.getProperty("passsword"));

        //4. Name is displayed and equals to expected result
        assertTrue(mainPage.isUsernameVisible());
        assertEquals(mainPage.getUsername(), "ROMAN IOVLEV");

        //5. Menu buttons are displayed and have proper texts
        assertTrue(mainPage.areAllHeaderMenuItemsDisplayed());

        //6. Name is displayed and equals to expected result
        mainPage.clickServiceMenuItem();
        mainPage.openTableWithPages();

        TableWithPagesPage tableWithPagesPage = new TableWithPagesPage(getDriver());

        //7. Default value is 5
        tableWithPagesPage.checkDefaultDropdownValue();

        //8.Selected value should be 10
        tableWithPagesPage.selectNewValue();

        //9. Table rows should correspond to the dropdown value
        assertEquals(tableWithPagesPage.getTableRowsCount(), 10);

        //10. Type in search text field "junit"
        String textToSearchFor = property.getProperty("searchText").toLowerCase();
        tableWithPagesPage.searchInTable(textToSearchFor);

        //11. Table contains records with searched field value
        List<String> searchResult = tableWithPagesPage.getTableRowsText();
        assertTrue(searchResult.stream()
                .allMatch(res -> res.toLowerCase().contains(textToSearchFor)));

    }

}
