package hw7;


import com.epam.jdi.light.driver.WebDriverFactory;
import hw7.domain.MetalsAndColorsData;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static hw7.domain.User.user;
import static org.testng.AssertJUnit.assertEquals;

public class HW7Test {
    @BeforeSuite(alwaysRun = true)
    void setUp() {
        initElements(JDISite.class);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        WebDriverFactory.reopenDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        killAllSeleniumDrivers();
    }

    @Test(dataProviderClass = MetalsAndColorsDataProvider.class, dataProvider = "testData")
    public void logInTest(MetalsAndColorsData data) {
        JDISite.open();
        JDISite.jdiHomePage.login(user);

        JDISite.jdiHomePage.getDisplayedName().assertThat().text(user.getFullName());

        JDISite.jdiHomePage.openMetalsAndColors();
        JDISite.jdiMetalsColorsPage.submitForm(data);

        assertEquals(JDISite.jdiMetalsColorsPage.getResults(), data.getExpectedResult());
    }
}
