package com.solution;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public interface Function {
    double EPS = 1e-6;

    double function(double x);

    boolean isValid(double x);

    default int calculateSize(
            double start, double end, double step) {
        return (int) ((end - start) / step) + 1;
    }

    default double[] argumentArray(
            double start, double end, double step) {
        return IntStream.range(0, calculateSize(start, end, step))
                .mapToDouble(i -> start + i * step)
                .toArray();
    }

    default double[] functionArray(double[] x) {
        return DoubleStream.of(x)
                .map(this::function)
                .toArray();
    }

    default double findMin(double[] array) {
        return Arrays
                .stream(array)
                .min()
                .orElse(Double.POSITIVE_INFINITY);
    }

    default double findMax(double[] array) {
        return Arrays.stream(array)
                .max()
                .orElse(Double.NEGATIVE_INFINITY);
    }

    default double calculateSum(double[] array) {
        return Arrays.stream(array).sum();
    }

    default double calculateMean(double[] array) {
        return calculateSum(array) / array.length;
    }


    default void displayMax(Double[] arr) {
        double[] x = argumentArray(arr[0], arr[1], arr[2]);
        double[] y = functionArray(x);
        double max = findMax(y);
        int index = IntStream.range(0, y.length)
                .filter(i -> y[i] == max)
                .findFirst()
                .orElse(-1);
        System.out.printf("Maximum:%nindex: %s%nX value: %s%nY value: %s%n",
                index, x[index], max);
    }

    default void displayMin(Double[] arr){
        double[] x = argumentArray(arr[0], arr[1], arr[2]);
        double[] y = functionArray(x);
        double min = findMin(y);
        int index = IntStream.range(0, y.length)
                .filter(i -> y[i] == min)
                .findFirst()
                .orElse(-1);
        System.out.printf("%n%s%nMinimum:%nindex: %s%nX value: %s%nY value: %s%n",
                this.getClass(), index, x[index], min);
    }
}
