package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSubtractTest {
    private Calculator calculator;

    @BeforeMethod
    public void setUp() {
        this.calculator = new Calculator();
    }

    @DataProvider
    Object[][] subtractTwoLongDigitsDataProvider() {
        return new Object[][]{
                {1L, 2L, -1L},
                {-3L, -2L, -1L},
                {-10L, 5L, -15L},
                {4L, 3L, 1L}
        };
    }

    @Test(dataProvider = "subtractTwoLongDigitsDataProvider")
    public void subtractTwoLongDigits(long a, long b, long expected) {
        long actual = calculator.sub(a, b);
        assertEquals(actual, expected);
    }

    @DataProvider
    Object[][] subtractTwoDoubleDigitsDataProvider() {
        return new Object[][]{
                {1.00, 2.00, -1.00},
                {-5.00, -2.00, -3.00},
                {-10.00, 5.00, -15.00},
                {3.00, 3.00, 0.00}
        };
    }

    @Test(dataProvider = "subtractTwoDoubleDigitsDataProvider")
    public void subtractTwoDoubleDigits(double a, double b, double expected) {
        double actual = calculator.sub(a, b);
        assertEquals(actual, expected);
    }

    @AfterMethod
    public void tearDown() {
        calculator = null;
    }
}

