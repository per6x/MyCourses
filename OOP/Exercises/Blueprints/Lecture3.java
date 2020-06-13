package Blueprints;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BL3 {

    /*
        Returns the smaller number between a and b
     */
    public static int min(int a, int b) {
        return 0;
    }

    /*
        This method takes as an int num as a parameter
        Returns a boolean based on whether num is a prime number or not

        Prime numbers are numbers starting from 2 that are only divisible by
        1 and themselves
     */
    public static boolean isPrime(int num) {
        return false;
    }

    /*
        Returns true if num is even and false if its odd
     */
    public static boolean isEven(int num) {
        return false;
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
        assertEquals(a, BL3.min(a, b));
    }

    @ParameterizedTest
    @CsvSource({"false, 0", "false, 1", "true, 2", "true, 3", "false, 4", "true, 5", "false, 6", "true, 7"})
    public void isPrimeTest(boolean expected, int param) {
        assertEquals(expected, BL3.isPrime(param));
    }

    @ParameterizedTest
    @CsvSource({"true, -2", "true, 0", "false, 1", "true, 8", "false, 9"})
    public void isEvenTest(boolean expected, int param) {
        assertEquals(expected, BL3.isEven(param));
    }
}
