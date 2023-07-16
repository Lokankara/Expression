package com.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static com.solution.Function.EPS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Function variation #08")
class FunctionEightTest {
    private double end;
    private double STEP;
    private double start;
    private Function main;

    @BeforeEach
    void init() {
        end = 2.0;
        start = 0.5;
        STEP = 0.005;
        main = new FunctionNine();
    }

    @DisplayName("Given x, calculateFunction should return the correct value of y")
    @ParameterizedTest(name = "Calculate Function f({0}) = {1}")
    @CsvFileSource(resources = {"/eight/function-eight-1.csv", "/eight/function-eight-2.csv"})
    void testFunction(double x, double expected) {
        double actual = main.function(x);
        assertEquals(expected, actual, EPS);
    }

    @DisplayName("When argument Array method is called, then the value at the specified index should be the expected value")
    @ParameterizedTest(name = "Argument array: {1}, index: {0}")
    @CsvFileSource(resources = "/eight/function-eight-index.csv")
    void testFillX(int index, double expected) {
        double[] x = main.argumentArray(start, end, STEP);
        assertEquals(expected, x[index], EPS);
    }

    @DisplayName("When Function Array method is called, then the value at the specified index should be the expected value")
    @ParameterizedTest(name = "Function array: {2}, index: {0}")
    @CsvFileSource(resources = "/eight/function-eight-index.csv")
    void testFillY(int index, double x, double expected) {
        double[] y = getDataFunction(start, end);
        assertEquals(expected, y[index], EPS);
    }

    @DisplayName("Given x = Double.MIN_VALUE, calculate should return the correct value of y")
    @ParameterizedTest(name = "Range start {0}, end {1}, find min = {2}")
    @CsvFileSource(resources = "/eight/function-eight-array.csv")
    void testFindMinValue(double start, double end, double expected, double b, double c, double d) {
        double[] y = getDataFunction(start, end);
        double actual = main.findMin(y);
        assertEquals(expected, actual, EPS);
    }

    @DisplayName("Given x = Double.MAX_VALUE, calculate should return the correct value of y")
    @ParameterizedTest(name = "Range start {0}, end {1}, find max = {3}")
    @CsvFileSource(resources = "/eight/function-eight-array.csv")
    void testFindMaxValue(double start, double end, double a, double expected, double c, double d) {
        double[] y = getDataFunction(start, end);
        double actual = main.findMax(y);
        assertEquals(expected, actual, EPS);
    }

    @DisplayName("Given an array of values, when calculating the sum, then the correct sum should be calculated")
    @ParameterizedTest(name = "Range start {0}, end {1}, find sum = {4}")
    @CsvFileSource(resources = "/eight/function-eight-array.csv")
    void testCalculateSum(double start, double end, double a, double b, double expected, double d) {
        double[] y = getDataFunction(start, end);
        double actual = main.calculateSum(y);
        assertEquals(expected, actual, EPS);
    }

    @DisplayName("Given an array of values, when calculating the mean, then the correct mean should be calculated")
    @ParameterizedTest(name = "Range start {0}, end {1}, find mean = {5}")
    @CsvFileSource(resources = "/eight/function-eight-array.csv")
    void testCalculateMean(double start, double end, double a, double b, double c, double expected) {
        double[] y = getDataFunction(start, end);
        double actual = main.calculateMean(y);
        assertEquals(expected, actual, EPS);
    }

    @DisplayName("Given start, end, and step values, when creating the argument array, then the array should be generated correctly")
    @ParameterizedTest(name = "createArgumentArrayLength({0}, {1}, index: {6})")
    @CsvFileSource(resources = "/eight/function-eight-array.csv")
    void testCreateArgumentArrayLength(double start, double end, double a, double b, double c, double expected, int index) {
        double[] argumentArray = main.functionArray(main.argumentArray(start, end, STEP));
        assertEquals(index, argumentArray.length);
    }

    @Test
    @DisplayName("Given an invalid x value, when calculate is called, then return false")
    void testIsValidWithInvalidInput() {
        double x = -2;
        assertFalse(main.isValid(x));
    }

    @ParameterizedTest(name = "Argument array {0}")
    @CsvSource({"1.0", "2.0", "0"})
    @DisplayName("Given a valid x value, when isValid is called, then return true")
    void testIsValidWithValidXValue(double x) {
        assertTrue(main.isValid(x));
    }


    @ParameterizedTest(name = "Argument array {0}")
    @CsvSource({"-3.0", "-1.0", "-.01"})
    @DisplayName("Given invalid case for sqrt (x) < 0, functional should throw DataInvalidFormatException")
    void testCalculateWithInvalidInput(double x) {
        assertThrows(DataInvalidFormatException.class, () -> main.function(x));
    }

    @Test
    @DisplayName("Given x = Double.POSITIVE_INFINITY, calculate should return the correct value of y")
    void testCalculateWithXEqualToDoublePositiveInfinity() {
        double x = -2;
        assertThrows(DataInvalidFormatException.class, () -> main.function(x));
    }

    @Test
    @DisplayName("Given x = Double.NEGATIVE_INFINITY, calculate should return the correct value of y")
    void testCalculateWithXEqualToDoubleNegativeInfinity() {
        double x = Double.NEGATIVE_INFINITY;
        assertThrows(DataInvalidFormatException.class, () -> main.function(x));
    }

    private double[] getDataFunction(double start, double end) {
        double[] x = main.argumentArray(start, end, STEP);
        return main.functionArray(x);
    }
}
