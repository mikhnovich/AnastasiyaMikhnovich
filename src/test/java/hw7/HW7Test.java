package hw7;


import com.epam.jdi.light.driver.WebDriverFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hw7.domain.MetalsAndColorsData;
import hw7.domain.User;
import org.testng.annotations.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initElements;
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

    @DataProvider
    public Object[][] testData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream is = getClass().getClassLoader().getResourceAsStream("JDI_ex8_metalsColorsDataSet.json");
        Map<String, MetalsAndColorsData> formData = objectMapper.readValue(is,
                new TypeReference<LinkedHashMap<String, MetalsAndColorsData>>() {
                });
        Object[][] testData = new Object[formData.size()][1];
        int i = 0;
        for (MetalsAndColorsData value : formData.values()) {
            testData[i][0] = value;
            i++;
        }
        return testData;
    }

    @Test(dataProvider = "testData")
    public void logInTest(MetalsAndColorsData data) {
        JDISite.open();
        JDISite.jdiHomePage.login(User.user);

        JDISite.jdiHomePage.getDisplayedName().assertThat().text("ROMAN IOVLEV");

        JDISite.jdiHomePage.openMetalsAndColors();
        JDISite.jdiMetalsColorsPage.submitForm(data);

        assertEquals(JDISite.jdiMetalsColorsPage.getResults(), data.getExpectedResult());
    }
}
