package com.solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final Map<Function, Double[]> map = new HashMap<>();
    public static void main(String[] args) {

        map.put(new FunctionOne(), new Double[]{0.0, 3.0, 0.004});

        map.put(new FunctionEight(), new Double[]{0.2, 5.0, 0.005});
        map.put(new FunctionNine(), new Double[]{0.5, 2.0, 0.005});
        map.put(new FunctionTen(), new Double[]{0.2, 2.0, 0.004});

        Set<Function> functions = map.keySet();
        for (Function function : functions) {
            function.displayMin(map.get(function));
            function.displayMax(map.get(function));
        }
    }
}
