package hw4;

import hw4.pages.MainPage;
import hw4.pages.TestingPreset;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class SecondExercise extends TestingPreset {
    private static GetProperty property = new GetProperty();

    @Test
    public void secondExerciseTest() throws IOException {

        //1. Test site is opened
        MainPage mainPage = new MainPage(getDriver());
        mainPage.launch();

        //2. Browser title equals "Home Page"
        assertEquals(mainPage.getPageTitle(), "Home Page");

        //3. User is logged
        mainPage.login(property.getProperty("userName"), property.getProperty("passsword"));

    }
}
