package com.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Concentration {

    private Concentration(){}

    public static double evaluate(double c0, double k, double t){
        return c0 * (1 - Math.exp(-(k*t)));
    }

    public static Double meanConcentration(double[] concentrations){
        return Arrays.stream(concentrations).average().orElse(Double.NaN);
    }

    public static Double meanConcentration(ArrayList<Double> concentrations){
        return concentrations.stream()
                .mapToDouble(d -> d)
                .average()
                .orElse(-1.0);
    }
}
