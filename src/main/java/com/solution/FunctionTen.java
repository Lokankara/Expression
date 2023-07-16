package com.solution;

public class FunctionTen implements Function {
    private static final double T = 2.2;
    private static final double EDGE = 0.9;

    @Override
    public double function(double x) {

        if (!isValid(x)) {
            throw new DataInvalidFormatException(
                    "The expression sqrt can't be less zero");
        }

        return x <= EDGE
                ? (Math.pow(Math.log(x), 3) * x + Math.pow(x, 2)) / Math.sqrt(x + T)
                : Math.cos(x) + T * Math.pow(Math.sin(x), 2);
    }

    @Override
    public boolean isValid(double x) {
        return (x + T) > 0 && x > 0 && x < Double.MAX_VALUE;
    }
}
