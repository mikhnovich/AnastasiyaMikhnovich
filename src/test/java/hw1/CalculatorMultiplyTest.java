package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class CalculatorMultiplyTest {
    private Calculator calculator;

    @BeforeMethod
    public void setUp() {
        this.calculator = new Calculator();
    }

    @DataProvider
    Object[][] multiplyTwoLongDigits() {
        return new Object[][]{
                {1L, 2L, 2L},
                {-10L, 3L, -30L},
                {0L, 2L, 0L},
                {-10L, -10L, 100L}
        };
    }

    @Test(dataProvider = "multiplyTwoLongDigits")
    public void multiplyTwoLongDigits(long a, long b, long expected) {
        long actual = calculator.mult(a, b);
        assertEquals(actual, expected);
    }

    @DataProvider
    Object[][] multiplyTwoDoubleDigits() {
        return new Object[][]{
                {1.01, 2.00, 2.00},
                {-10.00, 3.00, -30.00},
                {0.00, 2.00, 0.00},
                {-10.00, -10.00, 100.00}
        };
    }

    @Test(dataProvider = "multiplyTwoDoubleDigits")
    public void multiplyTwoDoubleDigits(double a, double b, double expected) {
        double actual = calculator.mult(a, b);
        assertEquals(actual, expected);
    }



    @AfterMethod
    public void tearDown() {
        calculator = null;
    }
}