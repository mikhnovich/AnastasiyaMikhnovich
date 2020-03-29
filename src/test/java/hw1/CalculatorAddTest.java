package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorAddTest extends TestingPreset {
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
}
