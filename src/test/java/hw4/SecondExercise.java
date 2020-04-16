package hw4;

import hw4.pages.MainPage;
import hw4.pages.MetalAndColorsPage;
import hw4.pages.TestingPreset;
import hw4.testdata.TestData;
import hw4.testdata.enums.Colour;
import hw4.testdata.enums.Element;
import hw4.testdata.enums.Metal;
import hw4.testdata.enums.Vegetable;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.joining;
import static org.testng.AssertJUnit.assertEquals;

public class SecondExercise extends TestingPreset {

    private static final GetProperty property = new GetProperty();

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][]{
                {new TestData.Builder()
                        .setElements(singletonList(Element.EARTH))
                        .setColors(Colour.YELLOW)
                        .setMetals(Metal.GOLD)
                        .build()},
                {new TestData.Builder()
                        .setSummaryLine1("3")
                        .setSummaryLine2("8")
                        .setVegetables(Arrays.asList(Vegetable.CUCUMBER, Vegetable.TOMATO))
                        .build()},
                {new TestData.Builder()
                        .setSummaryLine1("3")
                        .setSummaryLine2("2")
                        .setElements(Arrays.asList(Element.WATER, Element.WIND, Element.FIRE))
                        .setMetals(Metal.BRONZE)
                        .setVegetables(singletonList(Vegetable.ONION))
                        .build()},
                {new TestData.Builder()
                        .setSummaryLine1("5")
                        .setSummaryLine2("6")
                        .setElements(singletonList(Element.WATER))
                        .setColors(Colour.GREEN)
                        .setMetals(Metal.SELEN)
                        .setVegetables(Arrays.asList(Vegetable.CUCUMBER, Vegetable.TOMATO, Vegetable.VEGETABLES, Vegetable.ONION))
                        .build()},
                {new TestData.Builder()
                        .setElements(singletonList(Element.FIRE))
                        .setColors(Colour.BLUE)
                        .setVegetables(Arrays.asList(Vegetable.CUCUMBER, Vegetable.TOMATO, Vegetable.VEGETABLES))
                        .build()}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void secondExerciseTest(TestData testData) throws IOException {

        //1. Test site is opened
        MainPage mainPage = new MainPage(getDriver());
        mainPage.launch();

        //Browser title equals "Home Page"
        assertEquals(mainPage.getPageTitle(), "Home Page");

        //2. User is logged in
        mainPage.login(property.getProperty("userName"), property.getProperty("password"));

        //3. Click on the link on the Header section
        mainPage.goToMetalsAndColoursPage();

        MetalAndColorsPage metalAndColorsPage = new MetalAndColorsPage(getDriver());
        assertEquals("Metal and Colors", mainPage.getPageTitle());

        //4. Fill the form
        metalAndColorsPage.fillForm(testData);

        //5. Click "Submit" button
        metalAndColorsPage.submitForm();

        //6. Check Results block output on the right-side
        Map<String, String> leftBarResults = metalAndColorsPage.getLeftBarResults();

        int line1 = Integer.parseInt(testData.getSummaryLine1());
        int line2 = Integer.parseInt(testData.getSummaryLine2());

        int actualResult = Integer.parseInt(leftBarResults.get("Summary").trim());

        assertEquals(line1 + line2, actualResult);

        assertEquals(testData.getColors().toString(), leftBarResults.getOrDefault("Color", Colour.COLORS.toString()));
        assertEquals(testData.getMetals().toString(), leftBarResults.getOrDefault("Metal", Metal.METALS.toString()));

        assertEquals(testData.getVegetables().stream().map(Enum::toString).collect(joining(", ")),
                leftBarResults.getOrDefault("Vegetables", Vegetable.VEGETABLES.toString()));

        assertEquals(testData.getElements().stream().map(Enum::toString).collect(joining(", ")),
                leftBarResults.getOrDefault("Elements", Element.DEFAULT.toString()));
    }
}
