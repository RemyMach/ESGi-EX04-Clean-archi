package com.example.response;

import com.example.cli.Calculus;

public class TotalCalculusAdapter {

    public static String toTotalCalculusResponse(int total, Calculus calculus) {
        return "total = " + total + " (" + CalculusToCalculusResponse(calculus) + ")";
    }

    private static String CalculusToCalculusResponse(Calculus calculus) {
        switch (calculus) {
            case plus:
                return "addition";
            case minus:
                return "soustraction";
            case multiply:
                return "multiplication";
            default:
                throw new RuntimeException("Invalid operator");
        }
    }
}
