package com.solution;

public class FunctionOne implements Function {
    private static final double A = -0.5;
    private static final double B = 2.0;

    @Override
    public double function(double x) {
        if (x <= 0.7 + EPS) {
            return 1;
        }
        if (x > 1.4 + EPS) {
            return Math.exp(A * x) * Math.cos(B * x);
        }
        return A * x * x * Math.log(x);
    }

    @Override
    public boolean isValid(double x) {
        return x < Math.log(Double.MAX_VALUE);
    }
}
