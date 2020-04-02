package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;


public class FirstExercise extends SeleniumTestingPreset {
    SoftAssert asrt = new SoftAssert();
    String login = "Roman";
    String password = "Jdi1234";

    @Test
    public void firstExerciseTest() throws InterruptedException {

        //1. Test site is opened
        openSite(url);

        //2. Browser title equals "Home Page"
        asrt.assertEquals(driver.getTitle(), "Home Page");

        //3. User is logged
        login(login, password);

        //4. Name is displayed and equals to expected result
        asrt.assertEquals(driver.findElement(By.id("user-name")).isDisplayed(), true);
        asrt.assertEquals(driver.findElement(By.id("user-name")).getText(), "ROMAN IOVLEV");

        //5. Menu buttons are displayed and have proper texts
        List<String> expectedMenuItemsText = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        List<WebElement> actualMenuItems = driver.findElements(By.cssSelector(".m-l8 > li"));

        checkElementsAreDisplayed(actualMenuItems);

        List<String> actualMenuItemsText = getMenuItemsText(actualMenuItems);
        asrt.assertEquals(actualMenuItemsText, expectedMenuItemsText);

        //6. Images are displayed
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("benefit-icon")));
        List<WebElement> icons = driver.findElements(By.className("benefit-icon"));
        checkElementsAreDisplayed(icons);

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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("benefit-txt")));
        List<WebElement> iconTextsElements = driver.findElements(By.className("benefit-txt"));
        checkElementsAreDisplayed(iconTextsElements);

        List<String> actualIconTexts = getMenuItemsText(iconTextsElements);
        asrt.assertEquals(actualIconTexts, expectedIconTexts);

        //8. The iframe exists
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("frame"))));
        asrt.assertTrue(iframe.isDisplayed());

        //9. The “Frame Button” exists
        driver.switchTo().frame("frame");
        WebElement iframeButton = wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("frame-button"))));
        asrt.assertTrue(iframeButton.isDisplayed());

        //10. Driver has focus on the original window
        driver.switchTo().defaultContent();

        //11. Left section menu items are displayed and have proper text
        List<WebElement> leftSideMenuItems = driver.findElements(By.cssSelector(".sidebar-menu > li"));
        checkElementsAreDisplayed(leftSideMenuItems);
        List<String> actualLeftSideMenuNames = getMenuItemsText(leftSideMenuItems);
        List<String> expectedLeftSideMenuNames = Arrays.asList(
                "Home",
                "Contact form",
                "Service",
                "Metals & Colors",
                "Elements packs"
        );
        asrt.assertEquals(actualLeftSideMenuNames, expectedLeftSideMenuNames);

    }
}
