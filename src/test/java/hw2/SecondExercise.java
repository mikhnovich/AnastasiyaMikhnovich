package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class SecondExercise extends SeleniumTestingPreset{
    String login = "Roman";
    String password = "Jdi1234";

    @Test
    public void secondExerciseTest(){
        //1. Test site is opened
        openSite(url);

        //2. Browser title equals "Home Page"
        assertEquals(driver.getTitle(), "Home Page");

        //3. User is logged
        login(login, password);

        //4. Name is displayed and equals to expected result
        assertTrue(driver.findElement(By.id("user-name")).isDisplayed());
        assertEquals(driver.findElement(By.id("user-name")).getText(), "ROMAN IOVLEV");

        //5. Page is opened
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Service"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Different elements"))).click();

        //6, 7, 8. Elements are checked
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[normalize-space() = 'Water']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[normalize-space() = 'Wind']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[normalize-space() = 'Selen']"))).click();
        WebElement colorsDropdown =  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".colors select")));
        new Select(colorsDropdown).selectByVisibleText("Yellow");

        //9. Log rows are displayed and:
        // checkbox name and its status are corresponding to selected
        // radio button name and it status is corresponding to selected
        // dropdown name and selected value is corresponding to selected

        WebElement windLog = driver.findElement(By.xpath("//*[contains(text(),'Wind: condition changed to true')]"));
        WebElement waterLog = driver.findElement(By.xpath("//*[contains(text(),'Water: condition changed to true')]"));
        WebElement yellowColorLog = driver.findElement(By.xpath("//*[contains(text(),'Colors: value changed to Yellow')]"));

        assertTrue(windLog.isDisplayed());
        assertTrue(waterLog.isDisplayed());
        assertTrue(yellowColorLog.isDisplayed());
    }
}
