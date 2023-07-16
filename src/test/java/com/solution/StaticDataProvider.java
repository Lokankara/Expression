package com.solution;

import org.testng.annotations.DataProvider;

public class StaticDataProvider {
    @DataProvider(name = "dataForFunction")
    public static Object[][] createDataForFunction() {
        return new Object[][]{
                {0.5, 1.0},
                {2.0, -0.240462},
                {1.1, -0.057662},
                {1.0, 0}
        };
    }

    @DataProvider(name = "dataForSteps")
    public static Object[][] createDataForSteps() {
        return new Object[][]{
                {0, 10, .1, 101},
                {0, 3, .004, 751}
        };
    }

    @DataProvider(name = "dataForFillX")
    public static Object[][] dataFillX() {
        return new Object[][]{
                {175, .7},
                {350, 1.4},
                {750, 3},
        };
    }

    @DataProvider(name = "dataForFillY")
    public static Object[][] dataFillY() {
        return new Object[][]{
                {175, 1},
                {350, -0.329742},
                {750, 0.214242}
        };
    }

    @DataProvider(name = "dataForMinValue")
    public static Object[][] dataForMinValue() {
        return new Object[][]{
                {0.0, 3.0, -0.4702616},
                {0.0, 0.7, 1},
                {0.71, 1.4, -0.32740434},
                {1.4, 3.0, -0.4702616},
        };
    }

    @DataProvider(name = "dataForMaxValue")
    public static Object[][] dataForMaxValue() {
        return new Object[][]{
                {0.0, 3.0, 1.0},
                {0.0, 0.7, 1},
                {0.71, 1.4, 0.08632468},
                {1.4, 3.0, 0.214242},
        };
    }

    @DataProvider(name = "dataForSum")
    public static Object[][] dataForSum() {
        return new Object[][]{
                {0.0, 3.0, 118.94365463},
                {0.0, 0.7, 175.0},
                {0.71, 1.4, -10.3940162},
                {1.4, 3.0, -46.9569175},
        };
    }

    @DataProvider
    public static Object[][] dataForMean() {
        return new Object[][]{
                {0.0, 3.0, 0.1583803},
                {0.0, 0.7, 1.0},
                {0.71, 1.4, -0.0600810},
                {1.4, 3.0, -0.1170995},
        };
    }
}
