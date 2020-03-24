package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorAddTest {

    private Calculator calculator;

    @BeforeMethod
    public void setUp() {
        this.calculator = new Calculator();
    }


    @DataProvider
    public Object[][] addTwoLongDigitsDataProvider() {
        return new Object[][]{
                {1L, 2L, 3L},
                {0L, 0L, 0},
                {-10L, -20L, -30L},
                {-10L, 5L, -5L},
                {-1L, 4L, 3L}
        };
    }

    @Test(dataProvider = "addTwoLongDigitsDataProvider")
    public void addTwoLongDigits(long a, long b, long expected) {

        long actual = calculator.sum(a, b);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] addTwoDoubleDigitsDataProvider() {
        return new Object[][]{
                {20.04, 10.06, 30.1},
                {0.00, 0.00, 0.00},
                {-1.08, -2.04, -3.12},
                {-1.01, 5.06, 4.05},
                {-20.02, 10.02, -10.00}
        };
    }

    @Test(dataProvider = "addTwoDoubleDigitsDataProvider")
    public void addTwoLongDigits(double a, double b, double expected) {

        double actual = calculator.sum(a, b);
        assertEquals(actual, expected);
    }

    @AfterMethod
    public void tearDown() {
        calculator = null;
    }
}
