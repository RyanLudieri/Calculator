import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach // Antes de qualquer teste, esse método será chamado
    void setup() {
        // Cria uma nova instância calculator
        calculator = new Calculator();
    }

    @Test
    @DisplayName("#add > When both numbers are positive return a positive number")
    void addWhenBothNumbersArePositiveReturnAPositiveNumber() {
        int result = calculator.add(3,4);
        // Se result == 7
        Assertions.assertEquals(7, result);
    }

    @Test
    @DisplayName("#add > When both numbers are negative return negative number")
    void addWhenBothNumbersAreNegativeReturnNegativeNumber() {
        int result = calculator.add(-3, -4);
        Assertions.assertEquals(-7, result);
    }

    @Test
    @DisplayName("#add > When one number is positive and the another is negative return a positive number")
    void addWhenOneNumberIsPositiveAndTheAnotherIsNegativeReturnAPositiveNumber() {
        int result = calculator.add(-3, 4);
        Assertions.assertEquals(1, result);
    }

    @Test
    @DisplayName("#add > When One Number Is Negative And The Another Is Negative Return A Negative Number")
    void addWhenOneNumberIsNegativeAndTheAnotherIsNegativeReturnANegativeNumber() {
        int result = calculator.add(3, -4);
        Assertions.assertEquals(-1, result);
    }

    @Test
    @DisplayName("#add > When one number is positive and the another is zero return the given number")
    void addWhenOneNumberIsPositiveAndTheAnotherIsZeroReturnTheGivenNumber() {
        int result = calculator.add(3, 0);
        int secondResult = calculator.add(0, 4);

        Assertions.assertAll(
                () -> Assertions.assertEquals(3, result),
                () -> Assertions.assertEquals(4, secondResult)
        );
    }

    @Test
    @DisplayName("#add > When one number is negative and the another is zero return the given number")
    void addWhenOneNumberIsNegativeAndTheAnotherIsZeroReturnTheGivenNumber() {
        int result = calculator.add(-3, 0);
        int secondResult = calculator.add(0, -4);

        Assertions.assertAll(
                () -> Assertions.assertEquals(-3, result),
                () -> Assertions.assertEquals(-4, secondResult)
        );
    }

    @Test
    @DisplayName("#add > When both numbers are zero return zero")
    void addWhenBothNumbersAreZeroReturnZero() {
        int result = calculator.add(0, 0);
        Assertions.assertEquals(0, result);
    }

    @Test
    @DisplayName("#divide > When the divider is zero > Throw an exception")
    void divideWhenTheDividerIsZeroThrowAnException() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            calculator.divide(5,0);
        });
    }

    @Test
    @DisplayName("#divide > When the numerator is zero return zero")
    void divideWhenTheNumeratorIsZeroReturnZero() {
        int result = calculator.divide(0,2);
        Assertions.assertEquals(0,result);
    }

    @Test
    @DisplayName("#divide > When the divider is positive and the numerator is positive return a positive number")
    void divideWhenTheDividerIsPositiveAndTheNumeratorIsPositiveReturnAPositiveNumber() {
        int result = calculator.divide(2, 2);
        Assertions.assertEquals(1, result);
    }

    @Test
    @DisplayName("#divide > When the divider is negative and the numerator is negative return a positive number")
    void divideWhenTheDividerIsNegativeAndTheNumeratorIsNegativeReturnAPositiveNumber() {
        int result = calculator.divide(-2, -2);
        Assertions.assertEquals(1, result);
    }

    @Test
    @DisplayName("#divide > When the denominator is negative and the numerator is positive return a negative number")
    void divideWhenTheDenominatorIsNegativeAndTheNumeratorIsPositiveReturnANegativeNumber() {
        int result = calculator.divide(-2,2);
        Assertions.assertEquals(-1,result);
    }

    @Test
    @DisplayName("#divide > When the denominator is positive and the numerator is negative return a negative number")
    void divideWhenTheDenominatorIsPositiveAndTheNumeratorIsNegativeReturnANegativeNumber() {
        int result = calculator.divide(2,-2);
        Assertions.assertEquals(-1,result);
    }
}