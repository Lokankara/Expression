package com.solution;

public class FunctionEight implements Function {

    private static final double CONDITION = 3.4;

    @Override
    public double function(double x) {
        if (!isValid(x)) {
            throw new DataInvalidFormatException("The expression can't be negative");
        }
        return x > CONDITION
                ? Math.sin(x) * Math.log10(x)
                : Math.pow(Math.cos(x), 2);
    }

    @Override
    public boolean isValid(double x) {
        return x > 0;
    }
}
