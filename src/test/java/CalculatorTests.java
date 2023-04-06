import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CalculatorTests {
    Calculator calculator = new Calculator();

    @Test
    public void plusTest() {
        //given
        int expected = 25, a = 10, b = 15;

        //act
        int result = calculator.plus.apply(a, b);

        //assert
        assertThat(expected, is(equalTo(result)));
    }

    @ParameterizedTest
    @MethodSource("source")
    public void powTest(int number, int expected) {
        //act
        int result = calculator.pow.apply(number);

        //assert
        assertThat(result, is(equalTo(expected)));
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(5, 25),
                Arguments.of(-8, 64),
                Arguments.of(10, 100)
        );
    }

    @Test
    public void isPositiveTest() {
        int number = 10;

        boolean result = calculator.isPositive.test(number);

        assertThat(number, is(greaterThan(0)));
        assertThat(result, is(true));
    }

    @Test
    public void multiplyTest() {
        int a = -5;
        int b = 6;

        int result = calculator.multiply.apply(a, b);

        assertThat(result, is(lessThan(0)));
    }
}
