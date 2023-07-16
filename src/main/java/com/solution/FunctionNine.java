package com.solution;

public class FunctionNine implements Function {
    private static final double CONDITION = 1.2;
    private static final double A = 20.3;

    @Override
    public double function(double x) {

        if (!isValid(x)) {
            throw new DataInvalidFormatException(
                    "The expression can't be negative");
        }

        return x <= CONDITION
                ? Math.log10(x + 1)
                : Math.pow(Math.sin(A * x), 2) * Math.sqrt(A * x);
    }

    @Override
    public boolean isValid(double x) {
        return x >= -1 && (x + 1 > 0) && (A * x >= 0);
    }
}
