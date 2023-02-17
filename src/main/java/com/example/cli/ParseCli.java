package com.example.cli;

import java.util.List;

public class ParseCli {


    public ArgumentParsed parse(List<String> arguments) {
        if (arguments.size() != 2) {
            throw new IllegalArgumentException("Il faut 2 arguments");
        } else {
            String filename = arguments.get(0);
            Calculus sign = this.mapSignToCalculus(arguments.get(1));
            return new ArgumentParsed(filename, sign);
        }
    }

    private Calculus mapSignToCalculus(String sign) {
        switch (sign) {
            case "+":
                return Calculus.plus;
            case "-":
                return Calculus.minus;
            case "*":
                return Calculus.multiply;
            default:
                throw new IllegalArgumentException("Signe non reconnu");
        }
    }
}
