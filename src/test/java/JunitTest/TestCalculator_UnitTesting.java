package JunitTest;

import JUnit.Calculator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;

import static JUnit.Calculator.multiply;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class TestCalculator_UnitTesting
{
    private Calculator calculator;
    private Integer firstNumber,secondNumber,sumResult,multiplyResult;


    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
        firstNumber = 5;
        secondNumber = 8;
        sumResult = firstNumber + secondNumber;
        multiplyResult = firstNumber * secondNumber;

    }

    /*
      <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>RELEASE</version>
            <scope>test</scope>
        </dependency>
     */

    @Test
    @DisplayName("TEST_SUM")
    public void testSum() throws Exception {
        Integer result = calculator.sum(firstNumber,secondNumber);

        assertNotNull(result);
        assertEquals(result, sumResult);

    }

    @Test
    public void testMultiply() throws Exception {
        Integer result = multiply(firstNumber,secondNumber);
        assertNotNull(result);
        assertEquals(result, multiplyResult);
    }

    @Test
    @Disabled  //test doesnt run
    public void testMultiply2() throws Exception {
        Integer result = multiply(firstNumber,secondNumber);
        assertNotNull(result);
        assertEquals(result, multiplyResult);
    }

    @After
    public void tearDown() throws Exception {
        multiplyResult = null;
        sumResult = null;
    }
}