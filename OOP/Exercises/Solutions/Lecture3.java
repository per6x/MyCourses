package Solutions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SL3 {
    public static int min(int a, int b) {
        return (a < b) ? a : b;
    }

    public static boolean isPrime(int num) {
        if (num < 2)
            return false;

        int sum = 1;

        for (int i = 2; i <  num + 1; i++)
            if (num % i == 0)
                sum++;

        return sum == 2;
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }
}

/*
    DO NOT MODIFY

    This is the test class, you can run it to see if your implementation works as expected
 */
class BL3T {

    @ParameterizedTest
    @CsvSource({"1, 3", "-10, 0"})
    public void minTest(int a, int b) {
        assertEquals(a, SL3.min(a, b));
    }

    @ParameterizedTest
    @CsvSource({"false, 0", "false, 1", "true, 2", "true, 3", "false, 4", "true, 5", "false, 6", "true, 7"})
    public void isPrimeTest(boolean expected, int param) {
        assertEquals(expected,  SL3.isPrime(param));
    }

    @ParameterizedTest
    @CsvSource({"true, -2", "true, 0", "false, 1", "true, 8", "false, 9"})
    public void isEvenTest(boolean expected, int param) {
        assertEquals(expected, SL3.isEven(param));
    }
}

