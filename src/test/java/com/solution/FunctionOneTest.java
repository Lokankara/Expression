package com.solution;

import org.assertj.core.data.Offset;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.solution.Function.EPS;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FunctionOneTest {
    private double start;
    private double end;
    private double STEP;
    private Function main;

    @BeforeMethod
    void init() {
        main = new FunctionOne();
        start = 0;
        end = 3.0;
        STEP = 0.004;
    }

    @Test(dataProvider = "dataForFunction",
            dataProviderClass = StaticDataProvider.class,
            testName = "When functional method is called, then it should return the expected result ")
    void testFunctional(double x, double expected) {
        double actual = main.function(x);
        assertThat(actual).isCloseTo(expected, Offset.offset(EPS));
    }

    @Test(dataProvider = "dataForSteps",
            dataProviderClass = StaticDataProvider.class,
            testName = "When calculate Size method is called, then it should return the expected result ")
    void testCalculateSize(double start, double end, double step, int expected) {
        double actual = main.calculateSize(start, end, step);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(dataProvider = "dataForFillX",
            dataProviderClass = StaticDataProvider.class,
            testName = "When argument Array method is called, then the value at the specified index should be the expected value ")
    void testFillX(int index, double expected) {
        double[] x = main.argumentArray(start, end, STEP);
        assertThat(x[index]).isCloseTo(expected, Offset.offset(EPS));
    }

    @Test(dataProvider = "dataForFillY",
            dataProviderClass = StaticDataProvider.class,
            testName = "When function Array method is called, then the value at the specified index should be the expected value ")
    void testFillY(int index, double expected) {
        double[] y = getDataFunction(start, end);
        assertThat(y[index]).isCloseTo(expected, Offset.offset(EPS));
    }

    @Test(dataProvider = "dataForMinValue",
            dataProviderClass = StaticDataProvider.class,
            testName = "When find Min method is called, then it should return a value ")
    public void testFindMinValue(double start, double end, double expected) {
        double[] y = getDataFunction(start, end);
        double actual = main.findMin(y);
        assertThat(actual).isCloseTo(expected, Offset.offset(EPS));
    }

    @Test(dataProvider = "dataForMaxValue",
            dataProviderClass = StaticDataProvider.class,
            testName = "When find Max method is called, then it should return a value ")
    public void testFindMaxValue(double start, double end, double expected) {
        double[] y = getDataFunction(start, end);
        double actual = main.findMax(y);
        assertThat(actual).isCloseTo(expected, Offset.offset(EPS));
    }

    @Test(dataProvider = "dataForSum",
            dataProviderClass = StaticDataProvider.class,
            testName = "When calculate Sum method is called, then it should return a value ")
    public void testCalculateSum(double start, double end, double expected) {
        double[] y = getDataFunction(start, end);
        double actual = main.calculateSum(y);
        assertThat(actual).isCloseTo(expected, Offset.offset(EPS));
    }

    @Test(dataProvider = "dataForMean",
            dataProviderClass = StaticDataProvider.class,
            testName = "When calculate Mean method is called, then it should return a value ")
    public void testCalculateMean(double start, double end, double expected) {
        double[] y = getDataFunction(start, end);
        double actual = main.calculateMean(y);
        assertThat(actual).isCloseTo(expected, Offset.offset(EPS));
    }

    private double[] getDataFunction(double start, double end) {
        double[] x = main.argumentArray(start, end, STEP);
        return main.functionArray(x);
    }
}
