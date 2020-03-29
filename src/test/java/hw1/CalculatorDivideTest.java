package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorDivideTest extends TestingPreset {
    @DataProvider
    public Object[][] divideTwoDoubleDigitsDataProvider() {
        return new Object[][]{
                {10.00, 2.00, 5.00},
                {-100.00, 0.01, -10000},
                {-1.00, -2.00, 0.5}
        };
    }

    @Test(dataProvider = "divideTwoDoubleDigitsDataProvider")
    public void divideTwoDoubleDigitsTest(double a, double b, double expected){
        double actual = calculator.div(a, b);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][] divideTwoLongDigitsDataProvider() {
        return new Object[][]{
                {1L, 2L, 0L},
                {-10L, 2L, -5L},
                {-3L, -3L, 1L}
        };
    }

    @Test(dataProvider = "divideTwoLongDigitsDataProvider")
    public void divideTwoLongDigitsTest(long a, long b, long expected){
        long actual = calculator.div(a, b);
        assertEquals(actual, expected);
    }
}
